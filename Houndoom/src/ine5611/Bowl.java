package ine5611;

import static java.lang.System.out;
import java.util.Random;

public class Bowl {

    protected int bowlNumber;
    protected int coins = 4;
    protected int[] way;

    public Bowl(int[] array, int bowlNumber) {
        this.way = array;
        this.bowlNumber = bowlNumber;
    }

    public int getWay() {
        Random random = new Random();
        return way[random.nextInt(way.length)];
    }

    public boolean isEmpty() {
        return coins == 0;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getBowlNumber() {
        return bowlNumber;
    }

    public int getCoins() {
        return coins;
    }

}
