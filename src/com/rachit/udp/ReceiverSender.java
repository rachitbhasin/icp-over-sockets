package com.rachit.udp;

import com.rachit.CustomUtils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Properties;

public class ReceiverSender {
    public static void main(String[ ] args){
        try{

            Properties prop = CustomUtils.getProperties();

            String portNumber = prop.getProperty("portnumber");

            int MAX_LEN = 60;
            int localPortNum = Integer.parseInt(portNumber);
            DatagramSocket mySocket  = new DatagramSocket(localPortNum);
            byte[ ] recvBuffer = new byte[MAX_LEN];
            DatagramPacket packet = new DatagramPacket(recvBuffer, MAX_LEN);
            mySocket.receive(packet);
            String message = new String(recvBuffer);
            System.out.println(message);
            // to reply back to sender
            InetAddress senderAddress = packet.getAddress
                    ( );
            int senderPort = packet.getPort( );
            String messageToSend = "Welcome to the  of sockets";
            byte[ ] sendBuffer = messageToSend.getBytes();
            DatagramPacket datagram = new DatagramPacket(sendBuffer
                    , sendBuffer.length,
                    senderAddress, senderPort);
            mySocket.send(datagram);
            mySocket.close( );
        }
        catch(Exception e){e.printStackTrace( );}
    }
}
