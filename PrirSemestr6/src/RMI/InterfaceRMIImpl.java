package RMI;

import java.rmi.RemoteException;
import java.util.Scanner;

public class InterfaceRMIImpl implements InterfaceRMI{

    @Override
    public void wyslij(String s) throws RemoteException {
        System.out.println("Odebrałem "+s);

    }


}
