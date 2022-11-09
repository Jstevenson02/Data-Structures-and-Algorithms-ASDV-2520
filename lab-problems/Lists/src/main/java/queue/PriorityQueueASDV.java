/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;

public class PriorityQueueASDV<E extends Comparable<E>>
        implements Queue<E>, Cloneable {

    private Node<E> head;//head
    private Node<E> tail;//tail

    class Node<E> {

        E e;
        Node<E> l;
        Node<E> r;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without
     * violating capacity restrictions, returning true upon success and throwing an
     * IllegalStateException if no space is currently available.
     *
     * Specified by: add in interface Collection<E>
     * Parameters: e - the element to add Returns: true (as specified by Collection.add(E)) Throws:
     * IllegalStateException - if the element cannot be added at this time due to capacity
     * restrictions ClassCastException - if the class of the specified element prevents it from
     * being added to this queue NullPointerException - if the specified element is null and this
     * queue does not permit null elements IllegalArgumentException - if some property of this
     * element prevents it from being added to this queue
     *
     * @param e - the element to add
     * @return true if this collection changed as a result of the call
     * @throws IllegalStateException - if the element cannot be added at this time due to capacity
     * restrictions
     * @throws ClassCastException - if the class of the specified element
     * @throws NullPointerException - if the specified element is null and this queue does not
     * permit null elements
     * @throws IllegalArgumentException - if some property of this element prevents it from being
     * added to this queue
     */
    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException("NULL elements not allowed!");
        }

        Node<E> newNode = new Node<E>();
        newNode.e = e;

        //1. empty queue
        if (this.head == null && this.tail == null) {
            this.head = this.tail = newNode;
            return true;
        }

        int index = findCorrectPositionToInsertElement(e);
        // int index = findCorrectPositionToInsertElementHashCode(e);

        //2. we add at size ( last node)
        if (index == size()) {
            tail.r = newNode;//1
            newNode.l = tail;//2
            tail = newNode;//3
        } //3. we add at 0 in the front
        else if (index == 0) {
            newNode.r = head;
            this.head.l = newNode;
            this.head = newNode;
        } //4. we add in the middle
        else {
            Node<E> p = head;

            for (int i = 0; i < index - 1; ++i) {
                p = p.r;
            }

            //after for loop p point one position before insertion
            newNode.l = p;//we connect the left of the new node 
            //to the node that is BEFORE 
            //the node to be inserted

            newNode.r = p.r;//we connect the right of the new node
            // to the node thta is AFTER 
            //the node to be inserted

            p.r = newNode; //we connect the right the  node BEFORE the node
            //to be inserted to the new node

            p.r.l = newNode;//we connect the left of the node AFTER the node 
            //to be iserted to the new node
        }

        return true;
    }

    /**
     * public int size() Description copied from interface: Collection Returns the number of
     * elements in this collection. If this collection contains more than Integer.MAX_VALUE
     * elements, returns Integer.MAX_VALUE. Specified by: size in interface Collection<E>
     * Specified by: size in class AbstractCollection<E>
     * Returns: the number of elements in this collection
     */
    @Override
    public int size() {
        Node<E> p = this.head;
        int count = 0;
        while (p != null) {
            p = p.r;
            count++;
        }
        return count;
    }

    private int findCorrectPositionToInsertElementHashCode(E e) {
        Node<E> p = this.head;
        int pos = 0;
        while (p != null) {
            if (e.hashCode() > p.e.hashCode()) {
                p = p.r;
                ++pos;
            } else {
                break;
            }
        }

        return pos;
    }

    private int findCorrectPositionToInsertElement(E e) {
        Node<E> p = this.head;
        int pos = 0;
        while (p != null) {
            if (e.compareTo(p.e) > 0) {
                p = p.r;
                ++pos;
            } else {
                break;
            }
        }

        return pos;
    }

    /**
     * public boolean offer(E e) Inserts the specified element into this priority queue. Specified
     * by: offer in interface Queue<E>
     * Parameters: e - the element to add Returns: true (as specified by Queue.offer(E)) Throws:
     * ClassCastException - if the specified element cannot be compared with elements currently in
     * this priority queue according to the priority queue's ordering NullPointerException - if the
     * specified element is null
     */
    @Override
    public boolean offer(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * public boolean remove(Object o) Removes a single instance of the specified element from this
     * queue, if it is present. More formally, removes an element e such that o.equals(e), if this
     * queue contains one or more such elements. Returns true if and only if this queue contained
     * the specified element (or equivalently, if this queue changed as a result of the call).
     * Specified by: remove in interface Collection<E>
     * Overrides: remove in class AbstractCollection<E>
     * Parameters: o - element to be removed from this queue, if present Returns: true if this queue
     * changed as a result of the call
     */
    @Override
    public E remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * public E poll() Description copied from interface: Queue Retrieves and removes the head of
     * this queue, or returns null if this queue is empty. Specified by: poll in interface Queue<E>
     * Returns: the head of this queue, or null if this queue is empty
     */
    @Override
    public E poll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     */
    @Override
    public E element() {
        return (E) this.head;
    }

    /**
     * public E peek() Description copied from interface: Queue Retrieves, but does not remove, the
     * head of this queue, or returns null if this queue is empty. Specified by: peek in interface
     * Queue<E>
     * Returns: the head of this queue, or null if this queue is empty
     */
    @Override
    public E peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null ? true : false;
    }

    /**
     * public boolean contains(Object o) Returns true if this queue contains the specified element.
     * More formally, returns true if and only if this queue contains at least one element e such
     * that o.equals(e). Specified by: contains in interface Collection<E>
     * Overrides: contains in class AbstractCollection<E>
     * Parameters: o - object to be checked for containment in this queue Returns: true if this
     * queue contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * public Iterator<E> iterator() Returns an iterator over the elements in this queue. The
     * iterator does not return the elements in any particular order. Specified by: iterator in
     * interface Iterable<E>
     * Specified by: iterator in interface Collection<E>
     * Specified by: iterator in class AbstractCollection<E>
     * Returns: an iterator over the elements in this queue
     */
    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * public Object[] toArray() Returns an array containing all of the elements in this queue. The
     * elements are in no particular order. The returned array will be "safe" in that no references
     * to it are maintained by this queue. (In other words, this method must allocate a new array).
     * The caller is thus free to modify the returned array.
     *
     * This method acts as bridge between array-based and collection-based APIs.
     *
     * Specified by: toArray in interface Collection<E>
     * Overrides: toArray in class AbstractCollection<E>
     * Returns: an array containing all of the elements in this queue
     */
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * public boolean remove(Object o) Removes a single instance of the specified element from this
     * queue, if it is present. More formally, removes an element e such that o.equals(e), if this
     * queue contains one or more such elements. Returns true if and only if this queue contained
     * the specified element (or equivalently, if this queue changed as a result of the call).
     * Specified by: remove in interface Collection<E>
     * Overrides: remove in class AbstractCollection<E>
     * Parameters: o - element to be removed from this queue, if present Returns: true if this queue
     * changed as a result of the call *
     */
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Null Values not Allowed!");
        }
        Node<E> p = this.head;
        int pos = 0;
        while (p != this.tail) {
            ++pos;
            if (p.e.equals(o)) {
                // remove 
                this.removeAt(pos, (E) o);
                break;
            }
            ++pos;
            p = p.r;
        }
        if (p == tail && p.e.equals(o)) {
            this.removeAt(size() - 1, (E) o);

        }
        return true;
    }

    private boolean removeAt(int pos, E e) {
        if (pos < 0 || pos >= size()) {
            throw new IndexOutOfBoundsException(pos + "is Out of Bounds!");
        }
        // List empty
        if (isEmpty()) {
            return false;
        } // Only 1 node exists
        else if (size() == 1) {
            this.head = this.tail = null;
        } // Remove head node
        else if (pos == 0) {
            this.head = this.head.r;
            this.head.l = null;
        } // Remove tail node
        else if (pos == size() - 1) {
            this.tail = this.tail.l;
            this.tail.r = null;
        } else {
            Node<E> p = head;
            for (int i = 0; i < pos - 1; ++i) {
                p = p.r;
                p.r = p.r.r;
                p.r.l = p;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Queue.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        String s = "PriorityQueueASDV {";
        Node<E> p = head;
        while (p != null) {
            s += p.e.toString();
            if (p != tail) {
                s += ", ";
            }
            p = p.r;
        }

        s += "}";
        return s;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        System.out.println("\n--> PriorityQueueASDV  testing add");
        PriorityQueueASDV<String> pq1 = new PriorityQueueASDV();
        pq1.add("Paris");
        pq1.add("Athens");
        pq1.add("London");
        pq1.add("Lafayette");
        pq1.add("Berlin");

        System.out.println(pq1);

        System.out.println("\n--> Colllections PriorityQueue testing add");

        PriorityQueue<String> pq2 = new PriorityQueue();
        pq2.add("Paris");
        pq2.add("Athens");
        pq2.add("London");
        pq2.add("Lafayette");
        pq2.add("Berlin");

        System.out.println("element ========");
        System.out.println(pq1.element());
        System.out.println("element ========");

        System.out.println(pq2);

        System.out.println(pq2.peek());

        //TEST IT FULLY HERE. FOR ALL METHODS AND ALL CASES.
        //HAve the JAva PriorityQueue below
        System.out.println("Remove from front: ");
        pq1.remove("Athen");
        System.out.println(pq1);
    }

}
