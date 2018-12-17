/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Starter;

import Acquaintance.IBusiness;
import Acquaintance.IUI;
import Business.BusinessFacade;
import GUI.Gruppe_7_semesterprojekt;

/**
 *
 * @author nicol
 */
public class starter {
    
    public static void main(String[] args) {

        
        /**
         * this is where u start the program. 
         */
        
        IBusiness bus = new BusinessFacade();
        
        IUI ui = new Gruppe_7_semesterprojekt();
        
        ui.injectBusiness(bus);
        
        ui.startAppLication(args);
        
        
        
    }
}
