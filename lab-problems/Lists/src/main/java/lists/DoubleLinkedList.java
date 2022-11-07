/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

/**
 *
 * @author Jacob
 */
public class DoubleLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;

    private class Node<E> {

        E e;
        Node<E> l;
        Node<E> r;

    }

    public void insert(E e) {
        Node<E> newNode = new Node();
        newNode.e = e;

        if (head == null && tail == null) {
            head = tail = newNode;
        } else {
            tail.r = newNode;
            newNode.l = tail;
            tail = newNode;

        }
    }

    public void insertAt(int index, E e) {

        Node<E> newNode = new Node<>();
        newNode.e = e;

        // 1. the list is empty
        if (this.head == null && this.tail == null) {
            this.head = this.tail = newNode;
        } // 2. add at size (last node)
        else if (index == size()) {
            insert(e);
        } // 3. add in the front (at 0)
        else if (index == 0) {
            newNode.r = head;
            head.l = newNode;
            head = newNode;
        } // 4. add in the middle
        else {
            Node<E> p = head;

            for (int i = 0; i < index - 1; ++i) {
                p = p.r;
            }

            newNode.l = p;
            newNode.r = p.r;
            p.r = newNode;
            p.r.l = newNode;
        }
    }

    public int size() {
        Node<E> p = this.head;
        int count = 0;
        while (p != null) {
            p = p.r;
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        String s = "DoubleLInkedList{";
        Node<E> p = head;
        while (p != null) {
            s += p.e.toString();
        }
        s += " }";
        return s;
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> list1 = new DoubleLinkedList<>();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insertAt(0, 5);
        list1.insertAt(4, 35);
        list1.insertAt(3, 25);

        System.out.println(list1.toString());

    }

}
