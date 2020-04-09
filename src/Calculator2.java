public class Calculator2 {

    public static void main(String[] args) {
        double[] value1 = {31.0, 22.0, 137.5, 226.0};
        double[] value2 = {22.0, 5.5, 3.0, 2.0};
        char[] opperation = new char[] {'a', 's', 'd', 'm'};
        double[] result = new double[opperation.length];


        for (int i = 0; i < opperation.length; i++) {
            switch (opperation[i]) {
                case 'a': 
                    result[i] = value1[i] + value2[i];
                    break;
                case 's':
                   result[i] = value1[i] - value2[i];
                   break;
                case 'd':
                    result[i] = value2[i] !=0.0d? value1[i] / value2[i] : 0.0d;
                    break;
                case 'm':
                    result[i] = value1[i] * value2[i];
                    break;
                default:
                    System.out.println("Error - invalid operation");
                    result[i] = 0.0;
                    break;
            }
        }
        for (Double value: result) {
            System.out.printf("Result: %.2f\n", value);
        }
    }
}
