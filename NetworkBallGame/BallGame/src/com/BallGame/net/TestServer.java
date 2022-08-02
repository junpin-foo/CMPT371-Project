package com.BallGame.net;

import java.net.Socket;
import java.util.ArrayList;

public class TestServer {
    private ArrayList<Socket> csockets;

    public TestServer() {
        try {
            this.csockets = network.connectAsServer(1234);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestServer server = new TestServer();
    }
}
