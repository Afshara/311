import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

//Each object of this class represents a GUI enhanced model of a list of cities.
public class CalculatorModel extends CalculatorStateList {

    /**
     * List to keep track of who is registered to listen for events from the CityModel.
     */
    private ArrayList<ActionListener> actionListenerList;
    private CalculatorView calculatorView;



    public CalculatorModel(String currentState){
        super(currentState);
    }

    public void setCalculatorView(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;}

    //Setters
    @Override
    public void sendToServer() throws IOException {

        //Sending to server
        Socket socket = new Socket("127.0.0.1",9876);

        //Writing to outputStream
        OutputStream outputStream= socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(super.modelEquation);
        calculatorView.enterInputFields(super.modelEquation);

        //receiving from server
        try {
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            @SuppressWarnings("unchecked")
            Integer receivedInput = (Integer) objectInputStream.readObject();
            String finalReceivedInput = String.valueOf(receivedInput);
            super.setModelEquation(finalReceivedInput);
            calculatorView.enterInputFields(super.modelEquation);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear(){

        super.clear();
        calculatorView.enterInputFields(super.modelEquation);
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "clearing the Calculator"));
    }


    public void setOperator(String operatorEntered) throws IOException {
        super.setOperator(operatorEntered);
        calculatorView.enterInputFields(super.modelEquation);
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "setting operator in the Calculator"));
    }

    void setOperand(String operandEntered){
        super.setOperand(operandEntered);
        calculatorView.enterInputFields(super.modelEquation);
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "setting operand in the Calculator"));
    }

    public void equal(String equalEntered) throws IOException {
        super.equal(equalEntered);
        calculatorView.enterInputFields(super.modelEquation);
        processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "setting equal sign in the Calculator"));
    }



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
