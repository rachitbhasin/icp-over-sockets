package com.rachit.simpleSocket;

import com.rachit.CustomUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

public class ConnectionClient {
    public static void main(String[] args) {
        try {
            Properties prop = CustomUtils.getProperties();

            String hostName = prop.getProperty("hostname");
            String portNumber = prop.getProperty("portnumber");

            InetAddress acceptorHost = InetAddress.getByName(hostName);
            int serverPortNum = Integer.parseInt(portNumber);
            Socket clientSocket = new Socket(acceptorHost, serverPortNum);
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            System.out.println(br.readLine());
            PrintStream ps = new PrintStream(clientSocket.
                    getOutputStream());
            ps.println("Received your message.. Thanks");
            ps.flush();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
