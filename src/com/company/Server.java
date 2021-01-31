package com.company;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(Constant.port);
        App skeleton = new AppImpl();
        Naming.rebind(Constant.pairRemoteFullPath, skeleton);
    }
}
