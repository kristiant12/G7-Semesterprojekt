/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class Auction {
    
    /**
     * List of cases
     */
    private List<Case> list;
    
    
    /**
     * Constructor which initiates the list into an arraylist
     */
    public Auction(){
        list = new ArrayList<>();
    }

    /**
     * Inserts a case through sql query
     * @param newCase parameter from the case class
     */
    public void insertCase(Case newCase){
        list.add(newCase);
    }
    
    
    /**
     * Registers a bid by setting it
     * @param cs Case class paramter
     * @param bid a double number to represent what has been bid 
     */
    public void registerBid(Case cs, double bid) {
        cs.setBid(bid);
    }
}
