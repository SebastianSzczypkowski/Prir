package UslugiSieciowe.src.Uslugisiecowecz1;

import org.apache.cxf.frontend.ServerFactoryBean;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainSerwer {

    private Wydajnosc wydajnosc;


    public static void main(String [] args) throws InterruptedException, RemoteException {
        SerwerRMI();
        SerwerSOAP();
    }
    public static void SerwerSOAP() throws RemoteException
    {
        try {
            Wydajnosc wydajnosc = new WydajnoscImpl();
            ServerFactoryBean factory = new ServerFactoryBean();
            factory.setServiceClass(Wydajnosc.class);
            factory.setAddress("http://localhost:5000/Wydajnosc");
            factory.setServiceBean(wydajnosc);
            factory.create();
        } catch (Exception e) {
            System.err.println("Wyjątek podczas włączania serwera SOAP");
            e.printStackTrace();
        }
    }

    public static void SerwerRMI() throws RemoteException
    {
        try
        {
            String name="TestRMI";
            Wydajnosc wydajnosc=new WydajnoscImpl();
            Wydajnosc stub =(Wydajnosc) UnicastRemoteObject.exportObject(wydajnosc,0);
            Registry registry= LocateRegistry.createRegistry(5001);
            registry.rebind(name,stub);
            System.out.println("Uruchomiono serwer RMI");
        } catch (RemoteException e) {
            System.err.println("Wyjątek podczas włączania serwera RMI");
            e.printStackTrace();
        }
    }
}
