package Wątki.ProblemUcztujacychFilozofow.zad2;

import java.util.concurrent.Semaphore;

public class FilozofV2 extends Thread {
    Semaphore[] locks;
    int filozofId;
    int liczbaPaleczek;

    public FilozofV2(int nr, Semaphore[] paleczki, int liczbaPaleczek)
    {
        this.filozofId = nr;
        this.locks= paleczki;
        this.liczbaPaleczek=liczbaPaleczek;
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
                if(filozofId==liczbaPaleczek-1){
                    locks[(filozofId+1)%locks.length].acquireUninterruptibly();
                    locks[filozofId].acquireUninterruptibly();
                }
                else {
                    locks[filozofId].acquireUninterruptibly();
                    locks[(filozofId+1)%locks.length].acquireUninterruptibly();
                }
                System.out.println("Je "+filozofId);
                Thread.sleep((long)(5*Math.random()));
                System.out.println("Zjadł  "+filozofId);
                locks[filozofId].release();
                if(filozofId==liczbaPaleczek-1){
                    locks[(filozofId+1)%locks.length].release();
                    locks[filozofId].release();
                }else{
                    locks[filozofId].release();
                    locks[(filozofId+1)%locks.length].release();
                }
            }
        }
        catch (InterruptedException e)
        {
            System.out.println("Błąd");
        }
    }
}
