package com.rachit.summationServer;

import com.rachit.CustomUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;

public class SummationClient {
    public static void main(String[ ] args){
        try{
            Properties prop = CustomUtils.getProperties();

            String hostName = prop.getProperty("hostname");
            String portNumber = prop.getProperty("portnumber");

            InetAddress serverHost = InetAddress.getByName(hostName);
            int serverPort = Integer.parseInt(portNumber);
            long startTime = System.currentTimeMillis( );
            int count = 100;
            Socket clientSocket = new Socket(serverHost, serverPort);
            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println(count);
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            int sum = Integer.parseInt(br.readLine());
            System.out.println(" sum = "+sum);
            long endTime = System.currentTimeMillis();
            System.out.println("Time consumed for receiving the feedback from the server: "+(endTime-startTime)+" milliseconds");
            clientSocket.close( );
        }
        catch(Exception e){e.printStackTrace( );}
    }
}
