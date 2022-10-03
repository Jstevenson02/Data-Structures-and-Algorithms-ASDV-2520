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
public class GenericRule10 {
    public static void f10(List<? extends A> list1, List<?super C> list2)
    {
        System.out.println(list1.size());
    }
    
    public static void main(String[] args) {
        ArrayList<A> list1 = new ArrayList<A>();
        list1.add(new A());
        System.out.println(list1.get(0));
        ArrayList<Object> list2 = new ArrayList();
        f10(list1, list2);
        
        ArrayList<Integer> list3 = new ArrayList();
    }
}
