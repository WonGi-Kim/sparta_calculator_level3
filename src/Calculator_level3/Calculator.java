package Calculator_level3;

import java.util.LinkedList;
import java.util.Queue;


public abstract class Calculator<T extends Number> {

    int result;
    private Queue<T> resultQueue= new LinkedList<>();
    // 연산결과를 저장하는 컬렉션 타입, 캡슐화 private -> protected 변경
    // 접근 제어자를 변경할 경우 Arithmetic 클래스 내부 변경
    // protected Queue<Integer> resultQueue= new LinkedList<>();

    double result2;
    private Queue<Double> resultQueue2 = new LinkedList<>();

    public Calculator() {
        resultQueue.clear();
        resultQueue2.clear();
        System.out.println("resultQueue clear!: " + resultQueue);
        System.out.println("resultQueue2 clear!: " + resultQueue2);
    }
    // 여기부터 추상 메서드 추가
    public abstract void calculateOperation(String operator, T firstNumber, T secondNumber) throws
            DivisionByZeroException, InvalidOperatorException;

    public abstract void calculateRadius (double radius);


    // 결과값을 반환하는 메서드
    /*
    public final void calculateOperation(String operator, int firstNumber, int secondNumber) throws
            DivisionByZeroException, InvalidOperatorException{

        result = 0;

        if (operator.equals("+")) {
            result = firstNumber + secondNumber;
            System.out.println("결과는 : " + result);
        } else if (operator.equals("-")) {
            result = firstNumber - secondNumber;
            System.out.println("결과는 : " + result);
        } else if (operator.equals("*")) {
            result = firstNumber * secondNumber;
            System.out.println("결과는 : " + result);
        } else if (operator.equals("/")) {
            if (secondNumber == 0) {
                // Exception
                throw new DivisionByZeroException("분모에 0이 들어올 수 없습니다.");
            }
            result = firstNumber / secondNumber;
            System.out.println("결과는 : " + result);
        } else {
            throw new InvalidOperatorException("잘못된 연산자 입니다.");
        }
        resultQueue.offer(result);
        setResultQueue(resultQueue);
    } */
    public void setResultQueue(Queue<T> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public Queue<T> getResultQueue() {
        return resultQueue;
    }

    public void removeResultQueue() {
        resultQueue.remove();
    }

//    level3 요구사항 3 ArithmeticCalculator에 해당 함수 구현
//    추상 메서드로 바꿔서?
//    public void inquiryResultQueue() {
//        for(T value : getResultQueue()) {
//            System.out.print(value + " ");
//        }
//    }

    public abstract void inquiryResultQueue();
    /* public final void calculateRadius(double radius) {
        result2 = 0;
        result2 = radius * radius * Math.PI;
        resultQueue2.offer(result2);
        setResultQueue2(resultQueue2);
    }*/

    public void setResultQueue2(Queue<Double> resultQueue2) {
        this.resultQueue2 = resultQueue2;
    }

    public Queue<Double> getResultQueue2() {
        return resultQueue2;
    }

    public void removeResultQueue2() {
        resultQueue2.remove();
    }

    public void inquiryResultQueue2() {
        for(double value : getResultQueue2()) {
            System.out.print(value + " ");
        }
    }
}
