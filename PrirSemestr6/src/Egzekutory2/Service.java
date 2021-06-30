package Egzekutory2;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Service
{
    private final static Service instance;
    private CompletionService<Result> completionService;
    private ExecutorService executorService;
    private boolean isShutdown=false;
    static
    {
        instance = new Service();
    }
    private Service()
    {
        executorService = Executors.newFixedThreadPool(8);
        this.completionService = new ExecutorCompletionService<Result>(executorService);
    }
    synchronized public static Service getInstance()
    {
        return instance;
    }

    public CompletionService<Result> CompletionService()
    {
        return completionService;
    }

    public void Shutdown()
    {
        isShutdown = true;
        executorService.shutdown();
    }

    public boolean isShutdown()
    {
        return isShutdown;
    }
}

class Result
{
    String nazwa;
    int liczba;
    int iloscPowtorzen;

    public Result(String nazwa, int liczba, int iloscPowtorzen)
    {
        this.nazwa = nazwa;
        this.liczba = liczba;
        this.iloscPowtorzen = iloscPowtorzen;
    }

    public String getNazwa()
    {
        return nazwa;
    }

    public int getLiczba()
    {
        return liczba;
    }

    public int getIloscPowtorzen()
    {
        return iloscPowtorzen;
    }
}
