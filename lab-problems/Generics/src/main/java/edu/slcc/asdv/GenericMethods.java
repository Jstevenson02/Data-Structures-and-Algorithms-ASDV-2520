/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv;

/**
 *
 * @author jacob
 */
public class GenericMethods {
    
     public static <E extends GeometricObject> void PrintGeo(E[] ar) {
         for (int i = 0; i < ar.length; ++i) {
            System.out.println(ar[i] + " ");
        }
        System.out.println("");
    }

    public static <AnyArray> void PrintArray(AnyArray[] ar) {
        for (int i = 0; i < ar.length; ++i) {
            System.out.println(ar[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        PrintArray(new Integer[]{1, 2, 3});
        PrintArray(new String[]{"john", "marry"});
        
        PrintArray(new A[]{new A(10), new A(20)});
        
        PrintArray(new Circle[] {new Circle(), new Circle()});
        
        PrintGeo(new Circle[] {new Circle(), new Circle()});
        
    }
}

class A {

    int a;

    public A(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" + "a=" + a + '}';
    }
}

class GeometricObject 
{
    
}

class Circle extends GeometricObject
{

}

class Rectangle extends GeometricObject 
{

}