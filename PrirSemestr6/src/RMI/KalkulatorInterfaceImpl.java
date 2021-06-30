package RMI;

import java.rmi.RemoteException;
import java.util.Scanner;

public class KalkulatorInterfaceImpl implements KalkulatorInterface {
    private double a,b;


    @Override
    public void wyswietl() throws RemoteException {
        wczytaj();
        System.out.println("dodawanie: "+dodaj(a,b));
        System.out.println("odejmij: "+odejmij(a,b));
        System.out.println("mnóż : "+mnoz(a,b));
        System.out.println("dziel : "+dziel(a,b));
    }

    @Override
    public void wczytaj() throws RemoteException {
        Scanner input=new Scanner(System.in);
        System.out.println("Podaj liczbe a");
        a=input.nextDouble();
        System.out.println("Podaj liczbe b");
        b=input.nextDouble();
    }

    @Override
    public double dodaj(double a, double b) throws RemoteException {
        return a+b;
    }

    @Override
    public double odejmij(double a, double b) throws RemoteException {
        return a-b;
    }

    @Override
    public double mnoz(double a, double b) throws RemoteException {
        return a*b;
    }

    @Override
    public double dziel(double a, double b) throws RemoteException {
        return a/b;
    }
}
