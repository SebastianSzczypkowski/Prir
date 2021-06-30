package Wątki.Wyszukiwarka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class SzukajLiczb extends Thread{

    String file;

    SzukajLiczb(String filename)
    {
        this.file=filename;
    }

    public void run()
    {

        try
        {

            Scanner sc = new Scanner(new File(file));
            Map<String,Integer> mapa =new HashMap<>();
            Pattern pattern = Pattern.compile("\\d");
            while (sc.hasNext())
            {
                String s=sc.findInLine(pattern);
                if(mapa.containsKey(s))
                {
                    int k=mapa.get(s);
                    k++;
                    mapa.put(s,k);
                }
                else {
                    mapa.put(s,1);
                }
            }
            Set<String> set =mapa.keySet();
            for(String s:set)
            {
                System.out.println(s+ " | "+mapa.get(s));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
