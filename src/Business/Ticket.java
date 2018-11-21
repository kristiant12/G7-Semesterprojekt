/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.Serializable;



/**
 *
 * @author rober
 */
public class Ticket implements Serializable {
    
    private String issueNumber;
    private String issueDescription;
    static final long serialVersionUID = -7588980448693010399L;



    
    public Ticket(String issueNumber,String issueDescript){
        this.issueDescription = issueDescript;
        this.issueNumber = issueNumber;
    }

    public String getIssuenumber() {
      return issueNumber;
    }

    public void setIssuenumber(String issueNumber) {
       this.issueNumber = issueNumber;

    }

    public String getIssueDescription() {
         return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
         this.issueDescription = issueDescription;

    }
    public String toString(){
          return issueNumber +" "+ issueDescription;

    }
    
}
