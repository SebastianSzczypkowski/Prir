package Wątki.AgorytmWzajemnegoWykluczenia;

public class Main {

    public static void main(String [] args) throws InterruptedException {

        Zwrotnica z = new ZwrotnicaImpl();
        Licznik l= new Licznik();
        Thread rz1 = new RozjazdA(z,l);
        Thread rz2 = new RozjazdB(z,l);
        rz1.start();
        rz2.start();
        rz1.join();
        rz2.join();
        System.out.println("Koniec programu");
        System.out.println(l.get());
    }



}
