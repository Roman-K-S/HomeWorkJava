package Lesson_3_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenClass<T> {
    private T[] elems;

    public GenClass(T... elems){
        this.elems = elems;
    }

    public void swapElements (T... elems) {
        System.out.println(Arrays.toString(elems)); // печать исходного массива
        T temp = null;
        temp = elems[0];
        elems[0] = elems[1];
        elems[1] = temp;
        System.out.println(Arrays.toString(elems)); // печать после перемены элементов местами
    }

    public ArrayList<T> arrToArrayList (T... elems){
        List<T> arrList = new ArrayList<>(Arrays.asList(elems));
        return (ArrayList<T>) arrList;
    }
}
