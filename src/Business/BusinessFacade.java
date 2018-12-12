/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.ICase;
import Acquaintance.ICustomer;
import Acquaintance.IData;
import Acquaintance.ITicket;
import Acquaintance.IUser;
//import Data.DataFacade;
import Data.Database;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import testclinet.Client;

/**
 *
 * @author nicol
 */
public class BusinessFacade implements IBusiness{
      // Auction auction = new Auction();
//      BusinessFacade business = new BusinessFacade();
       Database mainDatabase = new Database();
        private Client client;
//        private IData data;
        private User user;
        private Manufacturer manu;
        private Case newCase;
        private Manufacturer newManufactor;
        private Ticket ticket;

    /**
     *
     */
    public BusinessFacade() {
        this.client = new Client();
        //user = null;
        
    //    this.data = data;
      //  mainDatabase = new Database();
    }
        
    

//    @Override
//    public void injectData(IData dataLayer) {
//        data = dataLayer;
//    }
    
       @Override
       
       /**
        * Creates a case, which has the appropriate parameters
        */
       
     
     public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText) throws IOException{
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
           setCase((ICase)SendCase);
           sendMapOfUserAndCases(SendCase);
     }
     
       @Override
       /**
        * gets the case
        */
     public Case getCase(){
         return newCase;
     }
     
       @Override
       
      
       
     public void setCase(ICase ia){
         Case c = (Case) ia;
         this.newCase = c;
     }
     
    public void createEmployee(String password, String usernam){
        Employee newEmployee  = new Employee(password, usernam);
    }

//    @Override
//    public String toServer(String i) {
//        return data.SendString(i);
//    }

    @Override
    public List<User> getUserFromServer() throws ClassNotFoundException, IOException{
        return client.getUserFromServer();
    }
    
        @Override
    public boolean logintest(String name, String password) throws ClassNotFoundException, IOException{
        List<User> list = getUserFromServer();
        for (int i = 0; i < list.size(); i++) {
            String name1 = list.get(i).getUserName();
            String pas = list.get(i).getPassword();
            if(name.equals(name1) && password.equals(pas)){
                setUser(list.get(i));
                return true;
            }
        }
       
        return false;  
    }
    
        @Override
        
        /**
         * Gets the user
         */
    public User getUser(){
//        if(user instanceof Manufacturer){
//            return (Manufacturer) user;
//        }
        return user;
    }
    
        @Override
    public void setUser(User u){
        if(u instanceof Manufacturer){
            this.user = (Manufacturer) u;
        }
        else if(u instanceof Customer){
            this.user = (Customer) u;
        }
        this.user = u;
    }
    
    
    public Manufacturer getManufactor(){
        return (Manufacturer) user;
    }
    
    public Customer getCustumer(){
        return (Customer) user;
    }
          
    
    /**
     * This method checks whether password and username matches, done with an if--statement.
     * @param name name of user
     * @param password password of user
     * @return returns the user
     * @throws ClassNotFoundException thrown when class is not found
     * @throws IOException  thrown when IOException occurs.
     */
    public User login(String name, String password) throws ClassNotFoundException, IOException{
        List<User> list = client.getUserFromServer();
        for (int i = 0; i < list.size(); i++) {
           String name1 = list.get(i).getUserName();
           String pas = list.get(i).getPassword();
           
           if(name.equals(name1) && password.equals(pas)){
               return list.get(i);
           }
        }
        
        return null;
    }

    
    @Override
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException {
       return client.getCaseFromServer();
    }
    

    /**
     * Modifies a case with the editcase() method
     * @param caseTitle title of a case
     * @param caseID ID of a case
     * @param caseBudget Budget of a case
     * @param deadline deadline of  a case
     * @param component componenent of the case
     * @param evaluated boolean value to state whether the case has been evaluated or not.
     * @param freeText freetext which is the description of the case
     * @throws IOException thrown when IOException. 
     */
       @Override
    public void modifyCase(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText) throws IOException{
      
        client.editCase(new Case(caseTitle, caseID, caseBudget, deadline, component, evaluated, freeText));


                    
    }
