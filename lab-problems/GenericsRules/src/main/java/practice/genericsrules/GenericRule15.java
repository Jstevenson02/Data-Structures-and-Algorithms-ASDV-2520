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
public class GenericRule15<T1> {

    List<? extends T1> list;

    public GenericRule15(ArrayList<? extends T1> list) {
        this.list = list;
    }

    // Array<? extends T2> list; // will not compile
    public static <T2> void f(ArrayList<? extends T2> list1) {
        System.out.println(list1.size());
        // list1.add( new Integer()); will not compile
    }

    public static void main(String[] args) {
        f(new ArrayList<Integer>());
        f(new ArrayList<Object>());
        f(new ArrayList<AAA>());
    }
}

class AAA {

}
