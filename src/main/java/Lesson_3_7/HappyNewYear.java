package Lesson_3_7;

public class HappyNewYear {
    private int year;
    private String congratulation;

    public HappyNewYear(int year, String congratulation) {
        this.year = year;
        this.congratulation = congratulation;
    }

    @test(priority = 1)
    public int getYear() {
        return year;
    }

    @BeforeSuite
    public void setYear(int year) {
        this.year = year;
    }

    @AfterSuite
    public String getCongratulation() {
        return congratulation;
    }

    @BeforeSuite
    public void setCongratulation(String congratulation) {
        this.congratulation = congratulation;
    }

    @test(priority = 2)
    public void printGreetings() {
        System.out.println("С наступающим новым годом!");
    }

    @test(priority = 3)
    public void printChristmasTree() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 - i; j++)
                System.out.print(" ");
            for (int k = 0; k < (2 * i + 1); k++)
                System.out.print("*");
            System.out.println();
        }
    }
}