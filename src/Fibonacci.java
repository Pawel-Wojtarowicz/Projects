public class Fibonacci {
    public static long fib(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("The 4th fibonacci number is: " + fib(4));
    }
}

/*
Obliczając n-ty wyraz ciągu, musisz posługiwać się wartościami poprzednimi czyli n-1, n-2 itd. aż dojdziesz do wartości które znasz. Są nimi wartości dla F0 i F1.
Obliczymy wartość 4 wyrazu ciągu Fibonacciego, wynosi ona:
{F}{4}={F}{4-1}+{F}{4-2}={F}{3}+{F}{2}

Jest to nasza wartość dla 4 wyrazu ciągu. Zapisujemy ją lub zapamiętujemy. Wzór rekurencyjny nie dostarcza nam informacji o elemencie F3 i F2
więc musimy ponownie rozpisać te wyrazy posługując się wzorem na n:
{F}{3}={F}{3-1}+{F}{3-2}={F}{2}+{F}{1}
{F}{2}={F}{2-1}+{F}{2-2}={F}{1}+{F}{0}=1+0=1

Zgodnie z obliczeniami wartość dla F2 wynosi 1. Dzięki temu możemy obliczyć wartość dla F3 i F4:
{F}{3}={F}{2}+{F}{1}=1+1=2
{F}{4}={F}{3}+{F}{2}=2+1=3

Ostatecznie 4 wyraz ciągu liczb Fibonacciego wynosi 3.
 */


