import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;

public class LineStorage implements ActionListener{
    private Input input = new Input();
    private ArrayList<String> lineStorage = new ArrayList<String>();

    public void insertLine(String addLine) {
        String newString = addLine.replaceAll("[^a-zA-Z0-9 ]","");
        lineStorage.add(newString);
    }

    String getLine(int index) {
        return lineStorage.get(index);
    }

    public void deleteLine(int lineIndex){lineStorage.remove(lineIndex);}

    public void deleteLine(String deleteString){
        int counter = 0;
        for(String each:lineStorage){
            if(each.equals(deleteString)){
                deleteLine(counter);
                return;
            }
            counter = counter+1;
        }
        System.out.println("Cannot find the instance of the String");
        return;
    }

    public ArrayList<String> getLineStorage(){return lineStorage;}

    public int size() {
        return lineStorage.size();
    }


    public ArrayList<String> addAll(LineStorage shift) {
        for(int i=0; i < shift.size(); i++){lineStorage.add(shift.getLine(i));}
        return lineStorage;
    }

    //Work on SetUP
    public void setup(LineStorage line) {
        LineStorage newStorage = new LineStorage();
        newStorage = line;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
