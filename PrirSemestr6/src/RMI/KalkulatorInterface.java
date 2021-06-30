package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface KalkulatorInterface extends Remote {
     void wyswietl()throws RemoteException;
     void wczytaj()throws RemoteException;
     double dodaj(double a,double b) throws RemoteException;
     double odejmij(double a,double b) throws RemoteException;
     double mnoz(double a,double b) throws RemoteException;
     double dziel(double a,double b) throws RemoteException;
}
