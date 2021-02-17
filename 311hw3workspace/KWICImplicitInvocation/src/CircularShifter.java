import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CircularShifter implements Observer, Subject {
    private LineStorage lineStorage;

    LineStorage getLineStorage() {
        return this.lineStorage;
    }

    public CircularShifter(LineStorage lineStorage){
        this.lineStorage = lineStorage;
        lineStorage.register(this);
    }

    //UML
    public void shiftALine(String line){

    }

    public LineStorage getAShift(LineStorage shiftStorage) throws FileNotFoundException, UnsupportedEncodingException {
        LineStorage finalLineStorage = new LineStorage();
        for(String line: shiftStorage.getLineStorage()){
            LineStorage eachLine = new LineStorage();
            for(String word:line.split(" ")){
                eachLine.addLine(word);}
            LineStorage allLines = new LineStorage();
            for(int i=0; i < eachLine.size(); i++){
                String temp = eachLine.removeLine(0);
                //eachLine.
                eachLine.addLine(temp);
                allLines.addLine(String.join(" ", eachLine.getLineStorage()));
            }
            finalLineStorage.addAll(allLines);
            //shiftStorage.addAll(allLines);
        }
        return finalLineStorage;
    }

    //OBSERVER
    @Override
    public void update(Event e) throws FileNotFoundException, UnsupportedEncodingException {
        this.lineStorage = e.getLineStorage();
        this.lineStorage = getAShift(this.lineStorage);
        e.setLineStorage(this.lineStorage);
        //Add a setter
        notifyObserver(e);
    }

    //SUBJECT
    private ArrayList<Observer> observers;

    @Override
    public synchronized void register(Observer newObserver) {
        if (observers == null)
            observers = new ArrayList<Observer>();
        observers.add(newObserver);
    }

    @Override
    public synchronized void unregister(Observer deleteObserver) {
        if (observers != null && observers.contains(deleteObserver))
            observers.remove(deleteObserver);
    }

    //What to notify--> Gotta see and do
    @Override
    public void notifyObserver(Event e) throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<Observer> observersList;

        synchronized (this) {
            if (observers == null) return;
            observersList = (ArrayList<Observer>)observers.clone();
        }

        for (int i = 0; i < observersList.size(); i++) {
            Observer observer = observersList.get(i);
            observer.update(e);
        }
    }

}
