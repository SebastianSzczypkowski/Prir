package Wątki.AgorytmWzajemnegoWykluczenia;

public class RozjazdB  extends Thread{

    Zwrotnica z;
    Licznik l;

    public RozjazdB(Zwrotnica z , Licznik l) {
        this.z=z;
        this.l=l;
    }



    public void run()
    {
        try{
            for(int i=0;i<24;i++)
            {
                z.ZwrotnicaNaTorBStart();
                l.increment();
                System.out.println("tory ustawione na Rozjazd B");
                z.ZwrotnicaNaTorBKoniec();
                sleep(10);
            }

        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
