package Wątki.ProblemUcztujacychFilozofow.zad1;

import java.util.concurrent.Semaphore;

public class Main
{
    public static void main(String[] args) {
        int LICZBA_PALEK = 5;
        Semaphore[] paleczki = new Semaphore[LICZBA_PALEK];
        Semaphore stol = new Semaphore(LICZBA_PALEK-1);
        for(int i=0;i<LICZBA_PALEK;i++)
        {
            paleczki[i] = new Semaphore(1);
        }

        for(int i=0;i<LICZBA_PALEK;i++)
        {
            new FilozofV2(i,paleczki,stol).start();
        }
    }
}