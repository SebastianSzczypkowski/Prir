package Wątki.Zadania;

public class Main
{
    public static boolean[] tablica = new boolean[10];

    public static void main(String[] args) throws InterruptedException
    {
//        Thread[] th = new Thread[10];
//        System.out.println("START");
//        for(int i=0;i<10;i++)
//        {
//            th[i] = new NowyWatek(i,tablica);
//            th[i].start();
//        }
//        Thread.sleep(1000);
//        for(int i=0;i<10;i++)
//        {
//            th[i].interrupt();
//        }
        Thread[] th = new Thread[10];
        System.out.println("START");
        for(int i=0;i<10;i++)
        {
            th[i] = new NowyWatekPoprawnie(i,tablica);
            th[i].start();
        }
        Thread.sleep(1000);
        for(int i=0;i<10;i++)
        {
            th[i].interrupt();
        }
    }
}