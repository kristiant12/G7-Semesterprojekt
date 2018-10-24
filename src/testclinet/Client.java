/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclinet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    private BufferedReader stdIn;
    private PrintWriter out;
    private BufferedReader in;
    
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 8081;
        Client c = new Client(host, port);
        Scanner scan  = new Scanner(System.in);
      while(true){
          String a  = scan.nextLine();
        System.out.println(c.test(a));
      }
    }

    public Client(String host, int port) {
        
        
        try {
            String serverHostname = new String("127.0.0.1");

            System.out.println("Connecting to host " + serverHostname + " on port " + port + ".");

            Socket echoSocket = null;
            out = null;
            in = null;

            try {
                echoSocket = new Socket(serverHostname, 8081);
                out = new PrintWriter(echoSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            } catch (UnknownHostException e) {
                System.err.println("Unknown host: " + serverHostname);
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Unable to get streams from server");
                System.exit(1);
            }

            /** {@link UnknownHost} object used to read from console */
            stdIn = new BufferedReader(new InputStreamReader(System.in));

          //  test();

            /** Closing all the resources */
//            out.close();
//            in.close();
//            stdIn.close();
//            echoSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String test(String i) throws IOException{
      //  while (true) {
                String client = "client: ";
                //System.out.print("client: ");
               // String userInput = stdIn.readLine();
                /** Exit on 'q' char sent */
//                if ("q".equals(userInput)) {
//                    break;
//                }
                out.println(i);
                String clientOut = client+" "+i;
                String server = "server"+in.readLine();
                return clientOut+"\n"+server; 
               // System.out.println("server: " + in.readLine());
            //} 
       // return null;
    }
}
