package ine5611;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Hunter {
    protected int coins;
    protected boolean winner;
    protected String name;

    public Hunter(String name) {
        coins = 0;
        winner = false;
        this.name = name;
    }

    public boolean getWinner() {
        return winner;
    }

    public void setCoins(int amount) {
        coins += amount;
        if (coins >= 50) {
            winner = true;
            Dog.running = false;
            out.println("Hunter " + name + " won.");
            exit(0);
        }
        out.println("Hunter " + name + " is with " + coins + " coins.");
    }

    public int getCoins() {
        return coins;
    }
}
