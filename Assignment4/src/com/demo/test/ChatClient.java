package com.demo.test;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 5000);
             BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to chat server...");
            
            new Thread(() -> {
                String serverMsg;
                try {
                    while ((serverMsg = serverInput.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String userMsg;
            while ((userMsg = input.readLine()) != null) {
                output.println(userMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
