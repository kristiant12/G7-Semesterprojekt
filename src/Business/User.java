/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author sebastian
 */
public class User {

    private String idNumber;
    private String password;
    private String userName; 
    
    
    public User(String id, String pass, String userNam){
        this.idNumber = id;
        this.password = pass;
        this.userName = userNam;
}
   public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    } 
    
    
}
