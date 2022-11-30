/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericsrules;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jacob
 */
public class GenericRule13 {

    public static void f(List<? extends List<Integer>> table) {

        List<Integer> row = new ArrayList<Integer>();

        for (int j = 0; j < 3; ++j) {
            row.add(i + j);
            System.out.println(row);
        }
        for (List<Integer> row: table)
        {
            System.out.println(row);
        }
    }
    public static void main(String[] args) {
        f( new ArrayList<List<Integer>>());
        // f( new List<ArrayList<Integer>>() ); //will not compile
        f ( new ArrayList<ArrayList<Integer>>());
        // f(new List<List<Integer>>() ); // will not compile 
    }
}
