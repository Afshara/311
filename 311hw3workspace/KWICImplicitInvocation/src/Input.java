import java.io.*;
import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);
    BufferedReader reader;

    public Integer checkNum(String input) {
        while(true){
            try {
                Integer numberC = Integer.parseInt(input);
                return numberC;}
            catch(Exception e){
                System.out.println("Please Input an integer type");
                break;}
        }
        return 0;
    }

    public String readInput(){
        String bye = scanner.nextLine();
        return bye;
    }

    public void readInput(LineStorage lineStorage, String type) throws FileNotFoundException, UnsupportedEncodingException {
        String oneLine;
        if (type.equals("C")){
            System.out.println("Enter the number of lines you want to enter");
            int lineNum = checkNum(scanner.nextLine());
            for(int i=0; i<lineNum;i++) {
                System.out.println("Input a line");
                oneLine = scanner.nextLine();
                lineStorage.addLine(oneLine);
                while (oneLine.isEmpty() | oneLine.isBlank()) {
                    System.out.println("Blanks and spaces cannot be accepted as a response");
                    oneLine = scanner.nextLine();
                }
            }
        }

        else if (type.equals("F")){
            System.out.println("Enter the filename");
            String fileName = scanner.nextLine();

            try {
                reader = new BufferedReader(new FileReader("./storedFiles/"+fileName+".txt"));
                String line = reader.readLine();
                while (line != null) {
                    lineStorage.addLine(line);
                    line = reader.readLine();
                }
                reader.close();
            }
            catch (IOException e){e.printStackTrace();}
        }

        else{
            System.out.println("Wrong Input Type.");
            System.out.println("Exiting the System");
            System.exit(0);
        }

    }

}
