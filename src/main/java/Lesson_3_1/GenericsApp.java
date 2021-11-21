package Lesson_3_1;

import java.util.List;

public class GenericsApp {
    public static void main(String[] args) {
        GenClass<Integer> arrInt = new GenClass<>();
        arrInt.swapElements(1,2,3,4,5);

        List<Integer> listInt = arrInt.arrToArrayList(1,2,3,4,5);
        System.out.println(listInt);

        GenClass<String> arrStr = new GenClass<>();
        arrStr.swapElements("aaa", "bbb", "ccc");

        List<String> listStr = arrStr.arrToArrayList("eee", "ddd", "fff");
        System.out.println(listStr.get(0));

        Fruit apple = new Apple();
        apple.setWeight(4);

        System.out.println(apple.getWeight());

    }
}
