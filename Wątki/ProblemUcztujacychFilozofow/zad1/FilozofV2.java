package Wątki.ProblemUcztujacychFilozofow.zad1;

import java.util.concurrent.Semaphore;

public class FilozofV2 extends Thread
{
    Semaphore[] locks;
    int filozofId;
    static Semaphore extraLock;

    public FilozofV2(int nr, Semaphore[] paleczki, Semaphore stol)
    {
        filozofId = nr;
        locks= paleczki;
        extraLock = stol;
    }

    @Override
    public void run()
    {
        try
        {
            while(true)
            {
                System.out.println("Myśli "+filozofId);
                Thread.sleep((long)(7*Math.random()));
                extraLock.acquireUninterruptibly();
                locks[filozofId].acquireUninterruptibly();
                locks[(filozofId+1)%locks.length].acquireUninterruptibly();
                System.out.println("Je "+filozofId);
                Thread.sleep((long)(5*Math.random()));
                System.out.println("Zjadł  "+filozofId);
                locks[filozofId].release();
                locks[(filozofId+1)&locks.length].release();
                extraLock.release();
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Błąd");
        }
    }
}