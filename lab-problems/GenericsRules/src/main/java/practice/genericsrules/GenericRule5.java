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
public class GenericRule5 {
    
    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Integer>();
        ArrayList<?> list2 = new ArrayList<Double>();
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("abc");
    }
}
