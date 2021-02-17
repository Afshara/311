import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;

class IntegerClass implements Serializable {
    private final Integer integerr;

    public IntegerClass(Integer integerr) {
        this.integerr = integerr;
    }

    public Integer getIntegerr() {
        return integerr;
    }
}

public class RequestHandler extends Thread implements Serializable{
    private Socket clientSocket = null;
    public RequestHandler(Socket _clientSocket){
        clientSocket = _clientSocket;
    }

    public void run(){

        int val;
        System.out.println("ServerSocket awaiting connections...");

        try{

            InputStream inputStream =  clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            @SuppressWarnings("unchecked")
            List<IntegerClass> oddIntegers = (List<IntegerClass>) objectInputStream.readObject();
            List<IntegerClass> integers = new ArrayList<>();

            for(IntegerClass element : oddIntegers){
                System.out.println(element.getIntegerr());
                if(element.getIntegerr() %2 ==1){
                   val  = element.getIntegerr();
                   integers.add(new IntegerClass(val));
                }

            }

            OutputStream outputStream= clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(integers);

            inputStream.close();
            objectInputStream.close();
            clientSocket.close();

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
