package Calculator_level3;

public interface OperatorInterface<T extends Number> {
    Double operate(T firstNumber, T secondNumber);
}
