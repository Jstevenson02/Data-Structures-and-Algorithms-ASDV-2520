/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pointers;

/**
 *
 * @author jacob
 */
public class SpreadSheet<E> implements Table<E>, Cloneable {

    private int rows;//current rows in spreadsheet
    private int columns;//current colums in spreadsheet

    private Node<E> startNode;//points to node at position 0,0

    class Node<E> {

        E e;
        Node<E> up;
        Node<E> down;
        Node<E> left;
        Node<E> right;
    }

    @Override
    public boolean createTable(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        Node<E> head = this.startNode;
        Node<E> p = startNode;

        for (int i = 0; i < rows; ++i) {
            p = head;
            for (int j = 0; j < columns; ++j) {
                Node<E> newNode = new Node<>();
                // the first node at (0, 0)
                if (i == 0 && j == 0) {
                    this.startNode = newNode;

                } else if (j == 0) {
                    newNode.up = head;
                    head.down = newNode;

                } else {
                    newNode.left = p;
                    p.right = newNode;
                    // 'a node in the second or third row or ith row'

                    if (i != this.rows - 1) {
                        p.up.right.down = newNode;
                    }

                    if (i != 0) {
                        newNode.up = p.up.right;
                    }
                    p = p.right;

                }
            }
            head = head.down; // move to the next row
        }
        return true;
    }

    @Override
    public boolean insertRow(int index
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertColumn(int index
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertCell(E e, int rowIndex, int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeCell(int rowIndex, int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeCell(E e
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getCell(int rowIndex, int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCell(E e, int rowIndex, int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[] rowToArray(int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[] columnToArray(int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[][] tableToArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveColumn(int from, int to
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveRow(int from, int to
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String s = "";
        Node<E> p = this.startNode;
        Node<E> head = this.startNode;

        for (int i = 0; i < this.rows; ++i) {
            head = head.down;
            for (int j = 0; j < this.columns; ++j) {
                s += p.e + " ";
            }
            p = head;
        }
        return s;
    }

    public static void main(String[] args) {
        SpreadSheet sp = new SpreadSheet<Integer>();
        sp.createTable(2, 2);
        System.out.println(sp);

    }
}
