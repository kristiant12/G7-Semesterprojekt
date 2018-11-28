/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
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
     public void setCase(Case a){
         this.newCase = a;
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
        this.user = u;
    }
    
    
    public Manufacturer getManufactor(){
        return (Manufacturer) user;
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
    public void modifyCase(Case a) throws IOException{
       client.editCase(a);


                    
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
    public void deleteCase(Case ce) throws IOException{
        client.deleteCase(ce);
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
    
   
    public List<Case> getUserCaseList2(Customer a) throws IOException, ClassNotFoundException {
        return client.getUserCaseList1(a);
    }
    
    @Override
    public void SendPicture(Picture pic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Picture> getPictureFromServer() throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException {
       return client.getNotEvaluatetCase();
    }

    @Override
    public void Evaluate(Case a) throws IOException {
        client.Evaluate(a);
    }
    public Logistics updateLogistics(String lastKnownCity, int estimatedTime, String FormOfTransportation, Case cs){
        
        
        
           return null;
    }
    
    public void trackLogistics(){
        
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
    public void deleteUser(User a) throws IOException {
        client.deleteUser(a);
    }

    @Override
    public void createTicket(Ticket t, Customer c) throws IOException {
        client.createTicket(t, c);
    }

    @Override
    public List<Ticket> getAllSpecifikCustumerTicket(Customer c) throws IOException, ClassNotFoundException {
        return client.getAllSpecifikCustumerTicket(c);
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
    public void employeeReplyTekst(Ticket t) throws IOException {
        client.employeeReplyTekst(t);
    }
  
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
