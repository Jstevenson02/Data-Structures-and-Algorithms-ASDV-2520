/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.lab9.chapter20;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jacob
 */
public class TestTheCollections {

    public static void main(String[] args) {
        System.out.println("Sorting in ascending order");
        List<String> list1 = Arrays.asList("red", "green", "blue");
        Collections.sort(list1);
        System.out.println(list1);

        System.out.println("Sorting in descending order");
        List<String> list2 = Arrays.asList("yellow", "red", "green", "blue");
        Collections.sort(list2);
        System.out.println(list2);
    }
}
