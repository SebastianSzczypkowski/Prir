package Wątki.SemaforyProducentKonsument.JedenProducent;

public interface Magazyn <T> {

    public void add(T produkt) throws InterruptedException;
    public T get() throws InterruptedException;
}
