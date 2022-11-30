/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.bl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asdv
 */
public class Company implements EmployeeInterface
{
    private final ArrayList<Employee> employeeList;

    public Company() {
        employeeList = new ArrayList<>();
        
        Boolean testing = true;
        if(testing){
            Employee emp1 = new Employee("Jon", "Snow",null, null, null, null);
            Employee emp2 = new Employee("Al", "Falcon",null, null, null, null);
            Employee emp3 = new Employee("Deb", "Ra",null, null, null, null);        

            employeeList.add(emp1);
            employeeList.add(emp2);
            employeeList.add(emp3);
        }
    }
    
    @Override
    public boolean insertEmployee(Employee e) 
    {
        return employeeList.add(e);
    }

    @Override
    public boolean removeEmployee(Employee e) {
        return employeeList.remove(e);
    }

    @Override
    public List<Employee> getEmployees() {        
        return employeeList;
    }

    @Override
    public boolean sortEmployee(Employee e) {
        return employeeList.equals(employeeList);
    }
}
