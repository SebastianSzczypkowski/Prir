package Wątki.SemaforyProducentKonsument.WileuProducentow;

public class Producent  extends  Thread{
    MagazynW magazynW;
    static int counter;

    public Producent(MagazynW m){
        magazynW =m;
    }

    public void run()
    {
        try
        {
            while(true)
            {
                String produkt;
                synchronized (Producent.class)
                {
                    produkt=""+counter;
                    counter++;
                    magazynW.add(produkt);
                }
                System.out.println(("Producent wrzucił do magazynu: "+produkt));
                Thread.sleep((int)(Math.random()*10));
            }
        }catch (InterruptedException e)
        {
            System.out.println("Koniec watku producenta");
        }
    }
}
