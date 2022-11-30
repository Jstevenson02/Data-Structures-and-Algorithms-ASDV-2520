/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojo.Birth;
import edu.slcc.asdv.pojo.Twin;
import java.util.Calendar;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author jacob
 */
@Named(value = "person")
@RequestScoped
public class Person {

    private String firstName;
    private String lastName;
    private Birth birth;
    private Twin twin;

    public Person() {
        this.firstName = "Joe";
        this.lastName = "Black";

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1998, Calendar.AUGUST, 28);
        birth = new Birth(calendar.getTime(), "Lafayette, LA");
        twin = new Twin(true);
    }

    public Twin getTwin() {
        return twin;
    }

    public void setTwin(Twin twin) {
        this.twin = twin;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
