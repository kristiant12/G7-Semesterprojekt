/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclinet;

import Business.HomeMadeMap;
import Acquaintance.IClient;
import Business.Case;
import Business.Customer;
import Business.Manufacturer;
import Business.Ticket;
import Business.User;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;;

/**
 *
 * @author Kristian
 */
public class Client implements IClient {

    private PrintStream out;
    private Scanner in;
    private InputStream stream;
    private ObjectInputStream mapInputStram;
    private ObjectOutputStream tss;
    private Map<User, Case> mapOfUserCase;
    private BufferedImage buffImage;
    private SecretKey key;
    private EnccryptionDecryption encrypt;
    
    /**
     *
     */
    public Client() {

        try {
            String serverHostname = new String("127.0.0.1");
            int port = 8081;
            System.out.println("Connecting to host " + serverHostname + " on port " + port + ".");
            Socket echoSocket = null;
            out = null;
            in = null;
            stream = null;
            mapInputStram = null;
            tss = null;
            
            try {
                echoSocket = new Socket(serverHostname, 8081);
                stream = echoSocket.getInputStream();
                mapInputStram = new ObjectInputStream(stream);
                out = new PrintStream(echoSocket.getOutputStream());
                tss = new ObjectOutputStream(echoSocket.getOutputStream());
                encrypt = new EnccryptionDecryption(getKey());
            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + serverHostname);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Unable to get streams from server");
                System.exit(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves users from the server
     * @return list of users
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException {
        sendtilServeren("1");
        List<User> ting = new ArrayList();
        List<SealedObject> test = new ArrayList();
        test = (List<SealedObject>) mapInputStram.readObject();

        try {
            ting = encrypt.decryptUserList(test);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ting;
    }

    /**
     * Retrieves cases from the server
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException {
        sendtilServeren("2");
        List<Case> ting = new ArrayList();
        List<SealedObject> test = new ArrayList();
        
        test = (List<SealedObject>) mapInputStram.readObject();
        
        try {
            ting = encrypt.decryptCaseList(test);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ting;
    }

    private void sendtilServeren(String i) {
        out.println(i);

    }

    /**
     * Sends user to server
     * @param d is a user
     * @throws IOException when exception
     */
    @Override
    public void sendUser(User d) throws IOException {
        sendtilServeren("3");
        SealedObject a = null;
        try {
            a = encrypt.encryptUser(d);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        tss.writeObject(a);
        tss.flush();

    }

    /**
     * Sends a case to the server
     * @param a is a case
     * @throws IOException when exception
     */
    @Override
    public void sendCase(Case a) throws IOException {
        sendtilServeren("4");
        SealedObject b = null;
        try {
             b = encrypt.encryptCase(a);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        tss.writeObject(b);

        tss.flush();
    }
  
    /**
     * Sends case to be deleted to server
     * @param ce is a case
     * @throws IOException when exception
     */
    @Override
    public void deleteCase(Case ce) throws IOException {
        sendtilServeren("5");
        SealedObject a = null;
        try {
            a = encrypt.encryptCase(ce);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        tss.writeObject(a);
        tss.flush();

    }

    /**
     * Sends ticket to server
     * @param ticket is a ticket
     * @throws IOException when exception
     */
    public void sendTicket(Ticket ticket) throws IOException {
        sendtilServeren("6");
        tss.writeObject(ticket);
        tss.flush();

    }


    /**
     * Sends list of users and cases to the server
     * @param a is a user
     * @param b is a case
     * @throws IOException when exception
     */
    @Override
    public void sendMapOfUserAndCases(User a, Case b) throws IOException {
        sendtilServeren("7");
        HomeMadeMap d = new HomeMadeMap(a, b);
        
        SealedObject ting = null;
       
        try {
            ting = encrypt.encryptHomeMadeMap(d);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tss.writeObject(ting);
    }

    /**
     * Sends case to  be edited to server
     * @param a is a case
     * @throws IOException when exception 
     */
    @Override
    public void editCase(Case a) throws IOException {
        sendtilServeren("11");
        SealedObject s = null;
        try {
            s = encrypt.encryptCase(a);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        tss.writeObject(s);
        tss.flush();

    }

    /**
     * Sends list of all cases for a user to server
     * @param a is a user
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException {
        sendtilServeren("10");
        List<Case> test = new ArrayList();
        List<SealedObject> ting = new ArrayList();
        SealedObject b = null;
        try {
            b =  encrypt.encryptUser(a);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        tss.writeObject(b);
        tss.flush();

        ting = (List<SealedObject>) mapInputStram.readObject();
        try {
            test = encrypt.decryptCaseList(ting);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        return test;

    }

    /**
     * Returns list of cases for a user to the server
     * @param a is a customer
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    public List<Case> getUserCaseList1(Customer a) throws IOException, ClassNotFoundException {
        sendtilServeren("10");
        List<Case> test;

        tss.writeObject(a);
        tss.flush();

        test = (List<Case>) mapInputStram.readObject();

        return test;
    }

    /**
     * SEnds list of all not evaluated cases to server
     * @return list of cases not evaluated
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Case> getNotEvaluatetCase() throws IOException, ClassNotFoundException {
        sendtilServeren("12");
        List<Case> test = new ArrayList();
        List<SealedObject> ting = (List<SealedObject>) mapInputStram.readObject();
        
        try {
            test = encrypt.decryptCaseList(ting);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    /**
     * Sends case to be evalued to server
     * @param a is a case
     * @throws IOException when exception
     */
    @Override
    public void Evaluate(Case a) throws IOException {
        sendtilServeren("13");
        SealedObject ting = null;
        try {
            ting = encrypt.encryptCase(a);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        tss.writeObject(ting);
        tss.flush();

    }
//

    /**
     * Retrieves list of tickets from server
     * @return list of tickets
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
    public List<Ticket> getTicketFromServer() throws IOException, ClassNotFoundException {

        sendtilServeren("14");
        List<Ticket> ticket = new ArrayList<>();
        List<SealedObject> ting = (List<SealedObject>) mapInputStram.readObject();
        try {
            //        ticket = (List<Ticket>) mapInputStram.readObject();
            ticket = encrypt.decryptTicketList(ting);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ticket;
    }

    /**
     * Retrieves all evaluated cases from the server
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
     public List<Case> getEvaluatetList() throws IOException, ClassNotFoundException{
         sendtilServeren("15");
         
         List<Case> dd = new ArrayList();
         List<SealedObject> ting = (List<SealedObject>) mapInputStram.readObject();
        try {
            dd = encrypt.decryptCaseList(ting);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dd;
         
     }
     
    /**
     * Sends request to server to delete user
     * @param a is a user
     * @throws IOException when exception
     */
    @Override
     public void deleteUser(User a) throws IOException{
         sendtilServeren("16");
         SealedObject ting = null;
         try {
            ting = encrypt.encryptUser(a);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         tss.writeObject(ting);
         
     }
     
    /**
     * Sends request to server to create ticket
     * @param t is a ticket
     * @param c is a customer
     * @throws IOException when exception
     */
    @Override
     public void createTicket(Ticket t, Customer c) throws IOException{
          sendtilServeren("17");
          HomeMadeMap ding = new HomeMadeMap(c, t);
          SealedObject ting = null;
        try {
            ting = encrypt.encryptHomeMadeMap(ding);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
          tss.writeObject(ting);
     }
     
    /**
     * Retrieves all tickets assigned to a specific user
     * @param c is a customer
     * @return list of tickets
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    @Override
     public List<Ticket> getAllSpecifikCustumerTicket(Customer c) throws IOException, ClassNotFoundException{
         sendtilServeren("18");
         SealedObject ting =null;
        try {
           ting = encrypt.encryptUser(c);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         tss.writeObject(ting);
         
         List<SealedObject> ting2 = (List<SealedObject>) mapInputStram.readObject();
         List<Ticket> list = null;
        try {
            list = encrypt.decryptTicketList(ting2);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         return list;
     }
     
    /**
     * Sends request to update values for a manufacturer
     * @param m is a manufacturer
     * @throws IOException when exception
     */
    @Override
     public void updateManufactor(Manufacturer m) throws IOException{
         sendtilServeren("19");
         SealedObject t = null;
        try {
            t = encrypt.encryptManufactor(m);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         tss.writeObject(t);
         
     }
     
    /**
     * sends request to add a reply from an employee to a ticket
     * @param t is a ticket
     * @throws IOException
     */
    @Override
     public void employeeReplyTekst(Ticket t) throws IOException{
         sendtilServeren("20");
         SealedObject ting = null;
        try {
            ting = encrypt.encrypTicket(t);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         tss.writeObject(ting);
     }

    /**
     * sends request to add a bid on a case to the database
     * @param a is a case
     * @throws IOException
     */
    @Override
    public void RegisterBid(Case a) throws IOException {
        sendtilServeren("21");
        tss.writeObject(a);
        tss.flush();
    }
    
    /**
     * Adds auctions to a list
     * @return list of cases
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    public List<Case> getAuction() throws IOException, ClassNotFoundException{
        sendtilServeren("22");
        List<SealedObject> ting = (List<SealedObject>) mapInputStram.readObject();
        List<Case> s = null;
        try {
            s = encrypt.decryptCaseList(ting);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return s;
    }
     
    /**
     * Retrieves key for encryption/decryption
     * @return key for decryption
     * @throws IOException when exception
     * @throws ClassNotFoundException when exception
     */
    public SecretKey getKey() throws IOException, ClassNotFoundException{
        sendtilServeren("30");
        SecretKey key = (SecretKey) mapInputStram.readObject();
        
        return key;

    }
}
