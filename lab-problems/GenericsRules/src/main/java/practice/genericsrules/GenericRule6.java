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
public class GenericRule6 {

    public static void f6(List<? extends A> list) {
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        List<A> list1 = new ArrayList();
        list1.add(new C());
        list1.add(new B());
        f6(list1);

        ArrayList<B> list2 = new ArrayList();
        list1.add(new A());
        f6(list2);
    }
}

class A {
}

class B extends A {
}

class C extends B {
}
