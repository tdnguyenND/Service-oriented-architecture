package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PairRemote extends UnicastRemoteObject implements Pair {
    protected PairRemote() throws RemoteException {
        super();
    }

    @Override
    public int getSum(int[] arr) {
        int sum = 0;
        for (int i: arr){
            sum += i;
        }
        return sum;
    }

    @Override
    public int getMul(int[] arr) {
        int mul = 1;
        for (int i: arr){
            mul *= i;
        }
        return mul;
    }
}
