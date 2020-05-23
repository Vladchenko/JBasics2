/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs.habrahabr44031.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.yanchenko
 */
public class Servers extends Thread {

    private List<Socket> server = new ArrayList<>();
    private ServerSocket serverSocket;
    private DataInputStream in;
    private DataOutputStream out;

    public Servers(int port) throws IOException {
        initializeServer(port);
        run();
    }

    private void initializeServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
//            serverSocket.setSoTimeout(1000000);
            System.out.println("Server is waiting for client to connect on port "
                + serverSocket.getLocalPort() + ". Timeout is 1000 seconds. ...");
//            server = serverSocket.accept();
//            System.out.println("Server connected to a client at "
//                        + server.getRemoteSocketAddress());
//            in = new DataInputStream(server.getInputStream());
//            out = new DataOutputStream(server.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Servers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        try {
            while (true) {
                if (in.available() > 0) {
                    System.out.print("Message received from client: ");
                    System.out.println(in.readUTF());
                }
            }
        } catch (IOException e) {
            //            e.printStackTrace();
//            try {
//                server.close();
//            } catch (IOException ex) {
//                System.out.println("Server cannot be closed.");
//                Logger.getLogger(Servers.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }

}
