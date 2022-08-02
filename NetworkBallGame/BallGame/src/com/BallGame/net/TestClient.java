package com.BallGame.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import com.BallGame.net.network.ClientResponse;

public class TestClient {
    private Socket socket;
    private int uid;
    // private ClientResponse clientResponse;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public TestClient() {
        try {
            ClientResponse clientResponse = network.connectAsClient("localhost", 1234);
            System.out.println("connected");
            this.socket = clientResponse.getSocket();
            this.uid = clientResponse.getUID();
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("my id: " + this.uid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * send msgs to client handler
     */
    // public void sendMsg() {
    //     try {
    //         bufferedWriter.write("hi");
    //         bufferedWriter.newLine();
    //         bufferedWriter.flush();

    //         // keep sending msgs
    //         Scanner scanner = new Scanner(System.in);
    //         while (socket.isConnected()) {
    //             String msgToSend = scanner.nextLine();
    //             bufferedWriter.write(username + ": " + msgToSend);
    //             bufferedWriter.newLine();
    //             bufferedWriter.flush();
    //         }
    //     } catch (IOException e) {
    //         closeEverything(socket, bufferedReader, bufferedWriter);
    //     }
    // }

    /**
     * listen for msgs from server (broadcast msgs)
     * need a new thread
     */
    // public void listenForMsgs() {
    //     new Thread(new Runnable() { // see wittcode's vid on runnable
    //         @Override
    //         public void run() {
    //             String msgFromServer;
    //             while (socket.isConnected()) {
    //                 try {
    //                     msgFromServer = bufferedReader.readLine();
    //                     System.out.println(msgFromServer);
    //                 } catch (IOException e) {
    //                     closeEverything(socket, bufferedReader, bufferedWriter);
    //                 }
    //             }
    //         }
    //     }).start();
    // }

    public void listenForMsgs() {
        
        String msgFromServer;
        while (socket.isConnected()) {
            try {
                msgFromServer = bufferedReader.readLine();
                System.out.println(msgFromServer);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }        
    }


    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TestClient client = new TestClient();

        // they're on diff threads
        client.listenForMsgs();
    }
}
    
