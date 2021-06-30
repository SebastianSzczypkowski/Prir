package Wątki.ProblemKonsumentaIProducenta;

public class Main {

    public static void main(String args[] ) throws InterruptedException
    {
        MagazynImpl magazyn = new MagazynImpl();
        Thread producent = new Producent(magazyn);
        Thread konsument = new Konsument(magazyn);

        producent.start();
        konsument.start();
        Thread.sleep(1000);
        producent.join();
        konsument.join();
    }
}
