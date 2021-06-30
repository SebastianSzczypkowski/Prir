package Wątki.KoordynacjaWatkow;

public interface Koordynator {
    void startA() throws InterruptedException;
    void startB() throws InterruptedException;
    void startC() throws InterruptedException;
    void koniecA();
    void koniecB();
    void koniecC();

}
