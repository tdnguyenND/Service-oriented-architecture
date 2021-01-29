package com.company;

public interface Constant {
    String host = "localhost";
    int port = 5000;
    String pairRemoteAppName = "pair";
    String pairRemoteFullPath = "rmi://" + host + ":" + port + "/" + pairRemoteAppName;
}
