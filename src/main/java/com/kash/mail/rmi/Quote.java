package com.kash.mail.rmi;

/**
 * Created by john on 6/15/15.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Quote extends Remote {
    String getQuoted() throws RemoteException;
}

