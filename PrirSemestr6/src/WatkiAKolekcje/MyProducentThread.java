package WatkiAKolekcje;

import java.util.List;

public class MyProducentThread extends Thread{
    List lista;
    private int counter=0;
    MyProducentThread(List<Integer> lista)
    {
    this.lista=lista;
    }
    public void run()
    {
            while (true) {
               synchronized(lista) {
                   lista.add(counter);
                   counter++;
               }
                if(this.isInterrupted())
                {
                    break;
                }

            }
    }
}
