import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class DeleteLineEvent extends Event {
    private LineStorage lineStorage;
    public LineStorage getLineStorage() {
        return lineStorage;
    }

    public void setLineStorage(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    DeleteLineEvent(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    @Override
    public void actionPerformed(String event) throws FileNotFoundException, UnsupportedEncodingException {
        if(event.equals("d")){
            this.lineStorage.deleteLine();
        }
    }


}
