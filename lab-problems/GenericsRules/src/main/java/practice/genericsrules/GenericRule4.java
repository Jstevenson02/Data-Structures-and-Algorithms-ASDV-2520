/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.genericsrules;

import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class GenericRule4 {

    public static void f1(ArrayList<?> list) {
        System.out.println(list.size());
        list.add(new Integer(5));
    }

    public static void main(String[] args) {
        f1(new ArrayList<Integer>());
        f1(new ArrayList<Double>());
    }
}
