package Lesson_7;

public class App {
    public static void main(String[] args) {
        //Массив котов
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Жорик", 5);
        cats[1] = new Cat("Лорик", 30);
        cats[2] = new Cat("Барсик", 10);
        cats[3] = new Cat("Альберт", 20);
        cats[4] = new Cat("Грей", 40);

        //Создаем тарелку с едой для котов
        Plate plate = new Plate(100);

        //Выводим количество еды в тарелке
        plate.info();
        System.out.println();

        //Кормими котов
        for (Cat cat : cats) {
            cat.eat(plate);
        }
        System.out.println();

        //Выводим информацию о сытости котов
        for (Cat cat : cats) {
            if(cat.isSatiety()){
                System.out.printf("Котэ %s сыт.%n", cat.getName());
            }else {
                System.out.printf("Котэ %s голоден.%n", cat.getName());
            }
        }
        System.out.println();

        //Добавляем еды в тарелку
        plate.increaseFood(100);
        System.out.println();

        //Снова кормим котов
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }// end main
} // end App

