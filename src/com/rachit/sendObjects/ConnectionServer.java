package com.rachit.sendObjects;

import com.rachit.CustomUtils;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class ConnectionServer {
    public static void main(String[] args) {
        try {
            Properties prop = CustomUtils.getProperties();

            String portNumber = prop.getProperty("portnumber");
            int serverListenPortNum = Integer.parseInt(portNumber);
            ServerSocket connectionSocket = new ServerSocket(serverListenPortNum);
            Socket dataSocket = connectionSocket.accept();
            ObjectInputStream ois = new ObjectInputStream(
                    dataSocket.getInputStream());
            Employee eData = (Employee) ois.readObject();
            System.out.println("Employee id : " + eData.getId()
            );
            System.out.println("Employee name : " + eData.getName(
            ));
            System.out.println("Employee salary : " + eData.getSalary());
            dataSocket.close();
            connectionSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
