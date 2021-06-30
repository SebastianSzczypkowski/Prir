package RMI2;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IKalkulator extends Remote {
    public void wyslij(double a,double b) throws RemoteException;
    double dodaj(double a,double b) throws RemoteException;
    double mnoz(double a,double b) throws RemoteException;
    double dziel(double a,double b) throws RemoteException;
    double odejmij(double a,double b) throws RemoteException;
}

class Kalkulator implements IKalkulator {

    @Override
    public void wyslij(double a,double b) throws RemoteException {
        System.out.println("Dodawanie: "+dodaj(a,b));
        System.out.println("Mnoz: "+mnoz(a,b));
        System.out.println("Dziel: "+dziel(a,b));
        System.out.println("Odejmij:"+odejmij(a,b));

    }

    @Override
    public double dodaj(double a, double b) throws RemoteException{
        return a+b;
    }

    @Override
    public double mnoz(double a, double b) throws RemoteException{
        return a*b;
    }

    @Override
    public double dziel(double a, double b) throws RemoteException {
        if(b==0){
            throw new RemoteException("You cant't divide by 0");
        }
        return a/b;
    }

    @Override
    public double odejmij(double a, double b) throws RemoteException {
        return a-b;
    }
}