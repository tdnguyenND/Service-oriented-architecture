package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface App extends Remote {
    Pair getSumMul() throws RemoteException;
}
