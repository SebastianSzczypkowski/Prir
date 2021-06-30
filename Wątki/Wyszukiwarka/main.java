package Wątki.Wyszukiwarka;

public class main {

    public static void main (String [] args) throws InterruptedException
    {
        String tablicaZnakow[] ={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","r","s","t","u","w","y","z","1","2","3","4","5","6","7","8","9","0"};
        int ileLosowac=300;
        String fileName = "src/tutu.txt";



        Thread losuj=new Thread(new Losuj(tablicaZnakow,ileLosowac,fileName));
        Thread szukajZnakow = new Thread(new SzukajZnakow(fileName));
        Thread szukajLiczb = new Thread(new SzukajLiczb(fileName));


       // losuj.start();
      // szukajLiczb.start();
      // szukajZnakow.start();
       // Thread.sleep(2000);
       // losuj.join();
       // szukajLiczb.join();
        //szukajZnakow.join();


    }
}
