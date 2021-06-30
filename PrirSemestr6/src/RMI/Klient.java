package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Klient {




    public static void main(String[] args) throws RemoteException
    {

        try {
            String name ="Moj zdalny Przyklad";
            String name2="Kalkulator";
            Registry registry= LocateRegistry.getRegistry(1099);
            InterfaceRMI zdalnyObiekt=(InterfaceRMI)registry.lookup(name);
            KalkulatorInterface kalkulator=(KalkulatorInterface)registry.lookup(name2);
            System.out.println("Przygotowano program do działania");
            zdalnyObiekt.wyslij("Hello serwer");
            kalkulator.wyswietl();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
