package Wątki.Stacja;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String [] args) throws InterruptedException
    {

        Semaphore DysA = new Semaphore(0);
        Semaphore DysB = new Semaphore(0);
        Semaphore DysC = new Semaphore(2);

        Thread A = new DystrybutorA(DysA,DysB,DysC);
        Thread B = new DystrybutorA(DysA,DysB,DysC);
        Thread C = new DystrybutorA(DysA,DysB,DysC);

        C.start();
        A.start();
        B.start();

        Thread.sleep((int)(Math.random()*2000));
        C.interrupt();
        A.interrupt();
        B.interrupt();





    }
}
