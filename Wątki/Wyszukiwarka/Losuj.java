package Wątki.Wyszukiwarka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Losuj extends Thread{

    int dlugosc;
    int wylosowana;
    String tablica[];
    String file;



    Random random = new Random();
    Losuj(String tablica [],int ile,String filename)
    {
        this.tablica=tablica;
        this.dlugosc=ile;
        this.file=filename;


    }

    public void run()
    {
            try {

                Scanner sc = new Scanner(new File(file));
                PrintStream ps = new PrintStream(new FileOutputStream(file));
                for(int i=0;i<dlugosc;i++) {
                    wylosowana = random.nextInt(tablica.length);
                    ps.println(tablica[wylosowana]);
                }


            } catch (FileNotFoundException  e) {
                e.printStackTrace();

            }
    }
}
