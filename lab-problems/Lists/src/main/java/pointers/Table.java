/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointers;

/**
 *
 * @author jacob
 */
public interface Table<E> {

    /**
     * Creates a rows x columns table
     *
     * @param rows number of roes
     * @param columns number of columns
     * @throws IllegalArgumentException if rows/columns are not GT zero.
     * @return true if the table was created successfully, false otherwise
     */
    boolean createTable(int rows, int columns);

    /**
     * Inserts a new row into the table.
     *
     * @param index the index of the row.
     * @throws IllegalArgumentException if the index is outside the bounds of
     * the table. Valid bounds are 0 to number of rows.
     * @return true if the rows was inserted successfully, false otherwise.
     */
    boolean insertRow(int index);

    /**
     * Inserts a new column into the table.
     *
     * @param index the index of the column.
     * @throws IndexOutOfBoundsException if the index is outside the bounds of
     * the table. Valid bounds are 0 to number of columns.
     * @return true if the column was inserted successfully, false otherwise.
     */
    boolean insertColumn(int index);

    /**
     * Inserts an element into the table.
     *
     * @param e the element to be inserted.
     * @param rowIndex the index of the row
     * @param columnIndex the index of the column
     * @throws IndexOutOfBoundsException if any of the indexes are outside the
     * bounds of the table.
     * @return true if the element was inserted successfully, false otherwise.
     */
    boolean insertCell(E e, int rowIndex, int columnIndex);

// Do not implement 
    /**
     * Removes the element at the given indexes.
     *
     * @param rowIndex row index
     * @param columnIndex column index
     * @throws IndexOutOfBoundsException if any of the indexes are outside the
     * bounds of the table.
     * @return true if cell was removed, false otherwise.
     */
    boolean removeCell(int rowIndex, int columnIndex);

// Do not implement 
    /**
     * Removes an element.
     *
     * @param e the element to be removed
     * @throws NuppPointerException if the parameter is null
     * @return the removed element if it exists, null otherwise
     */
    E removeCell(E e);

    /**
     * Retrieves the element of a cell.
     *
     * @param rowIndex row of cell
     * @param columnIndex column of cell\
     * @throws IndexOutOfBoundsException if any of the indexes are outside the
     * bounds of the table.
     * @return the element in the cell.
     */
    E getCell(int rowIndex, int columnIndex);

    /**
     * Sets the element of a cell.
     *
     * @param element e replaces null in table
     * @param rowIndex row of cell
     * @param columnIndex column of cell\
     * @throws IndexOutOfBoundsException if any of the indexes are outside the
     * bounds of the table.
     */
    void setCell(E e, int rowIndex, int columnIndex);

    /**
     * Clears the table
     */
    void clear();

    /**
     * Returns the column as an array.
     *
     * @param rowIndex the index of the row
     * @throws IndexOutOfBoundsException if the index is outside the bounds of
     * the table. Valid bounds are 0 to number of columns-1.
     * @return an array for the given row index
     */
    E[] rowToArray(int columnIndex);

    /**
     * Returns the column as an array.
     *
     * @param columnIndex the index of the column
     * @throws IndexOutOfBoundsException if the index is outside the bounds of
     * the table. Valid bounds are 0 to number of columns-1.
     * @return an array for the given column index.
     */
    E[] columnToArray(int columnIndex);

    /**
     * Creates and returns a 2D array for the table.
     *
     * @return a 2D array.
     */
    E[][] tableToArray();

    /**
     * Moves a column from position from to position to
     *
     * @param from current position of the column
     * @param to new position of the column
     * @throws IndexOutOfBoundsException if any of the indexes are outside the
     * bounds of the table.
     * @return true if the column was moved successfully, false otherwise
     */
    boolean moveColumn(int from, int to);

    /**
     * Moves a row from position from to position to
     *
     * @param from current position of the column
     * @param to new position of the row
     * @throws IndexOutOfBoundsException if any of the indexes are outside the
     * bounds of the table.
     * @return true if the row was moved successfully, false otherwise
     */
    boolean moveRow(int from, int to);
}
