/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IData;
import Business.Case;
import Business.User;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import testclinet.Client;

/**
 *
 * @author nicol
 */

public class DataFacade implements IData{
    private Client client;
    
    public DataFacade(Client client){
        this.client = client;
        
    }

    public void sendCase(Case SendCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDatabaseInfo(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

//    @Override
//    public String SendString(String i) {
//        try {
//            return client.SendString(i);
//        } catch (IOException ex) {
//            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    @Override
    public String SendString(String i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException {
        return client.getUserFromServer();
    }

  



    
}
