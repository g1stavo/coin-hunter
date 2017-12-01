package ine5611;

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
        System.out.println("Put one coin into bowl " + bowlNumber);
        notifyAll();
    }

    public synchronized int takeCoin() throws InterruptedException {
        int collected = 0;

        while (coins == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        while (collected < 3 && coins > 0) {
            coins--;
            collected++;
        }
        Thread.sleep(100);
        notifyAll();
        return collected;
    }

    public int getWay() {
        Random random = new Random();
        int position = random.nextInt(way.length);
        int bowlNumber = way[position];
        return bowlNumber;
    }

    public boolean isEmpty() {
        if (coins == 0) {
            return true;
        } else {
            return false;
        }
    }
}
