/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericpractice.lab8;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author jacob
 */
public class TestIterator<E> {

    private E[] array;
    private int size;

    public TestIterator() {
        array = (E[]) new Object[3];
    }

    public void add(E e) {
        array[array.length - 1] = e;
    }

    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < array.length) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                return array[index++];
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                while (hasNext()) {
                    action.accept(next());
                }
            }
        };
        return null;
    }

    public static void main(String[] args) {
        TestIterator<Integer> te1 = new TestIterator();
        TestIterator<String> te2 = new TestIterator();

        te1.add(1);
        te1.add(2);
        te1.add(3);

        te2.add("oen");
        te2.add("two");
        te2.add("three");

        Iterator<Integer> it1 = te1.iterator();
        Iterator<String> it2 = te2.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next() + "");
            System.out.println("");

            it1.forEachRemaining(new Consumer<Integer>() {

                @Override
                public void accept(Integer t) {
                    System.out.println(t * 200 + " ");
                }
            });
        }
        while (it2.hasNext()) {
            System.out.println(it2.next() + "");
            System.out.println("");
        }
    }
}
