package RMI2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Serwer {
    public static void main(String[] args) {

        try{
            String name="Moj zdalny przyklad";
            String name1="kalkulator";
            String name2="oblicz";

            Registry registry= LocateRegistry.createRegistry(5555);

            JakisInterface implementacjaSerwera=new ImplementacjaInterfejsu();
            JakisInterface stub=(JakisInterface) UnicastRemoteObject.exportObject(implementacjaSerwera,0);

            registry.rebind(name,stub);
            //zad 1
            IKalkulator kalkulator=new Kalkulator();
            IKalkulator stub2=(IKalkulator) UnicastRemoteObject.exportObject(kalkulator,0);
            registry.rebind(name1,stub2);
            //zad2
            Zadanie zadanie=new ZadanieImpl();
            Zadanie stub3=(Zadanie) UnicastRemoteObject.exportObject(zadanie,0) ;
            registry.rebind(name2,stub3);

            System.out.println("Uruchomiono i podpieto zdalny kalkulator");
        }catch (Exception e){
            System.err.println("Wyjatek podczas wlaczania");
            e.printStackTrace();
        }
    }
}