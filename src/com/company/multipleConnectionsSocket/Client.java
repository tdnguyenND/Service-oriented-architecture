package com.company.multipleConnectionsSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(Constants.SERVER_IP, Constants.SERVER_PORT);

        BufferedReader serverResponseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter requestWriter = new PrintWriter(socket.getOutputStream(), true);

        while (true){
            String command = keyboard.readLine();
            requestWriter.println(command);
            if (command.equals(Constants.QUIT_COMMAND)){
                break;
            }
            String response = serverResponseReader.readLine();
            System.out.println(response);

        }
        socket.close();
        System.exit(0);
    }
}
