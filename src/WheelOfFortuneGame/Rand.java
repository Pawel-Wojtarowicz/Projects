package WheelOfFortuneGame;

import java.util.Random;

public class Rand {

    private int[] Price = {0, 50, 50, 50, 50, 50, 100, 100, 100, 100, 150, 150, 150, 200, 200, 250, 0, 250, 500, 750, 1000, 1500, 2000, 3000, 5000};
    private String[] Sport = {"manchester united", "lekkoatletyka", "siatkówka", "cristiano ronaldo", "piłka nożna", "tomasz hajto", "skok o tyczce", "rzut oszczepem", "mistrzostwa świata w piłce noznej"};
    private String[] Cities = {"warszawa", "wrocław", "rio de janeiro", "hong kong", "los angeles"};
    private String[] Powiedzenia = {"kiełbasy do góry i golimy frajerów"};
    private String[] Zawody = {"kierowca autobusu"};

    public int randomPrice() {
        int index = new Random().nextInt(Price.length);
        int x = (Price[index]);
        return x;
    }

    public static int randomCategoryNumber() {  //losowanie kategorii
        int x = (int) (Math.random()*4);
        return x;
    }

    public String randomCategory(int z) {  //losowanie hasła
        if (z == 0) {
            int index = new Random().nextInt(Sport.length);
            String x = (Sport[index]);
            return x;
        }
        else if (z == 1) {
            int index = new Random().nextInt(Cities.length);
            String x = (Cities[index]);
            return x;
        }
        else if (z == 2) {
            int index = new Random().nextInt(Powiedzenia.length);
            String x = (Powiedzenia[index]);
            return x;
        }
        else {
            int index = new Random().nextInt(Zawody.length);
            String x = (Zawody[index]);
            return x;
        }
    }

    public String categoryName(int z) {  //wybieranie kategorii
        if (z == 0) {
            String x = "Sport.";
            return x;
        }
        else if (z == 1) {
            String x = "Miasta";
            return x;
        }
        else if (z == 2) {
            String x = "Powiedzenia";
            return x;
        }
        else {
            String x = "Zawody";
            return x;
        }
    }

}

