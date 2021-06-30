package PisarzeCzytelnicy3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MyThredWriter extends Thread {

    ReadWriteLock lock;
    static int idCzytelnika = 0;
    static int messageCounter = 0;
    int id;
    String file;

    public MyThredWriter(ReadWriteLock lock, String fileName) {
        this.lock = lock;
        this.file = fileName;
        this.id = idCzytelnika;
        idCzytelnika++;
    }
    @Override
    public void run() {

        try {
            while (true) {

                lock.lockWrite();
                System.out.println("Pisarz :" + id + " pisze");
                try (PrintStream ps = new PrintStream(new FileOutputStream(file, true))) {
                    String wiadomosc = "Wiadomosc od: " + id + "numer wiadomosci " + messageCounter;

                    ps.println(wiadomosc);
                    System.out.println("Watek  pisarz dodał wiadomosc >>>>>>" + wiadomosc);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlockWrite();
                }
                Thread.sleep((long) Math.random() * 100);
            }


        } catch (InterruptedException e) {
            System.out.println("Koniec watku pisarza: " + id);
        }

    }
}
