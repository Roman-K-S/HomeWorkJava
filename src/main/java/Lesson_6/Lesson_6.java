package Lesson_6;

public class Lesson_6 {
    public static void main(String[] args) {
        Animal catBarsik = new Cat("Барсик");
        Animal dogBobik = new Dog("Бобик");
        Animal catVovka = new Cat("Вовка");
        Animal dogBoris = new Dog("Борис");
        Animal dogRaks = new Dog("Борис");
        Animal dogCrazy= new Dog("Борис");

        catBarsik.run(150);
        catBarsik.swim(100);

        dogBobik.run(200);
        dogBobik.swim(100);

        catVovka.run(250);
        catVovka.swim(10);

        dogBoris.run(600);
        dogBoris.swim(5);


        System.out.println("Всего животных: " + Animal.getCounter());
        System.out.println("Всего котов: " + Cat.getCounterCat());
        System.out.println("Всего собак: " + Dog.getCounterDog());
    }
}
