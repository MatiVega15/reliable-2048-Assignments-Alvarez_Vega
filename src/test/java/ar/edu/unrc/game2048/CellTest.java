package ar.edu.unrc.game2048;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;


/**
 * Testing de Unidad para los métodos públicos de la clase Cell.
 */
public class CellTest {

    /**
     * Test para el constructor de la clase Cell con parámetro correcto.
     */
    @Test
    public void constructorCorrectoTest () {
        // Arrange.
        int valor = 0;

        // Act.
        Cell celda = new Cell (valor);

        // Assert.
        assertTrue (celda.isEmpty ());
        assertEquals (valor, celda.getValue ());
        assertTrue(celda.repOk());
    }

    /**
     * Test para el constructor de la clase Cell con parámetro incorrecto.
     */
    @Test
    public void constructorExcepcionTest () {
        // Arrange.
        int valor = -1;

        // Act - Assert.
        assertThrows (IllegalArgumentException.class, () -> {new Cell (valor);});
    }

    /**
     * Test para el constructor de la clase Cell con parametro no potencia de 2
     */
    @Test
    public void TestCellBadValue() {
        // Arrange.
        int value = 3;

        // Act - Assert.
        assertThrows(IllegalArgumentException.class, () -> {
            new Cell(value); 
        });
    }

    @Test 
    public void isEmptyTest(){
        // Arrange.
        int valor = 0;
        Cell celda = new Cell (valor);

        // Act
        boolean empty = celda.isEmpty();

        // Assert.
        assertTrue(empty);
        assertTrue(celda.repOk());
    }

    @Test
    public void isEmptyFalso(){
        // Arrange.
        int valor = 4;
        Cell celda = new Cell (valor);

        // Act
        boolean empty = celda.isEmpty();

        // Assert.
        assertFalse(empty);
        assertTrue(celda.repOk());
    }

    @Test
    public void testGetValue(){
        // Arrange
        int valor = 2;
        Cell celda = new Cell(valor);

        // Act - Assert.
        assertEquals(2, celda.getValue());
        assertTrue(celda.repOk());
    }

    /**
     * Test para el método canMergeWith con parámetro nulo.
     */
    @Test
    public void canMergeWithParametroNuloTest () {
        // Arrange.
        int valor = 0;
        Cell celda1 = new Cell (valor);
        Cell celda2 = null;

        // Act.
        IllegalArgumentException excepcion = assertThrows (IllegalArgumentException.class, () -> {celda1.canMergeWith (celda2);});
    
        // Assert.
        assertEquals ("La celda dada no puede ser nula.", excepcion.getMessage ());
    }

    @Test
    public void canMergeValid() {
        int value = 2;
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        boolean canMerge = myCell1.canMergeWith(myCell2);

        assertTrue(canMerge);
        assertTrue(myCell1.repOk());
        assertTrue(myCell2.repOk());
    }

    @Test
    public void canMergeInvalidNewEmpty() {
        int value = 2;
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(0);

        boolean canMerge = myCell1.canMergeWith(myCell2);

        assertFalse(canMerge);
        assertTrue(myCell1.repOk());
        assertTrue(myCell2.repOk());
    }

    @Test
    public void canMergeInvalidEmpty() {
        int value = 2;
        Cell myCell1 = new Cell(0);
        Cell myCell2 = new Cell(value);

        boolean canMerge = myCell1.canMergeWith(myCell2);

        assertFalse(canMerge);
        assertTrue(myCell1.repOk());
        assertTrue(myCell2.repOk());
    }

    /**
     * Test para el método canMergeWith con ambas celdas nulas.
     */
    @Test
    public void canMergeWithAmbasCeldasVaciasTest () {
        // Arrange.
        int valor = 0;
        Cell celda1 = new Cell (valor);
        Cell celda2 = new Cell (valor);

        // Act.
        boolean resultado = celda1.canMergeWith (celda2);

        // Assert.
        assertFalse (resultado);
        assertTrue(celda1.repOk());
        assertTrue(celda2.repOk());
    }

