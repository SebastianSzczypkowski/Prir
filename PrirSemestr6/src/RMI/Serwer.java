package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serwer {
    public static void main(String[] args) throws RemoteException

    {

        try{
            String name="Moj zdalny Przyklad";
            String name2="Kalkulator";
            KalkulatorInterface implementacja2=new KalkulatorInterfaceImpl();
            KalkulatorInterface stub2=(KalkulatorInterface) UnicastRemoteObject.exportObject(implementacja2,0);

            InterfaceRMI implementacjaSerwera = new InterfaceRMIImpl();
            InterfaceRMI stub= (InterfaceRMI) UnicastRemoteObject.exportObject(implementacjaSerwera,0);
            Registry registry= LocateRegistry.createRegistry(1099);
            registry.rebind(name,stub);
            registry.rebind(name2,stub);
            System.out.println("Uruchomiono i podpięto zdalnyKalkulator");

        } catch (RemoteException e) {
            System.err.println("Wyjatek podczas włączania: ");
            e.printStackTrace();
        }
    }


}
