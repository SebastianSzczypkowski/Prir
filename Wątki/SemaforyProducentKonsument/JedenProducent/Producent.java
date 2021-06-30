package Wątki.SemaforyProducentKonsument.JedenProducent;

public class Producent  extends Thread{
    Magazyn magazyn;

    public Producent(Magazyn m){
        this.magazyn=m;
    }

    public void run()
    {
        int i=0;
        try{
            while(true)
            {
                String produkt =""+i;
                magazyn.add(produkt);
                i++;
                System.out.println("Producent wrzucił do magazynu produkt: "+produkt);
                Thread.sleep((int)(Math.random()*10));
            }
        }catch(InterruptedException e)
        {
            System.out.println("Koniec watku producenta");
        }
    }
}
