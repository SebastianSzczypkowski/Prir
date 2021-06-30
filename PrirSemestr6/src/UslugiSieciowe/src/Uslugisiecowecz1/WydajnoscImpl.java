package UslugiSieciowe.src.Uslugisiecowecz1;

import Uslugisiecowecz1.Wydajnosc;

import java.rmi.RemoteException;

public class WydajnoscImpl implements Wydajnosc {
    @Override
    public byte[] get10B() throws RemoteException {

        byte tablica[] = new byte[9];
        for(int i=0;i<9;i++)
        {
           tablica[i]= (byte) (i+1);
        }
        return tablica;
    }

    @Override
    public byte[] get10KB() throws RemoteException {
        byte tablica[]= new byte[9999];
        for(int i=0;i<9999;i++)
        {
            tablica[i]= (byte) (i+1);
        }
        return tablica;
    }

    @Override
    public void setData(byte[] data) throws RemoteException {

        int suma=0;
        int srednia=0;
        int size=data.length;
        for(int i=0;i<size;i++) {
            suma += data[i];
            srednia = suma / i;
        }

        System.out.println("Srednia: "+srednia);
        }


    }

