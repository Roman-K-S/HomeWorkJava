package Lesson_2_5;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.Arrays;

public class WorkThread {
    public static void main(String[] args) {
        methodA();
        methodB();
    }

    public static void methodA() {
         int size = 10_000_000;

         float[] arr = new float[size];
         Arrays.fill(arr, 1.0f);

        //System.out.println(Arrays.toString(arr));

         long startTime = System.currentTimeMillis();

         for (int i = 0; i < arr.length; i++){
             arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
         }

        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

    }

    public static void methodB(){
        int size = 10_000_000;
        int half = size/2;

        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);

        long startTime = System.currentTimeMillis();

        float[] leftHalf = new float[half];
        float[] rightHalf = new float[half];

        System.arraycopy(arr, 0 , leftHalf , 0, half);
        System.arraycopy(arr, half, rightHalf, 0, half);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++){
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++){
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        thread1.start();
        thread2.start();

        float[] mergedArray = new float[size];
        System.arraycopy(leftHalf, 0 , mergedArray, 0, half);
        System.arraycopy(rightHalf, 0 , mergedArray, half, half);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");

    }
}


