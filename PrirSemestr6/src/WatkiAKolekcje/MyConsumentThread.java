package WatkiAKolekcje;

import java.util.List;

public class MyConsumentThread extends  Thread{

    List lista;
    private int counter=0;

    MyConsumentThread(List<Integer> lista)
    {
        this.lista=lista;
    }
    public void run()
    {
        try {
            Thread.sleep(100);
                while (true) {
                    synchronized (lista) {
                        System.out.println(lista.get(0));
                        assert counter == (int) lista.get(0) : counter + " || " + lista.get(0);
                        lista.remove(0);
                        counter++;
                    }
                    if(this.isInterrupted())
                    {
                        break;
                    }
                }
        } catch (InterruptedException e) {
           System.out.println("koniec watku klienta");
        }

    }

}
