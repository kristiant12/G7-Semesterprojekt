/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICustomer;

/**
 *
 * @author rober
 */
public class Customer implements ICustomer {

    private String idNumber;
    private String username;
    private String password;

    public Customer(String id, String pass, String userNam) {

        this.idNumber = id;
        this.password = pass;
        this.username = userNam;
    }

    @Override
    public void createCase(String caseTitle, int caseID, double caseBudget, String deadline, String component, boolean evaluated, String freeText) {
        Case SendCase = new Case(caseTitle, caseID, caseBudget, deadline, component, evaluated, freeText); 
       
    }
}