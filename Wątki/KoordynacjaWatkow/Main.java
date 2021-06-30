package Wątki.KoordynacjaWatkow;

public class Main {

    public static void main(String []args) throws InterruptedException
    {
        Koordynator koordynator = new KoordynatorImpl();
        Thread watekA = new WatekA(koordynator);
        Thread watekB = new WatekB(koordynator);
        Thread watekC = new WatekC(koordynator);

        watekC.start();
        watekA.start();
        watekB.start();

        Thread.sleep((int)(Math.random()*2000));
        watekC.interrupt();
        watekA.interrupt();
        watekB.interrupt();

    }



}
