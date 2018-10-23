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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setComponent(String i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getEvaluated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEvaluated(boolean i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFreeText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFreeText(String i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifyPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
   