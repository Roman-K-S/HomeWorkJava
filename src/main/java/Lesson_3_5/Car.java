package Lesson_3_5;

import javax.sound.midi.Soundbank;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static Lesson_3_5.Thread_Roads.*;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static boolean winner = false;
    final Lock lock = new ReentrantLock();

    public static boolean isWinner() {
        return winner;
    }

    public static void setWinner(boolean winner) {
        Car.winner = winner;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            ready_Steady_Go.await();
            race_Start.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            try {
                lock.lock();
                if (race.getStages().size() == i + 1 && !isWinner()) {
                    System.out.println(this.name + " - WIN!");
                    setWinner(true);
                }
            } finally {
                lock.unlock();
            }
        }
        race_Finish.countDown();
    }
}
