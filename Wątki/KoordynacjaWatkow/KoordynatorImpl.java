package Wątki.KoordynacjaWatkow;

public class KoordynatorImpl implements Koordynator{

    private boolean blokadaA = true;
    private boolean blokadaB =true;
    private boolean blokadaC = false;

    @Override
    synchronized public void startA() throws InterruptedException {
        while(blokadaA)
        {
            this.wait();
        }
        blokadaC=true;
    }

    @Override
    synchronized public void startB() throws InterruptedException {
        while(blokadaB)
        {
            this.wait();
        }

    }

    @Override
    synchronized public void startC() throws InterruptedException {
        while(blokadaC)
        {
            this.wait();
        }
        blokadaA=true;
        blokadaB=true;
    }

    @Override
    synchronized public void koniecA() {

        blokadaA=true;
        blokadaC=false;
        blokadaB=true;
        notifyAll();
    }

    @Override
    synchronized public void koniecB() {
    blokadaB=true;
    blokadaC=false;
    blokadaA=true;
    notifyAll();
    }

    @Override
    synchronized public void koniecC() {
        blokadaC=true;
        blokadaA=false;
        blokadaB=false;
        notifyAll();

    }
}
