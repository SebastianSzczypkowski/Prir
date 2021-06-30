package Egzekutory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyTaskCopy implements Runnable{

    String file1;
    String file2;

    public MyTaskCopy(String file1 ,String file2)
    {
        this.file1=file1;
        this.file2=file2;
    }

    @Override
    public void run() {

        Scanner sc =null;
        PrintWriter pw =null;
        try{
             sc = new Scanner(new File(file1));
             pw = new PrintWriter(file2);
            while(sc.hasNext())
            {
                pw.println(sc.nextLine());
            }
            System.out.println("z pliku "+file1+" do pliku "+file2+" skopiowano Numer wątku" +Thread.currentThread().getId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            sc.close();
            pw.close();
        }

    }
}
