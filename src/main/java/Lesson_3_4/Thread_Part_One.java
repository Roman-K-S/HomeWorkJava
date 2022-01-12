package Lesson_3_4;

public class Thread_Part_One {
    private final Object mon = new Object();
    private volatile char currrentLetter = 'A';

    public static void main(String[] args) {
        Thread_Part_One waitObj =  new Thread_Part_One();
        Thread thread1 = new Thread(() -> waitObj.printA());
        Thread thread2 = new Thread(() -> waitObj.printB());
        Thread thread3 = new Thread(() -> waitObj.printC());
        thread1.start();
        thread2.start();
        thread3.start();
    } // end main

    public void printA() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currrentLetter != 'A') {
                        mon.wait();
                    }
                    System.out.print("A");
                    currrentLetter = 'B';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    } //end printA()

    public void printB() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currrentLetter != 'B') {
                        mon.wait();
                    }
                    System.out.print("B");
                    currrentLetter = 'C';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    } //end printB()

    public void printC() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currrentLetter != 'C') {
                        mon.wait();
                    }
                    System.out.print("C");
                    currrentLetter = 'A';
                    mon.notifyAll();
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    } //end printC()

} // end
