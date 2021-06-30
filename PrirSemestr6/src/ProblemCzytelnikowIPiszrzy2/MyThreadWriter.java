package ProblemCzytelnikowIPiszrzy2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class MyThreadWriter extends Thread{
    Lock writeLock;
    String file;
    int id =0;
    static Licznik licznik = new Licznik();
    public MyThreadWriter(Lock lock, String fileName, int i) {
        this.writeLock=lock;
        this.file=fileName;
        this.id=i;
    }



    @Override
     public void run()
    {
          writeLock.lock();
            try (Scanner sc = new Scanner(new File(file))) {


                    PrintStream ps = new PrintStream(new FileOutputStream(file, true));
                    System.out.println("Watek " + id + " pisarz dodał wiadomosc");
                    ps.println("==> Wiadomosc od " + id + " pisarza" + " numer wiadomosci " + licznik.get());
                    licznik.increment();
            writeLock.unlock();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


