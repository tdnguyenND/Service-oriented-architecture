package com.company;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AppImpl extends UnicastRemoteObject implements App {
    protected AppImpl() throws RemoteException {
        super();
    }

    public Pair getSumMul() {
        return new PairImpl();
    }
}
