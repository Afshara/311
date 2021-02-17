import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class LineStorage  implements Subject{
    private ArrayList<Observer> observers;
    private ArrayList<String> lineStorage;
    Input input;
    private AddLineEvent addLineEvent;
    private  DeleteLineEvent deleteLineEvent;
    private PrintLineEvent printLineEvent;
    private QuitEvent quitEvent;
    private Boolean ouputNow = Boolean.FALSE;
    Scanner scanner = new Scanner(System.in);

    public LineStorage(){
        this.lineStorage= new ArrayList<String>();
        observers = new ArrayList<Observer>();
    }

    //UML

    public void getWord(int aWordIndex, int aLineIndex){}

    public void deleteLine(String line) throws FileNotFoundException, UnsupportedEncodingException {
        lineStorage.indexOf(line);
        notifyObserver(deleteLineEvent);

    }

    public void deleteLine() throws FileNotFoundException, UnsupportedEncodingException {
        //String bye = input.readInput();
        System.out.println("Enter the string you want to delete");
        String bye = scanner.nextLine();
        int index = lineStorage.indexOf(bye);
        lineStorage.remove(index);
        //deleteLineEvent = new DeleteLineEvent(this);
        //notifyObserver(deleteLineEvent);

    }

    public void addLine(String oneLine) throws FileNotFoundException, UnsupportedEncodingException {
        this.lineStorage.add(oneLine);
    }

    public void addLine() throws FileNotFoundException, UnsupportedEncodingException {
        Scanner scanner = new Scanner(System.in);
        String addd = scanner.nextLine();
        this.lineStorage.add(addd);
        addLineEvent = new AddLineEvent(this);
        notifyObserver(addLineEvent);
        return;
    }

    public String removeLine(int lineIndex){return lineStorage.remove(lineIndex);}

    public int size() {
        return lineStorage.size();
    }

    public ArrayList<String> addAll(LineStorage shift) {
        for(int i=0; i < shift.size(); i++){lineStorage.add(shift.getLine(i));}
        return lineStorage;
    }

    String getLine(int index) {
        return lineStorage.get(index);
    }

    public int getCount(){
        //No idea what to return
        return 0;
    }

    public void setOuputNow(Boolean ouputNow) throws FileNotFoundException, UnsupportedEncodingException {
        this.ouputNow = ouputNow;
        quitEvent = new QuitEvent(this);
        notifyObserver(quitEvent);
    }

    public Boolean getOuputNow() {
        return this.ouputNow;
    }

    public ArrayList<String> getLineStorage(){return this.lineStorage;}

    public void printLineStorage() throws FileNotFoundException, UnsupportedEncodingException {
//        for(String each: lineStorage){
//            System.out.println(each);
//        }
        printLineEvent = new PrintLineEvent(this);
        notifyObserver(printLineEvent);
    }

    public void printLine() throws FileNotFoundException, UnsupportedEncodingException {
        for(String each: lineStorage){
            System.out.println(each);
        }
    }
    //Subject
    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver(Event event) throws FileNotFoundException, UnsupportedEncodingException {
        for(Observer observer : observers){
            observer.update(event);
        }
    }

}
