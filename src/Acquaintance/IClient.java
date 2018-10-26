/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.User;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author nicol
 */
public interface IClient {
    
    //public String SendString(String i)throws IOException;
    
    
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException;
  
}
