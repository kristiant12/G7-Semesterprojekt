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
    
     public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText) throws IOException{
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
        sendCase(SendCase);
    }
//        public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText){
//        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
//      //  mainDatabase.sendCase(SendCase);                  
//    }

   
//       @Override
//    public void RegisterBid(Case cs) {
//           try {
//             
//               client.sendCase(cs);
//               
//           } catch (IOException ex) {
//               Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);
//           }
//        
//    }
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
    public void deleteCase(Case ce) throws IOException{
        client.deleteCase(ce);
        ce = null;
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
    
    
//    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        BusinessFacade a = new BusinessFacade();
//        Scanner scan = new Scanner(System.in);
//        while(true){
//             String test = scan.nextLine();
//               Customer dd = new Customer("sssdusi", "sdsdssd1si", "ewddses", 3353330, "sefdsfsdkds", "erds");
//            a.sendUser(dd);
//        System.out.println(a.logintest("nicolai4", "1234"));
//        System.out.println(a.getUser());
//        System.out.println(a.getUserCaseList(a.getUser()));
//            System.out.println("dfdef");
//        System.out.println(a.logintest("nidsi4", "12sdsdsd34"));
//            System.out.println(a.logintest("nicolasdsdi1", "1234"));
//      ;
//            System.out.println(a.logintest("sssdusi", "sdsdssd1si"));
//            
//            
////        System.out.println("");
////        String test2 = scan.nextLine();
////
////        System.out.println(a.logintest("henrik", "1234"));
////        System.out.println(a.getUser());
////        System.out.println(a.getUserCaseList(a.getUser()));
////        
////        System.out.println("");
//        }
       
//        
//           System.out.println(a.logintest("nicolai4", "1234"));
//        System.out.println(a.getUser());
//        System.out.println(a.getUserCaseList(a.getUser()));
//    }
    @Override
    public void SendPicture(Picture pic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Picture> getPictureFromServer() throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
