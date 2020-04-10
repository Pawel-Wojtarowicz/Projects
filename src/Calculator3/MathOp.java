package Calculator3;

public class MathOp {

    private double value1;
    private double value2;
    private char opperation;
    private double result;

    public double getValue1() {
        return value1;
    }
    public void setValue1(double value1) {
        this.value1 = value1;
    }
    public double getValue2() {
        return value2;
    }
    public void setValue2(double value2) {
        this.value2 = value2;
    }
    public char getOpperation() {
        return opperation;
    }
    public void setOpperation(char opperation) {
        this.opperation = opperation;
    }
    public double getResult() {
        return result;
    }

    public MathOp(char opperation) {
        this.opperation = opperation;
    }

    public MathOp(char opperation, double value1, double value2) {
        this(opperation);
        this.value1 = value1;
        this.value2 = value2;
    }

    public void execute(){
        switch (opperation) {
            case 'a':
                result = value1 + value2;
                break;
            case 's':
                result = value1 - value2;
                break;
            case 'd':
                result = value2 !=0.0d? value1 / value2 : 0.0d;
                break;
            case 'm':
                result = value1 * value2;
                break;
            default:
                System.out.println("Error - invalid operation");
                result = 0.0;
                break;
        }
    }

}
