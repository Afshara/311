public class WaitingNextOperandState implements CalculatorState {

    CalculatorStateList calculatorStateList;
    public WaitingNextOperandState(CalculatorStateList calculatorStateList1){
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
        calculatorStateList.setCalculatorState(calculatorStateList.getErrorState());
        calculatorStateList.setDiscardTo("2");
        calculatorStateList.setDiscardEquation(calculatorStateList.getModelEquation());
        calculatorStateList.setModelEquation("Error");
    }

    @Override
    public void setOperand(String operandEntered) {
        //setting it to getting second operand
        calculatorStateList.addToModelEquation(operandEntered);
        calculatorStateList.setCalculatorState(calculatorStateList.getGetGettingSecondOperandState());
    }

    @Override
    public void equal(String equalEntered) {
        calculatorStateList.setCalculatorState(calculatorStateList.getErrorState());
    }
}
