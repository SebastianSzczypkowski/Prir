package RMI3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainClient2 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Client client = new Client("Janusz","qwerty");
        client.start();
    }
}
