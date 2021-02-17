import java.io.IOException;

public interface CalculatorState {
//    void reset();
//    void discard();
    void clear();
    void setOperator(String operatorEntered) throws IOException;
    void setOperand(String operandEntered);
    void equal(String equalEntered) throws IOException;
}
