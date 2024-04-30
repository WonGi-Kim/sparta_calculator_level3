package Calculator_level3;

public class DivideOperator<T extends Number> implements OperatorInterface<T> {
    @Override
    public Double operate(T firstNumber, T secondNumber) {
        if (secondNumber.doubleValue() == 0) {
            throw new ArithmeticException("Divide by zero");
        } else {
            return firstNumber.doubleValue() / secondNumber.doubleValue();
        }
    }
}
