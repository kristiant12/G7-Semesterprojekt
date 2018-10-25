/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclinet;

import Acquaintance.IClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client implements IClient{

    private PrintStream out;
    private Scanner in;
    
    public static void main(String[] args) throws IOException {
        Client c = new Client();
        Scanner scan  = new Scanner(System.in);
      while(true){
          String a  = scan.nextLine();
        System.out.println(c.testServer(a));
      }
    }

    public Client() {
        
        
        
        try {
            String serverHostname = new String("127.0.0.1");
            int port = 8081;
            System.out.println("Connecting to host " + serverHostname + " on port " + port + ".");

            Socket echoSocket = null;
            out = null;
            in = null;

            try {
                echoSocket = new Socket(serverHostname, 8081);
                out = new PrintStream(echoSocket.getOutputStream());
                in = new Scanner(echoSocket.getInputStream());
                
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
    public String toServer(String i) throws IOException{
                String client = "client: ";
                out.println(i);
                String clientOut = client+""+i;
                String server = in.nextLine();
                return server; 
    }
    
        public List<String> testServer(String i) throws IOException{
                List<String> test = new ArrayList<>();
                String client = "client: ";
                out.println(i);
                String clientOut = client+""+i;
                test.add(in.nextLine());
                return test; 
    }


 
}
