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

    public synchronized void putCoin() {
        coins = 1;
        System.out.println("A red dog put one coin into bowl " + bowlNumber + ".");
        notifyAll();
    }

    public synchronized int takeCoin(int actualCoins) throws InterruptedException {
        int collected = 0;

        while (coins == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                out.println("Unexpected error!");
            }
        }
        
        while (collected < 3 && actualCoins < 20 && coins > 0) {
            coins--;
            collected++;
            actualCoins++;
        }
        
        Thread.sleep(100);
        notifyAll();
        return collected;
    }

    public int getWay() {
        Random random = new Random();
        return way[random.nextInt(way.length)];
    }

    public boolean isEmpty() {
        if (coins == 0) {
            return true;
        } else {
            return false;
        }
    }
}
