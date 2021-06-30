package Wątki.KoordynacjaWatkow;

public class WatekC extends Thread{
    Koordynator koordynator;

    public WatekC(Koordynator koordynator)
    {
        this.koordynator = koordynator;
    }

    public WatekC(Test.Zad4.Koordynator koordynator) {
    }

    public void run() {
        try {
            while (true) {
                koordynator.startC();
                System.out.println("Watek C ==++++");
                sleep((int) (Math.random() * 20));
                koordynator.koniecC();
            }
        } catch (Exception e) {
            System.out.println("koniec watku C");
        }
    }
}