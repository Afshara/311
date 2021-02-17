public class ErrorState implements CalculatorState{

    CalculatorStateList calculatorStateList;
    public ErrorState(CalculatorStateList calculatorStateList1){
        this.calculatorStateList = calculatorStateList1;

    }


    @Override
    public void clear() {
        String checker = calculatorStateList.getDiscardTo();

        if(checker.equals("1")){
            calculatorStateList.setCalculatorState(calculatorStateList.getGettingFirstOperandState());
            calculatorStateList.setModelEquation(calculatorStateList.getDiscardEquation());
            calculatorStateList.setDiscardTo("0");
        }
        else  if(checker.equals("2")){
            calculatorStateList.setCalculatorState(calculatorStateList.getWaitingNextOperandState());
            calculatorStateList.setModelEquation(calculatorStateList.getDiscardEquation());
            calculatorStateList.setDiscardTo("0");
        }
        else{
            calculatorStateList.display("Resetting");
            calculatorStateList.setCalculatorState(calculatorStateList.getStartState());
            calculatorStateList.setModelEquation("");
        }
    }

    @Override
    public void setOperator(String operatorEntered) {
        //nothing to do
    }

    @Override
    public void setOperand(String operandEntered) {
        //nothing to do
    }

    @Override
    public void equal(String equalEntered) {
    //nothing to do
    }
}
