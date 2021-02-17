import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface Subject {
    public void register(Observer o);

    public void unregister(Observer o);

    public void notifyObserver(Event e) throws FileNotFoundException, UnsupportedEncodingException;
}
