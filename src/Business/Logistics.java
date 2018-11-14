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
    private int shipmentID;

    public Logistics(String lastKnownCity, int estimatedTime, String FormOfTransportation,int shipmentID) {
        this.lastKnownCity = lastKnownCity;
        this.estimatedTime = estimatedTime;
        this.FormOfTransportation = FormOfTransportation;
        this.shipmentID = shipmentID;
        
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

    public int getShipmentID() {
        return shipmentID;
    }

    public void setShipmentID(int shipmentID) {
        this.shipmentID = shipmentID;
    }
    
    
}
