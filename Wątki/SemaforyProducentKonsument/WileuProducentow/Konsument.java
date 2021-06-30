package Wątki.SemaforyProducentKonsument.WileuProducentow;

public class Konsument extends Thread{

    MagazynW<String> magazynW;
    public Konsument(MagazynW<String> m)
    {
        this.magazynW =m;

    }
    public void run()
    {
        int i=0;
        try{
            while(true)
            {
                String produkt = magazynW.get();
                System.out.println("Kupiłem z magazynu produkt: "+produkt);
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
            System.out.println("koniec watku konsumenta");
        }
    }
}
