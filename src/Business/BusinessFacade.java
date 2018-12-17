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
//import Data.DataFacade;
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
        public BusinessFacade() {
        this.client = new Client();
        
    }
        
    

//    @Override
//    public void injectData(IData dataLayer) {
//        data = dataLayer;
//    }
        
        
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
     
       @Override
     public Case getCase(){
         return newCase;
     }
     
       @Override
     public void setCase(ICase ia){
         Case c = (Case) ia;
         this.newCase = c;
     }
     
//    public void createEmployee(String password, String usernam){
//        Employee newEmployee  = new Employee(password, usernam);
//    }

//    @Override
//    public String toServer(String i) {
//        return data.SendString(i);
//    }

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
     * @throws ClassNotFoundException thrown when exxception
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
    
        @Override
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
    

       @Override
    public void modifyCase(String caseTitle, String caseID, String caseBudget, String deadline, String component, boolean evaluated, String freeText) throws IOException{
      
        client.editCase(new Case(caseTitle, caseID, caseBudget, deadline, component, evaluated, freeText));


                    
    }
//  
//    
    
    
    // denne metode sender en ny user til sql
    @Override
    public void sendUser(User d) throws IOException {
        client.sendUser(d);
    }

    @Override
    public void sendCase(Case a) throws IOException {
        client.sendCase(a);
    }
    
    
    
       @Override
    public void deleteCase(ICase ic) throws IOException{
        Case c = (Case) ic;
        client.deleteCase(c);
    }

    /**
     *
     * @param ticket
     * @throws IOException
     */
    @Override
    public void sendTicket(Ticket ticket) throws IOException {
        client.sendTicket(ticket);
    }

    @Override
    public void sendMapOfUserAndCases(Case b) throws IOException {
        client.sendMapOfUserAndCases(getUser(), b);
    }

    @Override
    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException {
        return client.getUserCaseList(a);
    }
    
   
       @Override
    public List<Case> getUserCaseList2(Customer a) throws IOException, ClassNotFoundException {
       // Customer c = (Customer) a;
        return client.getUserCaseList1(a);
    }
    
    @Override
    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException {
       return client.getNotEvaluatetCase();
    }

    @Override
    public void Evaluate(ICase ic) throws IOException {
        Case c = (Case) ic;
        client.Evaluate(c);
    }
    

    @Override
    public List<Ticket> getTicketFromServer() throws IOException, ClassNotFoundException {
        return client.getTicketFromServer();
    }

    @Override
    public List<Case> getEvaluatetList() throws IOException, ClassNotFoundException {
        return client.getEvaluatetList();
    }

    @Override
    public void deleteUser(IUser iu) throws IOException {
        User u = (User) iu;
        client.deleteUser(u);
    }

    @Override
    public void createTicket(String issueNumber,String issueDescript, Customer ic) throws IOException {
        Ticket ticket2 = new Ticket(issueNumber,issueDescript);
        setTicket(ticket2);
        client.createTicket(ticket2, ic);
    }
    
    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
    
    public Ticket getTicket(){
        return ticket;
    }

    @Override
    public List<Ticket> getAllSpecifikCustumerTicket(Customer ic) throws IOException, ClassNotFoundException {
        return client.getAllSpecifikCustumerTicket(ic);
    }

    @Override
    public void updateManufactor(Manufacturer m) throws IOException {
        client.updateManufactor(m);
    }

   
    public void createManufactur(String username,String password) throws IOException{
        Manufacturer a = new Manufacturer(username, password, null, 0, null, null);
        sendUser(a);
        
    }
    
    public void setManufactor(Manufacturer m){
        this.newManufactor = m;
    }

    @Override
    public void employeeReplyTekst(ITicket it) throws IOException {
        Ticket t = (Ticket) it;
        client.employeeReplyTekst(t);
    }
    
       @Override
    public void registerBid(ICase ic,double bid) throws IOException{
        Case c = (Case) ic;
        c.setBid(bid);
        client.RegisterBid(c);
    }

    @Override
    public List<Case> getAuction() throws IOException, ClassNotFoundException {
        return client.getAuction();
        
    }
    
       @Override
    public Manufacturer createManufactor(String pass, String userNam,String firmaddress,int number,String firmaName,String firmaMail){
        Manufacturer a = new Manufacturer(pass, userNam, firmaddress, number, firmaName, firmaMail);
        return a;
    } 
    
       @Override
    public void createCustumer(String userName,String password, String addresse,int number, String email, String fullName) throws IOException{
        Customer test = new Customer(userName,password, addresse, number, email, fullName);
        client.sendUser(test);
    }
      
       @Override
    public void createEmployee(String username,String password) throws IOException{
        Employee em = new Employee(username,password);
        SetTing(em);
        client.sendUser(em);
           
    }
    
    public void SetTing(User t){
        this.ting = t;
    }
    public User getTing(){
        return ting;
    }
}
/*
 * To change this license header , choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
