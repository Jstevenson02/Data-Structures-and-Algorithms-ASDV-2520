/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.Company;
import edu.slcc.asdv.bl.Employee;
import edu.slcc.asdv.bl.EmployeeInterface;
import edu.slcc.asdv.bl.LocalableInterface;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author asdv
 */
@Named(value = "employeeController")
@SessionScoped
public class EmployeeController implements LocalableInterface, Serializable  {

    private String employeeLast;
    private String employeeFirst;
    private String employeePhone;
    private String employeeEmail;
    private String employeeAddress;
    private EmployeeInterface company;

    public EmployeeController() {
        company = new Company();
    }
    
    public EmployeeInterface getCompany() {
        return this.company;
    }

    public void sortEmployee(Boolean ascending) {
        if(ascending){
            Collections.sort(company.getEmployees());    
        }
        else
        {
            Collections.sort(company.getEmployees(), Collections.reverseOrder());    
        }        
    }

    public void insertEmployee() {

        boolean b = company.insertEmployee(new Employee(this.employeeFirst, this.employeeLast, this.employeePhone, this.employeeEmail, this.employeeAddress, "pfp.jpg"));

        FacesMessage facesMsg = null;

        if (b) 
        {
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Employee Successfully Added", null);
            this.employeeFirst = "";
            this.employeeLast = "";
            this.employeePhone = "";
            this.employeeEmail = "";
            this.employeeAddress = "";
        } 
        else 
        {
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee Not Added!", null);
        }
        
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }
    
    public void removeEmployee(Employee emp) {
        
        boolean b = company.removeEmployee(emp);

        FacesMessage facesMsg = null;

        if (b) {
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee Didn't Exist!", null);
        } else {

            company.getEmployees().remove(0);

            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contact Removed!", null);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);

            employeeFirst = "";
            employeeLast = "";
            employeePhone = "";
            employeeEmail = "";
            employeeAddress = "";
        }
    }

    public void removeEmployee() {

        boolean b = company.removeEmployee(new Employee(this.employeeFirst, this.employeeLast, this.employeePhone, this.employeeEmail, this.employeeAddress, "pfp.png"));

        FacesMessage facesMsg = null;

        if (b) {
            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Employee Didn't Exist!", null);
        } else {

            company.getEmployees().remove(0);

            facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contact Removed!", null);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);

            employeeFirst = "";
            employeeLast = "";
            employeePhone = "";
            employeeEmail = "";
            employeeAddress = "";
        }
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

    public String getEmployeeLast() {
        return employeeLast;
    }

    public void setEmployeeLast(String employeeLast) {
        this.employeeLast = employeeLast;
    }

    public String getEmployeeFirst() {
        return employeeFirst;
    }

    public void setEmployeeFirst(String employeeFirst) {
        this.employeeFirst = employeeFirst;
    }

    @Override
    public void germanLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("de"));
    }

    @Override
    public void frenchLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("fr"));
    }

    @Override
    public void spanishLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
    }

    @Override
    public void arabicLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("ar"));
    }

    @Override
    public void russianLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("ru"));
    }

    @Override
    public void chineseLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("zh"));
    }

    @Override
    public void englishLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
    }

    @Override
    public void greekLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("el"));
    }
}
