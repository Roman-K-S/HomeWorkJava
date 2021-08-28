package Lesson_5;

class Employee {
    private String fullname;
    private String position;
    private String email;
    private int phone;
    private int salary;
    private int age;

    public Employee(String fullname, String position, String email, int phone, int salary, int age){
        this.fullname = fullname;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullname='" + fullname + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

//    public void info(){
//        System.out.printf("Fullname: %s, Position: %s, Email: %s, Phone: %d, Salary: %d, Age: %d",fullname,
//                position, email, phone, salary, age);
//    }

}

public class Lesson_5{
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Ivanonv Ivan", "manager", "a@a.ru", 9321890,
                30000, 42);
        employee[1] = new Employee("Sidorov Artem", "Worker", "b@b.ru", 423432,
                35000, 43);
        employee[2] = new Employee("Ana Trujillo", "Worker", "c@c.ru", 425453,
                36000, 44);
        employee[3] = new Employee("Antonio Moreno", "teller", "d@d.ru", 2432432,
                32000, 23);
        employee[4] = new Employee("Thomas Hardy", "salesman", "e@e.ru", 424324,
                31000, 29);

        for (Employee temp : employee){
            if(temp.getAge() > 40){
                //temp.info();
                System.out.println(temp);
            }
        }
    }
}

