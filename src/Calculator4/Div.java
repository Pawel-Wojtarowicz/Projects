package Calculator4;

public class Div extends Base {
    public Div() {}

    public Div(double value1, double value2) {
        super(value1, value2);
    }

    @Override
    public void calculate() {
        double value = getValue2() !=0.0d ? getValue1() / getValue2() : 0.0d;
        setResult(value);
    }
}
