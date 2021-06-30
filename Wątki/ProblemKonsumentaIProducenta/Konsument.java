package Wątki.ProblemKonsumentaIProducenta;

public class Konsument extends Thread{
    MagazynImpl magazyn;

    Konsument(MagazynImpl magazyn)
    {
        setMagazyn(magazyn);
    }

    public MagazynImpl getMagazyn()
    {
        return magazyn;
    }
    public void setMagazyn(MagazynImpl magazyn)
    {
        this.magazyn=magazyn;
    }

    public void run(){
        try
        {
            while(true)
            {
                Thread.sleep((long)(500*Math.random()));
                String s=(String) getMagazyn().get();

            }
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
