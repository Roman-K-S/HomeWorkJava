package Lesson_2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindWord {
    static public void countWord(String[] wordsArr) {

        List<String> wordsList = new ArrayList<>(Arrays.asList(wordsArr));

        for (int i = 0; i < wordsList.size(); i++) {
            int count = 0;
            // начинаем проверку с i слова
            for (int j = i; j < wordsList.size(); j++) {
                if (wordsList.get(i) == wordsList.get(j)) {
                    count++;
                    // Удаляем дубликаты.
                    if (count > 1) {
                        wordsList.remove(j);
                    }
                }
            } // end Interior for
            System.out.printf("Слово %s содержится %d раз.", wordsList.get(i), count);
            System.out.println("");
        } // end Outer for

        System.out.println(wordsList);
    }
}
