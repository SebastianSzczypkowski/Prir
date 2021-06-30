package PisarzeiczytelncyWyklad;

public class CZytelnik extends Thread{
    Czytelnia czytelnia;
    CZytelnik(Czytelnia czytelnia)
    {
        this.czytelnia=czytelnia;
    }
    public void run()
    {
        try{
            while(true)
            {
                System.out.println("Czytelnik: "+getId()+ " pozdrawia");
                sleep((int)(Math.random()*100));
                System.out.println("Czytelnik: "+getId()+ " chce czytać");
                czytelnia.chceCzytac();
                sleep((int)(Math.random()*100));
                czytelnia.koniecCzytania();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
