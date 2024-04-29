package Calculator_level3;

public class ModOperator implements OperatorInterface {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber % secondNumber;
    }
}
