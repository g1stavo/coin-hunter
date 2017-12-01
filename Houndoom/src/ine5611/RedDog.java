package ine5611;

import static java.lang.System.out;

public class RedDog extends Thread {

    protected Bowl bowl;
    protected Forest forest;

    public RedDog(Forest forest) {
        this.forest = forest;
    }

    @Override
    public void run() {
        while (Dog.running) {
            for (int i = 1; i <= 20; i++) {
                bowl = forest.getPote(i);
                if (bowl.isEmpty()) {
                    bowl.putCoin();
                }
            }
        }
        out.println(getName() + " done.");
    }
}
