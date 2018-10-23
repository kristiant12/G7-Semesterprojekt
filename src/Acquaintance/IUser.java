/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author sebastian
 */
public interface IUser {
    public String getIdNumber(); 
    

    public void setIdNumber();

    public String getPassword();
    

    public void setPassword();

    public String getUserName();

    public void setUserName();
    
    public void createCase();
}
