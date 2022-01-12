package Lesson_3_7;

public class HappyNewYear {

    public HappyNewYear(){
    }

    @BeforeSuite
    public void printGreetings(String greeting) {
        System.out.println(greeting);
    }

    @test(priority = 2)
    public void printChristmasTree() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++)
                System.out.print(" ");
            for (int k = 0; k < (2 * i + 1); k++)
                System.out.print("*");
            System.out.println();
        }
        System.out.println();
    }

    @AfterSuite
    public void printCongratulation (String congratulation){
        System.out.println(congratulation);
    }
}