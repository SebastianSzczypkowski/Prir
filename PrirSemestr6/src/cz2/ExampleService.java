package cz2;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="MojPrzykład" ,targetNamespace="http://cz2",endpointInterface = "cz2.ExampleService")
public interface ExampleService {

    @WebMethod(operationName = "wyslijwiadomosc")
    void sendMessage(@WebParam(name="wiadomosc")String message);
    @WebMethod(operationName = "pobierzWiadomosc")
    @WebResult(name="NapisWczesniejOdebranyPrzezSerwis") String getMessage();

    @WebMethod(operationName = "pobierzLicznik")
    @WebResult(name = "liczbaWywolanWyslijWiadomosc") int getCounter();
}
