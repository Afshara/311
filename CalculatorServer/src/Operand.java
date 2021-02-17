public class Operand extends ArithmeticComponent implements Visitable{

    public String component;

    public Operand(String newComponent){
        this.component = newComponent;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
