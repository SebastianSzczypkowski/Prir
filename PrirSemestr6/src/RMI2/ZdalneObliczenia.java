package RMI2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ZdalneObliczenia extends Remote {
    void policz(Zadanie t) throws RemoteException;
    Object wynikObliczen() throws RemoteException;
}

class ZdalenObliczeniaImpl implements ZdalneObliczenia
{

    Zadanie zad=null;
    @Override
    public void policz(Zadanie t) throws RemoteException {
        this.zad=t;
        zad.licz();
    }

    @Override
    public Object wynikObliczen() throws RemoteException {
        if(zad==null)return 0;
        return zad.getWynik();
    }
}
