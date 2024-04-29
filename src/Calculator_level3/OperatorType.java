package Calculator_level3;

public enum OperatorType {
    Plus("+"),
    Minus("-"),
    Multiply("*"),
    Divide("/"),
    DivideMod("%");

    private String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static OperatorType fromString(String operator) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.operator.equals(operator)) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("잘못된 연산자 : " + operator);
    }
}
