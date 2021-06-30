package Wątki.Wyszukiwarka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class SzukajZnakow extends Thread{

    String file;


    SzukajZnakow(String filename)
    {
     this.file=filename;

    }

    public void run()
    {

        try(Scanner sc = new Scanner(new File(file))) {

            Pattern pattern = Pattern.compile("\\w");
            Map<String,Integer> mapa = new HashMap<>();
            while(sc.hasNext())
            {
                String znak =sc.findInLine(pattern);
                if(mapa.containsKey(znak))
                {
                    int k=mapa.get(znak);
                    k++;
                    mapa.put(znak,k);
                }
                else
                {
                    mapa.put(znak,1);
                }
            }
            Set<String> set =mapa.keySet();
            for(String s:set)
            {
                 System.out.println(s+" | "+mapa.get(s));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
