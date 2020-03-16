package WheelOfFortuneGame;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Game game = new Game();
        int option;
        boolean x = false;

        do {
            try {
                menu.printMenu();
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
                switch (option) {
                    case 1: //dodawanie graczy
                        if (game.playerList.size() > 1) {  //sprawdzanie czy gracze sa juz dodani
                            menu.clearScreen();
                            System.out.println("Dodałeś już graczy.");
                        } else {
                            menu.clearScreen();
                            for (int i = 0; i < 3; i++) {
                                System.out.println("Podaj imie gracza nr: " + (i + 1));
                                game.addPlayer(scanner.next());
                            }
                            menu.clearScreen();
                            System.out.println("Gracze to:");
                            for (int j = 0; j < 3; j++) {  //wyswietlanie graczy
                                game.showPlayers(j);
                            }
                        }
                        break;
                    case 2: //start
                        boolean z = true;
                        menu.clearScreen();
                        if (game.playerList.size() < 1) {  //sprawdzanie czy gracze sa juz dodani
                            System.out.println("Dodaj graczy!");
                        }
                        else {
                            boolean y = true;
                            while (y && z) {
                                try {
                                    menu.printMenu2();
                                    Scanner scanner1 = new Scanner(System.in);
                                    int option1 = scanner1.nextInt();
                                    switch (option1) {
                                        case 1:
                                            menu.clearScreen();
                                            game.gra(); //własciwa gra
                                            break;
                                        case 2:
                                            menu.clearScreen();
                                            game.gra2(); //Kup Samogłoskę
                                            break;
                                        case 3:
                                            game.guess(); //Odgaduje haslo
                                            break;
                                        case 0:
                                            menu.clearScreen();
                                            z = false;
                                            break;
                                        default:
                                            menu.clearScreen();
                                            System.out.println("Nie ma takiej opcji spróbuj jeszcze raz: ");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Nie ma takie opcji. Spróbuj jeszcze raz.");
                                }
                            } while (!y);
                        }
                        break;
                    case 3:  //ranking
                        menu.clearScreen();
                        if (game.playerList.size() < 1) {  //sprawdzanie czy gracze sa juz dodani
                            System.out.println("Dodaj graczy!");
                        } else {
                            for (int i = 0; i < game.playerList.size(); i++) {
                                System.out.println(game.playerList.get(i).getName() + " " + game.playerList.get(i).getPoints() + " złotych.");
                            }
                        }
                        break;
                    case 0:  //koniec
                        menu.clearScreen();
                        System.exit(0);
                    default:
                        menu.clearScreen();
                        System.out.println("Nie ma takiej opcji spróbuj jeszcze raz.");
                }
            } catch (Exception e) {
                System.out.println("Nie ma takie opcji. Spróbuj jeszcze raz.");
            }
        } while (!x);
    }

}

