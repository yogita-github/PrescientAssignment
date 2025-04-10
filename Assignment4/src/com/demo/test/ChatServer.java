package com.demo.test;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static Set<Socket> clientSockets = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            System.out.println("Chat server started...");

            while (true) {
                Socket socket = serverSocket.accept();
                clientSockets.add(socket);
                System.out.println("New user connected!");
                
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader input;
        private PrintWriter output;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Received: " + message);
                    
                    for (Socket s : clientSockets) {
                        new PrintWriter(s.getOutputStream(), true).println(message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
