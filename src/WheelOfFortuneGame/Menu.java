package WheelOfFortuneGame;

public class Menu {

    void printMenu() {
        System.out.print("\n...:::KOŁO FORTUNY:::...\n1. Podaj graczy \n2. Start \n3. Ranking \n0. Koniec \n\nWybierz: ");
    }
    void printMenu2() {
        System.out.print("\n...:::KOŁO FORTUNY:::...\n1. Zakręć Kołem \n2. Kup Samogłoskę \n3. Odgaduje Hasło \n0. Wróć \n\nWybierz: ");
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

