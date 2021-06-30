package ProblemCzytelnikowIPiszrzy2;

import java.awt.*;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

    public static void main(String []args)throws InterruptedException
    {

        String fileName ="src/text.txt";
        ReadWriteLock lock =new ReentrantReadWriteLock();
        Lock readLock =lock.readLock();
        Lock writeLock=lock.writeLock();
        final int iluPisarzy =4;
        final int iluCzytelnikow =20;


        Thread pisarze[]=new Thread[iluPisarzy];
        for(int i=0;i<iluPisarzy;i++)
        {
            pisarze[i]=new Thread(new MyThreadWriter(writeLock,fileName,i));
        }
        Thread czytelnicy[]=new Thread[iluCzytelnikow];
        for(int i=0;i<iluCzytelnikow;i++)
        {
            czytelnicy[i]=new Thread(new MyThreadReader(readLock,fileName,i));
        }

        for(Thread watek :pisarze){watek.start();}
        for(Thread watek :czytelnicy){watek.start();}
        for(Thread watek :pisarze){watek.join();}
        for(Thread watek :czytelnicy){watek.join();}





    }
}
