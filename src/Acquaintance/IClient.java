/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

import Business.Case;
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
    
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException;

   public void sendUser(User d) throws IOException;
   
   public void sendCase(Case a) throws IOException;
   
   public void deleteCase(Case ce) throws IOException;
    
   public void sendMapOfUserAndCases(User a, Case b) throws IOException;
   
    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException;
}
