import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class CircularShift extends EventController implements ActionListener{
//WORK ON THIS
    private LineStorage shiftStorage;

    public CircularShift(LineStorage shiftStorage){
        this.shiftStorage= shiftStorage;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for(String line: shiftStorage.getLineStorage()){
            LineStorage eachLine = new LineStorage();
            for(String word:line.split(" ")){
                eachLine.insertLine(word);}
            LineStorage allLines = new LineStorage();
            for(int i=0; i < eachLine.getLineStorage().size(); i++){
                String temp = eachLine.getLine(0);
                eachLine.insertLine(temp);
                allLines.insertLine(String.join(" ", eachLine.getLineStorage()));
            }
            shiftStorage.addAll(allLines);
        }
    }
}
