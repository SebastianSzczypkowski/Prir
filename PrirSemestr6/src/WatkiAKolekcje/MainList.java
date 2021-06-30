package WatkiAKolekcje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MainList {

    public static void main(String [] args) throws InterruptedException
    {
        List<Integer> lista = new ArrayList<Integer>();
        // lista = Collections.synchronizedList(lista);
         lista= new CopyOnWriteArrayList<>();
        Thread klient = new MyConsumentThread
                (lista);
        Thread producent = new MyProducentThread(lista);
        Thread sumator = new MySumThread(lista);
        producent.start();
        klient.start();
        sumator.start();
        Thread.sleep(2000);
        producent.interrupt();
        klient.interrupt();
        sumator.interrupt();

    }
    static void speedTest(List<Integer> list) {
        int n = 1000000;
        long addStartTime = System.currentTimeMillis();
        //dodaj milion elementow
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        //odczytaj milion elementow za pomoca get
        long getStartTime = System.currentTimeMillis();
        int j = 0;
        for (int i = 0; i < n; i++) {
            j += list.get(i);
        }
        //odczytaj milion elementow za pomoca iteratora
        long countStartTime = System.currentTimeMillis();
        int k = 0;
        for (int i : list) {
            k += 1;
        }
    }

}
