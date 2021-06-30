package PisarzeiczytelncyWyklad;

public class Main {
    public static void main(String[] args)
    {
        Czytelnia czytelnia=new Czytelnia();
        Pisarz pisarz = new Pisarz(czytelnia);
        CZytelnik[] czytelnicy = new CZytelnik[5];
        for(int i=0;i<czytelnicy.length;i++)
        {
            czytelnicy[i]=new CZytelnik(czytelnia);
        }
        pisarz.start();
        for(CZytelnik c: czytelnicy)c.start();
    }

}
