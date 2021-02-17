import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class AddLineEvent extends Event {

    private LineStorage lineStorage;

    public LineStorage getLineStorage() {
        return this.lineStorage;
    }

    public void setLineStorage(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    AddLineEvent(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }


    @Override
    public void actionPerformed(String event) throws FileNotFoundException, UnsupportedEncodingException {
        if(event.equals("a")){
            lineStorage.addLine();
        }
    }

}
