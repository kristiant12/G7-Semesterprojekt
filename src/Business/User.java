/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.BusinessFacade;
import Data.Database;

/**
 *
 * @author sebastian
 */
public class User {
    public Database mainDatabase = new Database();

    private String idNumber;
    private String password;
    private String userName; 
    
    
    
    
    public User(String id, String pass, String userNam){
        this.idNumber = id;
        this.password = pass;
        this.userName = userNam;
}
   public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    } 
    
    public void createCase(String caseTitle, int caseID,double caseBudget,String deadline, String component,boolean evaluated,String freeText){
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
        mainDatabase.sendCase(SendCase);
        
        
        
    }
}
