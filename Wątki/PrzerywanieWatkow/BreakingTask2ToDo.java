package Wątki.PrzerywanieWatkow;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Thread.sleep;

public class BreakingTask2ToDo implements Runnable{

    public static void main (String []args) throws InterruptedException
    {
        Thread t =new Thread(new BreakingTask2ToDo());
        t.start();
        Thread.sleep(500);
        t.interrupt();
    }
    @Override
    public void run() {

        Map<String,Integer> map =new HashMap<>();
        Random r = new Random();
        while(true)
        {
            String key=""+r.nextInt(10);
            Integer val = map.get(key);
            val=val==null?1:val+1;
            map.put(key,val);
            System.out.println( map.put(key, val));
            System.out.println("||"+ map.size());
            try {
                sleep(5);
            } catch (InterruptedException e) {
                System.out.println("Wyjątek");
                break;
            }
        }

    }
}
