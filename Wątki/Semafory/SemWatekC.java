package Wątki.Semafory;

import java.util.concurrent.Semaphore;

public class SemWatekC extends Thread{

    Semaphore A;
    Semaphore B;
    Semaphore C;
    public SemWatekC(Semaphore semA, Semaphore semB, Semaphore semC) {
        this.A=semA;
        this.B=semB;
        this.C=semC;
    }

    public void run()
    {
        try{

            while(true)
            {
                C.acquire(2);
                System.out.println("Watek C");
                sleep((int)(Math.random()*20));
                A.release();
                B.release();

            }
        }catch (Exception e)
        {
            System.out.println("Koniec watku C");
        }
    }
}