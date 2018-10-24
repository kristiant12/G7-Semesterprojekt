/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Data.Database;

/**
 *
 * @author nicol
 */
public class BusinessFacade implements IBusiness{
       Auction auction = new Auction();
       BusinessFacade business = new BusinessFacade();
       Database mainDatabase = new Database();

    public BusinessFacade() {
        //this.data = data;
        mainDatabase = new Database();
    }
        
    
    private IData data;

    @Override
    public void injectData(IData dataLayer) {
        data = dataLayer;
    }
        public void createCase(String caseTitle, int caseID,double caseBudget,String deadline, String component,boolean evaluated,String freeText){
        Case SendCase = new Case(caseTitle, caseID,caseBudget,deadline,component,evaluated,freeText);
        mainDatabase.sendCase(SendCase);                  
    }

   
    public void RegisterBid(Case cs, double bid) {
        auction.registerBid(cs, bid);
        mainDatabase.sendCase(cs);
        
    }
    
}
