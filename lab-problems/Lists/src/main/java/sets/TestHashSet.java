/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sets;

import java.util.*;
import java.util.function.BiConsumer;

/**
 *
 * @author jacob
 */
public class TestHashSet {

    public static void main(String[] args) {
        // Create a hash set
        Set<String> set = new TreeSet<>();

        // Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        System.out.println(set);

        // Display the elements in the hash set
        for (String s : set) {
            System.out.print(s.toUpperCase() + " ");
        }

        // Process the elements using a forEach method
        System.out.println();
        set.forEach(e -> System.out.print(e.toLowerCase() + " "));

        Iterator<String> it = set.iterator();

        while (it.hasNext()) {
            System.out.println(it.next() + " ");
        }
        ConsumerTest ct = (x, y) -> {
        };

        Set<B> setB = new TreeSet(new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                return o1.x - o2.x;
            }
        });
        setB.add(new B(10));
        setB.add(new B(5));
        System.out.println(setB);
    }
}

interface ConsumerTest {

    void test1(int x, int y);
}

class A implements Comparable<A> {

    int x;

    public A() {

    }

    public A(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "A{" + "x=" + x + '}';
    }

    @Override
    public int compareTo(A o) {
        return this.x - o.x;
    }
}

class B {

    int x;

    public B() {

    }

    public B(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "B{" + "x=" + x + '}';
    }

}
