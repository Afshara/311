import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class QuitEvent extends Event {
    private LineStorage lineStorage;

    public LineStorage getLineStorage(){
        return this.lineStorage;
    }

    public void setLineStorage(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    QuitEvent(LineStorage lineStorage) {
        this.lineStorage = lineStorage;
    }

    @Override
    public void actionPerformed(String event) throws FileNotFoundException, UnsupportedEncodingException {
        if(event.equals("q")){
            System.out.println("Exiting the system");
            System.exit(0);
            //lineStorage.setOuputNow(Boolean.TRUE);
        }
    }
}
