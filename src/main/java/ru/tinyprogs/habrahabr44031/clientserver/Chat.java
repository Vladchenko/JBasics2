/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs.habrahabr44031.clientserver;

import ru.tinyprogs.habrahabr44031.clientserver.GreetingClient;
import ru.tinyprogs.habrahabr44031.clientserver.GreetingServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.yanchenko
 */
public class Chat {

    public Chat() {
        try {
            Thread t = new GreetingServer(1234);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new GreetingClient("localhost", 1234);
    }

}

