/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclinet;

import Acquaintance.IClient;
import Business.Case;
import Business.Customer;
import Business.Employee;
import Business.Picture;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Client implements IClient{
    
    
    private PrintStream out;
    private Scanner in;
    private InputStream stream;
    private ObjectInputStream mapInputStram;
    private Map<String,String> map;
    private List<User> test;
    private List<Case> caseList;
  //  private List<Case> caseListForPerson;
    
    private ObjectOutputStream tss;
    private Map<User,Case> mapOfUserCase;
    private BufferedImage buffImage;
    private List<Picture> pictureList;
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client test = new Client();
        Customer cu = new Customer("hallo", "oleolesen", "danmark",876543, "henrik@gmail.com", "dsdsds");
        Scanner scan = new Scanner(System.in);
        while(true){
            String s = scan.nextLine();
            
            
            
            List<Case> ff = test.getUserCaseList(cu);
            for (int i = 0; i <ff.size() ; i++) {
                System.out.println(ff.get(i).toString());
            }
            
            
        }
        
    }

    public Client(){
        
        
        
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
                test = new ArrayList();
                map = new HashMap();
                echoSocket = new Socket(serverHostname, 8081);
                stream = echoSocket.getInputStream();
                mapInputStram = new ObjectInputStream(stream);
                out = new PrintStream(echoSocket.getOutputStream());

                
                tss = new ObjectOutputStream(echoSocket.getOutputStream());
                
                
//                test = (List<User>) mapInputStram.readObject();
               // in = new Scanner(echoSocket.getInputStream());
                


            }catch (UnknownHostException e) {
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
    
 
    
   
    @Override
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException{
        sendtilServeren("1");
        test = (List<User>) mapInputStram.readObject();
        //out.println("sidnsidn");
        return test;
    }
    
    
    @Override
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException{
        sendtilServeren("2");
        caseList = (List<Case>) mapInputStram.readObject();
     //   out.println("2");
        return caseList;
    }
    
    private void sendtilServeren(String i){
        out.println(i);
        
    }
    @Override
    public void sendUser(User d) throws IOException{
        sendtilServeren("3");
        tss.writeObject(d);
                tss.flush();

    }
        
    @Override
    public void sendCase(Case a) throws IOException{
        sendtilServeren("4");
        tss.writeObject(a);

        tss.flush();
    }
    
    

//    public static void main(String[] args) throws IOException {
//        
//        Client a = new Client();
//        Case s = new Case("test", "sfds", "fjnoisnf", "nsoeinsoien", "nvno", true, "nodsn");
//         
//        Scanner scan = new Scanner(System.in);
//        
//        while(true){
//                
//            String d = scan.nextLine();
//            
//            a.sendCase(s);
//
//                
//        }
//        
//       
//        
//        
//    }
//    

    @Override
    public void deleteCase(Case ce) throws IOException {
        sendtilServeren("5");
        tss.writeObject(ce);
        tss.flush();

    }
    public void sendTicket(Ticket ticket) throws IOException{
        sendtilServeren("6");
        tss.writeObject(ticket);
                tss.flush();
    
    }
    public void sendPicture(Picture pic) throws IOException {
        sendtilServeren("8");
        tss.writeObject(pic);
            tss.flush();

    }
    public List<Picture> getPictureFromServer() throws IOException, ClassNotFoundException{
        sendtilServeren("9");
        pictureList = (List<Picture>) mapInputStram.readObject();  
        return pictureList;
        
    }

    
    @Override
    public void sendMapOfUserAndCases(User a, Case b) throws IOException{
        sendtilServeren("7");
        mapOfUserCase = new HashMap();
        mapOfUserCase.put(a, b);
        tss.writeObject(mapOfUserCase);
        
    }
        
 
    
    @Override
    public List<Case> getUserCaseList(User a) throws IOException, ClassNotFoundException{
        sendtilServeren("10");
        List<Case> test;
        
        tss.writeObject(a);
                tss.flush();

        test = (List<Case>) mapInputStram.readObject();

        return test;
        
    }
    
    public List<Case> getUserCaseList1(Customer a) throws IOException, ClassNotFoundException{
        sendtilServeren("10");
        List<Case> test;
        
        tss.writeObject(a);
                tss.flush();

        test = (List<Case>) mapInputStram.readObject();

        return test;
        
    }
}
