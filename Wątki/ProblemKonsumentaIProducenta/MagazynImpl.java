package Wątki.ProblemKonsumentaIProducenta;


public class MagazynImpl implements Magazyn {

    String produkt;
    boolean TowarJestDostepny = false;

    @Override
    synchronized public void addItem(Object product) throws InterruptedException {
        while(TowarJestDostepny)
        {
            this.wait();
        }
        this.produkt =(String) product;
        TowarJestDostepny= true;
        notifyAll();
        System.out.println("Do magazynu dostarczono :" +product);

    }

    @Override
    synchronized public Object get() throws InterruptedException {

        while(!TowarJestDostepny)
        {
            this.wait();
        }
        TowarJestDostepny=false;
        notifyAll();
        System.out.println("Konsument wykupiła :" +produkt);
        return produkt;
    }
}
