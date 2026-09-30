package ar.edu.unrc.game2048;

import java.util.*;

import randoop.CheckRep;

/**
 * Represents the 2048 game board.
 * The board is a square grid of Cells, typically 4x4.
 *
 * Representation Invariants:
 * - grid is a non-null square matrix (rows == cols)
 * - all cells in the grid are non-null (they may be EMPTY)
 * - all cell values are valid per Cell invariants
 * - the board is always in a valid game state
 *
 * Thread-safety: This class is not thread-safe.
 */
public class Board {

    /**
     * Board default number of rows/columns (4 x 4)
     */
    public static final int DEFAULT_SIZE = 4;

    /**
     * Default winning value: when board contains this value, the player wins (2048)
     */
    public static final int WINNING_VALUE = 2048;

    /**
     * Board size (i.e., number of rows and columns). Must be > 0.
     */
    private final int size;

    /**
     * Contents of the board: a 2D array of Cells. grid[row][col] represents the cell at (row, col).
     */
    private final Cell[][] grid;

    /**
     * Game accumulated score.
     */
    private int score;

    /**
     * Estrategia de generación de nuevas fichas.
     */
    private final TileStrategy tileStrategy;

    /**
     * Creates a new board of the default size (4x4) with two random tiles.
     */
    public Board () {
        this (DEFAULT_SIZE, new RandomTileStrategy ());
    }

    /**
     * Creates a new board of the specified size with two random tiles.
     *
     * @param size the board size (must be > 0)
     * @throws IllegalArgumentException if size <= 0
     */
    public Board (int size) {
        this (size, new RandomTileStrategy ());
    }

    /**
     * Creates a new board with a specific size and tile generation strategy.
     *
     * @param size the board size (must be > 0)
     * @param strategy the tile generation strategy (not null).
     * @throws IllegalArgumentException if size <= 0 or strategy is null.
     */
    public Board (int size, TileStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException ("La estrategia dada no puede ser nula.");
        }
        
