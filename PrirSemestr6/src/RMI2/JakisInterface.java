package RMI2;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface JakisInterface extends Remote {
    public void wyslij(String s) throws RemoteException;
}

class ImplementacjaInterfejsu implements JakisInterface{
    @Override
    public void  wyslij(String s) throws RemoteException{
        System.out.println("Odebralem:"+s);
    }
}