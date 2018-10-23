/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nicol
 */
public class Database {
    
    Connection db = null;
    private final String url = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/lvavuwqi";
    private final String username = "lvavuwqi";
    private final String password = "YOEgDzeuFTOeiKaFdu4UaHUI-N1JrfBv";
    
     public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            db = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
        }
    }
     
     public String Test(){
         Statement a = null;
         ResultSet øv = null;
         String test = "";
         try{
             a = db.createStatement();
             øv = a.executeQuery("select * from test");
             while(øv.next()){
                 test = øv.getString(1);
             }
         }
         catch (Exception e){
             
         }
         return test;
     }
    
}
