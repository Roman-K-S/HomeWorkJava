package Lesson_7;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int needFood){
        if ((this.food-needFood) <= 0){
            System.out.println("В тарелке закончилась еда.");
            this.food = 0;
        }else{
            this.food -= needFood;
        }
    }

    public void increaseFood(int food){
        this.food += food;
        System.out.println("В тарелку добавили " + food);
    }

    public void info(){
        System.out.println("В тарелке: " + food);
    }
}
