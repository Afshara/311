import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class PrintLineEvent extends Event {
    private LineStorage lineStorage;

    public LineStorage getLineStorage() {
        return lineStorage;
    }

    public void setLineStorage(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    PrintLineEvent(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    @Override
    public void actionPerformed(String event) throws FileNotFoundException, UnsupportedEncodingException {
        if(event.equals("p")){
            lineStorage.printLineStorage();
        }
    }


}
