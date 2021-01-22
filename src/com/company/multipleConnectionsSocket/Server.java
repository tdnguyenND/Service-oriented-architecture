package com.company.multipleConnectionsSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(Constants.MAX_NUM_THREADS);


    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(Constants.SERVER_PORT);
        while (true){
            Socket client = listener.accept();
            ClientHandler clientHandler = new ClientHandler(client);

            System.out.println("New connection at thread " + clientHandler.getId());

            clientHandlers.add(clientHandler);
            pool.execute(clientHandler);
        }
    }
}
