package com.appd.pej;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by pejman on 17/05/17.
 */
public class MyServer {

    public static void main(String argv[]) throws Exception
    {
        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.print("Server Ready! ");
        while(true)
        {
            readMessage(welcomeSocket);
        }
    }

    private static void readMessage(ServerSocket welcomeSocket) {
        Socket connectionSocket;
        try {
            System.out.println("Waiting for message");
            connectionSocket = welcomeSocket.accept();
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(connectionSocket.getInputStream());
            Payload payload = (Payload) objectInputStream.readObject();
            processMessage(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processMessage(Payload payload) {
        doSomethingWithMessage(payload);
    }

    private static void doSomethingWithMessage(Payload payload) {
        if(payload != null){
            System.out.println("SINGULARITY HEADER: "+payload.getCorrId());
            //System.out.println("SINGULARITY HEADER: "+payload.getCorrelationId());
            System.out.println("MESSAGE: "+payload.getMessage());
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
