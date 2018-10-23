/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;

/**
 *
 * @author nicol
 */
public class Case implements ICase{
    
    private String caseTitle;
    private int caseID;
    private double caseBudget;
    private String deadline;
    private String component;
    private boolean evaluated;
    private String freeText;
    
    
    // skal tilføre billeder 
      public Case(String caseTitle, int caseID, double caseBudget, String deadline, String component, boolean evaluated, String freeText) {
        this.caseTitle = caseTitle;
        this.caseID = caseID;
        this.caseBudget = caseBudget;
        this.deadline = deadline;
        this.component = component;
        this.evaluated = evaluated;
        this.freeText = freeText;
    }
    

    @Override
    public String getCaseTitle() {
        return caseTitle;
    }

    @Override
    public void setCaseTitle(String i) {
        this.caseTitle = i;
    }

    @Override
    public double getCaseBudget() {
        return caseBudget;
    }

    @Override
    public void setCaseBudget(double i) {
        this.caseBudget = i;
    }

    @Override
    public String getDeadline() {
        return deadline;
    }

    @Override
    public void setDeadLine(String i) {
        this.deadline = i;
    }

    @Override
    public String getComponent() {
        return component;
    }

    @Override
    public void setComponent(String i) {
       this.component = i;
    }

    @Override
    public boolean getEvaluated() {
        return evaluated;
    }

    @Override
    public void setEvaluated(boolean i) {
        this.evaluated = i;
    }

    @Override
    public String getFreeText() {
        return freeText;
    }

    @Override
    public void setFreeText(String i) {
        freeText = i;
    }

    @Override
    public boolean verifyPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int i) {
        this.caseID = i;
        }

    @Override
    public int getId() {
        return caseID;
    }
}
   