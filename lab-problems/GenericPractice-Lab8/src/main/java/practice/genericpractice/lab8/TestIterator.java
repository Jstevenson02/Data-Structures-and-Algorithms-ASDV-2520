package practice.genericpractice.lab8;

import java.util.Iterator;
import java.util.function.Consumer;

public class TestIterator<E> {

    private E[] ar;
    private int size;

    public TestIterator() {
        ar = (E[]) new Object[3];
    }

    public void add(E e) {
        ar[size++] = e;
    }

    public Iterator<E> iterator() {
        Iterator<E> ti = new Iterator<E>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index < ar.length) {
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public E next() {
                return ar[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                while (hasNext()) {
                    action.accept(next());
                }
            }
        };
        return ti;
    }

    public static void main(String[] args) {
        TestIterator<Integer> testIteration1 = new TestIterator();
        TestIterator<String> testIteration2 = new TestIterator();

        testIteration1.add(1);
        testIteration1.add(2);
        testIteration1.add(3);
        testIteration2.add("one");
        testIteration2.add("two");
        testIteration2.add("three");

        Iterator<Integer> it1 = testIteration1.iterator();
        Iterator<String> it2 = testIteration2.iterator();

        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println("");

        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");

            it1.forEachRemaining(new Consumer<Integer>() {
                @Override
                public void accept(Integer t) {
                    System.out.println(t + 200 + " ");
                }
            });
        }
        System.out.println("");

        it1.forEachRemaining(
                new Consumer<Integer>() {
            @Override
            public void accept(Integer t) {
                System.out.println(t * 2 + " ");
            }

            @Override
            public Consumer<Integer> andThen(Consumer<? super Integer> after) {
                return Consumer.super.andThen(after);
            }
        });

    }
}

class C {
}
