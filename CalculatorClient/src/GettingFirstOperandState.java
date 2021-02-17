import com.sun.jdi.IntegerValue;

public class GettingFirstOperandState implements CalculatorState {

    CalculatorStateList calculatorStateList;

    public GettingFirstOperandState(CalculatorStateList calculatorStateList1){
        this.calculatorStateList = calculatorStateList1;
    }

    @Override
    public void clear() {
        //returning to startState
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
        calculatorStateList.setModelEquation("");
        calculatorStateList.setDiscardTo("0");
    }

    @Override
    public void setOperator(String operatorEntered) {
        //setting the currentState to waitingNExt..state
        calculatorStateList.setCalculatorState(calculatorStateList.getWaitingNextOperandState());
        calculatorStateList.addToModelEquation(" ");
        calculatorStateList.addToModelEquation(operatorEntered);
        calculatorStateList.addToModelEquation(" ");
    }

    @Override
    public void setOperand(String operandEntered) {
        //adding numbers to itself
        calculatorStateList.addToModelEquation(operandEntered);
    }

    @Override
    public void equal(String equalEntered) {
        calculatorStateList.setCalculatorState(calculatorStateList.getErrorState());
        calculatorStateList.setDiscardTo("1");
        calculatorStateList.setDiscardEquation(calculatorStateList.getModelEquation());
        calculatorStateList.setModelEquation("Error");
    }
}
