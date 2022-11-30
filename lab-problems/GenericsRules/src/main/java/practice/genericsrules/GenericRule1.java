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
public class GenericRule1 {
    public static void f1(ArrayList<Number> list) {}
    public static void main(String[] args) 
    {
        // no inhertence in the diamond 
        f1(new ArrayList<Integer>());
    }
}
