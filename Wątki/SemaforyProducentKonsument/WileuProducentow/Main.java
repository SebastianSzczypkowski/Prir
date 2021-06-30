package Wątki.SemaforyProducentKonsument.WileuProducentow;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String []args) throws InterruptedException
    {
        MagazynW m = new Magazynimple(3);
        List<Thread> th = new ArrayList<>();
        for(int i =0;i<10;i++)
        {
            Thread producent =new Producent(m);
            th.add(producent);
        }
        Thread konsument = new Konsument(m);
        th.add(konsument);
        th.forEach(t->t.start());
        Thread.sleep(1*1000);
        th.forEach(t->t.interrupt());
    }
}
