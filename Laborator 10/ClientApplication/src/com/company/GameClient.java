package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port

        int ok=1;

        while(ok>0)
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (
                        new InputStreamReader(socket.getInputStream())) ) {
            if(ok==3)
                ok=1;
            System.out.println("Player "+ok);
            // Send a request to the server
            Scanner scan= new Scanner(System.in);
            String request = scan.nextLine();
            out.println(ok);
            //if the request is "exit" , the client stops
            if(request.equals("exit"))
            { System.out.println("Player "+ok+" left the game");
            ok=-1;}
            out.println(request);
            if(request.equals("submit move"))
            {
                int line=scan.nextInt();
                int col=scan.nextInt();
                out.println(line);
                out.println(col);
            }
            // Wait the response from the server
            String response = in.readLine ();
            System.out.println(response);
            ok++;
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}

