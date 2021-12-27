package Lesson_3_7;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectApp {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Class clazz = HappyNewYear.class;
        start(clazz);
    }

    public static void start (Class testClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method[] declaredMethod = testClass.getDeclaredMethods();

        Constructor constructor = null;
        try {
            constructor = testClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        HappyNewYear obj = null;
        try {
            obj = (HappyNewYear) constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        for (Method decMeth : declaredMethod){
            if(decMeth.getAnnotation(BeforeSuite.class) != null){
                    Method m1 = testClass.getDeclaredMethod(decMeth.getName(),decMeth.getParameterTypes());
                    m1.invoke(obj,"С наступающим новым годом!");
            }

            if(decMeth.getAnnotation(test.class) != null){
                test testAnnotation = decMeth.getAnnotation(test.class);
                if(testAnnotation.priority() == 2){
                    Method m1 = testClass.getDeclaredMethod(decMeth.getName(),decMeth.getParameterTypes());
                    m1.invoke(obj, null);
                }
            }

            if(decMeth.getAnnotation(AfterSuite.class) != null){
                Method m1 = testClass.getDeclaredMethod(decMeth.getName(),decMeth.getParameterTypes());
                m1.invoke(obj,"Что бы всё у Вас было \n" +
                        "И ничего Вам за это не было!");
            }
        }
    }
}
