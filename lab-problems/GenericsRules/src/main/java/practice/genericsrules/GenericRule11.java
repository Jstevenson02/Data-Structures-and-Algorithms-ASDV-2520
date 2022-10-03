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
public class GenericRule11 {

    public static void f(List<List<Integer>> table) {
        for (int i = 0; i < 2; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < 3; ++j) {
                row.add(i + j);
            }
            table.add(row);
        }
        for (List<Integer> row : table) {
            System.out.println(row);
        }
    }

    public static void main(String[] args) {
        f(new ArrayList<List<Integer>>());
        f1(new ArrayList<ArrayList<Integer>>());
    }

    private static void f1(ArrayList<ArrayList<Integer>> arrayList) {
        for (int i = 0; i < 2; ++i) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < 3; ++j) {
                row.add(i + j);
            }
            arrayList.add(row);
        }
        for (List<Integer> row : arrayList) {
            System.out.println(row);
        }
    }
}
