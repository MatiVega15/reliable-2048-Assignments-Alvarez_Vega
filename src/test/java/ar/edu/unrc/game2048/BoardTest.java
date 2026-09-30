package ar.edu.unrc.game2048;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing de Unidad para los métodos públicos de la clase Board.
 */
public class BoardTest {
    /**
     * Test para el constructor de la clase Board con tamaño por defecto.
     */
    @Test
    public void constructorPorDefectoTest () {
        // Arrange - Act.
        Board tablero = new Board ();

        // Assert.
        assertEquals (4, tablero.getSize ());
        assertEquals (0, tablero.getScore ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el constructor de la clase Board con tamaño pasado como parámetro correcto.
     */
    @Test
    public void constructorTamañoPorParametroCorrectoTest () {
        // Arrange.
        int size = 10;

        // Act.
        Board tablero = new Board (size);

        // Assert.
        assertEquals (10, tablero.getSize ());
        assertEquals (0, tablero.getScore ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el constructor de la clase Board con tamaño pasado como parámetro incorrecto.
     */
    @Test
    public void constructorTamañoPorParametroIncorrectoTest () {
        // Arrange.
        int size = 0;

        // Act - Assert.
        assertThrows (IllegalArgumentException.class, () -> {new Board (size);});
    }

    /**
     * Test para verificar que el constructor de la clase Board agrega 2 fichas aleatorias.
     */
    @Test
    public void constructorAgregaDosFichasTest () {
        // Arrange.
        int size = 4;

        // Act.
        Board tablero = new Board (size);

        // Assert.
        assertEquals (14, tablero.getEmptyPositions ().size ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el constructor de la clase Board con una estrategia nula.
     */
    @Test
    public void constructorEstrategiaNulaTest () {
        // Arrange.
        int size = 10;
        TileStrategy estrategia = null;

        // Act.
        IllegalArgumentException excepcion = assertThrows (IllegalArgumentException.class, () -> {new Board (size, estrategia);});

        // Assert.
        assertEquals ("La estrategia dada no puede ser nula.", excepcion.getMessage ());
    }

    /**
     * Test para el constructor de la clase Board que copia un tablero nulo.
     */
    @Test
    public void constructorCopiaTableroNuloTest () {
        // Arrange.
        Board tablero1 = null;

        // Act.
        IllegalArgumentException excepcion = assertThrows (IllegalArgumentException.class, () -> {new Board (tablero1);});

        // Assert.
        assertEquals ("El tablero dado no puede ser nulo.", excepcion.getMessage ());
    }
    
    /**
     * Test para el constructor de la clase Board que copia un tablero dado.
     */
    @Test
    public void constructorCopiaTableroTest () {
        // Arrange.
        Board tablero1 = new Board(10);
        Cell celula1 = new Cell (2);
        tablero1.setCell (0, 0, celula1);

        // Act.
        Board resultado = new Board (tablero1);

        // Assert.
        assertEquals (10, resultado.getSize ());
        assertEquals (0, resultado.getScore ());
        assertEquals (celula1, resultado.getCell (0, 0));
        assertTrue (tablero1.repOk ());
        assertTrue (resultado.repOk ());
    }

    @Test
    public void testSize() {
        int value = Board.DEFAULT_SIZE;
        Board board = new Board();
        boolean isBoardCorrect = board.getSize() == value;

        assertTrue(isBoardCorrect);
        assertTrue (board.repOk ());
    }

    @Test
    public void testNotValidSize() {
        int value1 = 4;
        int value2 = 2;
        Board board = new Board(value1);
        boolean isBoardCorrect = board.getSize() == value2;

        assertFalse(isBoardCorrect);
        assertTrue (board.repOk ());
    }

    @Test
    public void testGetScore() {
        int value = 2048;
        Cell cell = new Cell(value);

        Board board = new Board();
        board.setCell(0, 0, cell);

        boolean isValid = board.getScore() == value;

        assertFalse(isValid);
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método getScore con puntaje mayor a 0.
     */
    @Test
    public void getScorePositivoTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (2));
        tablero.setCell (1, 0, new Cell (4));
        tablero.setCell (1, 1, new Cell (8));
        tablero.moveRight ();

        // Act.
        int resultado = tablero.getScore ();

        // Assert.
        assertEquals (4, resultado);
        assertTrue (tablero.repOk ());
    }

    @Test
    public void testAddCell() {
        int value = 512;
        Cell cell = new Cell(value);

        Board board = new Board();
        board.setCell(1, 0, cell);

        boolean isAdded = board.getCell(1, 0).equals(cell);

        assertTrue(isAdded);
        assertTrue (board.repOk ());
    }

    @Test
    public void testIsWinning() {
        int value = 2048;
        Cell cell = new Cell(value);

        Board board = new Board();
        board.setCell(0, 0, cell);

        boolean isWinning = board.isWinningBoard();

        assertTrue(isWinning);
        assertTrue (board.repOk ());
    }

    @Test
    public void testIsWinningNegative() {
        int value = 1024;
        Cell cell = new Cell(value);

        Board board = new Board();
        board.setCell(0, 0, cell);

        boolean isWinning = board.isWinningBoard();

        assertFalse(isWinning);
        assertTrue (board.repOk ());
    }

    @Test
    public void testIsLosing() {
        //Arrange
        Board board = new Board(2);
        Cell cell1 = new Cell(4);
        Cell cell2 = new Cell(16);
        Cell cell3 = new Cell(8);
        Cell cell4 = new Cell(32);
        board.setCell(0, 0, cell1);
        board.setCell(0, 1, cell2);
        board.setCell(1,0, cell3);
        board.setCell(1, 1, cell4);
        // Act - Assert
        assertTrue(board.isLosingBoard());
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método isLosing con al menos una celda vacía.
     */
    @Test
    public void isLosingBoardConCeldaVaciaTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, new Cell (8));
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.isLosingBoard ();

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método isLosing con fusión horizontal.
     */
    @Test
    public void isLosingBoardConFusionesHorizontalesTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (2));
        tablero.setCell (1, 0, new Cell (4));
        tablero.setCell (1, 1, new Cell (8));

        // Act.
        boolean resultado = tablero.isLosingBoard ();

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método isLosing con fusión horizontal.
     */
    @Test
    public void isLosingBoardConFusionesHorizontalesTableroMayorTest () {
        // Arrange.
        Board tablero = new Board (3);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (2));
        tablero.setCell (0, 2, new Cell (4));
        tablero.setCell (1, 0, new Cell (8));
        tablero.setCell (1, 1, new Cell (16));
        tablero.setCell (1, 2, new Cell (32));
        tablero.setCell (2, 0, new Cell (64));
        tablero.setCell (2, 1, new Cell (128));
        tablero.setCell (2, 2, new Cell (256));

        // Act.
        boolean resultado = tablero.isLosingBoard ();

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método isLosing con fusión horizontal.
     */
    @Test
    public void isLosingBoardConFusionesHorizontalesUltimasColumnasTest () {
        // Arrange.
        Board tablero = new Board (3);
        tablero.setCell (0, 0, new Cell (4));
        tablero.setCell (0, 1, new Cell (2));
        tablero.setCell (0, 2, new Cell (2));
        tablero.setCell (1, 0, new Cell (8));
        tablero.setCell (1, 1, new Cell (16));
        tablero.setCell (1, 2, new Cell (32));
        tablero.setCell (2, 0, new Cell (64));
        tablero.setCell (2, 1, new Cell (128));
        tablero.setCell (2, 2, new Cell (256));

        // Act.
        boolean resultado = tablero.isLosingBoard ();

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método isLosing con fusión vertical.
     */
    @Test
    public void isLosingBoardConFusionesVerticalesTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, new Cell (2));
        tablero.setCell (1, 1, new Cell (8));

        // Act.
        boolean resultado = tablero.isLosingBoard ();

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    @Test
    public void testFullBoardLleno(){
        //Arrange
                Board board = new Board(2);
        Cell cell1 = new Cell(4);
        Cell cell2 = new Cell(16);
        Cell cell3 = new Cell(8);
        Cell cell4 = new Cell(32);
        board.setCell(0, 0, cell1);
        board.setCell(0, 1, cell2);
        board.setCell(1,0, cell3);
        board.setCell(1, 1, cell4);
        // Act - Assert
        assertTrue(board.isFull());
        assertTrue (board.repOk ());
    }

    @Test
    public void testFullBoardNoLlenoConCeldas(){
        //Arrange
        Board board = new Board(2);
        Cell cell1 = new Cell(4);
        Cell cell2 = new Cell(16);
        Cell cell3 = new Cell(8);
        board.setCell(0, 0, cell1);
        board.setCell(0, 1, Cell.EMPTY);
        board.setCell(1,0, cell3);
        board.setCell(1, 1, cell2);
        // Act - Assert
        assertFalse(board.isFull());
        assertTrue (board.repOk ());
    }

    @Test
    public void testFullBoardNoLlenoSinCeldas(){
        //Arrange
        Board board = new Board(2);
        // Act - Assert
        assertFalse(board.isFull());
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método hasEmptyCell con al menos una celda vacía.
     */
    @Test
    public void hasEmptyCellConCeldaVaciaTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, new Cell (8));
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.hasEmptyCells ();

        // Assert.
        assertTrue (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método hasEmptyCell sin celdas vacías.
     */
    @Test
    public void hasEmptyCellSinCeldaVaciaTest () {
        // Arrange.
        Board tablero = new Board (1);
        tablero.setCell (0, 0, new Cell (2));

        // Act.
        boolean resultado = tablero.hasEmptyCells ();

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para corroborar que un movimiento exitoso agrega una nueva ficha.
     */
    @Test
    public void movimientoExitosoAgregaNuevaFichaTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, Cell.EMPTY);
        tablero.setCell (0, 1, new Cell (2));
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveLeft ();

        // Assert.
        assertTrue (resultado);
        assertEquals (2, tablero.getEmptyPositions ().size ());
        assertTrue (tablero.repOk ());
    }

    @Test
    public void testMoveUp() {
        int value = 2;

        Cell finalCell = new Cell(2 * value);
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        Board board = new Board();
        board.setCell(0, 0, myCell1);
        board.setCell(1, 0, myCell2);
        assertTrue(board.moveUp());

        boolean movedUp = board.getCell(0, 0).equals(finalCell);

        assertTrue(movedUp);
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método moveUp sin movimiento.
     */
    @Test
    public void moveUpSinMovimientoTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (8));
        tablero.setCell (1, 0, new Cell (4));
        tablero.setCell (1, 1, new Cell (16));

        // Act.
        boolean resultado = tablero.moveUp ();

        // Assert.
        assertFalse (resultado);
        assertEquals (2, tablero.getCell (0, 0).getValue ());
        assertEquals (4, tablero.getCell (1, 0).getValue ());
        assertEquals (8, tablero.getCell (0, 1).getValue ());
        assertEquals (16, tablero.getCell (1, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveUp sin fusiones.
     */
    @Test
    public void moveUpSinFusionesTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, Cell.EMPTY);
        tablero.setCell (0, 1, new Cell (8));
        tablero.setCell (1, 0, new Cell (2));
        tablero.setCell (1, 1, new Cell (16));

        // Act.
        boolean resultado = tablero.moveUp ();

        // Assert.
        assertTrue (resultado);
        assertEquals (2, tablero.getCell (0, 0).getValue ());
        assertEquals (8, tablero.getCell (0, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    @Test
    public void testMoveDown() {
        int value = 2;

        Cell finalCell = new Cell(2 * value);
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        Board board = new Board();
        board.setCell(2, 0, myCell1);
        board.setCell(3, 0, myCell2);
        assertTrue(board.moveDown());

        boolean movedUp = board.getCell(3, 0).equals(finalCell);

        assertTrue(movedUp);
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método moveDown sin movimiento.
     */
    @Test
    public void moveDownSinMovimientoTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, Cell.EMPTY);
        tablero.setCell (0, 1, Cell.EMPTY);
        tablero.setCell (1, 0, new Cell (2));
        tablero.setCell (1, 1, new Cell (8));

        // Act.
        boolean resultado = tablero.moveDown ();

        // Assert.
        assertFalse (resultado);
        assertEquals (2, tablero.getCell (1, 0).getValue ());
        assertEquals (8, tablero.getCell (1, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveDown sin fusiones.
     */
    @Test
    public void moveDownSinFusionesTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (8));
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveDown ();

        // Assert.
        assertTrue (resultado);
        assertEquals (2, tablero.getCell (1, 0).getValue ());
        assertEquals (8, tablero.getCell (1, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveDown sin fusiones.
     */
    @Test
    public void moveDownSinFusionesTableroMayorTest () {
        // Arrange.
        Board tablero = new Board (3);
        tablero.setCell (0, 0, Cell.EMPTY);
        tablero.setCell (1, 0, new Cell (2));
        tablero.setCell (2, 0, new Cell (4));
        tablero.setCell (0, 1, Cell.EMPTY);
        tablero.setCell (1, 1, Cell.EMPTY);
        tablero.setCell (2, 1, Cell.EMPTY);
        tablero.setCell (0, 2, Cell.EMPTY);
        tablero.setCell (1, 2, Cell.EMPTY);
        tablero.setCell (2, 2, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveDown ();

        // Assert.
        assertFalse (resultado);
        assertEquals (2, tablero.getCell (1, 0).getValue ());
        assertEquals (4, tablero.getCell (2, 0).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveDown corroborando el índice 0.
     */
    @Test
    public void moveDownVerificandoIndiceCeroTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (16));
        tablero.setCell (0, 1, new Cell (32));
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveDown ();

        // Assert.
        assertTrue (resultado);
        assertEquals (16, tablero.getCell (1, 0).getValue ());
        assertEquals (32, tablero.getCell (1, 1).getValue ());
        assertNotEquals (16, tablero.getCell (0, 0).getValue ());
        assertNotEquals (32, tablero.getCell (0, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    @Test
    public void testMoveLeft() {
        int value = 2;

        Cell finalCell = new Cell(2 * value);
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        Board board = new Board();
        board.setCell(0, 0, myCell1);
        board.setCell(0, 1, myCell2);
        assertTrue(board.moveLeft());

        boolean movedUp = board.getCell(0, 0).equals(finalCell);

        assertTrue(movedUp);
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método moveLeft sin movimiento.
     */
    @Test
    public void moveLeftSinMovimientoTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveLeft ();

        // Assert.
        assertFalse (resultado);
        assertEquals (2, tablero.getCell (0, 0).getValue ());
        assertEquals (4, tablero.getCell (0, 1).getValue ());
        assertEquals (0, tablero.getCell (1, 0).getValue ());
        assertEquals (0, tablero.getCell (1, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveLeft sin fusiones.
     */
    @Test
    public void moveLeftSinFusionesTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, Cell.EMPTY);
        tablero.setCell (0, 1, new Cell (2));
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, new Cell (4));

        // Act.
        boolean resultado = tablero.moveLeft ();

        // Assert.
        assertTrue (resultado);
        assertEquals (2, tablero.getCell (0, 0).getValue ());
        assertEquals (4, tablero.getCell (1, 0).getValue ());
        assertTrue (tablero.repOk ());
    }

    @Test
    public void testMoveRight() {
        int value = 2;

        Cell finalCell = new Cell(2 * value);
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        Board board = new Board();
        board.setCell(0, 2, myCell1);
        board.setCell(0, 3, myCell2);
        assertTrue(board.moveRight());

        boolean movedUp = board.getCell(0, 3).equals(finalCell);

        assertTrue(movedUp);
        assertTrue (board.repOk ());
    }

    /**
     * Test para el método moveRight sin movimiento.
     */
    @Test
    public void moveRightSinMovimientoTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, Cell.EMPTY);
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, new Cell (2));

        // Act.
        boolean resultado = tablero.moveRight ();

        // Assert.
        assertFalse (resultado);
        assertEquals (0, tablero.getCell (0, 0).getValue ());
        assertEquals (4, tablero.getCell (0, 1).getValue ());
        assertEquals (0, tablero.getCell (1, 0).getValue ());
        assertEquals (2, tablero.getCell (1, 1).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveRight sin fusiones.
     */
    @Test
    public void moveRightSinFusionesTest () {
        // Arrange.
        Board tablero = new Board (3);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, Cell.EMPTY);
        tablero.setCell (0, 2, Cell.EMPTY);
        tablero.setCell (1, 0, new Cell (2));
        tablero.setCell (1, 1, new Cell (4));
        tablero.setCell (1, 2, Cell.EMPTY);
        tablero.setCell (2, 0, new Cell (2));
        tablero.setCell (2, 1, Cell.EMPTY);
        tablero.setCell (2, 2, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveRight ();

        // Assert.
        assertTrue (resultado);
        assertEquals (2, tablero.getCell (0, 2).getValue ());
        assertEquals (2, tablero.getCell (1, 1).getValue ());
        assertEquals (4, tablero.getCell (1, 2).getValue ());
        assertEquals (2, tablero.getCell (2, 2).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método moveRight corroborando el índice 0.
     */
    @Test
    public void moveRightVerificandoIndiceCeroTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (64));
        tablero.setCell (0, 1, Cell.EMPTY);
        tablero.setCell (1, 0, new Cell (128));
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero.moveRight ();

        // Assert.
        assertTrue (resultado);
        assertEquals (64, tablero.getCell (0, 1).getValue ());
        assertEquals (128, tablero.getCell (1, 1).getValue ());
        assertNotEquals (64, tablero.getCell (0, 0).getValue ());
        assertNotEquals (128, tablero.getCell (1, 0).getValue ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método getEmptyPositions con celdas vacías.
     */
    @Test
    public void getEmptyPositionsConCeldasVaciasTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, new Cell (8));
        tablero.setCell (1, 1, Cell.EMPTY);

        // Act.
        Set <Board.Position> conjunto = tablero.getEmptyPositions ();

        // Assert.
        assertEquals (1, conjunto.size ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método getEmptyPositions sin celdas vacías.
     */
    @Test
    public void getEmptyPositionsSinCeldasVaciasTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, new Cell (4));
        tablero.setCell (1, 0, new Cell (8));
        tablero.setCell (1, 1, new Cell (8));

        // Act.
        Set <Board.Position> conjunto = tablero.getEmptyPositions ();

        // Assert.
        assertTrue (conjunto.isEmpty ());
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método getCell con una columna inválida.
     */
    @Test
    public void getCellColumnaInvalidaTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act.
        IndexOutOfBoundsException excepcion = assertThrows (IndexOutOfBoundsException.class, () -> {tablero.getCell (2, 0);});

        // Assert.
        assertEquals ("Position (2, 0) is out of bounds for board size 2", excepcion.getMessage ());
    }

    /**
     * Test para el método getCell con una columna inválida.
     */
    @Test
    public void getCellColumnaInvalida2Test () {
        // Arrange.
        Board tablero = new Board (2);

        // Act.
        IndexOutOfBoundsException excepcion = assertThrows (IndexOutOfBoundsException.class, () -> {tablero.getCell (0, 2);});

        // Assert.
        assertEquals ("Position (0, 2) is out of bounds for board size 2", excepcion.getMessage ());
    }

    /**
     * Test para el método getCell con una fila inválida.
     */
    @Test
    public void getCellFilaInvalidaTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act - Assert.
        assertThrows (IndexOutOfBoundsException.class, () -> {tablero.getCell (1, -1);});
    }

    /**
     * Test para el método getCell con una posición inválida negativa.
     */
    @Test
    public void getCellPosicionNegativaTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act - Assert.
        assertThrows (IndexOutOfBoundsException.class, () -> {tablero.getCell (-2, -1);});
    }

    /**
     * Test para el método getCell con una posición válida.
     */
    @Test
    public void getCellPosicionValidaTest () {
        // Arrange.
        Board tablero = new Board (2);
        Cell celda = new Cell (8);
        tablero.setCell (0, 0, celda);

        // Act.
        Cell resultado = tablero.getCell (0, 0);

        // Assert.
        assertEquals (celda, resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método setCell con celda nula.
     */
    @Test
    public void setCellNulaTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act - Assert.
        assertThrows (IllegalArgumentException.class, () -> {tablero.setCell (0, 0, null);});
    }

    /**
     * Test para el método setCell con fila inválida.
     */
    @Test
    public void setCellFilaInvalidaTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act.
        IndexOutOfBoundsException excepcion = assertThrows (IndexOutOfBoundsException.class, () -> {tablero.setCell (2, 0, new Cell (2));});

        // Assert.
        assertEquals ("Position (2, 0) is out of bounds for board size 2", excepcion.getMessage ());
    }

    /**
     * Test para el método setCell con columna inválida.
     */
    @Test
    public void setCellColumnaInvalidaTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act - Assert.
        assertThrows (IndexOutOfBoundsException.class, () -> {tablero.setCell (0, 2, new Cell (2));});
    }

    /**
     * Test para el método setCell con fila y columna inválida.
     */
    @Test
    public void setCellFilaYColumnaInvalidasTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act - Assert.
        assertThrows (IndexOutOfBoundsException.class, () -> {tablero.setCell (2, 2, new Cell (2));});
    }

    /**
     * Test para el método equals con el mismo objeto como parámetro.
     */
    @Test
    public void equalsMismoObjetoTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act.
        boolean resultado = tablero.equals (tablero);

        // Assert.
        assertTrue (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método equals con un objeto nulo como parámetro.
     */
    @Test
    public void equalsObjetoNuloTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act.
        boolean resultado = tablero.equals (null);

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método equals con un objeto de distinto tipo como parámetro.
     */
    @Test
    public void equalsObjetoDistintoTipoTest () {
        // Arrange.
        Board tablero = new Board (2);

        // Act.
        boolean resultado = tablero.equals ("tablero");

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para el método equals con dos tableros iguales.
     */
    @Test
    public void equalsTablerosIgualesTest () {
        // Arrange.
        Board tablero1 = new Board (2);
        tablero1.setCell (0, 0, new Cell (2));
        tablero1.setCell (0, 1, new Cell (4));
        tablero1.setCell (1, 0, new Cell (4));
        tablero1.setCell (1, 1, new Cell (2));
        Board tablero2 = new Board (2);
        tablero2.setCell (0, 0, new Cell (2));
        tablero2.setCell (0, 1, new Cell (4));
        tablero2.setCell (1, 0, new Cell (4));
        tablero2.setCell (1, 1, new Cell (2));

        // Act.
        boolean resultado = tablero1.equals (tablero2);

        // Assert.
        assertTrue (resultado);
        assertTrue (tablero1.repOk ());
        assertTrue (tablero2.repOk ());
    }

    /**
     * Test para el método equals con dimensiones distintos.
     */
    @Test
    public void equalsDimensionesDistintasTest () {
        // Arrange.
        Board tablero1 = new Board (2);
        Board tablero2 = new Board (1);

        // Act.
        boolean resultado = tablero1.equals (tablero2);

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero1.repOk ());
        assertTrue (tablero2.repOk ());
    }

    /**
     * Test para el método equals con puntuaciones distintas.
     */
    @Test
    public void equalsPuntuacionesDistintasTest () {
        // Arrange.
        Board tablero1 = new Board (2);
        tablero1.setCell (0, 0, new Cell (2));
        tablero1.setCell (0, 1, new Cell (2));
        tablero1.setCell (1, 0, Cell.EMPTY);
        tablero1.setCell (1, 1, Cell.EMPTY);
        tablero1.moveRight ();
        tablero1.setCell (0, 0, Cell.EMPTY);
        tablero1.setCell (1, 0, Cell.EMPTY);
        tablero1.setCell (1, 1, Cell.EMPTY);
        Board tablero2 = new Board (2);
        tablero2.setCell (0, 0, Cell.EMPTY);
        tablero2.setCell (0, 1, new Cell (4));
        tablero2.setCell (1, 0, Cell.EMPTY);
        tablero2.setCell (1, 1, Cell.EMPTY);

        // Act.
        boolean resultado = tablero1.equals (tablero2);

        // Assert.
        assertFalse (resultado);
        assertTrue (tablero1.repOk ());
        assertTrue (tablero2.repOk ());
    }

    /**
     * Test para el método hashCode con dos tableros iguales.
     */
    @Test
    public void hashCodeTablerosIgualesTest () {
        // Arrange.
        Board tablero1 = new Board (2);
        tablero1.setCell (0, 0, new Cell (2));
        tablero1.setCell (0, 1, new Cell (4));
        tablero1.setCell (1, 0, new Cell (4));
        tablero1.setCell (1, 1, new Cell (2));
        Board tablero2 = new Board (2);
        tablero2.setCell (0, 0, new Cell (2));
        tablero2.setCell (0, 1, new Cell (4));
        tablero2.setCell (1, 0, new Cell (4));
        tablero2.setCell (1, 1, new Cell (2));

        // Act.
        int hash1 = tablero1.hashCode ();
        int hash2 = tablero2.hashCode ();

        // Assert.
        assertEquals (hash1, hash2);
        assertTrue (tablero1.repOk ());
        assertTrue (tablero2.repOk ());
    }

    /**
     * Test para el método hashCode con dos tableros distintos.
     */
    @Test
    public void hashCodeTablerosDistintosTest () {
        // Arrange.
        Board tablero1 = new Board (2);
        tablero1.setCell (0, 0, new Cell (2));
        tablero1.setCell (0, 1, new Cell (4));
        tablero1.setCell (1, 0, new Cell (4));
        tablero1.setCell (1, 1, new Cell (2));
        Board tablero2 = new Board (2);
        tablero2.setCell (0, 0, new Cell (2));
        tablero2.setCell (0, 1, new Cell (2));
        tablero2.setCell (1, 0, new Cell (2));
        tablero2.setCell (1, 1, new Cell (2));

        // Act.
        int hash1 = tablero1.hashCode ();
        int hash2 = tablero2.hashCode ();

        // Assert.
        assertNotEquals (hash1, hash2);
        assertTrue (tablero1.repOk ());
        assertTrue (tablero2.repOk ());
    }

    /**
     * Test para el método toString.
     */
    @Test
    public void toStringTest () {
        // Arrange.
        Board tablero = new Board (2);
        tablero.setCell (0, 0, new Cell (2));
        tablero.setCell (0, 1, Cell.EMPTY);
        tablero.setCell (1, 0, Cell.EMPTY);
        tablero.setCell (1, 1, new Cell (16));

        // Act.
        String resultado = tablero.toString ();

        // Assert.
        String esperado =
                "Score: 0\n" +
                "+-----+-----+\n" +
                "|    2|     |\n" +
                "+-----+-----+\n" +
                "|     |   16|\n" +
                "+-----+-----+\n";

        assertEquals (esperado, resultado);
        assertTrue (tablero.repOk ());
    }

    /**
     * Test para los valores del enumerado Direction.
     */
    @Test
    public void directionValoresTest () {
        // Arrange - Act.
        Board.Direction [] direcciones = Board.Direction.values ();

        // Assert.
        assertEquals (4, direcciones.length);
        assertEquals (Board.Direction.UP, direcciones [0]);
        assertEquals (Board.Direction.DOWN, direcciones [1]);
        assertEquals (Board.Direction.LEFT, direcciones [2]);
        assertEquals (Board.Direction.RIGHT, direcciones [3]);
    }

    /**
     * Test para el constructor de Position.
     */
    @Test
    public void positionConstructorTest () {
        // Arrange.
        int fila = 2;
        int columna = 3;

        // Act.
        Board.Position posicion = new Board.Position (fila, columna);

        // Assert.
        assertEquals (fila, posicion.row);
        assertEquals (columna, posicion.col);
    }

    /**
     * Test para el método equals de la clase Position con el mismo objeto como parámetro.
     */
    @Test
    public void equalsPositionMismoObjetoTest () {
        // Arrange.
        Board.Position posicion = new Board.Position (0, 0);

        // Act.
        boolean resultado = posicion.equals (posicion);

        // Assert.
        assertTrue (resultado);
    }

    /**
     * Test para el método equals de la clase Position con un objeto nulo como parámetro.
     */
    @Test
    public void equalsPositionObjetoNuloTest () {
        // Arrange.
        Board.Position posicion = new Board.Position (0, 0);

        // Act.
        boolean resultado = posicion.equals (null);

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método equals de la clase Position con un objeto de otro tipo como parámetro.
     */
    @Test
    public void equalsPositionTipoDistintoTest () {
        // Arrange.
        Board.Position posicion = new Board.Position (0, 0);

        // Act.
        boolean resultado = posicion.equals ("posicion");

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método equals de la clase Position con objetos iguales.
     */
    @Test
    public void equalsPositionIgualesTest () {
        // Arrange.
        Board.Position posicion1 = new Board.Position (0, 0);
        Board.Position posicion2 = new Board.Position (0, 0);

        // Act.
        boolean resultado = posicion1.equals (posicion2);

        // Assert.
        assertTrue (resultado);
    }

    /**
     * Test para el método equals de la clase Position con objetos distintos.
     */
    @Test
    public void equalsPositionDistintosTest () {
        // Arrange.
        Board.Position posicion1 = new Board.Position (0, 0);
        Board.Position posicion2 = new Board.Position (1, 1);

        // Act.
        boolean resultado = posicion1.equals (posicion2);

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método equals de la clase Position con filas distintas.
     */
    @Test
    public void equalsPositionFilasDistintasTest () {
        // Arrange.
        Board.Position posicion1 = new Board.Position (0, 0);
        Board.Position posicion2 = new Board.Position (1, 0);

        // Act.
        boolean resultado = posicion1.equals (posicion2);

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método equals de la clase Position con columnas distintas.
     */
    @Test
    public void equalsPositionColumnasDistintasTest () {
        // Arrange.
        Board.Position posicion1 = new Board.Position (0, 0);
        Board.Position posicion2 = new Board.Position (0, 1);

        // Act.
        boolean resultado = posicion1.equals (posicion2);

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método hashCode de la clase Position iguales.
     */
    @Test
    public void hashCodePositionIgualesTest () {
        // Arrange.
        Board.Position posicion1 = new Board.Position (2, 3);
        Board.Position posicion2 = new Board.Position (2, 3);

        // Act.
        int hash1 = posicion1.hashCode ();
        int hash2 = posicion2.hashCode ();

        // Assert.
        assertEquals (hash1, hash2);
    }

    /**
     * Test para el método hashCode de la clase Position distintos.
     */
    @Test
    public void hashCodePositionDistintosTest () {
        // Arrange.
        Board.Position posicion1 = new Board.Position (1, 3);
        Board.Position posicion2 = new Board.Position (2, 3);

        // Act.
        int hash1 = posicion1.hashCode ();
        int hash2 = posicion2.hashCode ();

        // Assert.
        assertNotEquals (hash1, hash2);
    }

    /**
     * Test para el método toString de la clase Position.
     */
    @Test
    public void toStringPositionTest () {
        // Arrange.
        Board.Position posicion = new Board.Position (1, 3);

        // Act.
        String resultado = posicion.toString ();

        // Assert.
        String esperado = "(1, 3)";
        assertEquals (esperado, resultado);
    }

    /**
     * Test para chequear el funcionamiento probabilístico de RandomTileStrategy.
     */
    @Test
    public void randomTileStrategyTest () {
        // Arrange.

        // Mock para testear.
        Random generadorTrucado = new Random () {
            @Override
            public double nextDouble () {
                return 0.9;
            }
        };

        RandomTileStrategy estrategia = new RandomTileStrategy (generadorTrucado);

        // Act.
        int resultado = estrategia.determinarValor ();

        // Assert.
        assertEquals (4, resultado);
    }

    /**
     * Test para chequear el funcionamiento determinista de DeterministicTileStrategy.
     */
    @Test
    public void deterministicTileStrategyValorTest () {
        // Arrange.
        DeterministicTileStrategy estrategia = new DeterministicTileStrategy ();

        // Act.
        int resultado = estrategia.determinarValor ();

        // Assert.
        assertEquals (2, resultado);
    }

    /**
     * Test para chequear el funcionamiento determinista de DeterministicTileStrategy.
     */
    @Test
    public void deterministicTileStrategyPosicionTest () {
        // Arrange.
        DeterministicTileStrategy estrategia = new DeterministicTileStrategy ();

        Set <Board.Position> vacias = new LinkedHashSet <> ();
        vacias.add (new Board.Position (2, 2));
        vacias.add (new Board.Position (1, 2));
        vacias.add (new Board.Position (1, 3));
        Board.Position posicionGanadora = new Board.Position (1, 1);
        vacias.add (posicionGanadora);
        vacias.add (new Board.Position (3, 0));

        // Mock para testear.
        Board.Position clonTramposo = new Board.Position (1, 1) {
            @Override
            public int hashCode () {
                return super.hashCode () + 1;
            }
            @Override
            public boolean equals (Object o) {
                return false;
            }
        };
        vacias.add (clonTramposo);

        // Act.
        Board.Position elegida = estrategia.determinarPosicion (vacias);

        // Assert.
        assertSame (posicionGanadora, elegida);
    }

    /**
     * Test para el método repOk con tamaño inválido.
     */
    @Test
    public void repOkFalsoPorSizeInvalidoTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field size = Board.class.getDeclaredField ("size");
        size.setAccessible (true);
        size.setInt (tablero, 0);
        Field grid = Board.class.getDeclaredField ("grid");
        grid.setAccessible (true);
        grid.set (tablero, new Cell [0] [0]);

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con puntaje negativo.
     */
    @Test
    public void repOkFalsoPorScoreNegativoTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field score = Board.class.getDeclaredField ("score");
        score.setAccessible (true);
        score.setInt (tablero, -1);

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con la matriz grid nula.
     */
    @Test
    public void repOkFalsoPorGridNuloTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field grid = Board.class.getDeclaredField ("grid");
        grid.setAccessible (true);
        grid.set (tablero, null);

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con un tamaño diferente al de la matriz grid.
     */
    @Test
    public void repOkFalsoPorGridDeTamañoIncorrectoTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field size = Board.class.getDeclaredField ("size");
        size.setAccessible (true);
        size.set (tablero, 3);

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con una fila de la matriz grid nula.
     */
    @Test
    public void repOkFalsoPorFilaNulaTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field grid = Board.class.getDeclaredField ("grid");
        grid.setAccessible (true);
        Cell [] [] matriz = (Cell [] []) grid.get (tablero);
        matriz [0] = null;

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con una fila de la matriz grid de tamaño incorrecto.
     */
    @Test
    public void repOkFalsoPorFilaDeTamañoIncorrectoTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field grid = Board.class.getDeclaredField ("grid");
        grid.setAccessible (true);
        Cell [] [] matriz = (Cell [] []) grid.get (tablero);
        matriz [0] = new Cell [1];

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con una celda nula.
     */
    @Test
    public void repOkFalsoPorCeldaNulaTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field grid = Board.class.getDeclaredField ("grid");
        grid.setAccessible (true);
        Cell [] [] matriz = (Cell [] []) grid.get (tablero);
        matriz [0] [0] = null;

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con una celda que no cumple su invariante de representación.
     */
    @Test
    public void repOkFalsoPorCeldaInvalidaTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);
        Cell celula = new Cell (2);

        Field value = Cell.class.getDeclaredField ("value");
        value.setAccessible (true);
        value.setInt (celula, 3);
        tablero.setCell (0, 0, celula);

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }

    /**
     * Test para el método repOk con la estrategia de generación de fichas nula.
     */
    @Test
    public void repOkFalsoPorTileStrategyNulaTest () throws Exception {
        // Arrange.
        Board tablero = new Board (2);

        Field tileStrategy = Board.class.getDeclaredField ("tileStrategy");
        tileStrategy.setAccessible (true);
        tileStrategy.set (tablero, null);

        // Act.
        boolean resultado = tablero.repOk ();

        // Assert.
        assertFalse (resultado);
    }
}