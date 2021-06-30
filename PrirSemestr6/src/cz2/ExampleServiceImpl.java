package cz2;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class ExampleServiceImpl implements ExampleService
{
    private int counter = 0;
    private List<String> messages;

    public ExampleServiceImpl()
    {
        messages = new ArrayList<>();
    }

    @Override
    public void sendMessage(String message)
    {
        if(!message.equals(""))
        {
            System.out.println("Odebrano wiad: "+message);
            messages.add(message);
            counter++;
        }
    }

    @Override
    public String getMessage()
    {
        String mess;
        if(messages.size()>0)
        {
            mess =  messages.get(messages.size()-1);
            System.out.println(mess);
            counter++;
        }
        else
        {
            mess = "Nie ma wiadomości!";
            System.out.println(mess);
        }
        return mess;
    }

    @Override
    public int getCounter() {
        return counter;
    }
}
