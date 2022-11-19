package pointers;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpreadSheet<E> implements Table<E>, Cloneable {

    private int rows;//current rows in spreadsheet
    private int columns;//current colums in spreadsheet

    private Node<E> startNode;//points to node at position 0,0

    static class Node<E> {

        E e;
        Node<E> up;
        Node<E> down;
        Node<E> left;
        Node<E> right;
    }

    // Create table does not have up/down pointers for any column except first.
    /**
     * Creates a rows x columns table
     *
     * @param rows number of roes
     * @param columns number of columns #thows IllegalArgumentException if rows/columns are not GT
     * zero.
     * @return true if the table was created successfully, false otherwise
     */
    public boolean createTable(int rows, int columns) {

        if (rows < 1 && columns < 1) {
            throw new IllegalArgumentException();
        }
        this.rows = rows;
        this.columns = columns;

        Node<E> previousHorz = null;
        Node<E> previousVert = null;
        for (int row = 0; row < rows; ++row) {
            for (int column = 0; column < columns; ++column) {

                Node<E> newNode = new Node();

                if (row == 0 && column == 0)//node at ( 0,0)//head node of 1st row
                {
                    startNode = previousHorz = previousVert = newNode;
                } else if (column == 0)// node at ( i,0)//head node of every row
                {
                    newNode.up = previousVert;
                    previousVert.down = newNode;
                    previousHorz = previousVert = newNode;
                } else//2nd to last node in every row
                {
                    newNode.left = previousHorz;
                    previousHorz.right = newNode;
                    if (row != 0)//middle rows connect up 
                    {
                        newNode.up = previousHorz.up.right;
                    }

                    previousHorz = previousHorz.right;
                }
            }
        }
        return true;
    }

    @Override
    public boolean insertRow(int index) {

        if (index >= rows) {
            System.out.println("Index out Bounds");
            return false;
        }

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int c = 0; c < index; c++) {
            currentNode = currentNode.down;
        }

        for (int r = 0; r < this.columns; r++) {
            currentNode.e = null;
            currentNode = currentNode.right;
        }
        return true;
    }

    @Override
    public boolean insertColumn(int index) {

        if (index >= columns) {
            System.out.println("Index out Bounds");
            return false;
        }

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int r = 0; r < rows; r++) {

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            for (int c = 0; c < index; c++) {

                rowNode = rowNode.right;
            }

            rowNode.e = null;
            currentNode = currentNode.down;
        }
        return true;
    }

    @Override
    public boolean insertCell(E e, int rowIndex, int columnIndex) {

        if (rowIndex >= rows || columnIndex >= columns) {
            System.out.println("Out Bounds");
            return false;
        }

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int c = 0; c < rowIndex; c++) {
            currentNode = currentNode.down;
        }

        for (int r = 0; r < columnIndex; r++) {
            currentNode = currentNode.right;
        }

        if (currentNode.e != null) {
            System.out.println("Cannot Insert");
            return false;
        }
        currentNode.e = e;

        return true;

    }

    @Override
    public boolean removeCell(int rowIndex, int columnIndex) {
        if (rowIndex >= rows || columnIndex >= columns) {
            System.out.println("Out Bounds");
            return false;
        }

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int c = 0; c < columnIndex; c++) {
            currentNode = currentNode.down;
        }

        for (int r = 0; r < rowIndex; r++) {
            currentNode = currentNode.right;
        }

        if (currentNode.e == null) {
            System.out.println("Cannot Remove Already Null");
            return false;
        }

        currentNode.e = null;
        return true;
    }

    @Override
    public E removeCell(E e) {

        Node<E> currentNode = new Node();

        E ex = null;

        currentNode = this.startNode;
        for (int c = 0; c < this.columns; c++) {

            if (currentNode.e == e) {

                System.out.println("Element Found and Removed!");
                ex = currentNode.e;
                currentNode.e = null;
                return ex;
            }

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            for (int r = 1; r < this.rows; r++) {

                rowNode = rowNode.right;

                if (rowNode.e == e) {

                    System.out.println("Element Found and Removed!");
                    ex = currentNode.e;
                    rowNode.e = null;
                    return ex;
                }
            }
            currentNode = currentNode.down;
        }
        System.out.println("Element Not Found!");
        return null;
    }

    @Override
    public E getCell(int rowIndex, int columnIndex) {
        Node<E> headOfRow = this.startNode;

        ///headOfRow points to the first cell of row rowIndex
        for (int i = 0; i < rowIndex; ++i) {
            headOfRow = headOfRow.down;
        }

        Node<E> p = headOfRow;
        for (int i = 0; i < columnIndex; ++i) {
            p = p.right;
        }

        return p.e;
    }

    @Override
    public void setCell(E e, int rowIndex, int columnIndex) {
        Node<E> headOfRow = this.startNode;

        ///headOfRow points to the first cell of row rowIndex
        for (int i = 0; i < rowIndex; ++i) {
            headOfRow = headOfRow.down;
        }

        Node<E> p = headOfRow;
        for (int i = 0; i < columnIndex; ++i) {
            p = p.right;
        }
        p.e = e;

    }

    @Override
    public void clear() {

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int r = 0; r < rows; r++) {

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            for (int c = 0; c < columns; c++) {
                rowNode.e = null;
                rowNode = rowNode.right;
            }

            currentNode = currentNode.down;
        }
    }

    @Override
    public E[] rowToArray(int columnIndex) {

        ArrayList<E> elementArray = new ArrayList<E>();

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        // This should be row index
        for (int r = 0; r < columnIndex; r++) {

            currentNode = currentNode.down;
        }

        for (int c = 0; c < columns; c++) {
            elementArray.add(currentNode.e);
            currentNode = currentNode.right;
        }

        return (E[]) elementArray.toArray();
    }

    @Override
    public E[] columnToArray(int columnIndex) {
        ArrayList<E> elementArray = new ArrayList<E>();

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        // This should be row index
        for (int r = 0; r < rows; r++) {

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            for (int c = 0; c < columnIndex; c++) {
                rowNode = rowNode.right;
            }

            elementArray.add(rowNode.e);

            currentNode = currentNode.down;
        }
        return (E[]) elementArray.toArray();
    }

    @Override
    public E[][] tableToArray() {

        ArrayList<ArrayList<E>> array = new ArrayList<ArrayList<E>>();

        for (int rowCount = 0; rowCount < rows; rowCount++) {
            array.add(new ArrayList<E>());
        }

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int r = 0; r < rows; r++) {

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            for (int c = 0; c < columns; c++) {

                array.get(r).add(rowNode.e);
                rowNode = rowNode.right;
            }

            currentNode = currentNode.down;
        }
        return (E[][]) array.stream().map(l -> l.stream().toArray(Object[]::new)).toArray(Object[][]::new);
    }

    @Override
    public boolean moveColumn(int from, int to) {

        if ((from < 0 || from >= columns) || (to < 0 || to >= columns)) {
            System.out.println("Out of Bounds");
            return false;
        }

        Node<E> currentNode = new Node();
        currentNode = startNode;

        for (int r = 0; r < rows; r++) {

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            Node<E> rowNode2 = new Node();
            rowNode2 = currentNode;

            for (int c = 0; c < from; c++) {
                rowNode = rowNode.right;
            }

            for (int c = 0; c < to; c++) {
                rowNode2 = rowNode2.right;
            }

            rowNode2.e = rowNode.e;
            rowNode.e = null;

            currentNode = currentNode.down;
        }
        return true;

    }

    @Override
    public boolean moveRow(int from, int to) {

        if ((from < 0 || from >= rows) || (to < 0 || to >= rows)) {
            System.out.println("Out of Bounds");
            return false;
        }

        Node<E> rowNode = new Node();
        rowNode = startNode;

        Node<E> rowNode2 = new Node();
        rowNode2 = startNode;

        for (int r = 0; r < from; r++) {
            rowNode = rowNode.down;
        }

        for (int r = 0; r < to; r++) {
            rowNode2 = rowNode2.down;
        }

        for (int c = 0; c < columns; c++) {
            rowNode2.e = rowNode.e;
            rowNode.e = null;
            rowNode = rowNode.right;
            rowNode2 = rowNode2.right;
        }

        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SpreadSheet<E> sheet = new SpreadSheet<E>();
        sheet.createTable(rows, columns);

        Node<E> currentNode = new Node();
        currentNode = this.startNode;

        for (int r = 0; r < rows; r++) {

            Node<E> rowNode = new Node();
            rowNode = currentNode;

            // getCell does not work 
            for (int c = 0; c < columns; c++) {
                sheet.setCell(rowNode.e, r, c);
                rowNode = rowNode.right;
            }

            currentNode = currentNode.down;
        }
        return sheet;
    }

    @Override
    public String toString() {
        String s = "";
        Node<E> p = this.startNode;
        Node<E> headOfNextRow = this.startNode;
        for (int i = 0; i < this.rows; ++i) {
            p = headOfNextRow;
            for (int j = 0; j < this.columns; ++j) {
                s += p.e + " ";
                p = p.right;
            }
            s += "\n";
            headOfNextRow = headOfNextRow.down;
        }
        return s;
    }

    public static void main(String[] args) {
        SpreadSheet sp = new SpreadSheet<Integer>();
        sp.createTable(4, 4);

        sp.setCell(1, 0, 0);
        sp.setCell(1, 1, 0);
        sp.setCell(1, 2, 0);
        sp.setCell(1, 3, 0);

        sp.setCell(1, 0, 1);
        sp.setCell(0, 1, 1);
        sp.setCell(0, 2, 1);
        sp.setCell(0, 3, 1);

        sp.setCell(1, 0, 2);
        sp.setCell(0, 1, 2);
        sp.setCell(0, 2, 2);
        sp.setCell(0, 3, 2);

        sp.setCell(1, 0, 3);
        sp.setCell(0, 1, 3);
        sp.setCell(0, 2, 3);
        sp.setCell(0, 3, 3);

        System.out.println("\n" + "------------------------------Original Table------------------------------------");
        System.out.println(sp);

        System.out.println("\n" + "------------------------------Insert Column------------------------------------");
        sp.insertColumn(2);

        System.out.println("\n" + "------------------------------Insert Row------------------------------------");
        sp.insertRow(2);

        System.out.println("\n" + "------------------------------Remove Cell col row ------------------------------------");
        sp.removeCell(2, 2);

        System.out.println("\n" + "------------------------------Remove Cell E------------------------------------");
        sp.removeCell(5);

        System.out.println("\n" + "------------------------------Insert Cell------------------------------------");
        sp.insertCell(1, 2, 0);
        sp.insertCell(5, 2, 2);

        System.out.println("\n" + "------------------------------Row To Array------------------------------------");

        Object[] ints = sp.rowToArray(2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        System.out.println("\n" + "------------------------------Column To Array------------------------------------");
        Object[] ints2 = sp.columnToArray(2);
        for (int i = 0; i < ints2.length; i++) {
            System.out.println(ints2[i]);
        }

        System.out.println("\n" + "------------------------------Move Column------------------------------------");
        sp.moveColumn(0, 3);
        System.out.println(sp);

        System.out.println("\n" + "------------------------------Move Row------------------------------------");
        sp.moveRow(0, 3);

        System.out.println("\n" + "------------------------------Copy Sheet------------------------------------");
        try {
            System.out.println(sp.clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(SpreadSheet.class.getName()).log(Level.SEVERE, null, ex);
        }

//        sp.clear();
        System.out.println("\n" + "------------------------------Final Table------------------------------------");
        System.out.println(sp);

    }
}
