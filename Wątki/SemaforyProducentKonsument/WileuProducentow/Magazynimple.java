package Wątki.SemaforyProducentKonsument.WileuProducentow;

import Wątki.SemaforyProducentKonsument.JedenProducent.Magazyn;

import java.util.concurrent.Semaphore;

public class Magazynimple implements MagazynW<String> {


    Semaphore semProducent;
    Semaphore semKonsument;
    Semaphore semAdd = new Semaphore(1);
    Semaphore semGet = new Semaphore(1);
    String[] produkt;
    int size,licznikZapisu,licznikOdczytu;

    public Magazynimple(int size)
    {
        semProducent = new Semaphore(size);
        semKonsument = new Semaphore(0);
        produkt=new String[size];
        this.size=size;
    }

    @Override
    public void add(String produkt) throws InterruptedException {

        semProducent.acquire();
        semAdd.acquire();
        this.produkt[licznikZapisu]=produkt;
        licznikZapisu++;
        licznikZapisu=licznikZapisu%size;
        semAdd.release();
        semKonsument.release();


    }

    @Override
    public String get() throws InterruptedException {
        String temp;
        semKonsument.acquire();
        semGet.acquire();
        temp=produkt[licznikOdczytu];
        licznikOdczytu++;
        licznikOdczytu=licznikOdczytu%size;
        semGet.release();
        semProducent.release();
        return temp;
    }
}