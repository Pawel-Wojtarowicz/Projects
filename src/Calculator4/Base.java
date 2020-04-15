package Calculator4;

public abstract class Base {

    private double value1;
    private double value2;
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
    public double getResult() {
        return result;
    }
    public void setResult(double result) {
        this.result = result;
    }

    public Base(){}
    public Base(double value1, double value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public abstract void calculate();
}
