/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ITicket;

/**
 *
 * @author rober
 */
public class Ticket implements ITicket {
    
    private String issueNumber;
    private String issueDescription;

    
    public Ticket(String issueDescript){
        this.issueDescription = issueDescript;
    }

    @Override
    public String getIssuenumber() {
      return issueNumber;
    }

    @Override
    public void setIssuenumber(String issueNumber) {
       this.issueNumber = issueNumber;

    }

    @Override
    public String getIssueDescription() {
         return issueDescription;
    }

    @Override
    public void setIssueDescription(String issueDescription) {
         this.issueDescription = issueDescription;

    }
    public String toString(){
          return issueNumber + issueDescription;

    }
    
}
