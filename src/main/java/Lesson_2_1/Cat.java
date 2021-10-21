package Lesson_2_1;

public class Cat implements Participant{
    private int lengthDistanceMax = 50;
    private int heightWallMax = 2;

    @Override
    public boolean run(int length) {
        if (length <= lengthDistanceMax){
            System.out.println("Кот пробежал по дорожке.");
            return true;
        }else{
            System.out.printf("Кот может пробежать максимум %d, длина препятствия %d%n",
                    lengthDistanceMax,
                    length);
            return false;
        }
    }

    @Override
    public boolean jump(int height) {
        if (height <= heightWallMax){
            System.out.println("Кот перепрыгрнул стену.");
            return true;
        }else{
            System.out.printf("Кот может прыгать максимум %d, высота препятствия %d%n",
                    heightWallMax,
                    height);
            return false;
        }
    }
}
