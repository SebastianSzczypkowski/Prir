package Wątki.ProblemUcztujacychFilozofow.zad2Wersja2;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args) throws InterruptedException{

        int LICZBA_PALEK = 4;
        Semaphore[] paleczki = new Semaphore[LICZBA_PALEK];

        for(int i=0;i<LICZBA_PALEK;i++)
        {
            paleczki[i] = new Semaphore(1);
        }

        for(int i=0;i<LICZBA_PALEK;i++)
        {
            new FilozofV2(i,paleczki).start();
        }
    }
}