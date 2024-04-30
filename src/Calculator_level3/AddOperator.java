package Calculator_level3;

public class AddOperator<T extends Number> implements OperatorInterface<T>{
    @Override
    public Double operate(T firstNumber, T secondNumber) {
        return firstNumber.doubleValue() + secondNumber.doubleValue();
    }
}
