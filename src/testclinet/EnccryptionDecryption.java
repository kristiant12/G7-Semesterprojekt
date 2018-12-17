package testclinet;

import Business.HomeMadeMap;
import Business.Case;
import Business.Manufacturer;
import Business.Ticket;
import Business.User;
import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

/**
 *
 * @author nicol
 */
public class EnccryptionDecryption {

    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;
    private Client testt;
    
    /**
     *
     * @param key is the key need for encrypting and decrypting 
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public EnccryptionDecryption(SecretKey key) throws IOException, ClassNotFoundException{
        this.key = key;
            try {

            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");

            ecipher.init(Cipher.ENCRYPT_MODE, key);

            dcipher.init(Cipher.DECRYPT_MODE, key);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        } catch (NoSuchPaddingException e) {
            System.out.println("No Such Padding:" + e.getMessage());
            return;
        
        } catch (InvalidKeyException e) {
            System.out.println("Invalid Key:" + e.getMessage());
            return;
        
        } 
    }
    /**
     * decrypts a case
     * @param a is a sealedobject
     * @return a case
     * @throws IOException thrown when this exception happens
     * @throws ClassNotFoundException  thrown when this exception happens
     * @throws IllegalBlockSizeException thrown when this exception happens
     * @throws BadPaddingException  thrown when this exception happens
     */
    
public Case decryptCase(SealedObject a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     
      Case o = (Case) a.getObject(dcipher);
      
      return o;
      
  }
  
    /**
     * decrypts the case list
     * @param a is a list of sealedobjects
     * @return 
     * @returns a list with the cases
     * @throws IOException thrown when an IOException occurs.
     * @throws ClassNotFoundException thrown when a classnotfoundexception occurs. 
     * @throws IllegalBlockSizeException thrown when an illegalblocksizeexception occurs
     * @throws BadPaddingException  thrown when badpaddingexception occurs.
     */

  public List<Case> decryptCaseList(List<SealedObject> a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
      List<Case> test = new ArrayList();
      
       for (int i = 0; i < a.size(); i++) {
          
           Case o = (Case) a.get(i).getObject(dcipher);
           test.add(o);
      }
      
      return test;
      
      
  } 
  /**
   * decrypts a user
   * @param a sealedobject
   * @return
   * @throws IOException thrown when this occurs
   * @throws ClassNotFoundException thrown when this occurs
   * @throws IllegalBlockSizeException thrown when this occurs
   * @throws BadPaddingException  thrown when this occurs
   */

 public User decryptUser(SealedObject a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     
     User o = (User) a.getObject(dcipher);
     
     return o;
 }
    /**
    * decrypts a list of sealed objects
    * @param a list of sealed objects
    * @return
    * @throws IOException thrown when this occurs 
    * @throws ClassNotFoundException thrown when this occurs
    * @throws IllegalBlockSizeException thrown when this occurs 
    * @throws BadPaddingException thrown when this occurs
    */
 
 public List<User> decryptUserList(List<SealedObject> a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
      List<User> test = new ArrayList();
      
       for (int i = 0; i < a.size(); i++) {
          
           User o = (User) a.get(i).getObject(dcipher);
           test.add(o);
      }
      
      return test;
      
      
  } 
     /**
    * decrypts a ticket
    * @param a a sealedobject
     * @return 
    * @returns a Ticket
    * @throws IOException thrown when this occurs
    * @throws ClassNotFoundException thrown when this occurs
    * @throws IllegalBlockSizeException thrown when this occurs
    * @throws BadPaddingException  thrown when this occurs
    */

 public Ticket decryptTicket(SealedObject a)throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     Ticket o = (Ticket) a.getObject(dcipher);
     
