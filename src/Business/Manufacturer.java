/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

/**
 *
 * @author sebastian
 */

public class Manufacturer extends User implements Serializable {
    
    private String firmaddress;
    private int number;
    private String firmaName;
    private String firmaMail;
    
    /**
     *
     * @param pass is the password for a manufacturer
     * @param userNam is the username for a manufacturer
     * @param firmaddress is the company address for a manufacturer
     * @param number is the phone number for a manufacturer
     * @param firmaName is the company name for a manufacturer 
     * @param firmaMail is the mail for a manufacturer
     */
    public Manufacturer(String pass, String userNam, String firmaddress,int number,String firmaName,String firmaMail) {
        super(pass, userNam);
        this.firmaMail = firmaMail;
        this.firmaName = firmaName;
        this.firmaddress = firmaddress;
        this.number = number;
        
    }

    /**
     * Returns the company address for a manufacturer
     * @return firmaddress
     */
    public String getFirmaddress() {
        return firmaddress;
    }

    /**
     * Sets the manufacturers address value to firmaddress
     * @param firmaddress is the company address for a manufacturer
     */
    public void setFirmaddress(String firmaddress) {
        this.firmaddress = firmaddress;
    }

    /**
     * Returns the manufacturers phone number
     * @return number is the manufacturers phone number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the phone number for a manufacturer to number
     * @param number is the manufacturers phone number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Returns the manufacturers company name
     * @return firmaName is the manufacturers company name
     */
    public String getFirmaName() {
        return firmaName;
    }

    /**
     * Sets the company name for a manufacturer to firmaName
     * @param firmaName is the manufacturers company name
     */
    public void setFirmaName(String firmaName) {
        this.firmaName = firmaName;
    }

    /**
     * Returns the manufacturers email
     * @return firmaMail
     */
    public String getFirmaMail() {
        return firmaMail;
    }

    /**
     * Sets the manufacturers email to firmaMail
     * @param firmaMail is the manufacturers email
     */
    public void setFirmaMail(String firmaMail) {
        this.firmaMail = firmaMail;
    }

    /**
     * Overrides the toString super method
     * @return String
     */
    @Override
    public String toString() {
        return "Manufacturer{" +super.toString()+ '}';
    }
    
    
    
    
}
