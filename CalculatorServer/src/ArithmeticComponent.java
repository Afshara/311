public abstract class ArithmeticComponent {

    public String getComponent;

    // This allows me to add components
    public void add(ArithmeticComponent newArithmeticComponent){
        throw new UnsupportedOperationException();
    }

    // This allows me to remove components
    public void remove(ArithmeticComponent newArithmeticComponent){
        throw new UnsupportedOperationException();
    }

    // This allows me to get components
    public ArithmeticComponent getArithmeticComponent(int componentIndex){
        throw new UnsupportedOperationException();
    }


    protected abstract void accept(Visitor visitor);
}