//  
//    
    
    
    /**
     * sends a new user to the sql
     * @param user, a user
     * @throws IOException thrown when IOException 
     */
    @Override
    public void sendUser(User user) throws IOException {
        client.sendUser(user);
    }

    
    /**
     * Sends a new case to the sql 
     * @param casee is the case
     * @throws IOException  catches IOException
     */
    @Override
    public void sendCase(Case casee) throws IOException {
        client.sendCase(casee);
    }
    
    
    /**
     * Deletes a case in sql
     * @param ic is an interface Case
     * @throws IOException 
     */
    
       @Override
    public void deleteCase(ICase ic) throws IOException{
        Case c = (Case) ic;
        client.deleteCase(c);
    }

    /**
     *sends ticket to the sql 
     * @param ticket is a ticket from the ticket class
     * @throws IOException thrown when IOException
     */
    @Override
    public void sendTicket(Ticket ticket) throws IOException {
        client.sendTicket(ticket);
    }
    /**
     * sends a map of the Usersn, and the cases through sql
     * @param casee is a case parameter
     * @throws IOException thrown when there is an IOException. 
     */

    @Override
    public void sendMapOfUserAndCases(Case casee) throws IOException {
        client.sendMapOfUserAndCases(getUser(), casee);
    }
    /**
     * gets the user case list
     * @param user is a User parameter from the user class
     * @return return a list of the users, through the client
     * @throws IOException thrown when there appears an IOException
     * @throws ClassNotFoundException  is thrown when there is a classnotfoundexception.
     */

    @Override
    public List<Case> getUserCaseList(User user) throws IOException, ClassNotFoundException {
        return client.getUserCaseList(user);
    }
    
    /**
     * 
     * @param customer is a custoemr
     * @returnreturns a list of user Cases
     * @throws IOException is thrown when there is a IOException
     * @throws ClassNotFoundException thrown when there is a classnotfoundexception. 
     */
   
       @Override
    public List<Case> getUserCaseList2(Customer customer) throws IOException, ClassNotFoundException {
       // Customer c = (Customer) a;
        return client.getUserCaseList1(customer);
    }
    
    
    
    //SLETTES?
//    @Override
//    public void SendPicture(Picture pic) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<Picture> getPictureFromServer() throws IOException, ClassNotFoundException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    
    
    /**
     *
     * @returns a list with the not evaluated cases
     * @throws IOException thrown when IO exception
     * @throws ClassNotFoundException thrown when classnotfoundexception
     */
    @Override
    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException {
       return client.getNotEvaluatetCase();
    }

    /**
     * 
     * @param ic is the Icase
     * @throws IOException thrown when there is an IOException
     */
    @Override
    public void Evaluate(ICase ic) throws IOException {
        Case c = (Case) ic;
        client.Evaluate(c);
    }
    /**
     * 
     * @param lastKnownCity is the last known city the 
     * @param estimatedTime
     * @param FormOfTransportation
     * @param cs
     * @return 
     */
    public Logistics updateLogistics(String lastKnownCity, int estimatedTime, String FormOfTransportation, Case cs){
    
        return null;
    }
    
    //Slettes?
