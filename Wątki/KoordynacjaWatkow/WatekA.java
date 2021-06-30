package Wątki.KoordynacjaWatkow;

import java.util.concurrent.Semaphore;

public class WatekA extends Thread{

    Koordynator koordynator;

    public WatekA(Koordynator koordynator)
    {
        this.koordynator=koordynator;
    }


    public void run()
    {
        try
        {
            while(true)
            {
                koordynator.startA();
                System.out.println("Watek A");
                sleep((int)(Math.random()*20));
                koordynator.koniecA();
            }
        } catch (InterruptedException e) {
            System.out.println("Koniec watku A");
        }

    }


}
