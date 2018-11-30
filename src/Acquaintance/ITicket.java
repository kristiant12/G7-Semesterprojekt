/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acquaintance;

/**
 *
 * @author rober
 */
public interface ITicket {

    public String getIssuenumber();

    public void setIssuenumber(String issueNumber);

    public String getIssueDescription();

    public void setIssueDescription(String issueDescription);

    public String getBackMessage();

    public void setBackMessage(String backMessage);

    public String getEmployeeName();

    public void setEmployeeName(String employeeName);

}
