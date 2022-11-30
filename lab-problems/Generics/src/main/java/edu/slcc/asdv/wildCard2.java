/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv;

/**
 *
 * @author jacob
 */
public class wildCard2 {

    public static void print(GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
    }
}
