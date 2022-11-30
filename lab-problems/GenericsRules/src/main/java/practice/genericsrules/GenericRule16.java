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
public class GenericRule16<T1> {

    List<? extends T1> list;

    public GenericRule16(ArrayList<? extends T1> list) {
        this.list = list;
    }

    public GenericRule16(List<? extends T1> list) {
        this.list = list;
    }

    /* 
    This constructor is illegal because of the existing constructor 
    at line 11 IT WON'T COMPILE, IT HAS THE SAME TYPE ERASURE AS 
    constructor at line 11
    
    public GenericRule16(ArrayList<? super T1> list)
    {
        this.list = list;
    }
    
    This constructor is illegal because of the existing constructor at line 11
    IT WON'T COMPILE, IT HAS THE SAME TYPE ERASURE as constructor at line 11.
    
    public GenericRule16(ArrayList<?> list)
    {
        this.list = list;
    }
     */
    public static void main(String[] args) {
        GenericRule16<String> gr14_1 = new GenericRule16<String>(new ArrayList<String>());
        GenericRule16<Integer> gr14_2 = new GenericRule16<Integer>(new ArrayList<Integer>());
        GenericRule16<AAAA> gr14_3 = new GenericRule16<AAAA>(new ArrayList<AAAA>());

    }
}

class AAAA {
}
