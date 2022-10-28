package practice.testinghashset;

import java.util.*;

public class TestTreeSet {

    public static void main(String[] args) {
        // Create a hash set
        Set<String> set = new HashSet<>();

        // Add strings to the set
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("New York");

        TreeSet<String> treeSet = new TreeSet<>(set);
        System.out.println("Sorted tree set: " + treeSet);

        // Use the methods in SortedSet interface
        System.out.println("first(): " + treeSet.first());
        System.out.println("last(): " + treeSet.last());
        System.out.println("headSet(\"New York\"): "
                + treeSet.headSet("New York"));
        System.out.println("tailSet(\"New York\"): "
                + treeSet.tailSet("New York"));

        // Use the methods in NavigableSet interface
        System.out.println("lower(\"P\"): " + treeSet.lower("P"));
        System.out.println("higher(\"P\"): " + treeSet.higher("P"));
        System.out.println("floor(\"P\"): " + treeSet.floor("P"));
        System.out.println("ceiling(\"P\"): " + treeSet.ceiling("P"));
        System.out.println("pollFirst(): " + treeSet.pollFirst());
        System.out.println("pollLast(): " + treeSet.pollLast());
        System.out.println("New tree set: " + treeSet);

        TreeSet<B> s2 = new TreeSet(B.getComparator());
        s2.add(new B(10));
        s2.add(new B(2));

    }
}

class A implements Comparable<B> {

    int x;

    public A(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "A{" + "x=" + x + '}';
    }

    @Override
    public int compareTo(B o) {
        return this.x - o.x;
    }
}

class B {

    int x;

    public B(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "X =" + this.x;
    }

    public static Comparator<B> getComparator() {
        return new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                return o1.x - o2.x;
            }
        };
    }
}
