/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.Database;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SocketServer extends Thread {

    public static final int PORT_NUMBER = 8081;
    private Database db;
    protected Socket socket;
    private Map<String, String> map;
    private ObjectOutputStream mapObjectOutputStream;
    
    private SocketServer(Socket socket, Database db) {
        this.db = db;
        this.socket = socket;
        System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
        start();
    }
    
    public void run() {
        map = new HashMap();
        InputStream in = null;
        OutputStream out = null;
        mapObjectOutputStream = null;
        List<String> test = new ArrayList<>();
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            mapObjectOutputStream = new ObjectOutputStream(out);
            Scanner inp = new Scanner(in);
            PrintStream outp = new PrintStream(out);

            // BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String request;
            
            request = inp.nextLine();
            if(request.equals("1")){
                sendMap();
            }
            //String test = null;
//            while ((request = inp.nextLine()) != null) {
//                System.out.println("Message received:" + request);
//                
//              outp.println(db.SQLTest(request));
//            }
//             while ((request = inp.nextLine()) != null) {
//                System.out.println("Message received:" + request);
//                test.add(request);
//                //test.add(request+" 3");
//                
//              outp.println(test);
//
//            }
//         // detter virke så  
//            map.putAll(db.getUser());
//            mapObjectOutputStream.writeObject(map);
                
//            test = db.test();
//            mapObjectOutputStream.writeObject(test);
            
        } catch (IOException ex) {
            System.out.println("Unable to get streams from client");
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void sendMap () throws IOException{
            map.putAll(db.getUser());
            mapObjectOutputStream.writeObject(map);
    }
    
    public static void main(String[] args) {
        System.out.println("SocketServer Example");
        Database db = new Database();
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT_NUMBER);
            while (true) {
                /**
                 * create a new {@link SocketServer} object for each connection
                 * this will allow multiple client connections
                 */
                new SocketServer(server.accept(), db);
            }
        } catch (IOException ex) {
            System.out.println("Unable to start server.");
        } finally {
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
