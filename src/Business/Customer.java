package Business;

import Acquaintance.ICustomer;
import java.io.Serializable;

/**
 *
 * @author nicol
 */
public class Customer extends User implements Serializable{

  private String address;
  private int number;
  private String email;
  private String fulName;

    /**
     *
     * @param pass
     * @param userNam
     * @param address
     * @param number
     * @param email
     * @param fulName
     */
    public Customer(String pass, String userNam,String address,int number,String email,String fulName) {
        super(pass, userNam);
        this.address = address;
        this.email = email;
        this.fulName = fulName;
        this.number = number;
        
    }

    /**
     *return an address as a string
     * @return String 
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the address viable equal to address
     * @param address is a String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *  return a numbers as a int
     * @return int
     */
    public int getNumber() {
        return number;
    }

    /**
     * sets the variable number equal to number
     * @param number is a int
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * return a email as a string
     * @return string
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets email variable equal to email
     * @param email is a string 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * return a fullname as a string
     * @return string
     */
    public String getFulName() {
        return fulName;
    }

    /**
     * sets fullname variable equal to fullname 
     * @param fulName is a string 
     */
    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    /**
     * return the override the super to string
     * @return string
     */
    @Override
    public String toString() {
        return "Customer=" +super.toString();
    }
    
    
}