     return o;
           
 }
 
    /**
     * decrypt a list of sealedobject ot a list of ticket
     * @param a list of sealedObject 
     * @return List of tickets 
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public List<Ticket> decryptTicketList(List<SealedObject> a)throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     List<Ticket> test = new ArrayList();
     
     for (int i = 0; i < a.size(); i++) {
         Ticket o = (Ticket) a.get(i).getObject(dcipher);
         test.add(o);
     }
     return test;
 }
 
    /**
     * encrypt a case object and return a sealedobject 
     * @param a is a case 
     * @return sealedobject 
     * @throws IOException
     * @throws IllegalBlockSizeException
     */
    public SealedObject encryptCase(Case a) throws IOException, IllegalBlockSizeException{
     
     SealedObject test = new SealedObject(a, ecipher);
     
     return test;
     
 }
    /**
     * encrypts a case list
     * @param a is a sealed object
     * @return list of sealedObject
     * @throws IOException thrown is IOException
     * @throws IllegalBlockSizeException  thrown when this exception occurs
     */
 
 public List<SealedObject> encryptCaseList(List<Case> a) throws IOException, IllegalBlockSizeException{
    List<SealedObject> ting = new ArrayList();
     for (int i = 0; i < a.size(); i++) {
         SealedObject test = new SealedObject(a.get(i), ecipher);
         ting.add(test);
     }
     return ting;
 }
    /**
     * encrypts a user 
     * @param a is a user 
     * @return sealedObject
     * @returns a sealedobject
     * @throws IOException thrown when this exception occurs
     * @throws IllegalBlockSizeException  thrown when this exception occus
     */
    
 public SealedObject encryptUser(User a) throws IOException, IllegalBlockSizeException{
     
     SealedObject test = new SealedObject(a, ecipher);
     
     return test;
 }
 
    /**
     * enctypt a list of users and return a list of sealedObject 
     * @param a is a list of ussrs 
     * @return list of sealedObject
     * @throws IOException
     * @throws IllegalBlockSizeException
     */
    public List<SealedObject> encryptUserList(List<User> a) throws IOException, IllegalBlockSizeException{
    List<SealedObject> ting = new ArrayList();
     for (int i = 0; i < a.size(); i++) {
         SealedObject test = new SealedObject(a.get(i), ecipher);
         ting.add(test);
     }
     return ting;
 }
 
    /**
     * encrypt a ticket and returns a sealedObject
     * @param a is a ticket
     * @return sealedObject 
     * @throws IllegalBlockSizeException
     * @throws IOException
     */
    public SealedObject encrypTicket(Ticket a) throws IllegalBlockSizeException, IOException{
     
     SealedObject test = new SealedObject(a, ecipher);
     
     return test;
     
 }
 
    /**
     * encrypt a list of ticket and return a list of sealedobject
     * @param a is a list of ticket 
     * @return list of sealedObejct 
     * @throws IOException
     * @throws IllegalBlockSizeException
     */
    public List<SealedObject> encryptTicketList(List<Ticket> a) throws IOException, IllegalBlockSizeException{
     
     List<SealedObject> ting = new ArrayList();
     for (int i = 0; i <a.size() ; i++) {
         SealedObject test = new SealedObject(a.get(i), ecipher);
         ting.add(test);
     }
     
     return ting;
 }

    /**
     * encrypt a homeMadeMap and return a sealedObject 
     * @param i is a homeMadeMap
     * @return sealedObject 
     * @throws IOException
     * @throws IllegalBlockSizeException
     */
    public SealedObject encryptHomeMadeMap(HomeMadeMap i) throws IOException, IllegalBlockSizeException{
     SealedObject test  = new  SealedObject(i, ecipher);
     
     return test;
 }
 
    /**
     * derypt a sealedObject and return a homeMadeMap
     * @param i is a sealedObject
     * @return HomeMadeMap
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     */
    public HomeMadeMap decryptHomeMadeMap(SealedObject i) throws IOException, ClassNotFoundException, BadPaddingException, IllegalBlockSizeException{
     HomeMadeMap test = (HomeMadeMap) i.getObject(dcipher);
     return test;
 }

    /**
     * encypt manufactor and return a sealedObject
     * @param m is a manufactor
     * @return sealedObject
     * @throws IOException
     * @throws IllegalBlockSizeException
     */
    public SealedObject encryptManufactor(Manufacturer m) throws IOException, IllegalBlockSizeException{
     SealedObject test = new SealedObject(m, ecipher);
     
     return test;
 } 
 
    /**
     * decrypt a sealedObject and return a manufactor
     * @param i is a sealedObject 
     * @return Manufacturer
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public Manufacturer decryptManufacturer(SealedObject i) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     Manufacturer test = (Manufacturer) i.getObject(dcipher);
     return test;
 }
 
}
