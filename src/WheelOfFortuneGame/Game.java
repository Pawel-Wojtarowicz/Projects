package WheelOfFortuneGame;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Game{

    ///////////////////////////////////////////////////////////
    Scanner scanner = new Scanner(System.in);
    BufferedReader bufread = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Players> playerList = new ArrayList<>();  //tworzenie listy graczy z klasy
    Rand rand = new Rand();
    Round round = new Round();
    Menu menu = new Menu();
    int randomPrice;
    int randomCat = rand.randomCategoryNumber();
    boolean flag = true;
    boolean flag2 = true;
    ///////////////////////////////////////////////////////////
    String word1 = rand.randomCategory(randomCat);
    String word2 = word1.replaceAll("[a-z]", "#");
    String word4 = word2.replaceAll("[ą,ć,ę,ł,ń,ś,ó,ż,ź]", "#");
    StringBuilder word3 = new StringBuilder(word4);
    ///////////////////////////////////////////////////////////


    public void addPlayer(String name){
        Players player = new Players();
        player.setName(name);
        playerList.add(player);
    }
    public void showPlayers(int z){
        System.out.println(playerList.get(z).getName() + " " + playerList.get(z).getPoints());
    }
    public boolean checkPuzzle(String check) {  //sprawdzanie poprawności podanego hasła
        if (check.contains(word1)){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkRandomPrice(int z) {  //sprawdzanie bankruta
        if (z == 0){
            System.out.println("BANKRUT!!!");
            playerList.get(round.getPlayer()).clearPoints();
            round.nextPlayer();
            return false;
        }
        else {
            return true;
        }
    }
    public boolean checkPts(int points) { //sprawdzanie czy mozna kupic samogłoske
        if (points >= 200) {
            return true;
        }
        else {
            System.out.println("Masz za mało pieniędzy.");
            flag = false;
            return false;
        }
    }
    public boolean checkVowel(char vowel) {  //samogłoski
        for(int j = 0; j < vowel ; j++)
            switch(vowel) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'ó':
                    return true;
            }
        return false;
    }
    public boolean checkConsonant(char consonant) {  //spógłoski
        for(int k = 0; k < consonant ; k++)
            switch(consonant) {
                case 'ą':
                case 'b':
                case 'c':
                case 'ć':
                case 'd':
                case 'f':
                case 'g':
                case 'h':
                case 'j':
                case 'k':
                case 'l':
                case 'ł':
                case 'm':
                case 'n':
                case 'ń':
                case 'p':
                case 'r':
                case 's':
                case 'ś':
                case 't':
                case 'w':
                case 'y':
                case 'z':
                case 'ż':
                case 'ź':
                    return true;
            }
        return false;
    }
    public void guess(){    //odgadywanie hasła
        menu.clearScreen();
        try {
            System.out.print("Podaj Hasło: ");
            String checkP = bufread.readLine();
            if (checkPuzzle(checkP) == true) {
                System.out.println("Brawo! Wygrał(a): " + playerList.get(round.getPlayer()).getName() + " Hasło to: " + checkP.toUpperCase() + " wygrałeś " + playerList.get(round.getPlayer()).getPoints() + " złotych.");
            } else {
                System.out.println("Podane hasło jest nieprawidłowe.");
                round.nextPlayer();
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void gra() {  //odgadywanie spółgloski
        flag = true;
        menu.clearScreen();
        round.checkPlayer(round.getPlayer());
        randomPrice = rand.randomPrice();
        while(flag) {
            if (checkRandomPrice(randomPrice)) {
                System.out.println("Kręci: " + playerList.get(round.getPlayer()).getName());
                System.out.println("Wylosowałes kwote: " + randomPrice);
                System.out.println("Stan portfela: " + playerList.get(round.getPlayer()).getPoints());
                System.out.println("Kategoria: " + rand.categoryName(randomCat) + "\n" + word3.toString().toUpperCase());
                System.out.print("Podaj Spółgłoskę: ");
                puzzle(scanner.next().charAt(0));  //odkrywanie literek
            }
        }
    }
    public void puzzle(char litera) { //sprawdzanie społgłoski
        if (checkConsonant(litera)) {
            if(word1.indexOf(litera)!=-1){
                for (int i = 0; i < word1.length(); i++){
                    if (litera == word1.charAt(i)){
                        word3.setCharAt(i, word1.charAt(i));  //zastap index w haslo3
                        playerList.get(round.getPlayer()).addPoints(randomPrice);
                    }
                }
            }
            else {
                System.out.println("Hasło nie zawiera spółgłoski: " + litera);
                round.nextPlayer();
                randomPrice = 0;
                flag = !flag;
            }
            System.out.println("\nHasło: " + word3.toString().toUpperCase());
            randomPrice = 0;
            flag = !flag;
        }
        else {
            System.out.println("Wprowadziłeś " + litera + " Musisz podać samogłoskę. Spróbuj jeszcze raz.");
        }
    }

    public void gra2(){  //kupowanie samogłoski
        flag2 = true;
        menu.clearScreen();
        round.checkPlayer(round.getPlayer());
        while (flag2) {
            System.out.println("Kupuje: " + playerList.get(round.getPlayer()).getName());
            System.out.println("Stan portfela: " + playerList.get(round.getPlayer()).getPoints());
            if (checkPts(playerList.get(round.getPlayer()).getPoints())) {
                System.out.println("Kategoria: SPORT \nHasło: " + word3.toString().toUpperCase());
                System.out.print("Podaj Samogłoskę (Koszt 200zł): ");
                puzzle2(scanner.next().charAt(0));  //odkrywanie literek
            }
        }

    }
    public void puzzle2(char litera) {  //sprawdzanie samogłoski
        if (checkVowel(litera)) {
            if(word1.indexOf(litera)!=-1){
                for (int i = 0; i < word1.length(); i++){
                    if (litera == word1.charAt(i)){
                        word3.setCharAt(i, word1.charAt(i));  //zastap index w haslo3
                    }
                }
                playerList.get(round.getPlayer()).subPoints(200);
            }
            else {
                System.out.println("Hasło nie zawiera samogłoski: " + litera);
                round.nextPlayer(); //sprawdzic
                flag2 = !flag;
            }
            System.out.println("\nHasło: " + word3.toString().toUpperCase());
            flag2 = !flag;
        }
        else {
            System.out.println("Wprowadziłeś '" +  litera + "' Musisz podać samogłoskę. Spróbuj jeszcze raz");
        }
    }

}

