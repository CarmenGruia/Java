package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
        // Define the port on which the server is listening
        public static final int PORT = 8100;
        public static boolean ok=true;
    public GameServer() throws IOException {
            try (ServerSocket serverSocket = new ServerSocket(PORT);) {

                while(ok){
                    System.out.println("Waiting for a player ...");
                    Socket socket = serverSocket.accept();

                    // Execute the client's request in a new thread
                        ClientThread client =new ClientThread(socket);

                    client.start();
                    ok=client.server_on();

                }
            } catch (IOException e) {
                System.err.println("Ooops... " + e);
            }
        }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        GameServer server=new GameServer();}

    }

