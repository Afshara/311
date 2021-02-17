public class CalculatorClient {

    static CalculatorView calculatorView = new CalculatorView();
    static CalculatorModel calculatorModel = new CalculatorModel("startState");
    static CalculatorController calculatorController = new CalculatorController();

    public CalculatorClient(String address, int port)
    {}

    public static void main(String[] args){
        calculatorController.setModel(calculatorModel);
        calculatorController.setCalculatorView(calculatorView);
        calculatorModel.setCalculatorView(calculatorView);
    }

}