        if (size <= 0) {
            throw new IllegalArgumentException ("Board size must be positive: " + size);
        }
        this.size = size;
        this.grid = new Cell [size] [size];
        this.score = 0;
        this.tileStrategy = strategy;
        initializeEmpty ();
        addRandomTile ();
        addRandomTile ();
    }

    /**
     * Copy constructor - creates a deep copy of another board.
     *
     * @param other the board to copy (not null).
     * @throws IllegalArgumentException if other is null.
     */
    public Board(Board other) {
        if (other == null) {
            throw new IllegalArgumentException ("El tablero dado no puede ser nulo.");
        }
        
        this.size = other.size;
        this.grid = new Cell[size][size];
        this.score = other.score;
        this.tileStrategy = other.tileStrategy;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                this.grid[r][c] = other.grid[r][c];
            }
        }
    }

    /**
     * Initializes the board with all EMPTY cells.
     */
    private void initializeEmpty() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = Cell.EMPTY;
            }
        }
    }

    /**
     * Gets the board size (number of rows/columns).
     *
     * @return the board size
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the current score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the cell at the specified position.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @return the cell at the specified position
     * @throws IndexOutOfBoundsException if row or col is out of bounds
     */
    public Cell getCell(int row, int col) {
        validatePosition(row, col);
        return grid[row][col];
    }

    /**
     * Sets a cell at the specified position.
     *
     * @param row the row index (0-based)
     * @param col the column index (0-based)
     * @param cell the cell to set (must not be null)
     * @throws IndexOutOfBoundsException if row or col is out of bounds
     * @throws IllegalArgumentException if cell is null
     */
    public void setCell(int row, int col, Cell cell) {
        validatePosition(row, col);
        if (cell == null) {
            throw new IllegalArgumentException("Cell cannot be null");
        }
        grid[row][col] = cell;
    }

    /**
     * Validates that a position is within bounds.
     *
     * @param row the row index
     * @param col the column index
     * @throws IndexOutOfBoundsException if the position is out of bounds
     */
    private void validatePosition(int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            throw new IndexOutOfBoundsException(
                    String.format("Position (%d, %d) is out of bounds for board size %d",
                            row, col, size)
            );
        }
    }

    /**
     * Gets all empty cells on the board.
     *
     * @return a set of positions of all empty cells
     */
    public Set<Position> getEmptyPositions() {
        Set<Position> empty = new HashSet<>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].isEmpty()) {
                    empty.add(new Position(r, c));
                }
            }
        }
        return empty;
    }

    /**
     * Checks if the board has any empty cells.
     *
     * @return true if there is at least one empty cell
     */
    public boolean hasEmptyCells() {
        return !getEmptyPositions().isEmpty();
    }

    /**
     * Checks if the board is in a winning state.
     * A board is winning if it contains a cell with the WINNING_VALUE (2048).
     *
     * @return true if the board contains 2048
     */
    public boolean isWinningBoard() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (grid[r][c].getValue() == WINNING_VALUE) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the board is in a losing state (game over).
     * A board is losing if there are no empty cells AND no adjacent cells
     * (horizontal or vertical) can be merged.
     *
     * @return true if the game is over and the player has lost
     */
    public boolean isLosingBoard() {
        if (hasEmptyCells()) {
            return false;
        }

        // Check for possible merges
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Cell current = grid[r][c];
                // Check right neighbor
                if (c + 1 < size && current.canMergeWith(grid[r][c + 1])) {
                    return false;
                }
                // Check down neighbor
                if (r + 1 < size && current.canMergeWith(grid[r + 1][c])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if the board is full (no empty cells).
     *
     * @return true if there are no empty cells
     */
    public boolean isFull() {
        return !hasEmptyCells();
    }

    // ==================== MOVE OPERATIONS ====================

    /**
     * Moves all tiles upward.
     *
     * @return true if the board changed, false otherwise
     */
    public boolean moveUp() {
        Board previous = new Board(this);

        // For each column, slide up
        for (int col = 0; col < size; col++) {
            // Create a list of cells from top to bottom
            List<Cell> column = new ArrayList<>();
            for (int row = 0; row < size; row++) {
                column.add(grid[row][col]);
            }

            List <Cell> merged = procesarLinea (column);

            // Put back into the column
            int r = 0;
            for (Cell c : merged) {
                grid [r++] [col] = c;
            }
        }

        return finalizarMovimiento (previous);
    }

    /**
     * Moves all tiles downward.
     *
     * @return true if the board changed, false otherwise
     */
    public boolean moveDown() {
        Board previous = new Board(this);

        // For each column, slide down
        for (int col = 0; col < size; col++) {
            // Create a list of cells from bottom to top (reverse order)
            List<Cell> column = new ArrayList<>();
            for (int row = size - 1; row >= 0; row--) {
                column.add(grid[row][col]);
            }

            List <Cell> merged = procesarLinea (column);

            // Put back into the column (reverse back to original order)
            int r = size - 1;
            for (Cell c : merged) {
                grid [r--] [col] = c;
            }
        }

        return finalizarMovimiento (previous);
    }

    /**
     * Moves all tiles left.
     *
     * @return true if the board changed, false otherwise
     */
    public boolean moveLeft() {
        Board previous = new Board(this);

        // For each row, slide left
        for (int row = 0; row < size; row++) {
            // Create a list of cells from left to right
            List<Cell> rowList = new ArrayList<>();
            for (int col = 0; col < size; col++) {
                rowList.add(grid[row][col]);
            }

            List <Cell> merged = procesarLinea (rowList);

            // Put back into the row
            int c = 0;
            for (Cell celda : merged) {
                grid [row] [c++] = celda;
            }
        }

        return finalizarMovimiento (previous);
    }

    /**
     * Moves all tiles right.
     *
     * @return true if the board changed, false otherwise
     */
    public boolean moveRight() {
        Board previous = new Board(this);

        // For each row, slide right
        for (int row = 0; row < size; row++) {
            // Create a list of cells from right to left (reverse order)
            List<Cell> rowList = new ArrayList<>();
            for (int col = size - 1; col >= 0; col--) {
                rowList.add(grid[row][col]);
            }

            List <Cell> merged = procesarLinea (rowList);

            // Put back into the row (reverse back to original order)
            int c = size - 1;
            for (Cell celda : merged) {
                grid [row] [c--] = celda;
            }
        }

        return finalizarMovimiento (previous);
    }

    /**
     * Procesa una línea de celdas: elimina las celdas vacías, fusiona las celdas
     * adyacentes y completa con celdas vacías.
     *
     * @param celdas Las celdas de la fila o columna a procesar.
     * @return La línea procesada y completada con celdas vacías.
     */
    private List <Cell> procesarLinea (List<Cell> celdas) {
        // Remove empty cells
        List<Cell> nonEmpty = new ArrayList<>();
        for (Cell cell : celdas) {
            if (!cell.isEmpty()) {
                nonEmpty.add(cell);
            }
        }

        // Merge adjacent equal cells
        List<Cell> merged = new ArrayList<>();
        int i = 0;
        while (i < nonEmpty.size()) {
            if (i + 1 < nonEmpty.size() &&
                    nonEmpty.get(i).canMergeWith(nonEmpty.get(i + 1))) {
                Cell mergedCell = nonEmpty.get(i).mergeWith(nonEmpty.get(i + 1));
                merged.add(mergedCell);
                score += mergedCell.getValue();
                i += 2;
            } else {
                merged.add(nonEmpty.get(i));
                i++;
            }
        }

        // Pad with empty cells
        while (merged.size() < size) {
            merged.add(Cell.EMPTY);
        }

        return merged;
    }

    /**
     * Finaliza un movimiento verificando si el tablero cambió y agregando una
     * nueva ficha aleatoria cuando el movimiento fue válido.
     *
     * @param previo El tablero antes de realizar el movimiento.
     * @return true Si el tablero cambió, false en caso contrario.
     */
    private boolean finalizarMovimiento (Board previo) {
        boolean moved = !this.equals(previo);
        if (moved) {
            addRandomTile(); // Add new random tile after successful move
        }
        return moved;
    }

    // ==================== RANDOM TILE ADDITION (PRIVATE) ====================

    /**
     * Adds a random tile (2 or 4) to a random empty cell.
     * This method is private to maintain encapsulation - tiles are only added
     * during initialization or after successful moves.
     */
    private void addRandomTile () {
        Set <Position> empty = getEmptyPositions ();
        if (empty.isEmpty ()) {
            return;
        }

        // Se delega la lógica a la estrategia inyectada.
        Position pos = tileStrategy.determinarPosicion (empty);
        int value = tileStrategy.determinarValor ();

        grid [pos.row] [pos.col] = new Cell (value);
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Checks if this board is structurally identical to another.
     * Uses deep equality including score.
     *
     * @param o the object to compare
     * @return true if the boards are identical
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return size == board.size &&
                score == board.score &&
                Arrays.deepEquals(grid, board.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, Arrays.deepHashCode(grid), score);
    }

    /**
     * Returns a string representation of the board.
     * The board is displayed in a grid format with the current score.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score: ").append(score).append("\n");
        for (int r = 0; r < size; r++) {
            sb.append("+");
            for (int c = 0; c < size; c++) {
                sb.append("-----+");
            }
            sb.append("\n|");
            for (int c = 0; c < size; c++) {
                String val = grid[r][c].isEmpty() ? "     " :
                        String.format("%5d", grid[r][c].getValue());
                sb.append(val).append("|");
            }
            sb.append("\n");
        }
        sb.append("+");
        for (int c = 0; c < size; c++) {
            sb.append("-----+");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Verifica que el Board se encuentre en un estado de representación válido.
     *
     * Invariantes de representación:
     *  - size debe ser mayor que 0.
     *  - grid no debe ser null.
     *  - grid debe ser una matriz cuadrada de tamaño size x size.
     *  - score debe ser mayor o igual a 0.
     *  - Ninguna celda del grid debe ser null.
     *  - Todas las celdas deben cumplir su propio invariante de representación.
     *  - tileStrategy no debe ser null.
     *
     * @return true si el Board cumple todos los invariantes de representación,
     *         false en caso contrario.
     */
    @CheckRep
    public boolean repOk () {
        // El tamaño del tablero debe ser positivo.
        if (size <= 0) {
            return false;
        }

        // La matriz debe existir.
        if (grid == null) {
            return false;
        }

        // La matriz debe ser cuadrada.
        if (grid.length != size) {
            return false;
        }

        // El puntaje nunca debe ser negativo.
        if (score < 0) {
            return false;
        }

        for (int r = 0; r < size; r ++) {
            // Se verifica que cada fila sea válida y tenga la cantidad correcta de columnas.
            if (grid [r] == null || grid [r].length != size) {
                return false;
            }

            for (int c = 0; c < size; c ++) {
                Cell celda = grid [r] [c];

                // Se verifica que todas las celdas sean válidas.
                if (celda == null || !celda.repOk ()) {
                    return false;
                }
            }
        }

        // La estrategia debe estar definida.
        if (tileStrategy == null) {
            return false;
        }

        // Board válido.
        return true;
    }

    // ==================== INNER CLASSES ====================

    /**
     * Represents a direction on the board.
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * Represents a position on the board.
     */
    public static class Position {
        public final int row;
        public final int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row && col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "(" + row + ", " + col + ")";
        }
    }
}