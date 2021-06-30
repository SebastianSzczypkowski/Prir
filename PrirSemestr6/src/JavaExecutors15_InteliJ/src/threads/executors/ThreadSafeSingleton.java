package JavaExecutors15_InteliJ.src.threads.executors;

import java.util.concurrent.*;

public final class ThreadSafeSingleton  {
    private final static ThreadSafeSingleton instance;
    static {
        instance = new ThreadSafeSingleton();
    }
    private CompletionService<Wynik> completionService ;
    private ExecutorService executorService;
    private ThreadSafeSingleton(){
        ExecutorService executorService= Executors.newFixedThreadPool(8);
        this.completionService=new ExecutorCompletionService<>(executorService) ;
    }
    public  void setInstance(ExecutorService executorService) {
        this.completionService=new ExecutorCompletionService<>(executorService);
    }
    public CompletionService<Wynik> getCompletionService() {
        return completionService;
    }
    public void setCompletionService() {
        this.completionService = completionService;
    }
    public void Shutdown()
    {
        executorService.shutdown();
    }
    synchronized public static  ThreadSafeSingleton getInstance(){
       // if(instance == null)instance = new ThreadSafeSingleton();
        return instance;
    }
}

class Wynik{
    private String nazwaPliku;
    private int wartosc;
    private int ileRazy;

    public Wynik(String nazwaPliku, int wartosc, int ileRazy) {
        this.nazwaPliku = nazwaPliku;
        this.wartosc = wartosc;
        this.ileRazy = ileRazy;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public void setNazwaPliku(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getIleRazy() {
        return ileRazy;
    }

    public void setIleRazy(int ileRazy) {
        this.ileRazy = ileRazy;
    }
}
