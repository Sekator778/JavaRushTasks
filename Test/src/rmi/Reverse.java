package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface Reverse extends Remote
{
    public String reverse(String str) throws RemoteException;
}