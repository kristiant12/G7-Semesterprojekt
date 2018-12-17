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
import Business.Employee;
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
            //this.key = null;
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

//                test = (List<User>) mapInputStram.readObject();
                // in = new Scanner(echoSocket.getInputStream());
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
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
        
//        ting = (List<User>) mapInputStram.readObject();
        //out.println("sidnsidn");
        return ting;
    }

    /**
     * Retrieves cases from the server
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException {
        sendtilServeren("2");
        List<Case> ting = new ArrayList();
        List<SealedObject> test = new ArrayList();
        
        test = (List<SealedObject>) mapInputStram.readObject();
        
//        ting = (List<Case>) mapInputStram.readObject();
//        //   out.println("2");
//        return ting;
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
     * Adds user to the database
     * @param d
     * @throws IOException
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
     * Adds a case to the database
     * @param a
     * @throws IOException
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
     * Deletes case from database
     * @param ce
     * @throws IOException
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
     * Adds ticket to the database
     * @param ticket
     * @throws IOException
     */
    public void sendTicket(Ticket ticket) throws IOException {
        sendtilServeren("6");
        tss.writeObject(ticket);
        tss.flush();

    }


    /**
     *
     * @param a
     * @param b
     * @throws IOException
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
     * Changes values of a case in the database
     * @param a
     * @throws IOException
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
     * Retrieves all users in database, adds to a list
     * @param a
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
     *
     * @param a
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
     * Retrieves all cases in the database that is not evaluated
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
        
       // test = (List<Case>) mapInputStram.readObject();
        return test;
    }

    /**
     * Evaluates a case from the database
     * @param a
     * @throws IOException
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
     * Retrieves a ticket from the database
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
     * Retrieves all evaluated cases in the database
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
     public List<Case> getEvaluatetList() throws IOException, ClassNotFoundException{
         sendtilServeren("15");
         
         List<Case> dd = new ArrayList();
         List<SealedObject> ting = (List<SealedObject>) mapInputStram.readObject();
        try {
            //dd = (List<Case>) mapInputStram.readObject();
            dd = encrypt.decryptCaseList(ting);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
         return dd;
         
     }
     
    /**
     * Deletes user in the database
     * @param a
     * @throws IOException
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
     * Creates a ticket in the database
     * @param t
     * @param c
     * @throws IOException
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
     * @param c
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
//         List<Ticket> list = (List<Ticket>) mapInputStram.readObject();
         return list;
     }
     
    /**
     * Updates values for a manufacturer account
     * @param m
     * @throws IOException
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
     * Adds a reply from an employee to a ticket
     * @param t
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
     * Adds a bid on a case to the database
     * @param a
     * @throws IOException
     */
    @Override
    public void RegisterBid(Case a) throws IOException {
        sendtilServeren("21");
        tss.writeObject(a);
        tss.flush();
    }
    
    /**
     * Retrieves a specific auction in the database
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
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
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public SecretKey getKey() throws IOException, ClassNotFoundException{
        sendtilServeren("30");
        SecretKey key = (SecretKey) mapInputStram.readObject();
        
        return key;

    }
}
