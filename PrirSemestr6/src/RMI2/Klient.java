package RMI2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Klient {
    public static double a;
    public static double b;

    public static void wczytaj() {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj liczbę: ");
        a = input.nextDouble();
        b = input.nextDouble();
    }

    public static void main(String[] args) {
        try {
            String name = "Moj zdalny przyklad";
            String name1 = "kalkulator";
            String name2 ="oblicz";
            Registry registry = LocateRegistry.getRegistry(5555);
            JakisInterface zdalnyObiekt = (JakisInterface) registry.lookup(name);

            IKalkulator zdalnyObiekt2 = (IKalkulator) registry.lookup(name1);
            Zadanie zdalnyObiekt3=(Zadanie) registry.lookup(name2) ;
            System.out.println("Przygotowano program do dzialania");
            zdalnyObiekt.wyslij("Hello serwer");
            wczytaj();
            zdalnyObiekt2.wyslij(a, b);
            zdalnyObiekt3.getWynik();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
