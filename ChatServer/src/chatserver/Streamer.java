/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author kasra
 */
public class Streamer {
    private PrintWriter out;
    private Scanner in;
    private Socket socket;
    
    public Streamer(Socket s) throws IOException{
        this.socket = s;
        in = new Scanner(socket.getInputStream());
        out = new PrintWriter(socket.getOutputStream(), true);
    }
    
    public PrintWriter out() {return out;}
    public Scanner in() {return in;}
    public Socket socket() {return socket;}
}
