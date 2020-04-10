package Calculator3;

public class Calc {

    public static void main(String[] args) {
        MathOp[] equations = new MathOp[4];
        equations[0] = new MathOp('a',31.0d,22.0d);
        equations[1] = new MathOp('s',22.0d,5.5d);
        equations[2] = new MathOp('d',137.5d,3.0d);
        equations[3] = new MathOp('m',226.0d,2.0d);


        for (MathOp equation : equations) {
            equation.execute();
            System.out.printf("Result: %.2f\n", equation.getResult());
        }

    }
}
