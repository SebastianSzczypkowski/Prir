package cz2;



import org.apache.cxf.ext.logging.LoggingFeature;

import javax.xml.ws.Endpoint;

public class Server {

    public static void main(String[] args)throws InterruptedException
    {
        ExampleService implementacja = new ExampleServiceImpl();
        Endpoint.publish("http://127.0.0.1:9090/Test",implementacja,new LoggingFeature());
    }
}
