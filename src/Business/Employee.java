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
public class Employee extends User {
    
    private String idNumber;
    private String password;
    private String userName; 

    public Employee(String id, String pass, String userNam) {
        super(id, pass, userNam);
    }
    
    /**
     *
     * @param id
     * @param pass
     * @param userNam
     */

}
