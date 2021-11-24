package Lesson_3_1;

import java.util.List;

public class GenericsApp {
    public static void main(String[] args) {
        /**
         * Integer test Array
         */
        GenClass<Integer> arrInt = new GenClass<>();
        arrInt.swapElements(1,2,3,4,5);

        List<Integer> listInt = arrInt.arrToArrayList(1,2,3,4,5);
        System.out.println(listInt);

        /**
         * String test Array
         */
        GenClass<String> arrStr = new GenClass<>();
        arrStr.swapElements("aaa", "bbb", "ccc");

        List<String> listStr = arrStr.arrToArrayList("eee", "ddd", "fff");
        System.out.println(listStr.get(0));

        /**
         * Box & Fruits
         */
        Apple apple = new Apple();
        apple.setWeight(4);

        Orange orange = new Orange();
        orange.setWeight(10);

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(apple, 4);
        appleBox.addFruit(apple, 4);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(orange, 5);

        double weightApple = appleBox.getWeight(); // считаем вес коробки с яблоками
        double weightOrange = orangeBox.getWeight(); // считаем вес коробки с апельсинами

        System.out.println(weightApple);
        System.out.println(weightOrange);

        if (orangeBox.compareBox(appleBox)){
            System.out.println("Массы коробок равны.");
        } else {
            System.out.println("Массы коробок различаются.");
        }
    }
}
