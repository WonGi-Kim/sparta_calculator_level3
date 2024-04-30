package Calculator_level3;

import java.util.Queue;

public class ArithmeticCalculator<T extends Number> extends Calculator<T> {

    private final AddOperator<T> addOperator;
    private final SubstractOperator<T> substractOperator;
    private final MultiplyOperator<T> multiplyOperator;
    private final DivideOperator<T> divideOperator;
    private final ModOperator modOperator;

    // 연산자 타입 enum 추가
    private OperatorType operatorType;

    public ArithmeticCalculator() {
        this.addOperator = new AddOperator<>();
        this.substractOperator = new SubstractOperator<>();
        this.multiplyOperator = new MultiplyOperator<>();
        this.divideOperator = new DivideOperator<>();
        this.modOperator = new ModOperator();
    }

    @Override
    public void calculateOperation(String operator, T firstNumber, T secondNumber) throws
            DivisionByZeroException, InvalidOperatorException {
        Double result = 0.0;

        OperatorType operatorType = OperatorType.fromString(operator);

        switch (operatorType) {
            case Plus:
                result = addOperator.operate(firstNumber, secondNumber);
                break;
            case Minus:
                result = substractOperator.operate(firstNumber, secondNumber);
                break;
            case Multiply:
                result = multiplyOperator.operate(firstNumber, secondNumber);
                break;
            case Divide:
                result = divideOperator.operate(firstNumber, secondNumber);
                break;
            case DivideMod:
                result = modOperator.operate(firstNumber.intValue(), secondNumber.intValue());
                break;
            default:
                throw new InvalidOperatorException("잘못된 연산자 입니다.");
        }

        /*Enum 사용으로 if -> switch~case로 다시 변경
        if (operator.equals("+")) {
            result = addOperator.operate(firstNumber,secondNumber);
        } else if (operator.equals("-")) {
            result = substractOperator.operate(firstNumber, secondNumber);
        } else if (operator.equals("*")) {
            result = multiplyOperator.operate(firstNumber,secondNumber);
        } else if (operator.equals("/")) {
            result = divideOperator.operate(firstNumber, secondNumber);
        } else if (operator.equals("%")) {
            result = modOperator.operate(firstNumber, secondNumber);
        } else {
            throw new InvalidOperatorException("잘못된 연산자 입니다.");
        }*/
        System.out.println("결과는 : " + result);
        Queue<T> tempQueue = getResultQueue();
        tempQueue.offer((T) result);
        setResultQueue(tempQueue);
    };

    @Override
    public void calculateRadius(double radius) {
        throw new UnsupportedOperationException("ArithmeticCalculator does not support radius calculation.");
    };


}
