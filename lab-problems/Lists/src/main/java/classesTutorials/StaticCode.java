/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesTutorials;

/**
 *
 * @author jacob
 */
public class StaticCode {
    
    int y = 100;
    
    static {
        int x = 10;
        System.out.println(x);
    }
    
    public static void main(String[] args) {
        StaticCode st = new StaticCode();
        System.out.println(st.y);
        System.out.println("main");
    }
}
