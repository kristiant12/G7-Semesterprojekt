/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author sebastian
 */
public class Employee extends User implements Serializable{
    
//    private String idNumber;
//    private String password;
//    private String userName; 

//    public Employee(String pass, String userNam) {
//        super(pass, userNam);
//    }
//    
//    /**
//     *
//     * @param id
//     * @param pass
//     * @param userNam
//     */
//
//}
  public Employee(String pass, String userNam) {
        super(pass, userNam);
    }

    @Override
    public String toString() {
        return "Employee{" +super.toString()+ '}';
    }
    
    /**
     *
     * @param id
     * @param pass
     * @param userNam
     */
    
}
