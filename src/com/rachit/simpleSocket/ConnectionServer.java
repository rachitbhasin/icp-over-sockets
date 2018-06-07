package com.rachit.simpleSocket;

import com.rachit.CustomUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class ConnectionServer {
    public static void main(String[] args) {
        try {
            Properties prop = CustomUtils.getProperties();

            String portNumber = prop.getProperty("portnumber");
            String message = "Welcome to the socket world";

            int serverPortNumber = Integer.parseInt(portNumber);
            ServerSocket connectionSocket = new ServerSocket(serverPortNumber);
            Socket dataSocket = connectionSocket.accept();
            PrintStream socketOutput = new PrintStream(dataSocket.getOutputStream());
            socketOutput.println(message);
            System.out.println("sent response to client...");
            socketOutput.flush();

            BufferedReader br = new BufferedReader(new
                    InputStreamReader(dataSocket.getInputStream()));
            System.out.println(br.readLine());


            dataSocket.close();
            connectionSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
