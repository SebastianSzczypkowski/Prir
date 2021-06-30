package RMI3;
import RMI2.IKalkulator;
import RMI2.JakisInterface;
import RMI2.Zadanie;
import rmi.komunikatorSimple.CommunicatorService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class Client {

    CommunicatorService communicatorService;
    String imie;
    String pass;
    Client(String imie,String pass) throws RemoteException, NotBoundException {
        this.imie=imie;
        this.pass=pass;


        String name = "komunikator";
        Registry registry = LocateRegistry.getRegistry(4444);
        communicatorService = (CommunicatorService) registry.lookup(name);
        communicatorService.registerUser(imie, pass);
        System.out.println("Witaj w komunikatorze "+imie);
    }


    public void start() throws RemoteException, NotBoundException
    {
        boolean end=true;
        Scanner scanner = new Scanner(System.in);
        String komenda;
        new Thread(()->
        {
            try
            {
            while (true)
            {
                    String message = communicatorService.getMessage(imie,pass);
                    if(message==null)
                    {
                        continue;
                    }
                    else
                    {
                        System.out.println(message);
                    }
                }

            }
            catch (RemoteException e)
            {
                e.printStackTrace();
            }
        }).start();
        while(end)
        {
            komenda = scanner.nextLine();
            if(!komenda.equals("listUsers"))
            {
                String[] parts = komenda.split(";");
                String part1 = parts[0]; // 004
                String part2 = parts[1];
                communicatorService.addMessage(imie,pass,part1,part2);
            }
            if(komenda.equals("exit"))
            {
                end=false;
            }
            else
            {
                List<String> users = communicatorService.getUsers();
                System.out.println("Użytkownicy: ");
                for(String s : users)
                {
                    System.out.println(s);
                }
            }
        }
    }



}
