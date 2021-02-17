import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {

    public static void main(String[] args) throws IOException {
        int totalCorrectEquation = 0;
        ServerSocket server = new ServerSocket(9876);

        while(true){
            Socket client = server.accept();
            RequestHandler requestHandler = new RequestHandler(client);
            requestHandler.run();
            //THings to print in server
            if(requestHandler.getCount()){
                totalCorrectEquation +=1;
                System.out.println("the total number of all the successful calculated math equations: " + totalCorrectEquation);
            }
        }
    }
}
