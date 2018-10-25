/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

/**
 *
 * @author nicol
 */
public class testMain {
    public static void main(String[] args) {
        
        Database test = new Database();
        String noget = "dette er en test";
        System.out.println(test.SQLTest(noget));
        
        
    }
    
}
