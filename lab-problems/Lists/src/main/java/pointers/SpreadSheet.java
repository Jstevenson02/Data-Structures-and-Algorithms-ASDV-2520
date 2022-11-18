package pointers;

/**
<<<<<<< HEAD
 * The table is a collection of horizontal quadruple linked lists.The table
 * cannot be jagged. For example, row 0 is a double linked list and the head of
 * the list points at cell (0,0) Row 1 is a double linked list and the head of
 * the list points at cell (0,0). Row 2 is a double linked list and the head of
 * the list points at cell (1,0) And so on.
=======
 * The table is a collection of horizontal quadruple linked lists. The table cannot be jagged.
 *
 * For example, row 0 is a double linked list and the head of the list points at cell (0,0) Row 1 is
 * a double linked list and the head of the list points at cell (0,0). Row 2 is a double linked list
 * and the head of the list points at cell (1,0) And so on.
>>>>>>> 2dbebb6c709d2df634f928a2545e18a0425a06ae
 *
 * The Node at ( 0,0 ) has its pointers: up --> null down --> Node at (1,0) left --> null right --?
 * Node at (0,1)
 *
 *
<<<<<<< HEAD
 * A Node at ( 2,3 ) has its pointers: up --> Node(1,3) down --> Node at (3,3)
 * left --> Node(2,2) right --? Node at ( 2,4)
=======
 *  * A Node at ( 2,3 ) has its pointers: up --> Node(1,3) down --> Node at (3,3) left --> Node(2,2)
 * right --? Node at ( 2,4)
>>>>>>> 2dbebb6c709d2df634f928a2545e18a0425a06ae
 *
 * And so on.
 *
 * @author ASDV2
 * @param <E>
 */
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

    /**
     * Creates a rows x columns table
     *
     * @param rows number of roes
     * @param columns number of columns #thows IllegalArgumentException if rows/columns are not GT
     * zero.
     * @return true if the table was created successfully, false otherwise
     */
    public boolean createTable(int rows, int columns) {

        Node<E> previousHorzNode = null;
        Node<E> previousVertNode = null;
        for (int horzIndex = 0; horzIndex < rows; ++horzIndex) {
            for (int vertIndex = 0; vertIndex < columns; ++vertIndex) {
                Node<E> newNode = new Node();
                if (horzIndex == 0 && vertIndex == 0)//node at (0, 0) //head node of 1st row
                {
                    startNode = previousHorzNode = previousVertNode = newNode;
                } else if (vertIndex == 0)// node at (vertIndex, 0) //head node of every row
                {
                    newNode.up = previousVertNode;
                    previousVertNode.down = newNode;
                    previousHorzNode = previousVertNode = newNode;
                } else//2nd to last node in every row
                {
                    newNode.left = previousHorzNode;
                    previousHorzNode.right = newNode;
                    if (horzIndex != 0)//middle rows connect up 
                    {
                        newNode.up = previousHorzNode.up.right;
                    }
                    previousHorzNode = previousHorzNode.right;
                }
            }
        }
        return true;
    }

    @Override
    public boolean insertRow(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertColumn(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertCell(E e, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeCell(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E removeCell(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E getCell(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCell(E e, int rowIndex, int columnIndex) {

        Node<E> headOfRow = this.startNode;

        // headOfRow points to the Node at rowIndex
        for (int i = 0; i < rowIndex; ++i) {
            headOfRow = headOfRow.down;
        }

        Node<E> p = headOfRow;

        for (int j = 0; j < columnIndex; ++j) {
            p = p.right;
        }
        p.e = e;
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[] rowToArray(int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[] columnToArray(int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E[][] tableToArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveColumn(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean moveRow(int from, int to) {
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
        sp.setCell(10, 1, 2);
        System.out.println(sp);
    }
}
