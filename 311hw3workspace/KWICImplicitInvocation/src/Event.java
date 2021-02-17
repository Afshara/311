import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public abstract class Event{
    public Event(MasterController masterController, LineStorage lineStorage){}

    public Event() {}

    public abstract void actionPerformed(String event) throws FileNotFoundException, UnsupportedEncodingException;

    public abstract LineStorage getLineStorage();
    public abstract void setLineStorage(LineStorage lineStorage);

}
