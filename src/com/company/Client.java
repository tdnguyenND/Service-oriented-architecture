package com.company;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        App stub=(App) Naming.lookup(Constant.pairRemoteFullPath);
        Pair pair = stub.getSumMul();
        System.out.println(pair.getMul(new int[]{3, 2, 3}));
        System.out.println(pair.getSum(new int[]{0, 2, 3}));
    }
}
