package Wątki.Semafory;

import Wątki.KoordynacjaWatkow.WatekA;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main (String [] args) throws InterruptedException
    {
        Semaphore semA = new Semaphore(0);
        Semaphore semB = new Semaphore(0);
        Semaphore semC = new Semaphore(2);

        Thread watekA = new SemWatekA(semA,semB,semC);
        Thread watekB = new SemWatekB(semA,semB,semC);
        Thread watekC = new SemWatekC(semA,semB,semC);

        watekC.start();
        watekA.start();
        watekB.start();

        Thread.sleep((int) (Math.random()*2000));
        watekC.interrupt();
        watekA.interrupt();
        watekB.interrupt();

    }
}
