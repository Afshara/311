// A Java program for a Client
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;


class IntegerClass implements Serializable {
    private final Integer integerr;

    public IntegerClass(Integer integerr) {
        this.integerr = integerr;
    }

    public Integer getIntegerr() {
        return integerr;
    }
}


public class NumberFeederClient {
    // constructor to put ip address and port 
    public NumberFeederClient(String address, int port)
    {}

    public static void main(String args[]) throws IOException, ClassNotFoundException {
       //Create a socket to connect to the server
        Socket socket = new Socket("127.0.0.1",9876);
        OutputStream outputStream= socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Scanner scanner = new Scanner(System.in);
        List<IntegerClass> integers = new ArrayList<>();

        System.out.println("Input an integer");
        System.out.println("Input 'quit' to Exit");
        String input = scanner.nextLine();

        //Input an integer, add it to array list and send it to server
        while(!input.equals("quit")){
            try{
                // the String to int conversion happens here
                int i = Integer.parseInt(input);
                integers.add(new IntegerClass(i));
            }
            catch (NumberFormatException nfe){
                System.out.println("NumberFormatException");
            }
            System.out.println("Input an integer");
            System.out.println("Input 'quit' to Exit");
            input = scanner.nextLine();
        }
        //Sending it to server
        objectOutputStream.writeObject(integers);

        //create an InputStrean to read the response
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            @SuppressWarnings("unchecked")
            List<IntegerClass> oddIntegers = (List<IntegerClass>) objectInputStream.readObject();
            System.out.println("Odd Array Received");
            int totalOddNum=1;
            for(IntegerClass element : oddIntegers){
                   System.out.println(element.getIntegerr());
                   totalOddNum +=1;
            }
            System.out.println("Odd Array Size: " + totalOddNum);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        objectOutputStream.close();
        socket.close();
    }
} 