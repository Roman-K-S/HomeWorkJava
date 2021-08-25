package Lesson_6;

public class Cat extends Animal{

    public static int counter = 0;

    public Cat(String name){
        setName(name);
        counter++;
    }

    public static int getCounterCat(){
        return counter;
    }

    @Override
    public void run(int lengthBarrier) {
        if(lengthBarrier > 200){
            System.out.printf("КотЭ по кличке %s может пробежать максимум 200м %n", getName());
        }else {
            System.out.printf("КотЭ по кличке %s пробежал: %dм %n", getName(), lengthBarrier);
        }
    }

    @Override
    public void swim(int lengthBarrier) {
        System.out.printf("КотЭ по кличке %s не умеет плавать %n", getName());
    }
}
