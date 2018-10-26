/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclinet;

import Acquaintance.IClient;
import Business.Case;
import Business.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
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
    
    
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Client c = new Client();
//        Scanner scan  = new Scanner(System.in);
//        List<User> userList = new ArrayList();
//        userList = c.getUserFromServer();
////        
////        for (int i = 0; i < userList.size(); i++) {
////            System.out.println(userList.get(i).toString());
////        }
////       
//    }

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
            
            try {
                test = new ArrayList();
                map = new HashMap();
                echoSocket = new Socket(serverHostname, 8081);
                stream = echoSocket.getInputStream();
                mapInputStram = new ObjectInputStream(stream);
                
                
//                test = (List<User>) mapInputStram.readObject();
               out = new PrintStream(echoSocket.getOutputStream());
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
    
    public Map<String,String> test(){
        return this.map;
    }
    
    public List<User> testListz (){
        return this.test;
    }
    @Override
    public List<User> getUserFromServer() throws IOException, ClassNotFoundException{
        test = (List<User>) mapInputStram.readObject();
        //out.println("sidnsidn");
        return test;
    }
    
    
    public List<Case> getCaseFromServer() throws IOException, ClassNotFoundException{
        caseList = (List<Case>) mapInputStram.readObject();
     //   out.println("2");
        return caseList;
    }
    
    
//    @Override
//    public String SendString(String i) throws IOException{
//                String client = "client: ";
//                out.println(i);
//                String clientOut = client+""+i;
//                String server = in.nextLine();
//                return server; 
//    }
    
        public List<String> testServer(String i) throws IOException{
                List<String> test = new ArrayList<>();
                String client = "client: ";
                out.println(i);
                String clientOut = client+""+i;
                test.add(in.nextLine());
                return test; 
    }

        
        
 
}
