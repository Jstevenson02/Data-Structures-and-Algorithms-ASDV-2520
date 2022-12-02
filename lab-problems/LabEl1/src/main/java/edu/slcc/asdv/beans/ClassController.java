/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.EL.Interface_1;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jacob
 */
@Named(value = "person")
@RequestScoped
public class ClassController implements Interface_1 {

    private int x;
    private String y;
    private Interface_1 myInterface;

    public ClassController() {

        this.x = x;
        this.y = y;

    }

    @Override
    public int f1() {


    }
}
