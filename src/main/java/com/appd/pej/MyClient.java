package com.appd.pej;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by pejman on 17/05/17.
 */
public class MyClient {


    public static void main(String argv[]) throws Exception
    {
        while(true){
            Socket clientSocket = new Socket("localhost", 6789);
            ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
            Payload payload = new Payload("Message from client", "localhost");
            beginTxn(payload, outToServer);

            Thread.sleep(10000);
        }
    }

    private static void beginTxn(Payload payload, ObjectOutputStream outToServer) {
        doSomething(payload, outToServer);
    }

    private static void doSomething(Payload payload,
                                    ObjectOutputStream outToServer) {
        writeMessage(payload, outToServer);
    }

    private static void writeMessage(Payload payload, ObjectOutputStream outToServer) {
        try {

        System.out.println("Corrid "+payload.correlationId);
            System.out.println("Via innerpayload "+payload.singularityHeader);
            /*
            if (payload.singularityHeader != null){
                System.out.println("Via innerpayload "+payload.innerPayload.get(payload.singularityHeader));
            } else
                System.out.println("null for now");
            */
            outToServer.writeObject(payload);
            System.out.println("Message Sent!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



