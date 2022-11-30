/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author jacob
 */
@Named(value = "employee")
@SessionScoped
public class Employee implements Serializable {

    private String employeeName;
    private String employeeId;
    private String employeePlan;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePlan() {
        return employeePlan;
    }

    public void setEmployeePlan(String employeePlan) {
        this.employeePlan = employeePlan;
    }
}
