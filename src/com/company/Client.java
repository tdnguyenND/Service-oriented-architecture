package com.company;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Pair stub=(Pair) Naming.lookup(Constant.pairRemoteFullPath);
        System.out.println(stub.getMul(new int[]{3, 2, 3}));
        System.out.println(stub.getSum(new int[]{0, 2, 3}));
    }
}
