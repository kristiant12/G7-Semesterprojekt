/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.ICase;
import Acquaintance.ITicket;
import Acquaintance.IUser;
import java.io.IOException;
import java.util.List;
import testclinet.Client;

/**
 *
 * @author nicol
 */
public class BusinessFacade implements IBusiness{
        private Client client;
        private User user;
        private Manufacturer manu;
        private Case newCase;
        private Manufacturer newManufactor;
        private Ticket ticket;
        private User ting;

    /**
     *
     */
    public BusinessFacade() {
        this.client = new Client();
        
    }

        
        /**
         * creates a case 
         * @param caseTitle  is the title of the case
         * @param caseID is the ID of the case
         * @param caseBudget is the budget of the case
         * @param deadline is the deadline of the case
         * @param component is the component of the case
         * @param evaluated is whether the case is evaluated or not. 
         * @param freeText is the case description
         * @throws IOException  thrown when this exception happens.
         */
    
       @Override
     public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText) throws IOException{
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
           setCase(SendCase);
           sendMapOfUserAndCases(SendCase);
     }
     
    /**
     * This method returns a case
     * @return Case
     */
    @Override
     public Case getCase(){
         return newCase;
     }
     
    /**
     * This methods sets the value newcase equal to ia
     * @param ia Is an Icase interface
     */
    @Override
     public void setCase(ICase ia){
         Case c = (Case) ia;
         this.newCase = c;
     }
     
     /**
      * gets the users in a list from the server
      * @return s a list of users
      * @throws ClassNotFoundException is thrown when  this exception happens
      * @throws IOException is thrown when this exception happens.
      */
     
    @Override
    public List<User> getUserFromServer() throws ClassNotFoundException, IOException{
        return client.getUserFromServer();
    }
    
    /**
     * login function, checks if password matches username
     * @param name of the user
     * @param password of the user
     * @return boolean if password matches or not
     * @throws ClassNotFoundException thrown when exception
     * @throws IOException  thrown when exception
     */
    
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
    
    /**
     * This method returns a user
     * @return User
     */
    @Override
    public User getUser(){
        return user;
    }
    
    /**
     * This method sets the value user to the user u
     * @param u is a user
     */
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
    
    /**
     * This method returns a manufacturer
     * @return Manufacturer
     */
    public Manufacturer getManufactor(){
        return (Manufacturer) user;
    }
    
    /**
     * This method returns a customer
     * @return Customer
     */
    public Customer getCustumer(){
        return (Customer) user;
    }

    /**
     * This method returns a list of cases
     * @return List of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException {
       return client.getCaseFromServer();
    }
    
    /**
     * Edits values of a case and sends to client
     * @param caseTitle  is the title of the case
     * @param caseID is the ID of the case
     * @param caseBudget is the budget of the case
     * @param deadline is the deadline of the case
     * @param component is the component of the case
     * @param evaluated is whether the case is evaluated or not. 
     * @param freeText is the case description
     * @throws IOException when exception
     */
    @Override
    public void modifyCase(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText) throws IOException{
      
        client.editCase(new Case(caseTitle, caseID, caseBudget, deadline, component, evaluated, freeText));
                    
    }

    /**
     * Sends user to client
     * @param d is a user
     * @throws IOException when exception
     */
    @Override
    public void sendUser(User d) throws IOException {
        client.sendUser(d);
    }

    /**
     * Sends case to client
     * @param a is a case
     * @throws IOException when exception
     */
    @Override
    public void sendCase(Case a) throws IOException {
        client.sendCase(a);
    }
    
    /**
     * Deletes a case
     * @param ic is an ICase interface
     * @throws IOException when exception
     */
    @Override
    public void deleteCase(ICase ic) throws IOException{
        Case c = (Case) ic;
        client.deleteCase(c);
    }

    /**
     * Sends ticket to client
     * @param ticket is a ticket
     * @throws IOException when exception
     */
    @Override
    public void sendTicket(Ticket ticket) throws IOException {
        client.sendTicket(ticket);
    }

    /**
     * Sends users and cases to client
     * @param b is a case
     * @throws IOException when exception
     */
    @Override
    public void sendMapOfUserAndCases(Case b) throws IOException {
        client.sendMapOfUserAndCases(getUser(), b);
    }

    /**
     * Gets list cases to a specific user
     * @param a is a user
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException {
        return client.getUserCaseList(a);
    }
    
    /**
     * Gets list of cases to a specific customer
     * @param a is a customer
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getUserCaseList2(Customer a) throws IOException, ClassNotFoundException {
        return client.getUserCaseList1(a);
    }
    
    /**
     * Gets a list of all cases not evaluated
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException {
       return client.getNotEvaluatetCase();
    }

    /**
     * Evaluates a case
     * @param ic is an ICase interface
     * @throws IOException when exception
     */
    @Override
    public void Evaluate(ICase ic) throws IOException {
        Case c = (Case) ic;
        client.Evaluate(c);
    }
    
    /**
     * Returns a list of tickets to the client
     * @return list of tickets
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Ticket> getTicketFromServer() throws IOException, ClassNotFoundException {
        return client.getTicketFromServer();
    }

    /**
     * Returns a list of evaluated cases to the client
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getEvaluatetList() throws IOException, ClassNotFoundException {
        return client.getEvaluatetList();
    }

    /**
     * Deletes a user
     * @param iu is an IUser interface
     * @throws IOException when exception
     */
    @Override
    public void deleteUser(IUser iu) throws IOException {
        User u = (User) iu;
        client.deleteUser(u);
    }

    /**
     * Creates a ticket
     * @param issueNumber is the ticket ID
     * @param issueDescript is the ticket description
     * @param ic is a customer
     * @throws IOException when exception
     */
    @Override
    public void createTicket(String issueNumber,String issueDescript, Customer ic) throws IOException {
        Ticket ticket2 = new Ticket(issueNumber,issueDescript);
        setTicket(ticket2);
        client.createTicket(ticket2, ic);
    }
    
    /**
     * Sets value ticket to ticket
     * @param ticket is a ticket
     */
    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
    
    /**
     * This method returns a ticket
     * @return ticket
     */
    public Ticket getTicket(){
        return ticket;
    }

    /**
     * Returns a list of all tickets to a specific customer
     * @param ic is a customer
     * @return list of tickets
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Ticket> getAllSpecifikCustumerTicket(Customer ic) throws IOException, ClassNotFoundException {
        return client.getAllSpecifikCustumerTicket(ic);
    }

    /**
     * Updates values for a manufacturer
     * @param m is a manufacturer
     * @throws IOException when exception
     */
    @Override
    public void updateManufactor(Manufacturer m) throws IOException {
        client.updateManufactor(m);
    }

    /**
     * This method creates a manufacturer
     * @param username is the username of a manufacturer
     * @param password is the password of a manufacturer
     * @throws IOException when exception
     */
    public void createManufactur(String username,String password) throws IOException{
        Manufacturer a = new Manufacturer(username, password, null, 0, null, null);
        sendUser(a);
        
    }
    
    /**
     * This method sets the value newManfactor to m
     * @param m is a manufacturer
     */
    public void setManufactor(Manufacturer m){
        this.newManufactor = m;
    }

    /**
     * Adds a reply from an employee to a ticket
     * @param it is an ITicket interface
     * @throws IOException When exception
     */
    @Override
    public void employeeReplyTekst(ITicket it) throws IOException {
        Ticket t = (Ticket) it;
        client.employeeReplyTekst(t);
    }
    
    /**
     * Registers a bid on a case
     * @param ic is an ICase interface
     * @param bid is a bid on a case
     * @throws IOException when exception
     */
    @Override
    public void registerBid(ICase ic,double bid) throws IOException{
        Case c = (Case) ic;
        c.setBid(bid);
        client.RegisterBid(c);
    }

    /**
     * Returns a list of all cases found in auction
     * @return List of cases in auction
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getAuction() throws IOException, ClassNotFoundException {
        return client.getAuction();
        
    }
    
    /**
     * Creates a manufacturer
     * @param pass is the password for a manufacturer
     * @param userNam is the username for a manufacturer
     * @param firmaddress is the address for a manufacturer
     * @param number is the phone number for a manufacturer
     * @param firmaName is the company name for a manufacturer
     * @param firmaMail is the company mail for a manufacturer
     * @return manufacturer a
     */
    @Override
    public Manufacturer createManufactor(String pass, String userNam,String firmaddress,int number,String firmaName,String firmaMail){
        Manufacturer a = new Manufacturer(pass, userNam, firmaddress, number, firmaName, firmaMail);
        return a;
    } 
    
    /**
     * Creates a new customer
     * @param userName is the username for a customer
     * @param password is the password for a customer
     * @param addresse is the address for a customer
     * @param number is the number for a customer
     * @param email is the email for a customer
     * @param fullName is the name of a customer
     * @throws IOException when exception
     */
    @Override
    public void createCustumer(String userName,String password, String addresse,int number, String email, String fullName) throws IOException{
        Customer test = new Customer(userName,password, addresse, number, email, fullName);
        client.sendUser(test);
    }
      
    /**
     * Creates a new employee
     * @param username is the username for an employee
     * @param password is the password for an employee
     * @throws IOException when exception
     */
    @Override
    public void createEmployee(String username,String password) throws IOException{
        Employee em = new Employee(username,password);
        SetTing(em);
        client.sendUser(em);
           
    }
    
    /**
     * sets the value ting to user
     * @param t is a user
     */
    public void SetTing(User t){
        this.ting = t;
    }

    /**
     * returns ting
     * @return User
     */
    public User getTing(){
        return ting;
    }
}

