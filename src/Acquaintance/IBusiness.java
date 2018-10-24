package Acquaintance;

import Business.Case;

/* OSRS ER ET LORTE SPIL!!!!!!!!! CONFIRMED!
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public interface IBusiness {
    
    public void injectData(IData dataLayer);
    
    public void RegisterBid(Case cs, double bid);
    
    public String toServer(String i);
}
