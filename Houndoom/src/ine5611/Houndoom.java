package ine5611;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Houndoom {

    static ScheduledExecutorService lifeSaver;

    public static void main(String[] args) {
        Forest forest = new Forest();

        Hunter yellowHunter = new Hunter("Yellow");
        Hunter greenHunter = new Hunter("Green");
        Hunter blueHunter = new Hunter("Blue");

        ExecutorService yellowExecutor = Executors.newFixedThreadPool(1);
        ExecutorService greenExecutor = Executors.newFixedThreadPool(1);
        ExecutorService blueExecutor = Executors.newFixedThreadPool(1);

        lifeSaver = Executors.newSingleThreadScheduledExecutor();
        lifeSaver.scheduleAtFixedRate(new RedDog(forest), 0, 200, TimeUnit.MILLISECONDS);

        Dog yellow1 = new Dog(yellowHunter, forest, forest.getPote(1), "Yellow dog 1");
        Dog green1 = new Dog(greenHunter, forest, forest.getPote(1), "Green dog 1");
        Dog blue1 = new Dog(blueHunter, forest, forest.getPote(1), "Blue dog 1");
        Dog yellow2 = new Dog(yellowHunter, forest, forest.getPote(1), "Yellow dog 2");
        Dog green2 = new Dog(greenHunter, forest, forest.getPote(1), "Green dog 2");
        Dog blue2 = new Dog(blueHunter, forest, forest.getPote(1), "Blue dog 2");

        yellowExecutor.execute(yellow1);
        greenExecutor.execute(green1);
        blueExecutor.execute(blue1);
        yellowExecutor.execute(yellow2);
        greenExecutor.execute(green2);
        blueExecutor.execute(blue2);
        yellowExecutor.execute(yellow1);
        greenExecutor.execute(green1);
        blueExecutor.execute(blue1);

        lifeSaver.shutdown();
    }
}
