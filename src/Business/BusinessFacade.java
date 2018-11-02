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
    public BusinessFacade() {
        this.client = new Client();
        
    //    this.data = data;
      //  mainDatabase = new Database();
    }
        
    

//    @Override
//    public void injectData(IData dataLayer) {
//        data = dataLayer;
//    }
    
     public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText) throws IOException{
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
        sendCase(SendCase);
    }
//        public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText){
//        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
//      //  mainDatabase.sendCase(SendCase);                  
//    }

   
    public void RegisterBid(Case cs, double bid) {
       // auction.registerBid(cs, bid);
       // mainDatabase.sendCase(cs);
        
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
            if(name.equals(name1) && password.equals(password)){
                setUser(list.get(i));
                return true;
            }
        }
        return false;  
    }
    
        @Override
    public User getUser(){
        return user;
    }
    
        @Override
    public void setUser(User u){
        this.user = u;
    }
    
    
    public User login(String name, String password) throws ClassNotFoundException, IOException{
        List<User> list = getUserFromServer();
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
    

    public Case modifyCase(String caseTitle, int caseID, double caseBudget, double bid, String deadline, String component, boolean evaluated, String freeText) throws IOException{
        Case modifiedCase = new Case(caseTitle, caseTitle, caseTitle, deadline, component, evaluated, freeText);
        sendCase(modifiedCase);
        return modifiedCase;


                    
    }
//  
//    

    @Override
    public void sendUser(User d) throws IOException {
        client.sendUser(d);
    }

    @Override
    public void sendCase(Case a) throws IOException {
        client.sendCase(a);
    }
    public void deleteCase(Case ce) throws IOException{
        client.deleteCase(ce);
        ce = null;
    }
}
