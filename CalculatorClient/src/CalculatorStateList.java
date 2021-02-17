import java.io.IOException;

public class CalculatorStateList {
    String modelName;
    CalculatorState startState;
    CalculatorState gettingFirstOperandState;
    CalculatorState waitingNextOperandState;
    CalculatorState gettingSecondOperandState;
    CalculatorState errorState;
    CalculatorState calculateState;

    CalculatorState currentState;

    String discardTo;
    String discardEquation;

    String modelEquation;

    public CalculatorStateList(){
        modelName = "";
        this.discardTo = "";
        this.modelEquation="";
        this.discardEquation = "";
        startState = new StartState(this);
        gettingFirstOperandState = new GettingFirstOperandState(this);
        waitingNextOperandState = new WaitingNextOperandState(this);
        gettingSecondOperandState = new GettingSecondOperandState(this);
        errorState = new ErrorState(this);
        calculateState = new CalculateState(this);

        //starting the calculator
        currentState = startState;
    }

    public CalculatorStateList(String modelname){
        modelName = modelname;
        this.discardTo = "";
        this.modelEquation="";
        this.discardEquation = "";
        startState = new StartState(this);
        gettingFirstOperandState = new GettingFirstOperandState(this);
        waitingNextOperandState = new WaitingNextOperandState(this);
        gettingSecondOperandState = new GettingSecondOperandState(this);
        errorState = new ErrorState(this);
        calculateState = new CalculateState(this);

        //starting the calculator
        currentState = startState;
    }

    public String getModelEquation() {
        return modelEquation;
    }

    public void setModelEquation(String modelEquation) {
        this.modelEquation = modelEquation;
    }

    public void addToModelEquation(String modelEquation) {
        this.modelEquation += modelEquation;
    }

    public String getDiscardEquation() {
        return discardEquation;
    }

    public void setDiscardEquation(String discardEquation) {
        this.discardEquation = discardEquation;
    }

    public void sendToServer() throws IOException {
    }

    void setCalculatorState(CalculatorState newState){
        currentState = newState;
    }

    public void display(String discarding) {}

    //Setters
    public void clear(){
        currentState.clear();
    }

    public void setOperator(String operatorEntered) throws IOException {
        currentState.setOperator(operatorEntered);
    }

    void setOperand(String operandEntered){
        currentState.setOperand(operandEntered);
    }

    public void equal(String equalEntered) throws IOException {
        currentState.equal(equalEntered);
    }

    public void setDiscardTo(String num){
        this.discardTo = num;
    }

    public String getDiscardTo() {
        return this.discardTo;
    }

    //Getters
    public CalculatorState getGetGettingSecondOperandState() {
        return gettingSecondOperandState;
    }

    public CalculatorState getGettingFirstOperandState() {
        return gettingFirstOperandState;
    }

    public CalculatorState getErrorState() {
        return errorState;
    }

    public CalculatorState getCalculateState() {
        return calculateState;
    }

    public CalculatorState getStartState() {
        return startState;
    }

    public CalculatorState getCurrentState() {
        return currentState;
    }

    public CalculatorState getWaitingNextOperandState() {
        return waitingNextOperandState;
    }
}
