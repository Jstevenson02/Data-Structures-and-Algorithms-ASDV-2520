/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Consumer;

public class PriorityQueueASDV<E extends Comparable<E>>
        implements Queue<E>, Cloneable {

    private Node<E> head; //head
    private Node<E> tail; //tail

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
        //int index = findCorrectPositionToInsertElementHashCode(e);

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
            if (size() == 1) {
                tail = head;
            }
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

            p.r.r.l = newNode;//we connect the left of the node AFTER the node 
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
        return add(e);
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
        if (isEmpty()) {
            return null;
        }
        if (size() > 1) {
            this.head = head.r;
            E e = head.l.e;
            head.l = null;
            return e;
        } else {
            E e = head.e;
            head = null;
            tail = null;
            return e;
        }
    }

    /**
     * public E element() Retrieves, but does not remove, the head of this queue. This method
     * differs from peek only in that it throws an exception if this queue is empty. This
     * implementation returns the result of peek unless the queue is empty.
     *
     * Specified by: element in interface Queue<E>
     * Returns: the head of this queue Throws: NoSuchElementException - if this queue is empty
     */
    @Override
    public E element() {
        if (this.head == null) {
            throw new NoSuchElementException("No such element.");
        }
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
        if (isEmpty()) {
            return null;
        }
        return (E) this.head;
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
        return true;
//        Node<E> p = head;

//        while (p != null) {
//
//        }
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
        Iterator<E> it = new Iterator<E>() {
            Node<E> p = head;

            @Override
            public boolean hasNext() {
                return p == null ? false : true;
            }

            @Override
            public E next() {
                if (hasNext() == false) {
                    throw new NoSuchElementException("the is no next element");
                }
                E e = p.e;
                p = p.r;
                return e;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                while (hasNext()) {
                    action.accept(p.e);
                    p = p.r;
                }
            }
        };

        return it;

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
            throw new NullPointerException("null vales not allowed");
        }
        if (size() == 0) {
            return false;
        }

        Node<E> p = this.head;
        int pos = 0;
        while (p != this.tail) {
            if (p.e.equals(o)) {
                if (size() == 1) {
                    this.head = this.tail = null;
                    return true;
                }
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

    /**
     *
     * @param pos
     * @param e
     * @throws IndexOutOfBoundsException - if pos less 0 OR pos greater-equal size()
     * @return
     */
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

    /**
     * public boolean addAll(Collection<? extends E> c) Adds all of the elements in the specified
     * collection to this queue. Attempts to addAll of a queue to itself result in
     * IllegalArgumentException. Further, the behavior of this operation is undefined if the
     * specified collection is modified while the operation is in progress. This implementation
     * iterates over the specified collection, and adds each element returned by the iterator to
     * this queue, in turn. A runtime exception encountered while trying to add an element
     * (including, in particular, a null element) may result in only some of the elements having
     * been successfully added when the associated exception is thrown.
     *
     * Specified by: addAll in interface Collection<E>
     * Overrides: addAll in class AbstractCollection<E>
     * Parameters: c - collection containing elements to be added to this queue Returns: true if
     * this queue changed as a result of the call Throws: ClassCastException - if the class of an
     * element of the specified collection prevents it from being added to this queue
     * NullPointerException - if the specified collection contains a null element and this queue
     * does not permit null elements, or if the specified collection is null
     * IllegalArgumentException - if some property of an element of the specified collection
     * prevents it from being added to this queue, or if the specified collection is this queue
     * IllegalStateException - if not all the elements can be added at this time due to insertion
     * restrictions
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        int sizeBefore = size();
        for (E e : c) {
            add(e);
        }
        int sizeAfter = size();

        return sizeAfter > sizeBefore;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * public void clear() Removes all of the elements from this priority queue. The queue will be
     * empty after this call returns. Specified by: clear in interface Collection<E>
     * Overrides: clear in class AbstractQueue<E>
     */
    @Override
    public void clear() {
        head = tail = null;
    }

    /**
     * Performs the given action for each element of the Iterable until all elements have been
     * processed or the action throws an exception. Unless otherwise specified by the implementing
     * class, actions are performed in the order of iteration (if an iteration order is specified).
     * Exceptions thrown by the action are relayed to the caller. Implementation Requirements: The
     * default implementation behaves as if:
     *
     * for (T t : this) action.accept(t);
     *
     * Parameters: action - The action to be performed for each element Throws: NullPointerException
     * - if the specified action is null
     */
    @Override
    public void forEach(Consumer<? super E> action) {

        if (action == null) {
            throw new NullPointerException("Action is == null");
        }
        // 1. Use a pointer that point to the head.
        Node<E> p = head;
        // 2. While the pointer has not reached the end, consume it.
        while (p != null) {
            action.accept(p.e);

            // Advance pointer
            p = p.r;
        }
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

    // Turn into deep copy 
    @Override
    protected Object clone() throws CloneNotSupportedException {
        PriorityQueue<E> c = (PriorityQueue<E>) super.clone();
        return c;
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

        System.out.println(pq2);

        //TEST IT FULLY HERE. FOR ALL METHODS AND ALL CASES.
        //Have the Jzva PriorityQueue below
        System.out.println("\n--> PriorityQueueASDV  testing remove(object o)");
        System.out.println("\n\tremove from front Athens");
        pq1.remove("Athens");
        pq2.remove("Athens");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from end Paris");
        pq1.remove("Paris");
        pq2.remove("Paris");
        System.out.println(pq1);
        System.out.println(pq1);

        System.out.println("\n\tremove from the middle Lafayette");
        pq1.remove("Lafayette");
        pq2.remove("Lafayette");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tadd at the end Stocholm");
        pq1.add("Stocholm");
        pq2.add("Stocholm");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from the middle London");
        pq1.remove("London");
        pq2.remove("London");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from the front Berlin");
        pq1.remove("Berlin");
        pq2.remove("Berlin");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from the front/end Stocholm");
        pq1.remove("Stocholm");
        pq2.remove("Stocholm");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\tremove from empty queue");
        pq1.remove("Stocholm");
        pq2.remove("Stocholm");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n--> PriorityQueueASDV  recreate priority queues from empty");
        pq1.add("Paris");
        pq1.add("Athens");
        pq1.add("London");
        pq1.add("Lafayette");
        pq1.add("Berlin");
        pq1.add("Zurich");

        pq2.add("Paris");
        pq2.add("Athens");
        pq2.add("London");
        pq2.add("Lafayette");
        pq2.add("Berlin");
        pq2.add("Zurich");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\n+++HERE YOU TEST ALL YOUR METHODS FULLY, and the methods of Colleciion PriorityQueue");

        System.out.println("\n\t  offer New York");
        pq1.offer("New York");
        pq2.offer("New York");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  offer Miami");
        pq1.offer("Miami");
        pq2.offer("Miami");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  offer null");
        try {
            pq1.offer(null);
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            pq2.offer(null);
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  offer ClassCastException with Object");
        try {
            pq1.offer((String) new Object());
        } catch (Exception e) {
            System.err.println(e);
        }

        try {
            pq2.offer((String) new Object());
        } catch (Exception e) {
            System.err.println(e);
        }
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  poll suposed to be Athens");
        System.out.println(pq1.poll());
        System.out.println(pq2.poll());
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  Iterator");
        Iterator<String> it1 = pq1.iterator();
        Iterator<String> it2 = pq2.iterator();

        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }

        System.out.println("");

        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
        System.out.println("");

        System.out.println("\n\t  Iterator NoSuchElementException ");

        try {
            System.out.println(it1.next());
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }
        try {
            System.out.println(it2.next());
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }

        System.out.println("\n\t  Iterator foreach ");
        it1 = pq1.iterator();
        it2 = pq2.iterator();
        it1.forEachRemaining(new Consumer() {
            @Override
            public void accept(Object t) {
                System.out.print(t + "***  ");
            }
        });
        System.out.println("");
        it2.forEachRemaining(new Consumer() {
            @Override
            public void accept(Object t) {
                System.out.print(t + "+++  ");
            }
        });
        System.out.println("");

        System.out.println("\n\t  addAll  Houston Chicago");
        List<String> ar1 = Arrays.asList("Houston", "Chicago");
        pq1.addAll(ar1);
        pq2.addAll(ar1);
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  clear");
        pq1.clear();
        pq2.clear();
        System.out.println(pq1);
        System.out.println(pq2);
        System.out.println("");

        System.out.println("\n--> PriorityQueueASDV  recreate priority queues from empty");
        pq1.add("Paris");
        pq1.add("Athens");
        pq1.add("London");
        pq1.add("Lafayette");
        pq1.add("Berlin");
        pq1.add("Zurich");

        pq2.add("Paris");
        pq2.add("Athens");
        pq2.add("London");
        pq2.add("Lafayette");
        pq2.add("Berlin");
        pq2.add("Zurich");
        System.out.println(pq1);
        System.out.println(pq2);

        System.out.println("\n\t  forEach");
        pq1.forEach(new Consumer() {
            @Override
            public void accept(Object t) {
                System.out.print(t + "*** ");
            }
        });
        System.out.println("");
        pq2.forEach(new Consumer() {
            @Override
            public void accept(Object t) {
                System.out.print(t + "+++ ");
            }
        });
        System.out.println("");

        System.out.println("\n\t  clone");
        try {
            PriorityQueueASDV<String> pq1Cloned
                    = (PriorityQueueASDV<String>) pq1.clone();
            System.out.println(pq1Cloned);
            pq1Cloned.add("Las Vegas");
            System.out.println(pq1Cloned);
            System.out.println(pq1);

        } catch (CloneNotSupportedException e) {
            System.err.println(e);
        }

    }
}
