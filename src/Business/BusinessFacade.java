/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IBusiness;
import Acquaintance.IData;

/**
 *
 * @author nicol
 */
public class BusinessFacade implements IBusiness{
    
    private IData data;

    @Override
    public void injectData(IData dataLayer) {
        data = dataLayer;
    }
    
}
