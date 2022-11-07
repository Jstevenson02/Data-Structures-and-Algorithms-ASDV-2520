/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lists;

/**
 *
 * @author Jacob
 */
public class SingleLinkedList<E> {

    private Node<E> head;

    private class Node<E> {

        E e;
        Node<E> link;

    }

    public void insert(E e) {

        Node<E> newNode = new Node();
        newNode.e = e;

        if (head == null) { // list empty
            head = newNode;
        } else {// list not empty
            Node<E> p = this.head;
            Node<E> pTrail = this.head;

            while (p != null) {
                pTrail = p;
                p = p.link;
            }
            pTrail.link = newNode;
        }
    }

    public void insertAt(int index, E e) {
        Node<E> newNode = new Node();
        newNode.e = e;

        if (head == null) { // list empty
            head = newNode;
        } else if (index == 0) {
            newNode.link = this.head;
            this.head = newNode;
        }
    }

    @Override
    public String toString() {

        String s = "SingleLinkedList{";
        Node<E> p = this.head;

        while (p != null) { // while has not reached the last node's link

            s += p.e.toString() + " ";
            p = p.link;
        }

        return s;
    }

    public static void main(String[] args) {
        SingleLinkedList<Integer> list1 = new SingleLinkedList<>();
        list1.insert(10);
        list1.insert(20);
        list1.insert(30);
        list1.insertAt(0, 5);

        System.out.println(list1.toString());

    }

}
