package Wątki.SemaforyProducentKonsument.JedenProducent;

public class Konsument  extends Thread{
    Magazyn<String> magazyn;

    public Konsument(Magazyn<String> m)
    {
        this.magazyn=m;
    }

    public void run()
    {
        int i=0;
        try{

            while(true)
            {
                String produkt =magazyn.get();
                System.out.println("Zakupiłem z magazynu produkt: "+produkt);
                int j=Integer.parseInt(produkt);
                System.out.println(i+ " "+j);
                if(i!=j)
                {
                    throw new RuntimeException("Błąd , i i j nies ą sobie równe");

                }
                i++;
                Thread.sleep((int)(Math.random()*50));
            }
        }catch (InterruptedException e)
        {
            System.out.println("Koniec watku konsumenta");
        }
    }
}
