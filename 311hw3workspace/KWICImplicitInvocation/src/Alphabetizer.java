import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer implements Observer,Subject {
    private ArrayList<Observer> observers;
    private LineStorage lineStorage;
    private CircularShifter circularShifter;

    public Alphabetizer(CircularShifter circularShifter){
        this.lineStorage = circularShifter.getLineStorage();
        circularShifter.register(this);
    }

    private void sortByAlpha(CircularShifter circularShifter) throws FileNotFoundException, UnsupportedEncodingException {
        //this.lineStorage = circularShifter.getLineStorage();
        Collections.sort(this.lineStorage.getLineStorage(), String.CASE_INSENSITIVE_ORDER);
        lineStorage.printLine();
        //this.lineStorage.printLineStorage();
    }



    LineStorage getLineStorage() {
        return this.lineStorage;
    }
    //Observer
    @Override
    public void update(Event e) throws FileNotFoundException, UnsupportedEncodingException {
        this.lineStorage = e.getLineStorage();
        sortByAlpha(circularShifter);
        notifyObserver(e);
    }


    //Subject
    @Override
    public void register(Observer o) {
    }

    @Override
    public void unregister(Observer o) {
    }

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
