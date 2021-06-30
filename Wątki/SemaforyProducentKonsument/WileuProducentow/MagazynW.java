package Wątki.SemaforyProducentKonsument.WileuProducentow;

public interface MagazynW<T> {

    public void add(T produkt) throws InterruptedException;
    public T get() throws InterruptedException;
}