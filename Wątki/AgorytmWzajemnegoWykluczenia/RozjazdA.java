package Wątki.AgorytmWzajemnegoWykluczenia;

public class RozjazdA extends Thread{

    Zwrotnica z;
    Licznik l;
    public RozjazdA(Zwrotnica z ,Licznik l)
    {

        this.z=z;
        this.l=l;
    }

    public void run()
    {
        try{
            for(int i=0;i<24;i++)
            {
                z.ZwrotnicaNaTorAStart();
                l.increment();
                System.out.println("tory ustawione na Rozjazad A");
                z.ZwrotnicanaTorAKoniec();
                sleep(10);
            }

        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
