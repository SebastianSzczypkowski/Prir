package Wątki.ProblemUcztujacychFilozofow.filozofowie;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Semaphore;

public class FilozofowieMain {
    public static void main(String[] args) throws InterruptedException {
        List<String> files = Arrays.asList(
                "dane\\plik1.txt",
                "dane\\plik2.txt",
                "dane\\plik3.txt",
                "dane\\plik4.txt",
                "dane\\plik5.txt"
        );
        List<Semaphore> semaphores = Arrays.asList(
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)
        );
        List<Thread> threads = new ArrayList<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            threads.add(new FilozofSimpleImpl(files, semaphores));
        }
        threads.forEach(t -> t.start());
        Thread.sleep(3000);
        threads.forEach(t -> t.interrupt());
    }
}

class FilozofImpl extends Thread {
    List<String> files;
    List<Semaphore> semaphores;
    Random rnd = new Random();

    public FilozofImpl(List<String> files, List<Semaphore> semaphores) {
        this.files = files;
        this.semaphores = semaphores;
    }

    public void run() {
        int id1 = -1, id2 = -1, semID1 = -1, semID2 = -1, size = -1;
        String file1 = null, file2 = null;
        try {
            while (true) {

                size = files.size();
                id1 = rnd.nextInt(size);
                do {
                    id2 = rnd.nextInt(size);
                } while (id1 == id2);

                semID1 = id1 > id2 ? id2 : id1;
                semID2 = id1 > id2 ? id1 : id2;

                semaphores.get(semID1).acquire();
                semaphores.get(semID2).acquire();

                file1 = files.get(id1);
                file2 = files.get(id2);


                try (Scanner sc = new Scanner(new File(file1));
                     PrintStream ps = new PrintStream(new FileOutputStream(file2, true));) {

                    String line = null; //UWAGA: Podczas czytania z pliku, gdy pojawi się sygnał interrupt dla wątku to Scanner przerywa czytanie Wywołanie nextLine powoduje => NoSuchElementException
                    //Można to też identyfikować przez hasNextLine i potem sprawdzenie czy nie nastąpiło przerwanie wątku jak pokazałem poniżej.
                    //Gdyby tylko patrzeć na NoSuchElementException to można pominąć błąd związany z niepoprawny czytaniem danych z pliku.
                    //Poniżej uproszczona wersja programiku.
                    if (sc.hasNextLine()) {
                        line = sc.nextLine();
                    } else {
                        if (this.isInterrupted()) {
                            throw new InterruptedException();
                        }
                    }
                    ps.println("Thread:" + this.getId() + " => " + line);
                }

                semaphores.get(semID1).release();
                semaphores.get(semID2).release();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Koniec watku: " + this.getId());
        }
    }
}



class FilozofSimpleImpl extends Thread {
    List<String> files;
    List<Semaphore> semaphores;
    Random rnd = new Random();

    public FilozofSimpleImpl(List<String> files, List<Semaphore> semaphores) {
        this.files = files;
        this.semaphores = semaphores;
    }

    public void run() {
        int id1 = -1, id2 = -1, semID1 = -1, semID2 = -1, size = -1;
        String file1 = null, file2 = null;
        size = files.size();
        try {
            while (true) {

                id1 = rnd.nextInt(size);
                do {
                    id2 = rnd.nextInt(size);
                } while (id1 == id2);

                semID1 = id1 > id2 ? id2 : id1;
                semID2 = id1 > id2 ? id1 : id2;

                semaphores.get(semID1).acquire();
                semaphores.get(semID2).acquire();

                file1 = files.get(id1);
                file2 = files.get(id2);


                try (Scanner sc = new Scanner(new File(file1));
                     PrintStream ps = new PrintStream(new FileOutputStream(file2, true));) {

                    String line = sc.nextLine();
                    ps.println("Thread:" + this.getId() + " => " + line);
                }

                semaphores.get(semID1).release();
                semaphores.get(semID2).release();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException | NoSuchElementException e) {
            System.out.println("Koniec watku: " + this.getId());
        }
    }
}
