package Egzekutory2;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;

public class ResultsReciever implements Runnable
{
    @Override
    public void run()
    {
        boolean error = false;
        int recived = 0;

        while(recived<8 && !error)
        {
            try
            {
                Service service = Service.getInstance();
                Future<Result> future = service.getInstance().CompletionService().take();
                System.out.println("-- Plik: "+future.get().getNazwa()+", Liczba: "+future.get().getLiczba()+", powtórzono "+future.get().getIloscPowtorzen());
            }
            catch (Exception e)
            {
                e.printStackTrace();
                error=true;
            }
        }
    }
}
