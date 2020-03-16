package WheelOfFortuneGame;

public class Round {
    private int whichPlayer = 0;

    /*
    void setPlayer(int i) {
        whichPlayer = i;
    }
    */
    public int getPlayer() {
        return whichPlayer;
    }
    void checkPlayer(int i) {
        if (i > 2) {
            whichPlayer = 0;
        }
    }
    void nextPlayer() {
        whichPlayer++;
    }
}

