package RMI2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Random;

public interface Zadanie extends Remote {
    void licz()throws RemoteException;
    Object getWynik()throws RemoteException;
}

class ZadanieImpl implements Zadanie
{

    Random generator= new Random();
    private int ile =100;
    private double wynik;
    @Override
    public void licz() {


        int zawarte = 0;

        for(int i=0;i<ile;i++) {
            double x, y;
            x = Math.random();
            y = Math.random();
            if(x*x+y*y<=1)zawarte++;
        }
    }

    @Override
    public Object getWynik() {
        System.out.println(wynik);
        return wynik;
    }
}