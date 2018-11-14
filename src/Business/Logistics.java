/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author sebastian
 */
public class Logistics {
    private String lastKnownCity;
    private int estimatedTime;
    private String FormOfTransportation;

    public Logistics(String lastKnownCity, int estimatedTime, String FormOfTransportation) {
        this.lastKnownCity = lastKnownCity;
        this.estimatedTime = estimatedTime;
        this.FormOfTransportation = FormOfTransportation;
    }

    public String getFormOfTransportation() {
        return FormOfTransportation;
    }

    public void setFormOfTransportation(String FormOfTransportation) {
        this.FormOfTransportation = FormOfTransportation;
    }

    public String getLastKnownCity() {
        return lastKnownCity;
    }

    public void setLastKnownCity(String lastKnownCity) {
        this.lastKnownCity = lastKnownCity;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
    
}
