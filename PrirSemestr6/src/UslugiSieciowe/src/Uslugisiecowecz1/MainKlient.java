package UslugiSieciowe.src.Uslugisiecowecz1;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainKlient {

    public static void main(String[] args) throws RemoteException, NotBoundException {
       KlientSOAP();
       KlientRMI();
    }

    public static void KlientRMI() throws RemoteException, NotBoundException {
        String nazwaUslugi = "TestRMI";
        Registry registry = LocateRegistry.getRegistry(5001);
        Wydajnosc wydajnoscRMI = (Wydajnosc) registry.lookup(nazwaUslugi);
        System.out.println("RMI Speed test 10B : "+speedTest10B(wydajnoscRMI));
        System.out.println("RMI Speed test 10KB : "+speedTest10KB(wydajnoscRMI));

    }
    public static void KlientSOAP() throws RemoteException {
        ClientProxyFactoryBean clientFactory = new ClientProxyFactoryBean();
        clientFactory.setAddress("http://localhost:5000/Wydajnosc");
        Wydajnosc wydajnosc =clientFactory.create(Wydajnosc.class);
        System.out.println("Test 10B: "+speedTest10B(wydajnosc));
        System.out.println("Test 10KB: "+speedTest10KB(wydajnosc));
    }

    static long speedTest10KB(Wydajnosc service) throws RemoteException{
        long tStart=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            byte[] r=service.get10KB();
        }
        long tKoniec=System.currentTimeMillis();
        return tKoniec-tStart;
    }

    static long speedTest10B(Wydajnosc service) throws RemoteException{
        long tStart=System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            byte[] r=service.get10B();
        }
        long tKoniec=System.currentTimeMillis();
        return tKoniec-tStart;
    }
}
