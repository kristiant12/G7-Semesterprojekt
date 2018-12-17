/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    
    /**
     *
     * @param pass is the password for an admin
     * @param userNam is the username of an admin
     */
    public Admin(String pass, String userNam) {
        super (pass, userNam);
    }

    /**
     * This is the standard toString method, overrides the super method
     * @return String
     */
    @Override
    public String toString() {
        return "Admin{" +super.toString()+ '}';
    }
    
    
    
    
}
