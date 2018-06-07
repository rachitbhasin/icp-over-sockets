package com.rachit.summationServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SummationThread extends Thread {
    Socket clientSocket;

    SummationThread(Socket cs) {
        clientSocket = cs;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(clientSocket.getInputStream()));
            int count = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int ctr = 1; ctr <= count; ctr++) {
                sum += ctr;
                Thread.sleep(200);
            }
            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println(sum);
            ps.flush();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
