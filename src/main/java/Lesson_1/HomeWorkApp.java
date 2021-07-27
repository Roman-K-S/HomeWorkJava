package Lesson_1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign(2, -3);
        printColor(-1);
        compareNumbers(5, 9);
    } // end main

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    } // end printThreeWords

    public static void checkSumSign(int a, int b){
        int sum = a + b;

        if (sum >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    } // end checkSumSign

    public static void printColor(int value) {
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }

    }   // end prinColor

    public static void compareNumbers(int a, int b){
        if (a >= b){
            System.out.println("a >= b");
        }else{
            System.out.println("a < b");
        }
    } // end compareNumbers

} // end HomeWorkApp

