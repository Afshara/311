
import java.util.Scanner;

public class Main {
    static FileVerification fileVerification = new FileVerification();
    static Scanner scanner = new Scanner(System.in);

    static LineStorage lineStorage = new LineStorage();
    static LineStorage shiftStorage = new LineStorage();

    static Input input = new Input();
    static CircularShift circularShift = new CircularShift(lineStorage);
    static Alphabetizer alphabetizer = new Alphabetizer(lineStorage);
    static Output output = new Output();


    public static void main(String[] args) {
        System.out.println("Welcome to Interactive KWIC System\n");
        System.out.println("Type 'A' for Console Input\n");
        System.out.println("Type 'B' for File Input\n");
        System.out.println("Type 'EXIT' to exit the system\n");
        String inputType = scanner.nextLine();
        //Console Input
        if(inputType.toUpperCase().equals("A")){
            lineStorage= input.getInput(lineStorage);}
        //File Input
        else if(inputType.toUpperCase().equals("B")){
            System.out.println("Type Filename:");
            String inputFile = scanner.nextLine();
            if(fileVerification.fileExistCheck(inputFile,"2").equals(Boolean.FALSE)){
               lineStorage = input.getInput(lineStorage,inputFile);}
            else{System.out.println("The file name does not exist, Please create a file first.\n");}}
        else{
            System.out.println("Exiting the system");
            System.exit(0);}

        System.out.println("Add command for adding a new line when typing in 'a'\n");
        System.out.println("Delete command for deleting a line when typing in 'd'\n");
        System.out.println("Print command for printing shifts sorted alphabetically when typing in 'p'\n");
        System.out.println("Quit command for exiting the system when typing in 'q'\n");

        EventController controller = new EventController();
        String command = "";
        while(!command.equals("q")){
            System.out.println("Add, Delete, Print, Quit: ");
            command = scanner.nextLine();

            if(command.equals("a")){
                lineStorage.setup(lineStorage);
            }

            else if(command.equals("d")){

            }
            else if(command.equals("p")){
                output.getOutput(lineStorage);
            }
        }
    }
}
