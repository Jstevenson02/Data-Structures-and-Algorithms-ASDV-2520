/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.EL;

import java.util.Random;

/**
 *
 * @author jacob
 */
public class Class_1 implements Interface_1 {

    int x;
    String y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Class_1(int x, String y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int f1() {
        Random randomNum = new Random();
        int showMe = randomNum.nextInt(100);
        return showMe;
    }

}
