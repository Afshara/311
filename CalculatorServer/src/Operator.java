import java.util.ArrayList;
public class Operator extends ArithmeticComponent implements Visitable{

    ArrayList<ArithmeticComponent> arithmeticComponents = new ArrayList<ArithmeticComponent>();
    public String component;

    public Operator(String newComponent){
        this.component = newComponent;
    }

    public void add(ArithmeticComponent newArithmeticComponent){
        arithmeticComponents.add(newArithmeticComponent);
    }

    public void remove(ArithmeticComponent newArithmeticComponent){
        arithmeticComponents.remove(newArithmeticComponent);
    }

    public ArithmeticComponent getArithmeticComponent(int componentIndex) {
        return (ArithmeticComponent)arithmeticComponents.get(componentIndex);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for(ArithmeticComponent operand: arithmeticComponents){
            operand.accept(visitor);
        }
    }
}
