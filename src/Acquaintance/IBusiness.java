package Acquaintance;

import Business.Case;
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
    
    public void injectData(IData dataLayer);
    
    public void RegisterBid(Case cs, double bid);
    
    public String toServer(String i);
  
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException;
    
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException;


}
