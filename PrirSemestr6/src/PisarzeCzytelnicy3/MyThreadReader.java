package PisarzeCzytelnicy3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class MyThreadReader  extends Thread {

    ReadWriteLock lock;
    static int idCzytelnika;
    int id;
    String file;

    public MyThreadReader(ReadWriteLock lock, String fileName) {
        this.lock = lock;
        this.file = fileName;
        this.id = idCzytelnika;
        idCzytelnika++;

    }

    public void run() {

        try {
            while (true) {
                lock.lockRead();

                try (Scanner sc = new Scanner(new File(file))) {

                    System.out.println("Watek :" + id + " czyta: ");
                    while (sc.hasNext()) {

                        String odczytzPliku = sc.nextLine();
                        System.out.println("Watek  czytelnik odczytał " + odczytzPliku);

                    }
                } catch (FileNotFoundException e) {

                } finally {
                    lock.unlockRead();
                }
                Thread.sleep((long)Math.random()*100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
