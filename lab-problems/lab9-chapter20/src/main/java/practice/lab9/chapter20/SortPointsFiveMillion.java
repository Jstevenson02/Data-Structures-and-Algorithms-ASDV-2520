package practice.lab9.chapter20;

import java.util.*;

public class SortPointsFiveMillion {

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            arrayList.add(i);
        }
        LinkedList<Integer> linkedList = new LinkedList<>(arrayList);

        long iteratorTimerStart = System.currentTimeMillis();
        ListIterator<Integer> listIterator = linkedList.listIterator();
        
        while (listIterator.hasNext()) {
            listIterator.next();
        }
        long iteratorTimerEnd = System.currentTimeMillis();

        System.out.println("Time to traverse the list using an iterator :"
                + (iteratorTimerEnd - iteratorTimerStart) + " millis");

        // This method takes a literal DECADE to run, functional with numbers NOT of exponential magnitude.
        long getTimerStart = System.currentTimeMillis();
        for (int i = 0; i <  5000000 /* 50000 */; i++) {
            linkedList.get(i);
        }
        long getTimerEnd = System.currentTimeMillis();

        System.out.println("Time to traverse the list using the get(index) method :"
                + (getTimerEnd - getTimerStart) + " millis");

    }
}
