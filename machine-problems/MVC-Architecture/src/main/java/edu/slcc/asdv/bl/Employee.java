/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.bl;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable {

    private String employeeFirst;
    private String employeeLast;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private String photo;

    public Employee() {
        employeeFirst = null;
        employeeLast = null;
        employeePhone = null;
        employeeEmail = null;
        employeeAddress = null;
    }

    public Employee(String employeeFirst, String employeeLast, String employeePhone, String employeeEmail, String employeeAddress, String picturepng) {
        this.employeeFirst = employeeFirst;
        this.employeeLast = employeeLast;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.photo = picturepng;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmployeeFirst() {
        return employeeFirst;
    }

    public void setEmployeeFirst(String employeeFirst) {
        this.employeeFirst = employeeFirst;
    }

    public String getEmployeeLast() {
        return employeeLast;
    }

    public void setEmployeeLast(String employeeLast) {
        this.employeeLast = employeeLast;
    }
    
    @Override
    public String toString(){
        return getEmployeeLast() + getEmployeeFirst();
    }

    @Override
    public int compareTo(Employee o) {
     
        return (getEmployeeLast() + getEmployeeFirst()).compareTo(o.getEmployeeLast() + o.getEmployeeFirst());
    }
}
