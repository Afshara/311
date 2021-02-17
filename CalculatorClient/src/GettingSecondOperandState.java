import java.io.IOException;

public class GettingSecondOperandState implements CalculatorState {

    CalculatorStateList calculatorStateList;
    public GettingSecondOperandState(CalculatorStateList calculatorStateList1){
        this.calculatorStateList = calculatorStateList1;
    }

    @Override
    public void clear() {
        //setting current state to start state
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
        calculatorStateList.setModelEquation("");
        calculatorStateList.setDiscardTo("0");
    }

    @Override
    public void setOperator(String operatorEntered) throws IOException {
        //setting current state to waiting state
        calculatorStateList.sendToServer();
        calculatorStateList.addToModelEquation(" ");
        calculatorStateList.addToModelEquation(operatorEntered);
        calculatorStateList.addToModelEquation(" ");
        calculatorStateList.setCalculatorState(calculatorStateList.getWaitingNextOperandState());
    }


    @Override
    public void setOperand(String operandEntered) {
        //adding numbers to itself
        calculatorStateList.addToModelEquation(operandEntered);
    }

    @Override
    public void equal(String equalEntered) throws IOException {
        //setting current state to calculate state
        calculatorStateList.addToModelEquation(" ");
        calculatorStateList.addToModelEquation(equalEntered);
        calculatorStateList.setCalculatorState(calculatorStateList.getCalculateState());
        calculatorStateList.sendToServer();
    }
}
