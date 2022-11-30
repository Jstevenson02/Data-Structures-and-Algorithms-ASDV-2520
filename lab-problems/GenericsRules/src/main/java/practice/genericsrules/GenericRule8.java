package practice.genericsrules;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author jacob
 */
public class GenericRule8<T1> {

    List<? extends T1> lista = new ArrayList<String>();

    public static <T2> void f8(List<? extends T2> list) {
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        List<A> list1 = new ArrayList();
        list1.add(new C());
        list1.add(new B());
        f8(list1);

        ArrayList<B> list2 = new ArrayList();
        list1.add(new A());
        f8(list2);

        ArrayList<String> list3 = new ArrayList<String>();
        list3.add("abc");
        f8(list3);
    }
}
