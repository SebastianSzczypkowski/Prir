package Wątki.Stacja;

import java.util.concurrent.Semaphore;

public class DystrybutorA extends Thread{

    Semaphore A;
    Semaphore B;
    Semaphore C;


    public DystrybutorA(Semaphore a,Semaphore b,Semaphore c)
    {
        this.A=a;
        this.B=b;
        this.C=c;
    }

    public void run ()
    {
        try
        {
            while(true)
            {
                A.acquire();
                System.out.println("Dystrybutor A jest zajęty");
                sleep((int)(Math.random()*20));
                C.release();
            }
        }catch (Exception e)
        {
            System.out.println("Dystrybutor A zwolnił się");
        }
    }
}
