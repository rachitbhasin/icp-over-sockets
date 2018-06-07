package com.rachit.udp;

import com.rachit.CustomUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Properties;

class SenderReceiver {
    public static void main(String[] args) {
        try {
            Properties prop = CustomUtils.getProperties();

            String hostName = prop.getProperty("hostname");
            String portNumber = prop.getProperty("portnumber");

            InetAddress receiverHost = InetAddress.getByName(hostName);
            int receiverPort = Integer.parseInt(portNumber);
            String message = "Trying to connect...";
            DatagramSocket mySocket = new DatagramSocket();
            byte[] sendBuffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(sendBuffer
                    , sendBuffer.length,
                    receiverHost, receiverPort);
            mySocket.send(packet);
            // to receive a message
            int MESSAGE_LEN = 60;
            byte[] recvBuffer = new byte[MESSAGE_LEN];
            DatagramPacket datagram = new DatagramPacket(recvBuffer,
                    MESSAGE_LEN);
            mySocket.receive(datagram);
            String recvdString = new String(recvBuffer);
            System.out.println(recvdString);
            mySocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}