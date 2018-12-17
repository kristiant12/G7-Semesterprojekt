/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Acquaintance.IUser;
import java.io.Serializable;

/**
 *
 * @author sebastian
 */
public class User implements Serializable, IUser{

    private String password;
    private String userName; 
    static final long serialVersionUID = -7588980448693010399L;
    
    /**
     *
     * @param pass is the password for a user
     * @param userNam is the username for a user
     */
    public User(String pass, String userNam){
      
        this.password = pass;
        this.userName = userNam;
}
  
    /**
     * Returns a users password
     * @return Password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the users password to password
     * @param password is the password for a user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a users username
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * sets the users username to username
     * @param userName is the username for a user
     */
    public void setUserName(String userName) {
        this.userName = userName;
    } 
    
    /**
     * Sets the toString method output
     * @return String toString
     */
    @Override
    public String toString() {
        return  "userName=" + userName;
    }
        
    
    
}
