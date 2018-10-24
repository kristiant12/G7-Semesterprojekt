/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Acquaintance.IUser;
import Acquaintance.IData;
import Business.Case;



/**
 *
 * @author sebastian
 */
public class Database implements IData{

    public Database() {
    }
    


    @Override
    public void sendCase(Case SendCase) {
    //SQL SHIET

        
    }

    @Override
    public void getDatabaseInfo(String ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
