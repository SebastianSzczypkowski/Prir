package JavaExecutors15_InteliJ.src.threads.executors;

import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class ResultsReciever implements Runnable {
    @Override
    public void run() {


        int odebrane = 0;
        boolean error = false;

        while (odebrane < 8 && !error) {

            // CompletionService<Wynik> completionService=threadSafeSingleton.getCompletionService();

            try {
                ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
                Future<Wynik> fut = threadSafeSingleton.getInstance().getCompletionService().take();
                System.out.println("::" + fut.get().getNazwaPliku() + "  " + fut.get().getWartosc() + " " + fut.get().getIleRazy());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                error=true;
            }
        }
    }
}

