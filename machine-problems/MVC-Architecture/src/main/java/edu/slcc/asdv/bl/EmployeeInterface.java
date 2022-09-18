/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.slcc.asdv.bl;
import java.util.List;

/**
 *
 * @author asdv
 */
public interface EmployeeInterface {
    boolean sortEmployee(Employee e);
    boolean insertEmployee(Employee e);
    boolean removeEmployee(Employee e);
    List<Employee> getEmployees();
}
