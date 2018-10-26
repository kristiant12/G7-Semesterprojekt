/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IUser;
import Acquaintance.IData;
import Business.Case;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.security.util.Password;

/**
 *
 * @author sebastian
 */
public class Database {

    private String password;
    private String username;
    private List<String> testUsername = new ArrayList<String>();
    private List<String> testpassword = new ArrayList<String>();

    public List<String> getPassword() {
        return testpassword ;
    }
    public List<String> GetUsername(){
        return testUsername;
    }

    public Database() {
    }

    public void sendCase(Case SendCase) {
        //SQL SHIET

    }

    public void getDatabaseInfo(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
