/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ITicket;
import java.io.Serializable;



/**
 *
 * @author rober
 */
public class Ticket implements Serializable,ITicket {
    
    private String issueNumber;
    private String issueDescription;
    static final long serialVersionUID = -7588980448693010399L;
    
    private String backMessage;
    private String employeeName;

    /**
     *
     * @param issueNumber
     * @param issueDescript
     */
    public Ticket(String issueNumber,String issueDescript){
        this.issueDescription = issueDescript;
        this.issueNumber = issueNumber;
    }
    
    /**
     * returns issue number as a string
     * @return string
     */
    public String getIssuenumber() {
      return issueNumber;
    }

    /**
     * sets the issuenumber vaiable equal to issuenumber
     * @param issueNumber is a string
     */
    public void setIssuenumber(String issueNumber) {
       this.issueNumber = issueNumber;

    }

    /**
     * return issue description as a string
     * @return string
     */
    public String getIssueDescription() {
         return issueDescription;
    }

    /**
     * sets issues description variable equal to issue description
     * @param issueDescription is a string
     */
    public void setIssueDescription(String issueDescription) {
         this.issueDescription = issueDescription;

    }

    /**
     * returns the class toString 
     * @return´string
     */
    public String toString(){
          return issueNumber;

    }

    /**
     * returns back massage as a string 
     * @return string
     */
    public String getBackMessage() {
        return backMessage;
    }

    /**
     * sets back massage variable equal to backMassage 
     * @param backMessage is a string
     */
    public void setBackMessage(String backMessage) {
        this.backMessage = backMessage;
    }

    /**
     * returns a employeeName as a string
     * @return string
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * sets employeeName varible equal to employeeName 
     * @param employeeName is a string
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    
    
    
    
}
