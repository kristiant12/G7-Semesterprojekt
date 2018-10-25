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
    public void setCaseTitle(String i);
    
    public String getCaseBudget();
    public void setCaseBudget(String i);
    
    public String getDeadline();
    public void setDeadLine(String i);
    
    // skal kunne overføre billeder;
    
    public String getComponent();
    public void setComponent(String i);
    
    public boolean getEvaluated();
    public void setEvaluated(boolean i);
    
    public String getFreeText();
    public void setFreeText(String i);
    
    public boolean verifyPayment();
    
    public String getId();
    public void setId(String i);
    
}
