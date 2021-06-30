package UslugiSieciowe.src.Uslugisiecowecz1;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

public class Client {
    public static void main (String[] args)
    {
        ClientProxyFactoryBean clientFactory=new ClientProxyFactoryBean();
        clientFactory.setAddress("http://localhost:5000/Kalkulator");
        Kalkulator kalkulator=clientFactory.create(Kalkulator.class);

        System.out.println("Obliczenia dla 5 i 9");
        System.out.println(kalkulator.dodaj(5,9));
        System.out.println(kalkulator.odejmij(5,9));
        System.out.println(kalkulator.mnoz(5,9));
        System.out.println(kalkulator.dziel(5,9));



    }

}
