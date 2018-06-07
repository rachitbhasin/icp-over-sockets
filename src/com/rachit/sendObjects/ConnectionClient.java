package com.rachit.sendObjects;

import com.rachit.CustomUtils;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class ConnectionClient {
    public static void main(String[] args) {
        try {
            Properties prop = CustomUtils.getProperties();

            String hostName = prop.getProperty("hostname");
            String portNumber = prop.getProperty("portnumber");

            InetAddress serverHost = InetAddress.getByName(hostName);
            int serverPortNum = Integer.parseInt(portNumber);
            Socket clientSocket = new Socket(serverHost, serverPortNum);

            Employee empData = new Employee();
            Scanner input = new Scanner(System.in);
            System.out.print("Enter employee id: ");
            int id = input.nextInt();
            System.out.print("Enter employee name: ");
            String name = input.next();
            System.out.print("Enter employee salary: ");
            double salary = input.nextDouble();
            empData.setId(id);
            empData.setName(name);
            empData.setSalary(salary);
            ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
            oos.writeObject(empData);
            oos.flush();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
