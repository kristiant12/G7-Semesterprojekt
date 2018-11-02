package Acquaintance;

import Business.Case;
import Business.User;
import java.io.IOException;
import java.util.List;

/* OSRS ER ET LORTE SPIL!!!!!!!!! CONFIRMED!
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public interface IBusiness {
    
//    public void injectData(IData dataLayer);
    
    public void RegisterBid(Case cs, double bid);
    
//    public String toServer(String i);
  
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException;
    
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException;

    public boolean logintest(String name,String password) throws ClassNotFoundException,IOException;
    
    public User getUser();
    
    public void setUser(User user);    

    public void createEmployee(String pass, String usernam);
    
    public void sendUser(User d) throws IOException;
    
    public void sendCase(Case a) throws IOException;
    
    public void createCase(String caseTitle, String caseID,String caseBudget,
            String deadline, String component,boolean evaluated,String freeText) throws IOException;
     
    public void deleteCase(Case ce) throws IOException;
    
    public Case modifyCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText) throws IOException;
}
