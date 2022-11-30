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
public class GenericRule2 {

    
    // There IS inheretence outside the diamond
    public static void f2(List<Number> list) {
    }

    public static void main(String[] args) {
        f2(new ArrayList<Number>());
    }
}
