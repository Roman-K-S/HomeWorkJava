package Lesson_2_3;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<Long, String> phoneBook = new HashMap<>();

    public void add (Long number, String lastName){
        phoneBook.put(number,lastName);
    }

    public void get(String lastName){
        for (Map.Entry<Long, String> o : phoneBook.entrySet()) {
            if (o.getValue().equals(lastName)) {
                    System.out.println(o.getKey() + " " + o.getValue());
            }
        }
    }
}
