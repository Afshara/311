import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;

public class Input{
    private LineStorage lineStorage;
    Scanner scanner = new Scanner(System.in);

    public String getInput(){
        String oneLine = scanner.nextLine();
        while (oneLine.isEmpty() | oneLine.isBlank()){
            System.out.println("Blanks and spaces cannot be accepted as a response");
            oneLine = scanner.nextLine();
        }
       return oneLine;
    }

    public LineStorage getInput(LineStorage lineStorage) {
        String oneLine = scanner.nextLine();
        while (oneLine.isEmpty() | oneLine.isBlank()){
            System.out.println("Blanks and spaces cannot be accepted as a response");
            oneLine = scanner.nextLine();
        }
        lineStorage.insertLine(oneLine);
        return lineStorage;
        }

    public LineStorage getInput(LineStorage lineStorage,String fileName) {
        BufferedReader reader;
        //LineStorage lineStorage = new LineStorage();
        try {
            reader = new BufferedReader(new FileReader("./storedFiles/"+fileName+".txt"));
            String line = reader.readLine();
            while (line != null) {
                lineStorage.insertLine(line);
                line = reader.readLine();}
            reader.close();
            return lineStorage;
        }
        catch (IOException e){e.printStackTrace();}
        //LOOK AT THIS LATER
        System.out.println("File Count not be loaded");
        return lineStorage;
    }

    private class AddLineListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            lineStorage.insertLine(getInput());
        }
    }

    private class DeleteLineListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String deleteString = getInput();
            lineStorage.deleteLine(deleteString);
        }
    }
}
