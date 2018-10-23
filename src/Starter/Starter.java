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
import Data.DataFacade;
import gruppe_7_semesterprojekt.Gruppe_7_semesterprojekt;

/**
 *
 * @author nicol
 */
public class Starter {
    
    public static void main(String[] args) {
        
        IData data = new DataFacade();
        
        IBusiness bus = new BusinessFacade();
        
        bus.injectData(data);
        
        IUI ui = new Gruppe_7_semesterprojekt();
        
        ui.injectBusiness(bus);
        
        ui.startAppLication(args);
        
        
    }
}
