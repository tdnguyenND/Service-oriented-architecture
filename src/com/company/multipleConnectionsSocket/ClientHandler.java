package com.company.multipleConnectionsSocket;

import com.company.singleConnectionSocket.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    Socket client;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket client) throws IOException {
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
    }

    @Override
    public void run() {
        while (true) {
            try {
                String request = in.readLine();
                System.out.println("Receive request \"" + request + "\" from " + client.getInetAddress() + ", port " + client.getPort());
                if (request.equals(Constants.QUIT_COMMAND)) {
                    client.close();
                    break;
                } else {
                    String[] inp = request.split(" ");
                    int sum = 0;
                    long multi = 1;
                    for (String num : inp) {
                        int number = Integer.parseInt(num);
                        sum += number;
                        multi *= number;
                    }
                    out.println("sum = " + sum + ", multi = " + multi);
                }
            } catch (NumberFormatException e) {
                out.println("Not a number");
            } catch (NullPointerException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
