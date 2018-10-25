/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;



import Server.Database;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SocketServer extends Thread {
    public static final int PORT_NUMBER = 8081;
    private Database db;
    protected Socket socket;

    private SocketServer(Socket socket, Database db) {
        this.db = db;
        this.socket = socket;
        System.out.println("New client connected from " + socket.getInetAddress().getHostAddress());
        start();
    }


    public void run() {
        InputStream in = null;
        OutputStream out = null;
        List<String> test = new ArrayList<>();
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            Scanner inp = new Scanner(in);
            PrintStream outp = new PrintStream(out);
           // BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            String request;
            //String test = null;
//            while ((request = inp.nextLine()) != null) {
//                System.out.println("Message received:" + request);
//                
//              outp.println(db.SQLTest(request));
//            }
             while ((request = inp.nextLine()) != null) {
                System.out.println("Message received:" + request);
                test.add(request);
                test.add(request+" 3");
                
              outp.println(test);



            }

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
                new SocketServer(server.accept(),db);
            }
        } catch (IOException ex) {
            System.out.println("Unable to start server.");
        } finally {
            try {
                if (server != null)
                    server.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}