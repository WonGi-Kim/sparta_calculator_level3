package Calculator_level3;

import java.util.Queue;
import java.util.Scanner;

public class ArithmeticCalculator<T extends Number> extends Calculator<T> {

    private final AddOperator<T> addOperator;
    private final SubstractOperator<T> substractOperator;
    private final MultiplyOperator<T> multiplyOperator;
    private final DivideOperator<T> divideOperator;
    private final ModOperator modOperator;

    // 연산자 타입 enum 추가
    private OperatorType operatorType;
    // 생성자
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

    // 람다와 스트림을 포함한 기능을 구현한다.
    @Override
    public void inquiryResultQueue() {
        Scanner input = new Scanner(System.in);
        System.out.println("모든 결과를 출력하시려면 1 또는 아무 값을 입력하세요");
        System.out.println("특정 값 보다 큰 값을 출력하시려면 2 ");
        System.out.println("특정 값 보다 작은 값을 출력하시려면 3 ");
        System.out.println("소수점이 첫 자리가 5인 값만 출력하시려면 4 ");
        System.out.print("입력해주세요 >> ");


        int type = input.nextInt();
        input.nextLine();
        if (type == 1) {
            getResultQueue()
                    .stream()
                    .forEach(value -> System.out.print(value + " "));
        } else if (type == 2) {
            System.out.print("특정 값을 입력해주세요 >> ");
            String number = input.nextLine();
            Number specificNumber = number.contains(".") ? Double.parseDouble(number) : Integer.parseInt(number);
            getResultQueue()
                    .stream()
                    .filter(value -> value.doubleValue() > specificNumber.doubleValue())
                    .forEach(value -> System.out.print(value + " "));
        } else if (type == 3) {
            System.out.print("특정 값을 입력해주세요 >> ");
            String number = input.nextLine();
            Number specificNumber = number.contains(".") ? Double.parseDouble(number) : Integer.parseInt(number);
            getResultQueue()
                    .stream()
                    .filter(value -> value.doubleValue() < specificNumber.doubleValue())
                    .forEach(value -> System.out.print(value + " "));
        } else if (type == 4) {
            System.out.println("소수점 첫 자리가 5인 값만 출력");
            getResultQueue().stream()
                    .filter(value -> {
                        String strValue = String.valueOf(value.doubleValue());
                        int dotIndex = strValue.indexOf(".");
                        return dotIndex != -1 && dotIndex + 1 < strValue.length() && strValue.charAt(dotIndex + 1) == '5';
                    })
                    .forEach(value -> System.out.print(value + " "));

        } else {
            getResultQueue()
                    .stream()
                    .forEach(value -> System.out.print(value + " "));
        }

    }


}
