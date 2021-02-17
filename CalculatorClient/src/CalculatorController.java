import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalculatorController {
    private CalculatorModel calculatorModel;
    private CalculatorView calculatorView;


    public CalculatorController(){
        // intentionally empty
    }

    private class operand1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("1");
        }
    }

    private class operand2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("2");
        }
    }

    private class operand3Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("3");
        }
    }

    private class operand4Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("4");
        }
    }

    private class operand5Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("5");
        }
    }

    private class operand6Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("6");
        }
    }

    private class operand7Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("7");
        }
    }

    private class operand8Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("8");
        }
    }

    private class operand9Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("9");
        }
    }

    private class operand0Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.setOperand("0");
        }
    }

    private class operatorAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calculatorModel.setOperator("+");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class operatorSubListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calculatorModel.setOperator("-");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class operatorMulListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calculatorModel.setOperator("*");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class operatorDivListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calculatorModel.setOperator("/");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    private class equalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                calculatorModel.equal("=");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


    private class clearFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.clear();
        }
    }

    public void setModel(CalculatorModel calculatorModel) {
        this.calculatorModel = calculatorModel;
    }

    public CalculatorModel getModel() { // future use
        return this.calculatorModel;
    }

    public void setCalculatorView(CalculatorView calculatorView) {
        this.calculatorView = calculatorView;

        // Register listeners
        calculatorView.getB0().addActionListener(new operand0Listener());
        calculatorView.getB1().addActionListener(new operand1Listener());
        calculatorView.getB2().addActionListener(new operand2Listener());
        calculatorView.getB3().addActionListener(new operand3Listener());
        calculatorView.getB4().addActionListener(new operand4Listener());
        calculatorView.getB5().addActionListener(new operand5Listener());
        calculatorView.getB6().addActionListener(new operand6Listener());
        calculatorView.getB7().addActionListener(new operand7Listener());
        calculatorView.getB8().addActionListener(new operand8Listener());
        calculatorView.getB9().addActionListener(new operand9Listener());
        calculatorView.getbAdd().addActionListener(new operatorAddListener());
        calculatorView.getbSub().addActionListener(new operatorSubListener());
        calculatorView.getbMul().addActionListener(new operatorMulListener());
        calculatorView.getbDiv().addActionListener(new operatorDivListener());
        calculatorView.getbEql().addActionListener(new equalListener());
        calculatorView.getbClr().addActionListener(new clearFieldListener());
        System.out.println("listeners registered in controller for Calculator View");
    }

    public CalculatorView getCalculatorView() {
        return calculatorView;
    }
}
