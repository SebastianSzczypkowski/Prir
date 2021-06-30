package JavaExecutors15_InteliJ.src.threads.executors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;

class TaskProvider implements Runnable {

    @Override
    public void run() {
        String[] srcFiles = {"plikA4.txt", "plikB4.txt", "plikC4.txt", "plikD4.txt", "plikE4.txt", "plikF4.txt", "plikG4.txt", "plikH4.txt"};
            ThreadSafeSingleton threadSafeSingleton=ThreadSafeSingleton.getInstance();
            CompletionService<Wynik> completionService=threadSafeSingleton.getCompletionService();

        for(int i=0;i<8;i++)
        {

            completionService.submit(new MyCallable(srcFiles[i]));
        }

        threadSafeSingleton.Shutdown();
    }
}

class MyCallable implements Callable<Wynik> {

    String name;
    int a=0;
    int b=0;

    public MyCallable(String srcFile) {
        this.name=srcFile;
    }


    @Override
    public Wynik call() throws Exception {

        Map<Integer,Integer> wartosc=new HashMap<>();
       // Wynik wynik = new Wynik(name,0,0);
        try(Scanner sc = new Scanner(new File(name)))
        {

            while(sc.hasNext())
            {
                int liczba = sc.nextInt();
                if(wartosc.get(liczba)==null)wartosc.put(liczba,1);
                else wartosc.put(liczba,(wartosc.get(liczba)+1));
            }
            Iterator<Map.Entry<Integer,Integer>> iterator=wartosc.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<Integer,Integer> entry=iterator.next();
                int klucz=entry.getKey();
                int pow=entry.getValue();
                if(pow>b)
                {
                    a=klucz;
                    b=pow;
                }

            }
        }catch (FileNotFoundException e)
        {
            System.out.println("Brak pliku");
        }

        return new Wynik(name,a, b);
    }
}