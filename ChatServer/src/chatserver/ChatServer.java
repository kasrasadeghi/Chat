/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author kasra
 */
public class ChatServer {

    public static HashMap<String, Streamer> streamers;
    
    public static void main(String[] args) throws IOException{
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Scanner sysin = new Scanner(System.in);
            
            boolean cont = true;
            int counter = 0;
            
            while (cont) {
                Socket socket = serverSocket.accept();
                Streamer streamer = new Streamer(socket);
                new ChatThread(++counter, streamer).start();
                System.out.println("type yes to find another client");
                cont = sysin.next().equals("yes");
            }
            
            System.out.println("press enter to close");
            sysin.nextLine();
            serverSocket.close();
            sysin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   
}
