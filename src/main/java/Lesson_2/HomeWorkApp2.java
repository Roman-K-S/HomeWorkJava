package Lesson_2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(checkSum1020(9,0));

        checkPositive(1);

        System.out.println(trueNegative(-1));

        printString("String",5);

          System.out.println(leapYear(2000));
    } // end main

    public static boolean checkSum1020(int value1, int value2){
        int sum = value1 + value2;
        if (sum >= 10 && sum <= 20){
            return true;
        } else {
            return false;
        }
    } // end checkSum

    public static void checkPositive(int value){
        if (value >= 0){
            System.out.println("Число положительное");
        }else{
            System.out.println("Число отрицательное");
        }
    }   // end checkSign

    public static boolean trueNegative(int value){
        if (value < 0){
            return true;
        }else{
            return false;
        }
    } // end returnSign

    public static void printString(String string, int count){
        for (int i = 1; i <= count; i++){
            System.out.println(string + " " + i);
        }
    } // end printString

    public static boolean leapYear(int value){
        if ((value % 400) == 0){
            return true;
        }else if((value % 100) == 0){
            return false;
        }else if((value % 4) == 0){
            return true;
        } else {
            return false;
        }
    } // end leapYear (100 невисокосные, 400 високосный, 4 високосный)
} // end HomeWorkApp2
