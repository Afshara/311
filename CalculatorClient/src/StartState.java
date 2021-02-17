public class StartState implements CalculatorState{

    CalculatorStateList calculatorStateList;

    public StartState(CalculatorStateList calculatorStateList1){
        this.calculatorStateList = calculatorStateList1;

    }

    @Override
    public void clear() {
        //returning to itself
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
        calculatorStateList.setModelEquation("");
        calculatorStateList.setDiscardTo("0");
    }

    @Override
    public void setOperator(String operatorEntered) {
        //returning to itself
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
    }

    @Override
    public void setOperand(String operandEntered) {
        //setting it to getting first operand
        calculatorStateList.setModelEquation(operandEntered);
        calculatorStateList.setCalculatorState(calculatorStateList.getGettingFirstOperandState());
    }

    @Override
    public void equal(String equalEntered) {
        //returning to itself
        calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
    }
}
