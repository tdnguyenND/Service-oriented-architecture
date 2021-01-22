package com.company.singleConnectionSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(Constants.SERVER_PORT);
        System.out.println("Waiting for client connection");

        Socket client = listener.accept();
        BufferedReader clientInput = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter responseWriter = new PrintWriter(client.getOutputStream(), true);
        while (true){
            String request = clientInput.readLine();
            System.out.println("Receive request \"" + request + "\"");
            try {
                if (request.equals(Constants.QUIT_COMMAND)) {
                    client.close();
                    break;
                }

                else try {
                    String[] inp = request.split(" ");
                    int sum = 0;
                    long multi = 1;
                    for (String num : inp){
                        int number = Integer.parseInt(num);
                        sum += number;
                        multi *= number;
                    }

                    responseWriter.println("sum = " + sum + ", multi = " + multi);
                }
                catch (NumberFormatException e){
                    responseWriter.println("Not a number");
                }
            } catch (NullPointerException e){
                System.out.println("Null input");
            }
        }
        listener.close();
        System.exit(0);
    }
}
