import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public interface Observer {
    public void update(Event e) throws FileNotFoundException, UnsupportedEncodingException;
}
