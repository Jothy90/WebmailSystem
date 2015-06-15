package com.kash.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by john on 6/15/15.
 */
public class Client {
    public static String getQuote(){
        try {
            Registry registry = LocateRegistry.getRegistry();
            Quote stub = (Quote) registry.lookup("Quote");
            return stub.getQuoted();

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
            return "RMI Server Not connected";
        }
    }
}