    /**
     * Test para el método mergeWith con parámetro nulo.
     */
    @Test
    public void mergeWithParametroNuloTest () {
        // Arrange.
        Cell celda1 = new Cell (2);
        Cell celda2 = null;

        // Act.
        IllegalArgumentException excepcion = assertThrows (IllegalArgumentException.class, () -> {celda1.mergeWith (celda2);});

        // Assert.
        assertEquals ("La celda dada no puede ser nula.", excepcion.getMessage ());
    }

    /**
     * Test para el método mergeWith con celdas del mismo valor.
     */
    @Test
    public void mergeWithCorrectoTest () {
        // Arrange.
        Cell celda1 = new Cell (2);
        Cell celda2 = new Cell (2);

        // Act.
        Cell resultado = celda1.mergeWith (celda2);

        // Assert.
        assertFalse (resultado.isEmpty ());
        assertEquals (4, resultado.getValue ());
        assertTrue(celda1.repOk());
        assertTrue(celda2.repOk());
    }

    /**
     * Test para el método mergeWith con celdas de distinto valor.
     */
    @Test
    public void mergeWithIncorrectoTest () {
        // Arrange.
        Cell celda1 = new Cell (2);
        Cell celda2 = new Cell (4);

        // Act - Assert.
        assertTrue(celda1.repOk());
        assertTrue(celda2.repOk());
        assertThrows (IllegalArgumentException.class, () -> {celda1.mergeWith (celda2);});
    }

    @Test
    public void equalsTestPositive() {
        int value = 2;
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        boolean canMerge = myCell1.equals(myCell2);
        assertTrue(myCell1.repOk());
        assertTrue(myCell2.repOk());
        assertTrue(canMerge);
    }

    @Test
    public void equalsTestNegative() {
        int value1 = 0;
        int value2 = 2;
        Cell myCell1 = new Cell(value1);
        Cell myCell2 = new Cell(value2);

        boolean canMerge = myCell1.equals(myCell2);
        assertTrue(myCell1.repOk());
        assertTrue(myCell2.repOk());
        assertFalse(canMerge);
    }

    /**
     * Test para el método equals con un objeto nulo como parámetro.
     */
    @Test
    public void equalsConParametroNuloTest () {
        // Arrange.
        Cell celda1 = new Cell (2);
        Cell celda2 = null;

        // Act.
        boolean resultado = celda1.equals (celda2);

        // Assert.
        assertTrue(celda1.repOk());

        assertFalse (resultado);
    }

    /**
     * Test para el método equals con un objeto de otro tipo como parámetro.
     */
    @Test
    public void equalsConParametroDeOtroTipoTest () {
        // Arrange.
        Cell celda1 = new Cell (2);
        String celda2 = "2";

        // Act.
        boolean resultado = celda1.equals (celda2);

        // Assert.
        assertFalse (resultado);
    }

    @Test
    public void hashCodeTestPositive() {
        int value = 2;
        Cell myCell1 = new Cell(value);
        Cell myCell2 = new Cell(value);

        boolean canMerge = myCell1.hashCode() == myCell2.hashCode();

        assertTrue(canMerge);
    }

    @Test
    public void hashCodeTestNegative() {
        int value1 = 0;
        int value2 = 2;
        Cell myCell1 = new Cell(value1);
        Cell myCell2 = new Cell(value2);

        boolean canMerge = myCell1.hashCode() == myCell2.hashCode();

        assertFalse(canMerge);
    }

    @Test
    public void toStringEmpty() {
        // Arrange
        int value = 0;
        Cell myCell = new Cell(value);

        // Act - Assert
        assertEquals(".", myCell.toString());
    }

    @Test
    public void toStringWithValue() {
        // Arrange
        int value = 2;
        Cell myCell = new Cell(value);
        
        // Act - Assert
        assertEquals("2", myCell.toString());
    }


    @Test
    public void repOkFalsoPorNoSerPotenciaDeDos() throws Exception {
        // Arrange
        Cell cell = new Cell(2);

        Field field = Cell.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(cell, 3);

        // Act - Assert
        assertFalse(cell.repOk());
    }

    @Test
    public void repOkFalsoPorSerNegativo() throws Exception {
        // Arrange
        Cell cell = new Cell(2);

        Field field = Cell.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(cell, -3);

        // Act - Assert
        assertFalse(cell.repOk());
    }
}