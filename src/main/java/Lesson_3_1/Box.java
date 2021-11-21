package Lesson_3_1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private List<T> fruits = new ArrayList<>();
    private int number;

    public double getWeight(double fruitWeight){
        return number * fruitWeight;
    }

    public boolean compareBox(Box<?> another){
        return Math.abs (this.getWeight() - another.getWeight()) < 0.0001;
    }
}
