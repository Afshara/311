import java.net.ServerSocket;
import java.net.Socket;

public class OddFinderServer {
    public static void main(String args[]) throws Exception{
        ServerSocket server = new ServerSocket(9876);

        while(true){
            Socket client = server.accept();

            RequestHandler rh = new RequestHandler(client);
            rh.start();
        }
    }
}
