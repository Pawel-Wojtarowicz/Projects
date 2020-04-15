package Calculator4;

import Calculator3.MathOp;

public class Calc {

    public static void main(String[] args) {
        Base[] calculators = {
                new Add(25.0d, 92.0d),
                new Sub(225.0d, 17.0d),
                new Multi(11.0d, 3.0d),
                new Div(100.0d, 2.0d)
        };


        for (Base calcualtor : calculators) {
            calcualtor.calculate();
            System.out.print("Result: ");
            System.out.println(calcualtor.getResult());
        }


    }
}
