public class Expression {
    private NumList operand;
    private NumList operand2;
    private String operator;

    private int exp;
    public Expression(NumList operand, NumList operand2, String operator, int exp){
        this.operand = operand;
        this.operand2 = operand2;
        this.operator = operator;
        this.exp = exp;
    }

    public String getOperator() {
        return operator;
    }

    public NumList getOperand() {
        return operand;
    }

    public NumList getOperand2() {
        return operand2;
    }
    public int getexp(){
        return this.exp;
    }
}
