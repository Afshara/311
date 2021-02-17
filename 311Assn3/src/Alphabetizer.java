import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer extends EventController implements ActionListener {
//WORK ON THIS
    private LineStorage lineStorage;

    public Alphabetizer(LineStorage lineStorage){
        this.lineStorage= lineStorage;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Collections.sort(lineStorage.getLineStorage(), String.CASE_INSENSITIVE_ORDER);
    }
}
