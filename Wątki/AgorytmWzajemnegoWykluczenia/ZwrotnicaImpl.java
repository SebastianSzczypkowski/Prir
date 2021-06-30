package Wątki.AgorytmWzajemnegoWykluczenia;

public class ZwrotnicaImpl implements Zwrotnica{

    public volatile  boolean flagaA;
    public volatile  boolean flagaB;
    public volatile int turn;


    @Override
    public void ZwrotnicaNaTorAStart() {
        flagaA = true;
        turn =2;
        do{


        }while(!(turn==1 || flagaB==true));
    }

    @Override
    public void ZwrotnicaNaTorBStart() {
    flagaB=true;
    turn=1;
    do
        {

        }while((!(turn==2||flagaA==false)));
    }



    @Override
    public void ZwrotnicanaTorAKoniec() {
        flagaA=false;

    }

    @Override
    public void ZwrotnicaNaTorBKoniec() {
        flagaB=false;
    }
}
