import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class EventController {
    Input input = new Input();
    private LineStorage lineStorage;
    Scanner scanner = new Scanner(System.in);
//    private String line;
//
//    Event(String line) {
//        this.line = line;
//    }
//
//    public String getLine() {
//        return line;
//    }
    public EventController(){}
    ArrayList<ActionListener> actionListenerList;

    /**
     * Register an action event listener.
     */
    public synchronized void addActionListener(ActionListener l) {
        if (actionListenerList == null)
            actionListenerList = new ArrayList<ActionListener>();
        actionListenerList.add(l);
    }

    /**
     * Remove an action event listener.
     */
    public synchronized void removeActionListener(ActionListener l) {
        if (actionListenerList != null && actionListenerList.contains(l))
            actionListenerList.remove(l);
    }

    /**
     * Fire event.
     */
    private void processEvent(ActionEvent e) {
        ArrayList<ActionListener> list;

        synchronized (this) {
            if (actionListenerList == null) return;
            list = (ArrayList<ActionListener>)actionListenerList.clone();
        }

        for (int i = 0; i < list.size(); i++) {
            ActionListener listener = list.get(i);
            listener.actionPerformed(e);
        }
    }
}
