package Acquaintance;

import Business.Case;
import Business.Customer;
import Business.Manufacturer;
import Business.Ticket;
import Business.User;
import java.io.IOException;
import java.util.List;

/* 
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

    public boolean logintest(String name, String password) throws ClassNotFoundException, IOException;

    public User getUser();

    public void setUser(User user);

    public void createEmployee(String pass, String usernam)throws IOException;

    public void sendUser(User d) throws IOException;

    public void sendCase(Case a) throws IOException;

    public void createCase(String caseTitle, String caseID, String caseBudget,
            String deadline, String component, boolean evaluated, String freeText) throws IOException;

    public void deleteCase(ICase ic) throws IOException;

    public void sendTicket(Ticket ticket) throws IOException;

    public void modifyCase(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText) throws IOException;

    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException;

    public void sendMapOfUserAndCases(Case b) throws IOException;

    public List<Case> getUserCaseList2(Customer a) throws IOException, ClassNotFoundException;

    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException;

    public void Evaluate(ICase ic) throws IOException;

    public List<Case> getEvaluatetList() throws IOException, ClassNotFoundException;

    public void deleteUser(IUser iu) throws IOException;

   public void createTicket(String issueNumber,String issueDescript, Customer ic) throws IOException;

    public List<Ticket> getAllSpecifikCustumerTicket(Customer ic) throws IOException, ClassNotFoundException;

    public void updateManufactor(Manufacturer m) throws IOException;

    public Manufacturer getManufactor();

    public Case getCase();

    public void setCase(ICase ia);

    public void createManufactur(String username, String password) throws IOException;

    public void setManufactor(Manufacturer m);

    public void employeeReplyTekst(ITicket it) throws IOException;

    public void registerBid(ICase ic, double bid) throws IOException;

    public List<Case> getAuction() throws IOException, ClassNotFoundException;

   public Manufacturer createManufactor(String pass, String userNam,String firmaddress,int number,String firmaName,String firmaMail); 

   public Customer getCustumer();
   
   public Ticket getTicket();

    public void createCustumer(String userName,String password, String addresse,int number, String email, String fullName) throws IOException;
    
    public User getTing();
}
