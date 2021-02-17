import java.io.*;
import java.net.Socket;
import java.util.regex.PatternSyntaxException;

public class RequestHandler extends Thread {
    private Socket clientSocket = null;
    Boolean count=false;

    public RequestHandler(Socket _clientSocket) {
        clientSocket = _clientSocket;
    }

    public Boolean getCount(){
        return this.count;
    }

    public void setCount(Boolean count) {
        this.count = count;
    }

    public void run(){
        System.out.println("ServerSocket awaiting connections...");
        try{
            //Receiving from Client
            InputStream inputStream =  clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            String testString = (String) objectInputStream.readObject();

            String[] expression = new String[0];

            try {
               expression = testString.split(" ");
            } catch (PatternSyntaxException ex) {
                //
            }

            //Sending to client
            ArithmeticComponent operatorA = new Operator(expression[1]);
            ArithmeticComponent operandA = new Operand(expression[0]);
            ArithmeticComponent operandB = new Operand(expression[2]);

            operatorA.add(operandA);
            operatorA.add(operandB);

            TotalVisitor totalVisitor = new TotalVisitor();
            ((ArithmeticComponent)operatorA).accept(totalVisitor);
            int total = totalVisitor.getTotal();

            if(expression.length ==4){
                setCount(true);
                System.out.println("==Successful Equations==");
                System.out.println(testString+total);
            }
            else{setCount(false);}

            //sending back to the client
            OutputStream outputStream= clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(total);
            inputStream.close();
            objectInputStream.close();
            clientSocket.close();

        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
