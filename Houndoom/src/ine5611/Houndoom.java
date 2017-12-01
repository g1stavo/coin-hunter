package ine5611;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Houndoom {

    static ScheduledExecutorService lifeSaver;

    public static void main(String[] args) {
        Forest forest = new Forest();

        Hunter ethan = new Hunter("Ethan");
        Hunter brendan = new Hunter("Brendan");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        lifeSaver = Executors.newSingleThreadScheduledExecutor();
        lifeSaver.scheduleAtFixedRate(new RedDog(forest), 0, 200, TimeUnit.MILLISECONDS);

        Dog yellow1 = new Dog(ethan, forest, forest.getPote(1), "Ethan yellow dog");
        Dog green1 = new Dog(ethan, forest, forest.getPote(1), "Ethan green dog");
        Dog blue1 = new Dog(ethan, forest, forest.getPote(1), "Ethan blue dog");
        Dog yellow2 = new Dog(brendan, forest, forest.getPote(1), "Brendan yellow dog");
        Dog green2 = new Dog(brendan, forest, forest.getPote(1), "Brendan green dog");
        Dog blue2 = new Dog(brendan, forest, forest.getPote(1), "Brendan blue dog");

        executor.execute(yellow1);
        executor.execute(yellow2);
        executor.execute(green1);
        executor.execute(green2);
        executor.execute(blue1);
        executor.execute(blue2);

        lifeSaver.shutdown();
    }
}
