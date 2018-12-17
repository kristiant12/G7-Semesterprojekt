/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;

public class HomeMadeMap implements Serializable {
    
    static final long serialVersionUID = -7588980448693010399L;

    private User user;
    private Case ting;
    private Customer customer;
    private Ticket ticket;
    
    /**
     * Assigns the value user to a user, and case to ting
     * @param user is a user
     * @param ting is a case
     */
    public HomeMadeMap(User user,Case ting){
        this.ting = ting;
        this.user = user; 
    }

    /**
     * assigns the value customer to a customer, and ticket to a ticket
     * @param customer is a customer
     * @param ticket is a ticket
     */
    public HomeMadeMap(Customer customer,Ticket ticket){
        this.customer = customer;
        this.ticket = ticket;
        
    }
    
    /**
     * Returns a user
     * @return User
     */
    public User getUser(){
        return this.user;
    }
    
    /**
     * Returns a case assigned to ting
     * @return ting
     */
    public Case getCase(){
        return this.ting;
    }

    /**
     * returns a customer assigned to customer
     * @return Customer
     */
    public Customer getCustomer(){
        return this.customer;
    }

    /**
     * Returns a ticket assigned to ticket
     * @return ticket
     */
    public Ticket getTicket(){
        return this.ticket;
    }
    
}
