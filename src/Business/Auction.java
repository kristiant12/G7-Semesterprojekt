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
    
    private List<Case> list;
    
    public Auction(){
        list = new ArrayList<>();
    }

    public void insertCase(Case newCase){
        list.add(newCase);
    }
    
    
    
}
