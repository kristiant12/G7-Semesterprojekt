package Acquaintance;

import Business.Case;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public interface IData {
    
    public void sendCase(Case SendCase);
    public void getDatabaseInfo(String ID);
}