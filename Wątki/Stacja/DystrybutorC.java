package Wątki.Stacja;

import java.util.concurrent.Semaphore;

public class DystrybutorC extends Thread{

    Semaphore A;
    Semaphore B;
    Semaphore C;

    public DystrybutorC(Semaphore a,Semaphore b,Semaphore c)
    {
        this.A=a;
        this.B=b;
        this.C=c;
    }

    public void run()
    {
        try
        {
            while(true)
            {
                C.acquire(2);
                System.out.println("Dystrybutor C jest zajęty");
                sleep((int)(Math.random()*20));
                A.release();
                B.release();

            }
        }catch (Exception e)
        {
            System.out.println("Dystrybutor C zwolnił się");
        }
    }

}
