/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Data.DataFacade;
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
      BusinessFacade business = new BusinessFacade();
      // Database mainDatabase = new Database();

        private IData data;

    public BusinessFacade() {
    //    this.data = data;
      //  mainDatabase = new Database();
    }
        
    

    @Override
    public void injectData(IData dataLayer) {
        data = dataLayer;
    }
        public void createCase(String caseTitle, String caseID,String caseBudget,String deadline, String component,boolean evaluated,String freeText){
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
      //  mainDatabase.sendCase(SendCase);                  
    }

   
    public void RegisterBid(Case cs, double bid) {
       // auction.registerBid(cs, bid);
       // mainDatabase.sendCase(cs);
        
    }

    @Override
    public String toServer(String i) {
        return data.SendString(i);
    }

    @Override
    public List<User> getUserFromServer() throws ClassNotFoundException, IOException{
        return data.getUserFromServer();
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
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BusinessFacade a = new BusinessFacade();
        Client s = new Client();
        DataFacade q  = new DataFacade(s);
        a.injectData(q);
       
       User f = a.login("admin", "password");
       
       f.toString();
    }
    
}
