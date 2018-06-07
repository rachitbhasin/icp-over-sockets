package com.rachit.summationServer;

import com.rachit.CustomUtils;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class SummationServer {

    public static void main(String[] args) {
        try {
            Properties prop = CustomUtils.getProperties();

            String portNumber = prop.getProperty("portnumber");
            int serverPort = Integer.parseInt(portNumber);
            ServerSocket calcServer = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = calcServer.accept();
                SummationThread thread = new SummationThread(clientSocket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
