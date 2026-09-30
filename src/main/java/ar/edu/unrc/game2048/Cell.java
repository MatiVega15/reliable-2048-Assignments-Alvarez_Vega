package ar.edu.unrc.game2048;

import java.util.Objects;

import randoop.CheckRep;

/**
 * Represents a single cell in the 2048 game board.
 * A cell is either empty (value = 0) or contains a power of two (2, 4, 8, ...).
 * 
 * Representation Invariant:
 * - value >= 0
 * - if value > 0, then value is a power of two 
 * 
 * Immutable class - once created, a Cell cannot change its value.
 */
public final class Cell {

    /**
     * Cell value (0 for empty, or a power of two).
     */
    private final int value;
    
    /**
     * The empty cell singleton (value = 0).
     */
    public static final Cell EMPTY = new Cell(0);
    
    /**
     * Creates a new cell with the given value.
     * 
     * @param value the value of the cell (must be 0 or a power of two)
     * @throws IllegalArgumentException if the value is negative or not a power of two (except 0)
     */
    public Cell(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Cell value cannot be negative: " + value);
        }

        if (value > 0 && !esPotenciaDeDos (value)) {
            throw new IllegalArgumentException ("El valor de la celda debe ser una potencia de dos: " + value);
        }

        this.value = value;
    }

    /**
     * Verifica si un valor es una potencia de 2.
     *
     * @param valor El valor a verificar.
     * @return true Si el valor es una potencia de 2, false en caso contrario.
     */
    private static boolean esPotenciaDeDos (int valor) {
        // Toda potencia de 2 tiene un único bit '1' en su representación binaria.
        return Integer.bitCount (valor) == 1;
    }
    
    /**
     * Checks if this cell is empty.
     * 
     * @return true if the cell is empty (value == 0), false otherwise
     */
    public boolean isEmpty() {
        return value == 0;
    }
    
    /**
     * Gets the numeric value of this cell.
     * 
     * @return the cell value (0 for empty cells)
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Checks if this cell can merge with another cell.
     * Two cells can merge if they are both non-empty and have the same value.
     * 
     * @param other the other cell to check merge compatibility with (not null).
     * @return true if the cells can merge, false otherwise
     * @throws IllegalArgumentException if other is null.
     */
    public boolean canMergeWith(Cell other) {
        if (other == null) {
            throw new IllegalArgumentException ("La celda dada no puede ser nula.");
        }
        
        if (this.isEmpty() || other.isEmpty()) {
            return false;
        }
        return this.value == other.value;
    }
    
    /**
     * Creates a new cell that is the result of merging this cell with another.
     * The resulting cell has double the value.
     * 
     * @param other the cell to merge with (must have the same value, not null).
     * @return a new Cell with the merged value
     * @throws IllegalArgumentException if the cells cannot be merged or it's null.
     */
    public Cell mergeWith(Cell other) {
        if (other == null) {
            throw new IllegalArgumentException ("La celda dada no puede ser nula.");
        }
        
        if (!canMergeWith(other)) {
            throw new IllegalArgumentException(
                "Cannot merge cells: " + this + " and " + other
            );
        }
        return new Cell(this.value * 2);
    }

    /**
     * Compares this cell with another object for equality.
     * Two cells are equal if they have the same value.
     * 
     * @param o the object to compare with
     * @return true if the object is a Cell with the same value, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return value == cell.value;
    }
    
    /**
     * Returns the hash code for this cell.
     * Cells with the same value will have the same hash code.
     * 
     * @return the hash code based on the cell's value
     */
    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
    
    /**
     * Returns a string representation of this cell.
     * Empty cells (value = 0) are represented as ".", non-empty cells as their numeric value.
     * 
     * @return "." if the cell is empty, otherwise the numeric value as a string
     */
    @Override
    public String toString() {
        return value == 0 ? "." : String.valueOf(value);
    }

    /**
     * Verifies that Cell is in a valid state.
     * Cell is valid when it's either a power of 2, or 0 (representing an empty cell).
     *
     * @return true if it is a valid cell, otherwise false.
     */
    @CheckRep
    public boolean repOk () {
        return value >= 0 && (value == 0 || esPotenciaDeDos (value));
    }
}