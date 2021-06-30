package Wątki.Zadania;

public class NowyWatek extends Thread
{
    int id_watku;
    public boolean[] tablica;

    NowyWatek(int id, boolean[] tablica)
    {
        this.id_watku = id;
        this.tablica = tablica;
    }

    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                synchronized(tablica)
                {
                    System.out.println("WATEK "+id_watku);
                    tablica[id_watku]=true;
                    notifyAll();
                }
                if(id_watku<5)
                {
                    for(int i=0;i<5;i++)
                    {
                        if(!tablica[i])
                        {
                            try
                            {
                                wait();
                            }
                            catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            synchronized (tablica)
                            {
                                notifyAll();
                            }
                        }
                    }
                }
                else if(id_watku>5)
                {
                    for(int j=5;j<10;j++)
                    {
                        if(!tablica[j])
                        {
                            try
                            {
                                wait();
                            }
                            catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}