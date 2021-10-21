package Lesson_2_1;

public class Human implements Participant{
    private int lengthDistanceMax = 10;
    private int heightWallMax = 5;

    @Override
    public boolean run(int length) {
        if (length <= lengthDistanceMax){
            System.out.println("Человек пробежал по дорожке.");
            return true;
        }else{
            System.out.printf("Человек может пробежать максимум %d, длина препятствия %d%n",
                    lengthDistanceMax,
                    length);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= heightWallMax){
            System.out.println("Человек перепрыгрнул стену.");
            return true;
        }else{
            System.out.printf("Человек может прыгать максимум %d, высота препятствия %d%n",
                    heightWallMax,
                    height);
            return false;
        }
    }
}
