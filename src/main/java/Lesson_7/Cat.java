package Lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public String getName() {
        return name;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p){
        if(satiety){
            System.out.printf("КотЭ %s уже сыт.%n",name);
        }else {
            if (appetite > p.getFood()) {
                System.out.printf("КотЭ %s с аппетитом %d видит дно! И есть не будет. %n", name, appetite);
            } else {
                satiety = p.decreaseFood(appetite);
                System.out.printf("КотЭ %s съел: %d. В тарелке осталось: %d %n", name, appetite, p.getFood());
            }
        } // end eat
    }
}
