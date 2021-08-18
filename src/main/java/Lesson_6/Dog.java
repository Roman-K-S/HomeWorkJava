package Lesson_6;

public class Dog extends Animal{

    public static int counter = 0;

    public Dog(String name){
        setName(name);
        counter++;
    }

    public static int getCounterDog() {
        return counter;
    }

    @Override
    public void run(int lengthBarrier) {
        if(lengthBarrier > 500){
            System.out.printf("Собака по кличке %s может пробежать максимум 500м %n", getName());
        }else {
            System.out.printf("Собака по кличке %s пробежала: %dм %n", getName(), lengthBarrier);
        }
    }

    @Override
    public void swim(int lengthBarrier) {
        if(lengthBarrier > 10){
            System.out.printf("Собака по кличке %s может проплыть максимум 10м %n", getName());
        }else{
            System.out.printf("Собака по кличке %s проплыла: %dм %n",getName(),lengthBarrier);
        }

    }
}
