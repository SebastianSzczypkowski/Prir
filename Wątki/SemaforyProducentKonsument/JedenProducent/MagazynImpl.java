package Wątki.SemaforyProducentKonsument.JedenProducent;

import java.util.concurrent.Semaphore;

public class MagazynImpl implements Magazyn<String>{


    Semaphore semProducent;
    Semaphore semKonsument;
    String[] produkt;
    int size,licznikZapisu,licznikOdczytu;

    public MagazynImpl(int size)
    {
        semProducent = new Semaphore(size);
        semKonsument = new Semaphore(0);
        produkt=new String[size];
        this.size=size;
    }

    @Override
    public void add(String produkt) throws InterruptedException {

        semProducent.acquire();
        this.produkt[licznikZapisu]=produkt;
        licznikZapisu++;
        licznikZapisu=licznikZapisu%size;
        semKonsument.release();

    }

    @Override
    public String get() throws InterruptedException {
        String temp;
        semKonsument.acquire();
        temp=produkt[licznikOdczytu];
        licznikOdczytu++;
        licznikOdczytu=licznikOdczytu%size;
        semProducent.release();
        return temp;
    }
}
