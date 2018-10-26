/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Business.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nicol
 */
public class Database {
    
    
    
    
    Connection db = null;
    private final String url = "jdbc:postgresql://horton.elephantsql.com:5432/ddrapuye";
    private final String username = "ddrapuye";
    private final String password = "FdCxvGtgDcCFm0Jc2Oixndk3t9SGy8YF";
    
     public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
        }
    }
     
     public String SQLTest(String i){
         Statement a = null;
         ResultSet øv = null;
         String test = "";
         try{
             a = db.createStatement();
             øv = a.executeQuery("select * from test where test = '" + i + "'");
             while(øv.next()){
                 test = øv.getString(2);
             }
         }
         catch (Exception e){
             
         }
         return test;
     }
     
    public Map<String,String> getUser(){
        Map<String,String> list = new HashMap<>();
        list.putAll(list);
        list.putAll(getCustomer());
        list.putAll(getEmployee());
        list.putAll(getManufacturer());
        
        return list;
        
    }
    
    
    public Map<String,String> getAdmin(){
        Statement a = null;
        ResultSet øv = null;
        Map<String,String> list = new HashMap<>();
        String userName = "";
        String password = "";
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from admin");
            
            while(øv.next()){
                userName = øv.getString(1);
                password = øv.getString(2);
                list.put(userName, password);
            }
            
            
        } catch (Exception ex) {

        }
        return list;
    }
     
       public Map<String,String> getManufacturer(){
        Statement a = null;
        ResultSet øv = null;
       Map<String,String> list = new HashMap<>();
        String userName = "";
        String password = "";
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from manufacturer");
            
            while(øv.next()){
                userName = øv.getString(1);
                password = øv.getString(2);
                list.put(userName, password);
            }
            
            
        } catch (Exception ex) {

        }
        return list;
    }
        public Map<String,String> getCustomer(){
        Statement a = null;
        ResultSet øv = null;
        Map<String,String> list = new HashMap<>();
        String userName = "";
        String password = "";
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from customer");
            
            while(øv.next()){
                userName = øv.getString(1);
                password = øv.getString(2);
                list.put(userName, password);
            }
            
            
        } catch (Exception ex) {

        }
        return list;
    }
    
        public Map<String,String> getEmployee(){
        Statement a = null;
        ResultSet øv = null;
        Map<String,String> list = new HashMap<>();
        String userName = "";
        String password = "";
        try{
            a = db.createStatement();
            øv = a.executeQuery("select * from employee");
            
            while(øv.next()){
                userName = øv.getString(1);
                password = øv.getString(2);
                list.put(userName, password);
            }
            
            
        } catch (Exception ex) {

        }
        return list;
    }
    
    
        public List<String> test(){
            List<String> list = new ArrayList<>();
            
            list.add("1");
            list.add("2");
            
            return list;
        }
    
           public List<String> test2(){
            List<String> list = new ArrayList<>();
            
            list.add("4");
            list.add("5");
            
            return list;
        }
}
