package Lesson_3_7;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectApp {
    public static void main(String[] args) {
        Class clazz = HappyNewYear.class;
        start(clazz);
    }

    public static void start (Class testClass){
        Method[] declaredMethod = testClass.getDeclaredMethods();

        for (Method decMeth : declaredMethod){
            System.out.println("name = " + decMeth.getName() + " returnType = " + decMeth.getReturnType().getName() +
                    " parameters " + Arrays.toString(decMeth.getParameterTypes()));
        }
    }
}
