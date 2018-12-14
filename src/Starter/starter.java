/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IData;
import Acquaintance.IUI;
import Business.BusinessFacade;
import GUI.Gruppe_7_semesterprojekt;
import Data.Database;
import testclinet.Client;

/**
 *
 * @author nicol
 */
public class starter {
    
    public static void main(String[] args) {

        
        /**
         * this is where u start the program. 
         */
        
 //       IData data = new DataFacade();
        
        IBusiness bus = new BusinessFacade();
        
  //      bus.injectData(data);
        
        IUI ui = new Gruppe_7_semesterprojekt();
        
        ui.injectBusiness(bus);
        
        ui.startAppLication(args);
        
        
        
    }
}
