package WheelOfFortuneGame;

class Players {

    private String name;
    private int points;

    void setName(String x) {
        name = x;
    }
    public String getName() {
        return name;
    }
    public int getPoints() {
        return points;
    }
    void addPoints(int a) {
        points = points + a;
    }
    void clearPoints() {
        points = 0;
    }
    void subPoints(int a) {
        points = points - a;
    }
}

