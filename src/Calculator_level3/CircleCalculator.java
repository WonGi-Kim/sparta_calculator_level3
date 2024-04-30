package Calculator_level3;

import java.util.Queue;

public class CircleCalculator<T extends Number> extends Calculator<T> {
    @Override
    public void calculateRadius (double radius) {
        double result2 = 0.0;
        result2 = radius * radius * Math.PI;
        Queue<Double> tempQueue = getResultQueue2();
        tempQueue.offer(result2);
        setResultQueue2(tempQueue);
    };
    @Override
    public void calculateOperation (String operator,T firstNumber, T secondNumber) throws
            DivisionByZeroException, InvalidOperatorException {
        throw new UnsupportedOperationException("CircleCalculator does not support Arithmetic calculation.");
    };
}
