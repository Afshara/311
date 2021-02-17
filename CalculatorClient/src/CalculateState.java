
public class CalculateState implements CalculatorState {
    CalculatorStateList calculatorStateList;
    public CalculateState(CalculatorStateList calculatorStateList1){
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
        //returning to startState
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());

    }

    @Override
    public void setOperand(String operandEntered) {
        //returning to getting first operand State
        calculatorStateList.setCalculatorState(calculatorStateList.getGettingFirstOperandState());
        calculatorStateList.setModelEquation(operandEntered);
    }

    @Override
    public void equal(String equalEntered) {
        //returning to startState
        //READY TO SEND TO THE SERVER
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
    }
}
