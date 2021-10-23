package Lesson_2_2;

public class ExceptWork {
    public static void main(String[] args) {
        String[][] arr = {
                { "60", "80", "75", "33" },
                { "47", "21", "23", "11" },
                { "66", "91", "15", "18"},
                { "47", "21", "23", "7" }
        };
//        String[][] arr = new String[4][4];
//
//        int count = 0; // счётчик для заполнения массива
//
//        for (int i = 0; i < arr.length; i++){
//            for (int x = 0; x < arr[i].length; x++){
//                arr[i][x] = Integer.toString(count);
//                count++;
//            }
//        }

         arr[1][1] = "a"; // Подкидываем символ во входной поток.


        try {
            arraySizeDataSum(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void arraySizeDataSum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        try {
            for (int i = 0; i < arr.length; i++) {
                if (arr.length != 4 || arr[i].length != 4) {
                    throw new MyArraySizeException("Размер массива отличается от: 4 х 4.");                }
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        int[][] newArr = new int[4][4];
        int sum = 0;

//        try {
            for (int i = 0; i < arr.length; i++){
                for (int x = 0; x < arr[i].length; x++){
                    try {
                        newArr[i][x] = Integer.parseInt(arr[i][x]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException ("Входной поток содержит символ: " + arr[i][x] +
                        " по индексу [" + i + "][" + x + "]");
                    }
                    sum += newArr[i][x];
                    System.out.print(newArr[i][x] + "  ");
                }
                System.out.println();
            }
            System.out.println(sum);
//        } catch (NumberFormatException e) {
//            throw new MyArrayDataException ("Входной поток содержит символ.");
//        }

    }
}