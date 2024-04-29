package Calculator_level3;

import java.util.LinkedList;
import java.util.Queue;


public abstract class Calculator {

    int result;
    private Queue<Integer> resultQueue= new LinkedList<>();
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
    public abstract void calculateOperation(String operator, int firstNumber, int secondNumber) throws
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
    public void setResultQueue(Queue<Integer> resultQueue) {
        this.resultQueue = resultQueue;
    }

    public Queue<Integer> getResultQueue() {
        return resultQueue;
    }

    public void removeResultQueue() {
        resultQueue.remove();
    }

    public void inquiryResultQueue() {
        for(int value : getResultQueue()) {
            System.out.print(value + " ");
        }
    }
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

/** 메서드는 final이 가능하다고 생각됨 :
 *  기능적으로 요구사항에 맞춰져 완성되었기 때문에
 *  수정하여 안정성을 낮추지 않으려면 final선언을 활용할 수 있다고 생각됨
 *
 *  다만 static은 활용성이 떨어진다고 생각됨 :
 *  변수 result, result2 모두 값을 저장하고 그 값을 큐에 삽입 후
 *  다시 초기화 하는 과정이 있기에 더미값이 들어가지 않는다고 생각되는데
 *  정적 변수인 static선언 시 저장되는 값이 바뀌지 않을 가능성이 있다고 생각
 */

