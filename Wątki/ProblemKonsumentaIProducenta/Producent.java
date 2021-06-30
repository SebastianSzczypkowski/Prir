package Wątki.ProblemKonsumentaIProducenta;

public class Producent extends Thread{

    MagazynImpl magazyn;
    int idtowaru =0;
    Producent(MagazynImpl magazyn)
    {
        setMagazyn(magazyn);
    }
    public MagazynImpl getMagazyn()
    {
        return  magazyn;
    }
    public void setMagazyn(MagazynImpl magazyn)
    {
        this.magazyn =magazyn;
    }
    public void run()
    {

        try{
            while(true)
            {
                Thread.sleep((long)(500*Math.random()));
                getMagazyn().addItem("Dodano towar o id:"+idtowaru);
                idtowaru++;


            }
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
