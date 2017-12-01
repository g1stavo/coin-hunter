package ine5611;

import static java.lang.System.out;

public class Dog extends Thread {

    protected int i = 0;
    protected Bowl bowl;
    protected Forest forest;
    protected Hunter hunter;
    public static boolean running = true;

    public Dog(Hunter hunter, Forest forest, Bowl bowl, String name) {
        this.setName(name);
        this.bowl = bowl;
        this.forest = forest;
        this.hunter = hunter;
    }

    @Override
    public void run() {
        while (i < 20 && hunter.getCoins() + i < 50 && running) {
            try {
                int collected = takeCoin(i);
                i += collected;
                out.println(getName() + " is with " + i + " coins.");
                int caminho = bowl.getWay();
                bowl = forest.getBowl(caminho);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                out.println("Unexpected error!");
            }
        }
        if (!hunter.getWinner()) {
            out.println(getName() + " got " + i + " coins. Going to give to its owner.");
            hunter.setCoins(i);
            i = 0;
        }
        out.println(getName() + " done.");
    }

    public synchronized int takeCoin(int actualCoins) throws InterruptedException {
        int collected = 0;

        while (bowl.getCoins() == 0) {
            try {
                sleep(6000);
            } catch (InterruptedException e) {
                out.println("Unexpected error!");
            }
        }

        while (collected < 3 && actualCoins < 20 && bowl.getCoins() > 0) {
            bowl.setCoins(bowl.getCoins() - 1);
            collected++;
            actualCoins++;
        }

        return collected;
    }
}
