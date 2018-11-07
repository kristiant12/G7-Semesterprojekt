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
      public Case(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText, double bid) {
        this.caseTitle = caseTitle;
        this.caseID = caseID;
        this.caseBudget = caseBudget;
        this.deadline = deadline;
        this.component = component;
        this.evaluated = evaluated;
        this.freeText = freeText;
        this.bid = bid;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
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
    public String getCaseBudget() {
        return caseBudget;
    }

    @Override
    public void setCaseBudget(String i) {
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
    public void setId(String i) {
        this.caseID = i;
        }

    @Override
    public String getId() {
        return caseID;
    }

    @Override
    public String toString() {
        return "Case{" + "caseTitle=" + caseTitle + ", caseID=" + caseID + ", caseBudget=" + caseBudget + ", deadline=" + deadline + ", component=" + component + ", evaluated=" + evaluated + ", freeText=" + freeText + ", bid=" + bid + '}';
    }

}