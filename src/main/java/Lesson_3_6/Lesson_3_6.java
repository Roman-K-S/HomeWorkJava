package Lesson_3_6;

import java.util.Arrays;

public class Lesson_3_6 {

    public int[] arrTest(int[] arr) {
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                lastIndex = i;
            }
        } //end for
        int[] result = Arrays.copyOfRange(arr, lastIndex + 1, arr.length);
        return result;
    }

    public boolean arrTest14(int[] arr) {
        boolean searchOne = false;
        boolean searchFour = false;

        for (int o : arr) {
            if (o != 1 && o != 4) {
                return false;
            }

            switch (o) {
                case 1:
                    searchOne = true;
                    break;
                case 4:
                    searchFour = true;
                    break;
            }
        }
        if (searchFour == true && searchOne == true) {
            return true;
        }
        return false;
    }
}
