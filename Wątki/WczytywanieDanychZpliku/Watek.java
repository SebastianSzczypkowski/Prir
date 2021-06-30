package Wątki.WczytywanieDanychZpliku;

public class Watek extends Thread {

    static double lowerPay = 10000;
    static double largestPay =0;
    int fromID;
    int toID;
    Zbior zbior;

    Watek(Zbior zbior,int fromID,int toID)
    {
        this.zbior=zbior;
        this.fromID=fromID;
        this.toID=toID;
        System.out.println("Zadany zakres : od "+fromID+" do "+toID);
    }
    @Override
    public void run()
    {
        lookForLowlest();
       lookForLargestPay();
       medium();

    }

    synchronized void lookForLowlest() {
        System.out.println("Start wątku.");
        for(int i=fromID;i<toID;i++)
        {
            if(zbior.getdane().get(i)<lowerPay)
            {
                lowerPay=zbior.getdane().get(i);
            }
        }
    }
    synchronized void lookForLargestPay()
    {
        System.out.println("-----------");
        for(int i=fromID;i<toID;i++)
        {
            if(zbior.getdane().get(i)>largestPay);
            {
                largestPay=zbior.getdane().get(i);
            }
        }
    }
    synchronized void medium()
    {
        double mediumPay=0;
        int counter = toID-fromID;
        System.out.println("----------");
        for(int i=fromID;i<toID;i++)
        {
            mediumPay+=zbior.getdane().get(i);

        }
        mediumPay=mediumPay/counter;
        System.out.println("Srednie zarobki: "+mediumPay);
    }

}
