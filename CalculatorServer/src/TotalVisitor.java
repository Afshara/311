import java.util.ArrayList;

public class TotalVisitor implements Visitor{
    ArrayList<String>  equationList = new ArrayList<String>();
    String operator="";

    @Override
    public void visit(ArithmeticComponent arithmeticComponent) {
        if(arithmeticComponent instanceof Operand){
            equationList.add(((Operand) arithmeticComponent).component);
        }
        else{
            operator = (((Operator) arithmeticComponent).component);
        }
    }

    public int getTotal(){
        Integer operand1 = Integer.parseInt(this.equationList.get(0));
        Integer operand2 = Integer.parseInt(this.equationList.get(1));
        Integer returnVal = 0;

            if(operator.equals("+")){
               returnVal = operand1 + operand2;
            }else if(operator.equals("-")){
                returnVal = operand1 - operand2;
            }
            else if(operator.equals("*")){
                returnVal = operand1 * operand2;
            }
            else if(operator.equals("/")){
                returnVal = operand1 / operand2;
            }

        return returnVal;
    }
}
