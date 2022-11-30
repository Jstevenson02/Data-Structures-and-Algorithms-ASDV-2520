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
public class GenericRule3 {
    
    // Rule 1 and 2 apply for assignment as well as in method calls passing args to parms IS assignment.
    public static void main(String[] args) {
        List<Number> list1 = new ArrayList<Number>(); // rule 2
        ArrayList<Number> list2 = new ArrayList<Integer>(); // rule 1
    }
}
