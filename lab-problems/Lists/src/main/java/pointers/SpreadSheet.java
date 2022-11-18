package pointers;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertColumn(int index) {
        Node<E> headOfColumn = this.startNode;

        for (int column = 0; column < columns; ++column) {
            if (column == index) {
                headOfColumn = headOfColumn.right;
            }
        }

        return true;
    }

    @Override
    public boolean insertCell(E e, int rowIndex, int columnIndex) {
        return true;

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

        sp.setCell(0, 0, 0);
        sp.setCell(0, 1, 0);
        sp.setCell(0, 2, 0);
        sp.setCell(0, 3, 0);
        
        sp.setCell(0, 0, 1);
        sp.setCell(0, 1, 1);
        sp.setCell(0, 2, 1);
        sp.setCell(0, 3, 1);

        sp.setCell(0, 0, 2);
        sp.setCell(0, 1, 2);
        sp.setCell(0, 2, 2);
        sp.setCell(0, 3, 2);
        
        sp.setCell(0, 0, 3);
        sp.setCell(0, 1, 3);
        sp.setCell(0, 2, 3);
        sp.setCell(0, 3, 3);


        System.out.println(sp);
        sp.insertColumn(2);

    }
}
