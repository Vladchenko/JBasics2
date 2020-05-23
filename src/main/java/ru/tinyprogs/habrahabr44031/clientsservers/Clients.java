package ru.tinyprogs.habrahabr44031.clientsservers;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v.yanchenko
 */
public class Clients extends Thread {

    private Socket client;
    private OutputStream outToServer;
    private DataOutputStream out;
    private InputStream inFromServer;
    private DataInputStream in;

    public Clients(String serverName, int port) {
        try {
            initializeClient(serverName, port);
//            out.writeUTF("Hello from "
//                    + client.getLocalSocketAddress());
//            System.out.println("Server says " + in.readUTF());
            run();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeClient(String serverName, int port) {
        try {
            System.out.println("Connecting to " + serverName
                    + " on port " + port);
            Socket client = new Socket(serverName, port);
            System.out.println("Client connected to server at "
                    + client.getRemoteSocketAddress());
            outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);
            inFromServer = client.getInputStream();
            in = new DataInputStream(inFromServer);
        } catch (IOException e) {
            System.out.println("Cannot connect to a server named: " + serverName
                    + " on port #" + port);
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void run() {
        Scanner scnr = new Scanner(System.in);
        String str;
        while (true) {
            str = "";
            System.out.print("Message sent to server: ");
            str = scnr.nextLine();
            if (str.isEmpty()) {
                try {
                    out.writeUTF("Client is off");
                    client.close();
                } catch (IOException ex) {
                    System.out.println("Trouble with a client finalizing !");
                    Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                // Writing a line to an output stream
                out.writeUTF(str);
            } catch (IOException ex) {
                System.out.println("Cannot send data to a server !");
                Logger.getLogger(Clients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
