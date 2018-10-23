/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author nicol
 */
public interface ICase {
    
    public String getCaseTitle();
    public void setCaseTitle();
    
    public double getCaseBudget();
    public void setCaseBudget();
    
    public String getDeadline();
    public void setDeadLine();
    
    // skal kunne overføre billeder;
    
    public String getComponent();
    public void setComponent();
    
    public boolean getEvaluated();
    public void setEvaluated();
    
    public String getFreeText();
    public void setFreeText();
    
    public boolean verifyPayment();
    
    
}
