package Wątki.SemaforyProducentKonsument.JedenProducent;

public class Main {

    public static void main(String [] args) throws InterruptedException
    {
        int size=10;
        Magazyn m = new MagazynImpl(size);
        Thread producent = new Producent(m);
        Thread konsument = new Konsument(m);
        producent.start();
        konsument.start();
        Thread.sleep(1*1000);
        producent.interrupt();
        konsument.interrupt();
    }
}
