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
public class GenericRule12 {

    public static void main(String[] args) {
        List<List<Integer>> table = new ArrayList<List<Integer>>();

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
}
