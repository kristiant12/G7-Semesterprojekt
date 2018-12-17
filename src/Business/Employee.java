/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author sebastian
 */
public class Employee extends User implements Serializable{
    
    /**
     *
     * @param pass is the password for an employee
     * @param userNam is the username for an employee
     */
    public Employee(String pass, String userNam) {
        super(pass, userNam);
    }

    /**
     * Returns the toString
     * @return String
     */
    @Override
    public String toString() {
        return "Employee{" +super.toString()+ '}';
    }
}
