package UslugiSieciowe.src.Uslugisiecowecz1;

import UslugiSieciowe.src.Uslugisiecowecz1.Kalkulator;
import UslugiSieciowe.src.Uslugisiecowecz1.KalkulatorImpl;
import org.apache.cxf.frontend.ServerFactoryBean;

public class Serwer {

    public static void main(String args[]) throws InterruptedException
    {
        Kalkulator kalkulator= new KalkulatorImpl();
        ServerFactoryBean factory=new ServerFactoryBean();
        factory.setServiceClass(Kalkulator.class);
        factory.setAddress("http://localhost:5000/Kalkulator");
        factory.setServiceBean(kalkulator);
        factory.create();
    }

}
