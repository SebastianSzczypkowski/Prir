package Wątki.Stacja;

import java.util.concurrent.Semaphore;

public class DystrybutorB extends Thread{

    Semaphore A;
    Semaphore B;
    Semaphore C;

    public DystrybutorB(Semaphore a,Semaphore b,Semaphore c)
    {
        this.A=a;
        this.B=b;
        this.C=c;

    }

    public void run()
    {
        try{
            while(true)
            {
                B.acquire();
                System.out.println("Dystrybutor B jest zajęty");
                sleep((int)(Math.random()*20));
                C.release();
            }
        }catch (Exception e)
        {
            System.out.println("Dystrybutor B zwolnił się");
        }
    }
}
