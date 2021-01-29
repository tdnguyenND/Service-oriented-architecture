package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Pair extends Remote {
    int getSum(int[] arr) throws RemoteException;
    int getMul(int[] arr) throws RemoteException;
}
