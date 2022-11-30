/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.pojo;

import java.util.Date;

/**
 *
 * @author jacob
 */
public class Birth {

    private Date birthday;
    private String birthplace;
    private Twin myTwin;

    public Birth(Date birthday, String birthplace) {
        this.birthday = birthday;
        this.birthplace = birthplace;
    }

    public Twin getMyTwin() {
        return myTwin;
    }

    public void setMyTwin(Twin myTwin) {
        this.myTwin = myTwin;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }
}
