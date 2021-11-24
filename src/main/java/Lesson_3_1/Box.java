package Lesson_3_1;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit> {
    private double weight;
    private List<T> fruits = new ArrayList<>();

    public void calculateWeight() {
        double fullWeight = 0;
        for (Fruit fruit : fruits){
             fullWeight += fruit.getWeight();
        }
        this.weight = fullWeight; 
    }

    public void addFruit(T fruit, int number){
            for (int i = 0; i < number; i++) {
                fruits.add(fruit);
            }
            calculateWeight();
    }

    public double getWeight() {
        return weight;
    }

    public boolean compareBox(Box<?> another){
        return Math.abs (this.getWeight() - another.getWeight()) < 0.0001;
    }
}
