package ProblemCzytelnikowIPiszrzy2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class MyThreadReader extends Thread{

    Lock readLock;
    String file;
    int id;
    public MyThreadReader(Lock lock, String fileName, int i) {
        this.readLock=lock;
        this.file=fileName;
        this.id=i;
    }

    public void run()
    {
            readLock.lock();
            try(Scanner sc = new Scanner(new File(file)))
            {
                    while(sc.hasNext()) {

                        String odczytzPliku = sc.nextLine();
                        System.out.println("Watek " + id + " czytelnik odczytał " + odczytzPliku);

                    }
                readLock.unlock();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

}
