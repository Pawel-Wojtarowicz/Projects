import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;


public class AnimalShelter {
    public static void main(String[] args) {
        String menu = "\nSchronisko \n\n" + "1. Psy\n" + "2. Koty\n" + "3. Status\n" + "4. Wyjście\n";
        //load ArrayList from textfile
        ArrayList<String> dogsl = new ArrayList<String>();
        try (Scanner s = new Scanner(new File("C:\\Users\\Pawel\\IdeaProjects\\psy.txt"))){
            while (s.hasNext()){
                dogsl.add(s.next());
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Nie znaleziono pliku\nZamykanie programu");
            System.exit(0);
        }

        ArrayList<String> catsl = new ArrayList<String>();
        catsl.add("kot1");
        catsl.add("kot2");
        catsl.add("kot3");
        catsl.add("kot4");

        Scanner scan = new Scanner(System.in);

        boolean x = false;

        do {
            System.out.println(menu + "\nWybierz: ");
            int option = scan.nextInt();
            switch(option)
            {
                case 1:
                    String menu1 = new String("\nPsy:\n" + "\n1. Adoptuj" + "\n2. Oddaj" + "\n3. Wróc" + "\n\nWybierz: ");
                    boolean y = false;
                    do {
                        System.out.print(menu1);
                        int option1 = scan.nextInt();
                        if(option1 == 1) {
                            boolean t = false;
                            do {
                                for (int i = 0; i < dogsl.size(); i++) {
                                    System.out.println(i + 1 + ". " + dogsl.get(i));
                                }
                                System.out.print("\n0. Wróć.");
                                System.out.print("\nWybierz psa: ");
                                int z = scan.nextInt();
                                if (z <= dogsl.size() && z !=0 && z > 0 ) {
                                    System.out.print("\nAdoptowałes psa " + dogsl.get(z - 1));
                                    dogsl.remove(z - 1);
                                    if(dogsl.size() < 4){
                                        System.out.println(" i schronisko jest prawie puste. Ilość psów to " + dogsl.size() + "/10");
                                    }
                                    //else{}
                                    break;
                                }
                                else if (z == 0) {
                                    break;
                                }
                                else if ( z > 0 ) {
                                    System.out.print("Nie ma takiego psa. Spróbuj jeszcze raz\n");
                                }
                                else {
                                    System.out.print("Nie ma takiego psa. Spróbuj jeszcze raz\n");
                                }
                            }while(!t);
                        }
                        else if (option1 == 2)
                            if (dogsl.size() < 10) {
                                System.out.print("\nPodaj imie psa: ");
                                String newdog = scan.next();
                                dogsl.add(newdog);
                                System.out.print("\nOddałeś psa: " + newdog + "\n");
                                if (dogsl.size() == 10)
                                {
                                    System.out.println("Schronisko jest przepelnione, ilość psów to: " + dogsl.size() + "/10");
                                }
                                //break;
                            } else {
                                System.out.println("Schronisko jest przepełnione");
                            }
                        else if (option1 == 3) {
                            break;
                        }
                        else {
                            System.out.print("Nie ma takiej opcji spróbuj jescze raz: ");
                        }
                    }while(!y);
                    break;
                case 2:
                    String menu2 = new String("\nKoty:\n" + "\n1. Adoptuj" + "\n2. Oddaj" + "\n3. Wróc" + "\n\nWybierz: ");
                    boolean k = false;
                    do {
                        System.out.print(menu2);
                        int option1 = scan.nextInt();
                        if(option1 == 1) {
                            boolean t = false;
                            do {
                                for (int i = 0; i < catsl.size(); i++) {
                                    System.out.println(i + 1 + ". " + catsl.get(i));
                                }
                                System.out.print("\n0. Wróć.");
                                System.out.print("\nWybierz kota: ");
                                int z = scan.nextInt();
                                if (z <= catsl.size() && z !=0 && z > 0) {
                                    System.out.print("\nAdoptowałes kota " + catsl.get(z - 1));
                                    catsl.remove(z - 1);
                                    break;
                                }
                                else if (z == 0) {
                                    break;
                                }
                                else if ( z > 0 ) {
                                    System.out.print("Nie ma takiego kota. Spróbuj jeszcze raz\n");
                                }
                                else {
                                    System.out.print("Nie ma takiego kota. Spróbuj jeszcze raz\n");
                                }
                            }while(!t);
                        }
                        else if (option1 == 2) {
                            if (catsl.size() < 10) {
                                System.out.print("\nPodaj imie Kota: ");
                                String newcat = scan.next();
                                catsl.add(newcat);
                                System.out.print("\nOddałeś kota: " + newcat + "\n");
                                //break;
                            } else {
                                System.out.println("Schronisko jest przepełnione");
                            }
                        }
                        else if (option1 == 3) {
                            break;
                        }
                        else {
                            System.out.print("Nie ma takiej opcji spróbuj jescze raz: ");
                        }
                    }while(!k);
                    break;
                case 3:
                    String menu3 = new String("Status Schroniska");
                    String menu4 = new String("Psy: " + dogsl.size() + "/10" + "\nKoty: " + catsl.size() + "/10" + "\n\n0. Wróć");
                    boolean t = false;
                    do {
                        System.out.println(menu3);
                        if (dogsl.size() > 10)
                        {
                            System.out.println("Schronisko jest przepelnione");
                        }
                        //else{}
                        System.out.println(menu4);
                        int option1 = scan.nextInt();
                        if (option1 == 0 ){
                            break;
                        } else
                        {
                            System.out.println("Nie ma takiej opcji");
                        }
                    }while (!t);
                    break;
                case 4:
                    //save ArrayList to Textfile
                    try
                    {
                        FileWriter fw = new FileWriter("C:\\Users\\Pawel\\IdeaProjects\\psy.txt");
                        FileWriter fw1 = new FileWriter("C:\\Users\\Pawel\\IdeaProjects\\psy.csv");
                        for(String str: dogsl){
                            fw.write(str + System.lineSeparator());
                        }
                        fw.close();
                        String collect = dogsl.stream().collect(Collectors.joining(","));
                        fw1.write(collect);
                        fw1.close();
                    }
                    catch (IOException ex){
                        ex.printStackTrace();
                    }

                    System.exit(0);
                    break;
                default:
                    System.out.println("Nie ma takiej opcji spróbuj jeszcze raz: ");
            }
        } while (!x);
    }
}

