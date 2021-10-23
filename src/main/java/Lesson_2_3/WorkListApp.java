package Lesson_2_3;

public class WorkListApp {
    public static void main(String[] args) {
        String[] wordsArr = {"Nine","One", "Two","Three","Four", "Five",
                "Five","Two","Six","Seven","Two","Eight","Nine","Ten"};

        FindWord.countWord(wordsArr);

       System.out.println();

       PhoneBook pb = new PhoneBook();

       pb.add(1111L, "Петров");
       pb.add(2222L, "Сидоров");
       pb.add(3333L, "Гавриков");
       pb.add(444L, "Пантилеев");
       pb.add(555L, "Петров");
       pb.add(777L, "Петров");
       pb.add(888L, "Говрилов");
       pb.add(999L, "Петухов");
       pb.add(282828L, "Клавишников");

       pb.get("Клавишников");
       pb.get("Петров");
    }


}
