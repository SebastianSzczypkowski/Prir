package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceRMI extends Remote {

     void wyslij(String s)throws RemoteException;



}
