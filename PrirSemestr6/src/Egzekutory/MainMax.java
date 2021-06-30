package Egzekutory;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
import java.util.concurrent.*;

public class MainMax {
    public static void main(String[] args) throws FileNotFoundException{

        List<String> srcFiles =
                Arrays.asList("plikA.txt", "plikB.txt", "plikC.txt", "plikD.txt", "plikE.txt",
                        "plikF.txt", "plikG.txt");

        ExecutorService es=null;
        try {
            Iterator<String> srcIterator = srcFiles.listIterator();
            List<Callable<Double>> tasks = new ArrayList<>();
            while (srcIterator.hasNext()) {
                String src = srcIterator.next();
                tasks.add(new MyTaskMax(src));
            }
            es = Executors.newFixedThreadPool(3);
            List<Future<Double>> res = es.invokeAll(tasks);
            double result = 0;
            for (Future<Double> future : res) {
                result += future.get();
            }

            System.out.println("Result: " + result);
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        finally {
            if(es!=null) es.shutdown();
        }


        System.out.println("Finish!");
    }

}
