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
import java.util.HashMap;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class EnccryptionDecryption {

    private static Cipher ecipher;
    private static Cipher dcipher;
    private static SecretKey key;
    private Client testt;
    
    public EnccryptionDecryption(SecretKey key) throws IOException, ClassNotFoundException{
        this.key = key;
            try {

            // generate secret key using DES algorithm
            //key = KeyGenerator.getInstance("DES").generateKey();

            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");

            // initialize the ciphers with the given key 
            ecipher.init(Cipher.ENCRYPT_MODE, key);

            dcipher.init(Cipher.DECRYPT_MODE, key);

            // create a sealed object
//            SealedObject test = new SealedObject((new Case(null, null, null, null, null, true, null)), ecipher);
//
//            // get the algorithm with the object has been sealed
//            String algorithm = test.getAlgorithm();
//
//            System.out.println("Algorithm " + algorithm);
//
//            // unseal (decrypt) the object
//            Case o = (Case) test.getObject(dcipher);
//            
//            System.out.println("Original Object: " + o);
//            
//            System.out.println(key);

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

public Case decryptCase(SealedObject a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     
      Case o = (Case) a.getObject(dcipher);
      
      return o;
      
  }
  
  public List<Case> decryptCaseList(List<SealedObject> a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
      List<Case> test = new ArrayList();
      
       for (int i = 0; i < a.size(); i++) {
          
           Case o = (Case) a.get(i).getObject(dcipher);
           test.add(o);
      }
      
      return test;
      
      
  } 

 public User decryptUser(SealedObject a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     
     User o = (User) a.getObject(dcipher);
     
     return o;
 }
 public List<User> decryptUserList(List<SealedObject> a) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
      List<User> test = new ArrayList();
      
       for (int i = 0; i < a.size(); i++) {
          
           User o = (User) a.get(i).getObject(dcipher);
           test.add(o);
      }
      
      return test;
      
      
  } 

 public Ticket decryptTicket(SealedObject a)throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     Ticket o = (Ticket) a.getObject(dcipher);
     
     return o;
           
 }
 
 public List<Ticket> decryptTicketList(List<SealedObject> a)throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     List<Ticket> test = new ArrayList();
     
     for (int i = 0; i < a.size(); i++) {
         Ticket o = (Ticket) a.get(i).getObject(dcipher);
         test.add(o);
     }
     return test;
 }
 
 public SealedObject encryptCase(Case a) throws IOException, IllegalBlockSizeException{
     
     SealedObject test = new SealedObject(a, ecipher);
     
     return test;
     
 }
 
 public List<SealedObject> encryptCaseList(List<Case> a) throws IOException, IllegalBlockSizeException{
    List<SealedObject> ting = new ArrayList();
     for (int i = 0; i < a.size(); i++) {
         SealedObject test = new SealedObject(a.get(i), ecipher);
         ting.add(test);
     }
     return ting;
 }
 
 public SealedObject encryptUser(User a) throws IOException, IllegalBlockSizeException{
     
     SealedObject test = new SealedObject(a, ecipher);
     
     return test;
 }
 
  public List<SealedObject> encryptUserList(List<User> a) throws IOException, IllegalBlockSizeException{
    List<SealedObject> ting = new ArrayList();
     for (int i = 0; i < a.size(); i++) {
         SealedObject test = new SealedObject(a.get(i), ecipher);
         ting.add(test);
     }
     return ting;
 }
 
 public SealedObject encrypTicket(Ticket a) throws IllegalBlockSizeException, IOException{
     
     SealedObject test = new SealedObject(a, ecipher);
     
     return test;
     
 }
 
 public List<SealedObject> encryptTicketList(List<Ticket> a) throws IOException, IllegalBlockSizeException{
     
     List<SealedObject> ting = new ArrayList();
     for (int i = 0; i <a.size() ; i++) {
         SealedObject test = new SealedObject(a.get(i), ecipher);
         ting.add(test);
     }
     
     return ting;
 }
// public SealedObject encryptHashMap(HashMap<User,Case> i) throws IOException, IllegalBlockSizeException{
//    SealedObject test = new SealedObject(i, ecipher);
//    return test;
// }
// public HashMap<User,Case> decryptHashMap(SealedObject i) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
//     
//     HashMap<User,Case> test = (HashMap<User,Case>) i.getObject(dcipher);
//     
//     return test;
// }
   public SealedObject encryptHomeMadeMap(HomeMadeMap i) throws IOException, IllegalBlockSizeException{
     SealedObject test  = new  SealedObject(i, ecipher);
     
     return test;
 }
 
 public HomeMadeMap decryptHomeMadeMap(SealedObject i) throws IOException, ClassNotFoundException, BadPaddingException, IllegalBlockSizeException{
     HomeMadeMap test = (HomeMadeMap) i.getObject(dcipher);
     return test;
 }
 public SealedObject encryptManufactor(Manufacturer m) throws IOException, IllegalBlockSizeException{
     SealedObject test = new SealedObject(m, ecipher);
     
     return test;
 } 
 
 public Manufacturer decryptManufacturer(SealedObject i) throws IOException, ClassNotFoundException, IllegalBlockSizeException, BadPaddingException{
     Manufacturer test = (Manufacturer) i.getObject(dcipher);
     return test;
 }
 
}
