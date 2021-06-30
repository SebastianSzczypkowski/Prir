package PisarzeiczytelncyWyklad;

public class Pisarz extends Thread{

    Czytelnia czytelnia;
    Pisarz(Czytelnia czytelnia)
    {
        this.czytelnia=czytelnia;
    }
    public void run()
    {
        try
        {
            while(true)
            {
                System.out.println("Pisarz: "+getId()+ " pozdrawia");
                sleep((int)(Math.random()*100));
                System.out.println("Pisarz: "+getId()+ " chce pisać");
                czytelnia.chcePisac();
                sleep((int)(Math.random()*100));
                czytelnia.koniecPisania();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
