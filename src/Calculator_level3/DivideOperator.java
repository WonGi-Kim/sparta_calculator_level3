package Calculator_level3;

public class DivideOperator implements OperatorInterface {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException("Divide by zero");
        } else {
            return firstNumber / secondNumber;
        }
    }
}
