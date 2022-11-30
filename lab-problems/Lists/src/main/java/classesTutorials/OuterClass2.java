/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesTutorials;

/**
 *
 * @author jacob
 */
public class OuterClass2 {

    static class Inner2 {

        int x = 10;

        void modifyX(int x) {
            this.x += x;
        }
    }

    public static void main(String[] args) {
        OuterClass2 ds = new OuterClass2();
        Inner2 inner = new Inner2();
        Inner2 inner2 = new Inner2();

        inner.modifyX(100);
        inner2.modifyX(500);
        System.out.println(inner.x);
        System.out.println(inner2.x);

    }
}
