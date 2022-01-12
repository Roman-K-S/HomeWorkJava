package Lesson_3_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Tests {
    private Lesson_3_6 methodsForTest;

    @BeforeEach
    public void init() {
        methodsForTest = new Lesson_3_6();
    }

    @ParameterizedTest
    @MethodSource("dataForArrTest")
    public void arrTest(int[] array, int[] result) {
        Assertions.assertArrayEquals(result, methodsForTest.arrTest(array));
    }

    public static Stream<Arguments> dataForArrTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}));
        out.add(Arguments.arguments(new int[]{2, 2, 2, 4, 4, 3, 6}, new int[]{3, 6}));
        out.add(Arguments.arguments(new int[]{1, 2, 3, 4, 1, 4, 1, 4, 8, 9}, new int[]{8, 9}));
        out.add(Arguments.arguments(new int[]{10, 10, 5, 20, 40, 30, 4, 1, 20}, new int[]{1, 20}));
        return out.stream();
    }

    @ParameterizedTest
    @MethodSource("dataForArrTest14")
    public void arrTest14(int[] array) {
        Assertions.assertTrue(methodsForTest.arrTest14(array));
    }

    public static Stream<Arguments> dataForArrTest14() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
        out.add(Arguments.arguments(new int[]{1, 1, 1, 1, 1, 1}));
        out.add(Arguments.arguments(new int[]{4, 4, 4, 4, 4}));
        out.add(Arguments.arguments(new int[]{1, 4, 4, 1, 1, 4, 3}));
        return out.stream();
    }
}
