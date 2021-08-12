package Lesson_3;


import java.util.Arrays;

public class Lesson_3 {
    public static void main(String[] args) {
        int[] arrTask1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arrTask1));
        changeZeroOne(arrTask1);
        System.out.println();//change zero to one | one to zero

        int[] arrTask2 = new int[100];
        setVaules(arrTask2);
        System.out.println();// set values [0..100]

        int[] arrTask3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        num6mult2(arrTask3);
        System.out.println();// if the number is less than 6 multiply by 2

        int[][] arrTask4 = new int[5][5];
        setDiagOne(arrTask4);
        System.out.println();// set diagonal as 1

        int len = 10;
        String initialValue = "*";
        String[] arrTask5 = initialArr(len, initialValue);
        System.out.println(Arrays.toString(arrTask5));
        System.out.println();// initial array

        int[] arrTask6 = {5,10,20,30,40,1,2};
        Arrays.sort(arrTask6); //sort Array min to max
        System.out.println(arrTask6[0]); // print min value
        System.out.println(arrTask6[arrTask6.length-1]); // print max value
        System.out.println();

        int[] arrTask7 = {1,1,1,2,1};
        boolean result = checkBalance(arrTask7);
        System.out.println(result);
        System.out.println(); //if left part == right part return true

        int[] arrTask8 = {3,5,6,1};
        int step = 4;
        offsetElements(arrTask8, step); //offset elements array if positive to right, negative to left

    } // end main

    static public void changeZeroOne(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0){
                arr[i] = 1;
            } else {
                arr [i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    } // end changeZeroOne

    static public void setVaules(int[] arr){
        for (int i = 0 ; i < arr.length; i++){
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    } // end setValues

    static public void  num6mult2(int[] arr){
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
             System.out.println(Arrays.toString(arr));
    } // end num6mult2

    static public void setDiagOne(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0,k = arr[i].length-1; j < arr[i].length; j++, k--) {
                if (arr[i] == arr[j] || arr[i] == arr[k] ){
                    System.out.print("1 ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    } // end setDiagOne

    static public String[] initialArr(int len, String initialValue){
        String[] arr =new String[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    } // end initialArr

    static public boolean checkBalance(int[] arr){
        boolean result = false;
        for (int i = 0; i < arr.length; i++){
            int sumLeft = 0;
            int sumRight = 0;
            int countElements = 0; // counter used elements
            for(int j=i; j >= 0 ; j--){
                sumLeft += arr[j];
                countElements++;
            } // end sumLeft

            for(  ;countElements < arr.length; countElements++){
                sumRight += arr[countElements];
            } // end sumRight

            if(sumLeft == sumRight){
                result = true;
                break;
            }
        }
        return result;
    }// end checkBalance

    static public void offsetElements(int[] arr, int step){
        if(step > 0) {
            while (step > 0) {
                int tmp = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                        arr[i] = arr[i - 1];
                }
                step--;
                arr[0] = tmp;
                System.out.println(Arrays.toString(arr));
            } //end While Step Right
        }else if(step < 0){
            while (step < 0) {
                int tmp = arr[0];
                for (int i = 0; i < arr.length-1; i++) {
                        arr[i] = arr[i + 1];
                }
                step++;
                arr[arr.length-1] = tmp;
                System.out.println(Arrays.toString(arr));
            } // end While Step Left
        }else{
            System.out.println(Arrays.toString(arr));
        } // step == 0 --> return the original array
    } // end offsetElements

} // end Lesson_3
