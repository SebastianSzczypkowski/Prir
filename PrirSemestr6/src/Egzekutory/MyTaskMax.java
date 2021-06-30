package Egzekutory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class MyTaskMax implements Callable<Double> {
    String filename;
    public MyTaskMax(String file)
    {
        this.filename=file;
    }
    @Override
    public Double call() throws Exception{
        double max=0;
        try (Scanner in =new Scanner(new File(filename)))
        {
            while (in.hasNext())
            {
                String s=in.nextLine();
                double nextFromFile=Double.parseDouble(s);
                if(nextFromFile>max)
                {
                    max=nextFromFile;
                } }
        }
        catch (FileNotFoundException e)
        { e.printStackTrace();
        }
        return max;
    }
}
