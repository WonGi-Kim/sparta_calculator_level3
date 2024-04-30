package Calculator_level3;

public class ModOperator implements OperatorInterface<Integer> {
    @Override
    public Double operate(Integer firstNumber, Integer secondNumber) {
        return firstNumber.doubleValue() % secondNumber.doubleValue();
    }
}
