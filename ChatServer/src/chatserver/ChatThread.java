/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;

/**
 *
 * @author kasra
 */
public class ChatThread extends Thread{
    private Streamer s;
    private int clientID;
    
    public ChatThread(int cID, Streamer st) {
        super("Client" + cID);
        this.clientID = cID;
        this.s = st;
    }
    
    @Override
    public void run() {
//        try {
            String fromClient;
            s.out().println("Connected!");
            s.out().println("What's your username?");
            String clientName = s.in().next();
            ChatServer.streamers.put(clientName, s);
            s.out().println("Users currently online:\n"
                    + ChatServer.streamers.keySet());
            s.out().println("Press");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
