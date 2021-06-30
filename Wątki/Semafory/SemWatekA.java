package Wątki.Semafory;

import java.util.concurrent.Semaphore;

public class SemWatekA extends Thread{

    Semaphore A;
    Semaphore B;
    Semaphore C;
    public SemWatekA(Semaphore semA, Semaphore semB, Semaphore semC) {
    this.A=semA;
    this.B=semB;
    this.C=semC;
    }

    public void run()
    {
        try{

            while(true)
            {
                A.acquire();
                System.out.println("Watek A");
                sleep((int)(Math.random()*20));
                C.release();

            }
        }catch (Exception e)
        {
            System.out.println("Koniec watku A");
        }
    }
}
