package Wątki.Zadania;

public class NowyWatekPoprawnie extends Thread
{
    final int id;
    static boolean[] tablica;

    NowyWatekPoprawnie(int id, boolean[] tablica)
    {
        this.id = id;
        this.tablica = tablica;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                synchronized (tablica)
                {
                    while (tablica[id])
                    {
                        tablica.wait();
                    }
                }
                System.out.println("Watek id"+id);
                synchronized (tablica)
                {
                    tablica[id]=true;

                    if(id<=4)
                    {
                        if(tablica[0]&&tablica[1]&&tablica[2]&&tablica[3]&&tablica[4])
                        {
                            for(int i=5;i<10;i++)
                            {
                                tablica[i] = false;
                            }
                        }
                    }
                    if(id>=5)
                    {
                        if(tablica[5]&&tablica[6]&&tablica[7]&&tablica[8]&&tablica[9])
                        {
                            for(int i=0;i<5;i++)
                            {
                                tablica[i] = false;
                            }
                        }
                    }
                    tablica.notifyAll();
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Watek "+id+" konczy prace. ");
        }
    }
}

