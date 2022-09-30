/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojo.Birth;
import edu.slcc.asdv.pojo.Gender;
import edu.slcc.asdv.pojo.Twin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.el.LambdaExpression;
import javax.el.ELContext;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author jacob
 */
@Named(value = "person")
@RequestScoped
public class Person {

    enum Hobbies {
        FOOTBALL, BASKETBALL, BASEBALL, SWIMMING, TENNIS, RUNNING;
    };

    enum Education {
        HIGH_SCHOOL, COLLEGE, GRADUATE;
    };

    private String firstName;
    private String lastName;
    private Birth birth;
    private Twin twin;

    Education education;

    private String[] siblingsNames = {"Paul", "Mary", "Alexander", "Anna"};
    private Map<String, String> siblingsFacts = new HashMap();
    private List<String> siblingsList = Arrays.asList(siblingsNames);
    private ArrayList<Hobbies> hobbiesList = new ArrayList<>();

    public Person() {

        this.firstName = "Joe";
        this.lastName = "Black";
        education = Education.COLLEGE;

        siblingsFacts.put(siblingsNames[0], "Brown Hair, Height 5.11");
        siblingsFacts.put(siblingsNames[1], "Black Hair, Height 5.4");
        siblingsFacts.put(siblingsNames[2], "Blond Hair, Height 6.2");
        siblingsFacts.put(siblingsNames[3], "Brown Hair, Height 5.8");

        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1998, Calendar.AUGUST, 28);
        birth = new Birth(calendar.getTime(), "Lafayette, LA", new Gender(true));
        twin = new Twin(true);
        hobbiesList.add(Hobbies.TENNIS);
        hobbiesList.add(Hobbies.BASEBALL);
        hobbiesList.add(Hobbies.BASKETBALL);
        hobbiesList.add(Hobbies.FOOTBALL);
        hobbiesList.add(Hobbies.RUNNING);
        hobbiesList.add(Hobbies.SWIMMING);
    }

    public Object firstLambdaAction(LambdaExpression lambdaExpression) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return lambdaExpression.invoke(elContext, 8, 3);
    }
    
        public Object min3LambdaAction(LambdaExpression lambdaExpression) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        return lambdaExpression.invoke(elContext, 3, 2, 1);
    }
    
    public void printFirstAndLastName() {
        System.out.println(this.firstName + "" + this.lastName);
    }

    public String firstAndLastName() {
        return this.firstName + " " + this.lastName;
    }

    public void printText(String text) {
        System.out.println(text);
    }

    public static String returnHello() {
        return "hello!";
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

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public List<String> getSiblingsList() {
        return siblingsList;
    }

    public void setSiblingsList(List<String> siblingsList) {
        this.siblingsList = siblingsList;
    }

    public String[] getSiblingsNames() {
        return siblingsNames;
    }

    public Map<String, String> getSiblingsFacts() {
        return siblingsFacts;
    }

    public ArrayList<Hobbies> getHobbiesList() {
        return hobbiesList;
    }

    public Education getEducation() {
        return education;
    }

    public Twin getTwin() {
        return twin;
    }

    public void setTwin(Twin twin) {
        this.twin = twin;
    }

}
