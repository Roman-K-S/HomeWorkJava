package Lesson_2_2;

public class ExceptWork {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];

        int count = 0; // счётчик для заполнения массива

        for (int i = 0; i < arr.length; i++){
            for (int x = 0; x < arr[i].length; x++){
                arr[i][x] = Integer.toString(count);
                count++;
            }
        }

//         arr[1][1] = "a"; // Подкидываем символ во входной поток.


        try {
            arraySizeDataSum(arr);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public static void arraySizeDataSum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if(arr.length != 4 || arr[0].length != 4){
            throw new MyArraySizeException ("Размер массива отличается от: 4 х 4.");
        }

        int[][] newArr = new int[4][4];
        int sum = 0;

        try {
            for (int i = 0; i < arr.length; i++){
                for (int x = 0; x < arr[i].length; x++){
                    newArr[i][x] = Integer.parseInt(arr[i][x]);
                    sum += newArr[i][x];
                    System.out.print(newArr[i][x] + "  ");
                }
                System.out.println();
            }
            System.out.println(sum);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException ("Входной поток содержит символ.");
        }

    }
}