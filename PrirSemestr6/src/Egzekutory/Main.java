package Egzekutory;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[]args)
    {
        List<String> srcFiles =
                List.of("plikA.txt","plikB.txt","plikC.txt","plikD.txt","plikE.txt",
                        "plikF.txt","plikG.txt");

        List<String> dstFiles =
                List.of("plikADst.txt","plikBDst.txt","plikCDst.txt","plikDDst.txt",
                        "plikEDst.txt","plikFDst.txt","plikGDst.txt");

       //generateFiles(srcFiles);
       //System.out.println("Success files generated");

        int n=7;
        Iterator<String> srcIterator=srcFiles.listIterator();
        Iterator<String> dstIterator=dstFiles.listIterator();

        long time1=System.currentTimeMillis();
        ExecutorService executorService=null;
        try {
        if(srcFiles.size()==dstFiles.size() ) {
            executorService=Executors.newFixedThreadPool(n);

                while (srcIterator.hasNext() && dstIterator.hasNext()) {
                    executorService.submit(new MyTaskCopy(srcIterator.next(), dstIterator.next()));
                }
            }else {
        System.out.println("Rozmiary tablic nie są równe");
        }
        }finally {
                executorService.shutdown();
            }



        long time2=System.currentTimeMillis();

        System.out.println("Czas trwania dla "+n+" wątków: "+(time2-time1) +" sekund.");

    }

    public static void generateFiles(List<String> files){
        for(String s : files){
            try(PrintStream ps = new PrintStream(s);) {
                Random r = new Random();
                for (int i = 0; i < 100000; i++) {
                    double val = r.nextDouble() * 100;
                    ps.println(val);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
