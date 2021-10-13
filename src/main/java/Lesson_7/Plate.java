package Lesson_7;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int needFood){
        if ((this.food-needFood) <= 0){
            System.out.println("В тарелке закончилась еда.");
            this.food = 0;
            return false;
        }else{
            this.food -= needFood;
            return true;
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
