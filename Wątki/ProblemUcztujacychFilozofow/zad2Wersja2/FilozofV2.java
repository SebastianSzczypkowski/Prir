package Wątki.ProblemUcztujacychFilozofow.zad2Wersja2;

import java.util.concurrent.Semaphore;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class FilozofV2 extends Thread {
    Semaphore[] locks;
    int filozofId;
    int liczbaPaleczek;
    String[] files = {
            "plik1.txt",
            "plik2.txt",
            "plik3.txt",
            "plik4.txt",
            "plik5.txt"};
    Random liczba_losowa = new Random();
    public FilozofV2(int nr, Semaphore[] paleczki)
    {
        this.filozofId = nr;
        this.locks= paleczki;

    }

    @Override
    public synchronized void run()
    {
        try
        {
            while(true)
            {
                int los1 = liczba_losowa.nextInt(5);
                int los2 = liczba_losowa.nextInt(5)                                                  ;
                if (los2 == los1) {
                    los2 = liczba_losowa.nextInt(5);
                }
                System.out.println("Myśli "+filozofId);
                Thread.sleep((long)(7*Math.random()));
                int id1 = filozofId;
                int id2 =(filozofId+1)% locks.length;
                int id1Sem = id1>id2? id2: id1;
                int id2Sem = id1>id2? id1: id2;
                locks[id1Sem].acquireUninterruptibly();
                locks[id2Sem].acquireUninterruptibly();
                File file = new File(files[los1]);
                Scanner odczyt = new Scanner(file);
                String odczytZpliku = odczyt.nextLine();

                System.out.println(odczytZpliku + "\\" + id1);
                PrintWriter zapis = new PrintWriter(new FileWriter(files[los2], true));

                zapis.println(odczytZpliku + " ||Wątek: " + id1);
                zapis.close();
                System.out.println("Je "+filozofId);
                Thread.sleep((long)(5*Math.random()));
                System.out.println("Zjadł  "+filozofId);
                locks[id1Sem].release();
                locks[id2Sem].release();

            }
        }
        catch (InterruptedException | IOException e)
        {
            System.out.println("Błąd");
        }
    }
}

