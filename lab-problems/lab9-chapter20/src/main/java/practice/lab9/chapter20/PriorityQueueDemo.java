/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practice.lab9.chapter20;

import java.util.*;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");

        System.out.println("Priority queue using Comparable:");
        while (queue1.size() > 0) {
            System.out.print(queue1.remove() + " ");
        }

        PriorityQueue<String> queue2 = new PriorityQueue<>(
                4, Collections.reverseOrder());
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");

        System.out.println("\nPriority queue using Comparator:");
        while (queue2.size() > 0) {
            System.out.print(queue2.remove() + " ");
        }
    }
}
