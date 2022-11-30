/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv;

/**
 *
 * @author jacob
 */
public class GenericStack<E> {

    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    // how bib is the stack?
    public int getSize() {
        return list.size();
    }

    // returns what's on the top of the stack
    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    public static void main(String[] args) {
        GenericStack<Integer> gsi = new GenericStack();
        GenericStack<String> gss = new GenericStack();

        gsi.push(10);
        gsi.push(20);

        gss.push("john");
        gss.push("mary");

        System.out.println(gsi);
        System.out.println(gss);

        System.out.println("-----------------------------------------------");

        System.out.println(gsi.peek());
        System.out.println(gsi.pop());
        System.out.println(gsi);

        System.out.println("-----------------------------------------------");

        System.out.println(gss.peek());
        System.out.println(gss.pop());
        System.out.println(gss);

    }

}
