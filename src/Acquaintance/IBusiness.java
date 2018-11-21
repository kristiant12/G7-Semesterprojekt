package Acquaintance;

import Business.Case;
import Business.Customer;
import Business.Manufacturer;
import Business.Picture;
import Business.Ticket;
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
    
//    public void RegisterBid(Case cs);
    
//    public String toServer(String i);
  
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException;
    
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException;
    
    public List<Ticket> getTicketFromServer() throws IOException, ClassNotFoundException;

    public boolean logintest(String name,String password) throws ClassNotFoundException,IOException;
    
    public User getUser();
    
    public void setUser(User user);    

    public void createEmployee(String pass, String usernam);
    
    public void sendUser(User d) throws IOException;
    
    public void sendCase(Case a) throws IOException;
    
    public void createCase(String caseTitle, String caseID,String caseBudget,
            String deadline, String component,boolean evaluated,String freeText) throws IOException;
     
    public void deleteCase(Case ce) throws IOException;
    
    public void sendTicket(Ticket ticket) throws IOException;
    
    public void modifyCase(Case a) throws IOException;
    
    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException;
    
    public void sendMapOfUserAndCases(Case b) throws IOException;
    
    public List<Case> getUserCaseList2(Customer a) throws IOException, ClassNotFoundException;

    public void SendPicture(Picture picture);

    public List<Picture> getPictureFromServer() throws IOException, ClassNotFoundException;
    
    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException;
    
    public void Evaluate(Case a) throws IOException;
     
    public List<Case> getEvaluatetList(Case a) throws IOException, ClassNotFoundException; 
     
    public void deleteUser(User a) throws IOException;
     
    public void createTicket(Ticket t, Customer c) throws IOException;
    
    public List<Ticket> getAllSpecifikCustumerTicket(Customer c) throws IOException, ClassNotFoundException;
    
     public void updateManufactor(Manufacturer m) throws IOException;
    
}