//    public void trackLogistics(){
//        
//    }

    
    /**
     * 
     * @return a list of tickets from the server
     * @throws IOException thrown when a IOException occurs
     * @throws ClassNotFoundException thrown when a classfoundexception occurs
     */
    @Override
    public List<Ticket> getTicketFromServer() throws IOException, ClassNotFoundException {
        return client.getTicketFromServer();
    }
    
    /**
     * 
     * @returns a list with the evaluated cases
     * @throws IOException thrown when a IOException occurs
     * @throws ClassNotFoundException thrown when a classnotfoundexception occurs
     */

    @Override
    public List<Case> getEvaluatetList() throws IOException, ClassNotFoundException {
        return client.getEvaluatetList();
    }
    /**
     * deletes a uses from the sql. 
     * @param iu is a Iuser from the IUser interface
     * @throws IOException thrown when a IOException occurs
     */

    @Override
    public void deleteUser(IUser iu) throws IOException {
        User u = (User) iu;
        client.deleteUser(u);
    }
    /**
     * creates a ticket using sql queries
     * @param issueNumber is the issuenumber regarding a ticket
     * @param issueDescript is the issue description regarding a ticket
     * @param ic is a parameter from the custoemr class
     * @throws IOException  thrown when a IOException occurs
     */

    @Override
    public void createTicket(String issueNumber,String issueDescript, Customer ic) throws IOException {
        Ticket ticket2 = new Ticket(issueNumber,issueDescript);
        setTicket(ticket2);
        client.createTicket(ticket2, ic);
    }
    
    /**
     * Sets a ticket
     * @param ticket variable from ticket class
     */
    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
    
    /**
     * gets  ticket
     * @return ticket
     */
    public Ticket getTicket(){
        return ticket;
    }
    /**
     * gets teh tickets specific to a customer
     * @param ic custoemer parameter
     * @returns a list with the cases relevant
     * @throws IOException thrown when a IOException occurs
     * @throws ClassNotFoundException thrown when a Classnotfoundexception occurs
     */

    @Override
    public List<Ticket> getAllSpecifikCustumerTicket(Customer ic) throws IOException, ClassNotFoundException {
               
        return client.getAllSpecifikCustumerTicket(ic);
    }

    /**
     * 
     * @param m manufacturer parameter
     * @throws IOException thrown when a IOException occurs
     */
    @Override
    public void updateManufactor(Manufacturer m) throws IOException {
        client.updateManufactor(m);
    }

    
    /**
     * Creates a manufactuer
     * @param username username for the manufactuer
     * @param password password for the manufacturer
     * @throws IOException  thrown when a IOException occurs
     */
    public void createManufactur(String username,String password) throws IOException{
        Manufacturer a = new Manufacturer(username, password, null, 0, null, null);
        sendUser(a);
        
    }
    /**
     * sets manufacturer
     * @param m manufacturer parameter
     */
    
    public void setManufactor(Manufacturer m){
        this.newManufactor = m;
    }
    /**
     * 1
     * @param it parameter from ITicket interface
     * @throws IOException thrown when a IOException occurs
     */

    @Override
    public void employeeReplyTekst(ITicket it) throws IOException {
        Ticket t = (Ticket) it;
        client.employeeReplyTekst(t);
    }
    
    /**
     * registers a bid in the database
     * @param ic parameter from the ICase interface
     * @param bid what the bid is on
     * @throws IOException thrown when a IOException occurs
     */
       @Override
    public void registerBid(ICase ic,double bid) throws IOException{
        Case c = (Case) ic;
        c.setBid(bid);
        client.RegisterBid(c);
    }

    /**
     * gets auction
     * @return list of  cases 
     * @throws IOException thrown when a IOException occurs
     * @throws ClassNotFoundException thrown when a classnotfoundexception occurs
     */
    @Override
    public List<Case> getAuction() throws IOException, ClassNotFoundException {
        return client.getAuction();
        
    }
    /**
     * creates a  manufacturer with his parameters
     * @param pass manufacturers pass
     * @param userNam manufacturers username
     * @param firmaddress manufacturers address
     * @param number his number
     * @param firmaName his firm name 
     * @param firmaMail his firm email
     * @return a manufacturer
     */
    
       @Override
    public Manufacturer createManufactor(String pass, String userNam,String firmaddress,int number,String firmaName,String firmaMail){
        Manufacturer a = new Manufacturer(pass, userNam, firmaddress, number, firmaName, firmaMail);
        return a;
    } 
}
/*
 * To change this license header , choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
