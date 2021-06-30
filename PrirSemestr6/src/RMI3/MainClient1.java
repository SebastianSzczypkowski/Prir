package RMI3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient1 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Client client = new Client("Jacek","ZAQ12wsx");
        client.start();
    }
}
