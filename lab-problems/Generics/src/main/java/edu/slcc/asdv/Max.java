/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv;

/**
 *
 * @author jacob
 */
public class Max {

    public static Comparable max(Comparable o1, Comparable o2) {
        if (o1.compareTo(o2) > 0) {
            return o1;
        } else {
            return o2;
        }
    }

    private static <EventCompare extends Comparable<EventCompare>> EventCompare maxSafe(EventCompare e1, EventCompare e2) {
        if (e1.compareTo(e2) > 0) {
            return e1;
        } else {
            return e2;
        }
    }

    public static void main(String[] args) {
        System.out.println(max(1, 2));
        try {
            System.out.println(maxSafe(1, 2));
            System.out.println(maxSafe("abc", "ABC"));
            System.out.println("");
            GenericStack stackUnsafe = new GenericStack();
            GenericStack<Integer> stackSafe = new GenericStack<>();
            stackSafe.push(1);
            stackSafe.push(2);
            System.out.println(stackSafe);
            stackUnsafe.push(1);
            stackUnsafe.push("two");
            System.out.println("This line compiles but crushes the program" + max(1, "two"));

        } catch (ClassCastException e) {
            System.err.println("RAW TYPES ARE UNSAFE " + e.getMessage());
        }
    }
}
