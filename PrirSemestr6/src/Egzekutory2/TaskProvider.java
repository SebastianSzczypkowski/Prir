package Egzekutory2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;

public class TaskProvider implements Runnable
{
    @Override
    public void run()
    {
        String files[] = {"plikA4.txt", "plikB4.txt", "plikC4.txt",
                "plikD4.txt", "plikE4.txt", "plikF4.txt", "plikG4.txt", "plikH4.txt"};

        Service service = Service.getInstance();
        CompletionService<Result> completionService = service.CompletionService();

        for(int i=0;i<8;i++)
        {
            completionService.submit(new MyTask(files[i]));
        }
        service.Shutdown();
        if(service.isShutdown())
        {
            System.out.println("Niby przerwano ale nie przerwano xD");
            Thread.currentThread().interrupt();
        }
    }
}
class MyTask implements Callable<Result>
{
    String fileName;
    int number=0;
    int count=0;

    public MyTask(String fileName)
    {
        this.fileName = fileName;
    }

    @Override
    public Result call() throws Exception
    { Map<Integer, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName)))
        {
            while (scanner.hasNext())
            {
                int liczba = scanner.nextInt();
                if(map.get(liczba)==null)
                    map.put(liczba,1);
                else map.put(liczba,(map.get(liczba)+1));
            }
            Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext())
            {
                Map.Entry<Integer,Integer> entry = iterator.next();
                int numberSearch = entry.getKey();
                int numberCount = entry.getValue();
                if(numberCount>count)
                {
                    number = numberSearch;
                    count = numberCount;
                }
            }
        }
        catch (FileNotFoundException e)
        { e.printStackTrace();
        }
        return new Result(fileName,number, count);
    }
}

