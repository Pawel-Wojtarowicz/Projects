import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class Calculator
{
    public static void main(String[] args) {
        Calculator m = new Calculator();
        Scanner scan = new Scanner(System.in);
        boolean x = false;
        do {
            System.out.println("1. Dodawanie");
            System.out.println("2. Odejmowanie");
            System.out.println("3. Mnożenie");
            System.out.println("4. Dzielenie");
            System.out.println("5. Zgadnij liczbę");
            System.out.println("\nSelect:");
            int Choice = scan.nextInt();

            if(Choice <=4 && Choice > 0){

                System.out.println("Podaj pierwsza liczbę: ");
                int a = scan.nextInt();
                System.out.println("Podaj drugą liczbę: ");
                int b = scan.nextInt();

                switch(Choice)
                {
                    case 1:
                        System.out.println("Wynik to: " + m.sum(a,b) + "\n");
                        break;
                    case 2:
                        System.out.println("Wynik to: " + m.sub(a,b) + "\n");
                        break;
                    case 3:
                        System.out.println("Wynik to: " + m.multi(a,b) + "\n");
                        break;
                    case 4:
                        System.out.println("Wynik to: " + m.div(a,b) + "\n");
                        break;
                }
            }
            else if (Choice == 5) {
                //System.out.println("Losowa Liczba: " + m.rand());
                int random = m.rand();
                //System.out.println("Losowa Liczba: " + random);
                boolean y = false;
                int i = 0;
                do {

                    System.out.println("Podaj liczbe: ");
                    int pick = scan.nextInt();
                    if (pick < random) {
                        System.out.println("Liczba jest większa");
                    } else if (pick > random){
                        System.out.println("Liczba jest mnijesza");
                    } else{
                        System.out.println("brawo, odgadłeś. Losową liczba było: " + random + " zajeło Ci to: " + (i+1) + " prób");
                        break;
                    }
                    i++;
                }while (!y);
            }
        }while (!x);
    }

    public int sum(int a, int b)
    {
        return a + b;
    }
    public int sub(int a, int b)
    {
        return a - b;
    }
    public int multi(int a, int b)
    {
        return a * b;
    }
    public int div(int a, int b)
    {
        return a / b;
    }
    public int rand()
    {
        Random random = new Random();
        int x = random.nextInt(50);
        return x;
    }
}


