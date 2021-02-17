import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class MasterController{
    //The subject
    static LineStorage lineStorage = new LineStorage();
    //EventHandlers
    static Event addLineEvent = new AddLineEvent(lineStorage);
    static Event deleteLineEvent = new DeleteLineEvent(lineStorage);
    static Event printLineEvent = new PrintLineEvent(lineStorage);
    static Event quitEvent = new QuitEvent(lineStorage);

    //The observers
    static CircularShifter circularShifter = new CircularShifter(lineStorage);
    static Alphabetizer alphabetizer = new Alphabetizer(circularShifter);
    static Output output = new Output(alphabetizer);

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Input input = new Input();
        String eventCommand;

        System.out.println("Welcome to Interactive KWIC System\n");
        System.out.println("Type 'C' for Console Input\n");
        System.out.println("Type 'F' for File Input\n");
        input.readInput(lineStorage,input.readInput());

        while (true){
            System.out.println("Add command for adding a new line when typing in 'a'\n");
            System.out.println("Delete command for deleting a line when typing in 'd'\n");
            System.out.println("Print command for printing shifts sorted alphabetically when typing in 'p'\n");
            System.out.println("Quit command for exiting the system when typing in 'q'\n");
            eventCommand = input.readInput();
            if(eventCommand.equals("d")){
                deleteLineEvent.actionPerformed(eventCommand);
            }
            else if(eventCommand.equals("a")){
                addLineEvent.actionPerformed(eventCommand);
            }
            else if(eventCommand.equals("p")){
                printLineEvent.actionPerformed(eventCommand);
            }
            else if(eventCommand.equals("q")){
                quitEvent.actionPerformed(eventCommand);
            }
        }
    }
}
