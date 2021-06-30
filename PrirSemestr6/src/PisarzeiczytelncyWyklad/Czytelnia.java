package PisarzeiczytelncyWyklad;

public class Czytelnia {

    private boolean pisarzPisze;
    private boolean pisarzCzeka;
    private boolean pisarzWlasnieCosWpisal;
    private int liczbaCzytelnikow;
    public synchronized  void chceCzytac() {
        try {
            while (pisarzPisze || (pisarzCzeka && !pisarzWlasnieCosWpisal)) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void koniecCzytania()
    {
        liczbaCzytelnikow--;
        notifyAll();
    }
    public synchronized  void chcePisac()
    {
        try{
            pisarzCzeka=true;
            while(liczbaCzytelnikow>0||pisarzCzeka)
            {
                wait();
            }
            pisarzCzeka=false;
            pisarzPisze=true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void koniecPisania()
    {
        pisarzPisze=false;
        pisarzWlasnieCosWpisal=true;
        notifyAll();
    }


}
