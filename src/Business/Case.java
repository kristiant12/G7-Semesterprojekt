/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;
import java.io.Serializable;

/**
 *
 * @author nicol
 */
public class Case implements ICase,Serializable{
    
   /**
    * All these parameters represent what a case consists of
    */ 
   
    private String caseTitle;
    private String caseID;
    private String caseBudget;
    private String deadline;
    private String component;
    private boolean evaluated;
    private String freeText;
    private double bid;
    static final long serialVersionUID = -7588980448693010399L;
 

    
    
    // skal tilføre billeder 
//      public Case(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText, double bid) {
//        this.caseTitle = caseTitle;
//        this.caseID = caseID;
//        this.caseBudget = caseBudget;
//        this.deadline = deadline;
//        this.component = component;
//        this.evaluated = evaluated;
//        this.freeText = freeText;
//        this.bid = bid;
//    }
    
    /**
     * Initiates the parameters that a case has
     * @param caseTitle of the case
     * @param caseID of the case
     * @param caseBudget of the case
     * @param deadline of the case
     * @param component of the case
     * @param evaluated of the case
     * @param freeText  of the case
     */
       public Case(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText) {
        this.caseTitle = caseTitle;
        this.caseID = caseID;
        this.caseBudget = caseBudget;
        this.deadline = deadline;
        this.component = component;
        this.evaluated = evaluated;
        this.freeText = freeText;
    }

       
    public Case() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets the bid
     * @returns a a double number specified as the bid 
     */
     
    public double getBid() {
        return bid;
    }
    /**
    * sets the bid
    * @param bid a double value to represent the bid value
    */
    
    public void setBid(double bid) {
        this.bid = bid;
    }
    
    /**
     * gets the case title
     * @return casetitle
     */

    @Override
    public String getCaseTitle() {
        return caseTitle;
    }

    /**
     * sets the case titlte
     * @param i is what the case title represents
     */
    @Override
    public void setCaseTitle(String i) {
        this.caseTitle = i;
    }

    /**
     * gets the case budget
     * @returns budget of the case 
     */
    
    @Override
    public String getCaseBudget() {
        return caseBudget;
    }

    /**
     * sets teh case budget
     * @param i case budget
     */
    
    @Override
    public void setCaseBudget(String i) {
        this.caseBudget = i;
    }

    /**
     * gets the deadline
     * @return is the deadline hidden in a string parameter
     */
   
    
    @Override
    public String getDeadline() {
        return deadline;
    }

    /**
     * sets the deadline
     * @param i is a deadline parameter
     */
    
    @Override
    public void setDeadLine(String i) {
        this.deadline = i;
    }

    /**
     * gets the component of a case
     * @return string component that represents the component 
     */
    
    @Override
    public String getComponent() {
        return component;
    }
    
    /**
     * sets the string component
     * @param i is a string 
     */

    @Override
    public void setComponent(String i) {
       this.component = i;
    }

    
    /**
     * gets a boolean value to decide whether the case is evaluated or not
     * @return a boolean false or true
     */
    @Override
    public boolean getEvaluated() {
        return evaluated;
    }
    /**
     * sets the case evaluated
     * @param i a boolean value
     */

    @Override
    public void setEvaluated(boolean i) {
        this.evaluated = i;
    }
    
    /**
     * gets the free text
     * @return string of free texxt
     */

    @Override
    public String getFreeText() {
        return freeText;
    }
    /**
     * sets the freetext
     * @param i is a string of free text
     */

    @Override
    public void setFreeText(String i) {
        freeText = i;
    }
    
    /**
     * boolean return to assess whether the payment went thru or not
     * @returns a boolean value
     */

    @Override
    public boolean verifyPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * sets the ID of a case
     * @param i represents the id 
     */
    
    @Override
    public void setId(String i) {
        this.caseID = i;
        }

    /**
     * gets the id
     * @return is the id of the case
     */
    
    @Override
    public String getId() {
        return caseID;
    }

    /**
     * simple toString method
     * @return a string
     */
    
    @Override
    public String toString() {
        return  "caseTitle=" + caseTitle;
    }

}