package Wątki.WczytywanieDanychZpliku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main (String [] args) throws InterruptedException
    {

        System.out.println("Podaj ile chcesz użyc wątków:");
        Scanner scanner =new Scanner(System.in);
        int threads =scanner.nextInt();
        System.out.println("Użyjemy " +threads+" wątków");

        try(Scanner sc= new Scanner(new File("src/dane.txt")))
        {
            Zbior zbior = new Zbior();

            while(sc.hasNext())
            {
                String s =sc.next();
                String [] wiersz = s.split(";");
                int id_osoby = Integer.parseInt(wiersz[0]);
                double wynagrodzenie = Double.parseDouble(wiersz[1]);
                zbior.getdane().put(id_osoby,wynagrodzenie);
            }
            System.out.println("Została wczytana nastepując ilośc wierszy: "+zbior.getdane().size());

            long time = System.currentTimeMillis();
            Watek tablicaWatkow[] = new Watek[threads];
            for(int i=0;i<threads;i++)
            {
                int howMuch = (zbior.getdane().size()/threads);
                int startIndex =i*howMuch;
                int endIndex = startIndex+howMuch;
                tablicaWatkow[i] =new Watek(zbior,startIndex,endIndex);
                tablicaWatkow[i].start();
                tablicaWatkow[i].join();
            }
            long end = System.currentTimeMillis()-time;
            System.out.println("Czas Wykonania: "+end+ " milisekund");
            System.out.println("Najmniejsze wynagrodzenie: "+Watek.lowerPay);
            System.out.println("Najwyższe wynagrodzenie: "+Watek.largestPay);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
