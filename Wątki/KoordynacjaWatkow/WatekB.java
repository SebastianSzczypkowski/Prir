package Wątki.KoordynacjaWatkow;

public class WatekB extends Thread {

    Koordynator koordynator;

    public WatekB(Koordynator koordynator)
    {
        this.koordynator = koordynator;
    }

    public WatekB(Test.Zad4.Koordynator koordynator) {
    }

    public void run() {
        try {
            while (true) {
                koordynator.startB();
                System.out.println("Watek B ==");
                sleep((int) (Math.random() * 20));
                koordynator.koniecB();
            }
        } catch (Exception e) {
            System.out.println("koniec watku B");
        }
    }

}