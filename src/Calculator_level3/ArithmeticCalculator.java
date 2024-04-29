package Calculator_level3;

//  Calculator Class 를 추상화 하고 여기랑 Circle에 extends
//  그럼 여기서 연산 메서드 final?

import java.util.Queue;

public class ArithmeticCalculator extends Calculator {

    private final AddOperator addOperator;
    private final SubstractOperator substractOperator;
    private final MultiplyOperator multiplyOperator;
    private final DivideOperator divideOperator;
    private final ModOperator modOperator;

    public ArithmeticCalculator() {
        this.addOperator = new AddOperator();
        this.substractOperator = new SubstractOperator();
        this.multiplyOperator = new MultiplyOperator();
        this.divideOperator = new DivideOperator();
        this.modOperator = new ModOperator();
    }
    @Override
    public void calculateOperation (String operator, int firstNumber, int secondNumber) throws
            DivisionByZeroException, InvalidOperatorException {
        result = 0;

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
        }
        System.out.println("결과는 : " + result);
        Queue<Integer> tempQueue = getResultQueue();
        tempQueue.offer(result);
        setResultQueue(tempQueue);
    };

    @Override
    public void calculateRadius (double radius) {
        throw new UnsupportedOperationException("ArithmeticCalculator does not support radius calculation.");
    } ;


}
