package Calculator_level3;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String finish = new String();
        String stopQueue = new String();
        String printQueue = new String(); //요구사항 8 inquiry를 받을 문자열

        int a; // 첫 번째 숫자
        int b; // 두 번째 숫자
        String operand; // 연산자
        int result = 0; // switch 문 밖에서 선언하고 초기화

        int calculateType;
        double radius = 0;

        ArithmeticCalculator arithmetic = new ArithmeticCalculator();
        CircleCalculator circle = new CircleCalculator();

        System.out.println("실행할 계산기의 번호를 입력하세요");
        System.out.println("사칙연산 : 1");
        System.out.println("반지름 계산기 : 2");

        calculateType = in.nextInt();
        if(calculateType == 1) {
            while (!finish.equals("exit")) {

                System.out.print("첫 번째 숫자를 입력하세요: ");
                a = in.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                operand = in.next();

                System.out.println("두 번째 숫자를 입력하세요: ");
                b = in.nextInt();

                try {
                    arithmetic.calculateOperation(operand,a,b);
                } catch (DivisionByZeroException e) {
                    throw new RuntimeException(e);
                } catch (InvalidOperatorException e) {
                    throw new RuntimeException(e);
                }

                if(arithmetic.getResultQueue().size() >= 2) { // remove는 큐가 비어있는 경우 예외가 발생하므로 예외 처리를 먼저 해줘야 함
                    System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력시 삭제)");
                    stopQueue = in.next();
                    if (stopQueue.equals("remove")) {
                        arithmetic.removeResultQueue();
                    }
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력시 조회)");
                printQueue = in.next();
                if (printQueue.equals("inquiry")) {
                    arithmetic.inquiryResultQueue();
                    System.out.println();
                }

                System.out.print("더 계산하시겠습니까? (계속 계산하시려면 아무키나 입력해주세요. exit 입력 시 종료됩니다.)");
                finish = in.next();
                if(finish.equals("exit")) {
                    break;
                } else {
                    continue;
                }
            }
        } else if (calculateType == 2) {
            while (!finish.equals("exit")) {


                System.out.print("계산할 반지름 입력 : ");
                radius = in.nextDouble();
                circle.calculateRadius(radius);

                if(circle.getResultQueue2().size() >= 2) { // remove는 큐가 비어있는 경우 예외가 발생하므로 예외 처리를 먼저 해줘야 함
                    System.out.print("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력시 삭제)");
                    stopQueue = in.next();
                    if (stopQueue.equals("remove")) {
                        circle.removeResultQueue2();
                    }
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력시 조회)");
                printQueue = in.next();
                if (printQueue.equals("inquiry")) {
                    circle.inquiryResultQueue2();
                    System.out.println();
                }

                System.out.print("더 계산하시겠습니까? (계속 계산하시려면 아무키나 입력해주세요. exit 입력 시 종료됩니다.)");
                finish = in.next();
                if(finish.equals("exit")) {
                    break;
                } else {
                    continue;
                }
            }
        }
    }
}

