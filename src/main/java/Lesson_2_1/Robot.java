package Lesson_2_1;

public class Robot implements Participant{
    private int lengthDistanceMax = 100;
    private int heightWallMax = 9;

    @Override
    public boolean run(int length) {
        if (length <= lengthDistanceMax){
            System.out.println("Робот пробежал по дорожке.");
            return true;
        }else{
            System.out.printf("Робот может пробежать максимум %d, длина препятствия %d%n",
                    lengthDistanceMax,
                    length);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= heightWallMax){
            System.out.println("Робот перепрыгрнул стену.");
            return true;
        }else{
            System.out.printf("Робот может прыгать максимум %d, высота препятствия %d%n",
                    heightWallMax,
                    height);
            return false;
        }
    }
}
