package Wątki.Semafory;

import java.util.concurrent.Semaphore;

public class SemWatekB extends Thread{

    Semaphore A;
    Semaphore B;
    Semaphore C;
    public SemWatekB(Semaphore semA, Semaphore semB, Semaphore semC) {
        this.A=semA;
        this.B=semB;
        this.C=semC;
    }

    public void run()
    {
        try{

            while(true)
            {
                B.acquire();
                System.out.println("Watek B");
                sleep((int)(Math.random()*20));
                C.release();

            }
        }catch (Exception e)
        {
            System.out.println("Koniec watku B");
        }
    }
}
