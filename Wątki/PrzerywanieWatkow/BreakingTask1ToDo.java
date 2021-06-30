package Wątki.PrzerywanieWatkow;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BreakingTask1ToDo implements Runnable{

    public static void main (String []args)throws InterruptedException
    {
        Thread t =new Thread(new BreakingTask1ToDo());
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        t.join();
        System.out.println("Koniec programu");
    }

    @Override
    public void run() {
        Map<String,Integer> map= new HashMap<>();
        Random r= new Random();

        try{
            while(true)
            {
                String key=""+r.nextInt(10);
                Integer val = map.get(key);
                val=val==null?1:val+1;
                map.put(key,val);
                System.out.println(map.put(key,val));
                Thread.sleep(100);


            }
        }catch (InterruptedException e)
        {
            System.out.println("Przerwano watek");
        }

    }
}
