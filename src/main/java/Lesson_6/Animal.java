package Lesson_6;

abstract class Animal {
    private String name;
    private static int counter = 0;

    public Animal() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public void run(int lengthBarrier);

    abstract public void swim(int lengthBarrier);

} //end class Animal
