import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private static final long serialVersionUID = 21305503976948004L;

    // create a frame
    static JFrame f;

    // create a textfield
    static JTextField calculatorField = new JTextField(20);

    //creating buttons
    JButton b0 = new JButton("0");
    JButton b1 = new JButton("1");
    JButton b2 = new JButton("2");
    JButton b3 = new JButton("3");
    JButton b4 = new JButton("4");
    JButton b5 = new JButton("5");
    JButton b6 = new JButton("6");
    JButton b7 = new JButton("7");
    JButton b8 = new JButton("8");
    JButton b9 = new JButton("9");
    JButton bAdd = new JButton("+");
    JButton bSub = new JButton("-");
    JButton bMul = new JButton("*");
    JButton bDiv = new JButton("/");
    JButton bEql = new JButton("=");
    JButton bClr = new JButton("C");



    // store oprerator and operands
    String operator;
    int operand1, operand2;

    // default constrcutor
    CalculatorView(){
        //add every buttion here
        setTitle("===CALCULATOR===");
        JPanel p1 = new JPanel(new GridLayout(1, 0, 5, 5));
        p1.add(calculatorField);
        JPanel p2 = new JPanel(new GridLayout(1, 4, 5, 5));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(bAdd);
        JPanel p3 = new JPanel(new GridLayout(1, 4, 5, 5));
        p3.add(b4);
        p3.add(b5);
        p3.add(b6);
        p3.add(bSub);
        JPanel p4 = new JPanel(new GridLayout(1, 4, 5, 5));
        p4.add(b7);
        p4.add(b8);
        p4.add(b9);
        p4.add(bMul);
        JPanel p5 = new JPanel(new GridLayout(1, 4, 5, 5));
        p5.add(b0);
        p5.add(bEql);
        p5.add(bClr);
        p5.add(bDiv);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1, 5, 5));
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        add(p5);
        pack();
        setVisible(true);
    }

    //Setting the calculatorField to empty
    public void setbClr(){
        calculatorField.setText("");
    }

    //All getters
    public JButton getB0() {
        return b0;
    }

    public JButton getB1() {

        return b1;
    }

    public JButton getB2() {

        return b2;
    }

    public JButton getB3() {

        return b3;
    }

    public JButton getB4() {

        return b4;
    }

    public JButton getB5() {

        return b5;
    }

    public JButton getB6() {

        return b6;
    }

    public JButton getB7() {

        return b7;
    }

    public JButton getB8() {

        return b8;
    }

    public JButton getB9() {

        return b9;
    }

    public JButton getbAdd() {
        return bAdd;
    }

    public JButton getbSub() {
        return bSub;
    }

    public JButton getbMul() {
        return bMul;
    }

    public JButton getbDiv() {
        return bDiv;
    }

    public JButton getbEql() {
        return bEql;
    }

    public JButton getbClr() {
        return bClr;
    }

    public void clearInputFields(){
        calculatorField.setText("");
    }

    public void enterInputFields(String c){
        calculatorField.setText(c);
    }
}
