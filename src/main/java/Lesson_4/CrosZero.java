package Lesson_4;

import java.util.Random;
import java.util.Scanner;

public class CrosZero {
    public static int SIZE = 5;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWinLines() == 'H' || checkWinDiagonals() == 'H' || checkWinOppositeDiagonals() == 'H') {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWinLines() == 'C' || checkWinDiagonals() == 'C' || checkWinOppositeDiagonals() == 'C') {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }
    public static char checkWinLines() {
        /**
         * counter for lines
         */

        int counterX;
        int couter0;


        /**
         * Checking horizontal lines
         */

        for (int i = 0; i < map.length; i++) {
            counterX = 0;
            couter0 = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_X) {
                    counterX++;
                }
                if (map[i][j] == DOT_O) {
                    couter0++;
                }
            }
            if (counterX == DOTS_TO_WIN) {
                return 'H';
            }
            if (couter0 == DOTS_TO_WIN) {
                return 'C';
            }
        }

        /**
         * Checking vertical lines
         */

        for (int i = 0; i < map.length; i++) {
            counterX = 0;
            couter0 = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == DOT_X) {
                    counterX++;
                }
                if (map[j][i] == DOT_O) {
                    couter0++;
                }
            }
            if (counterX == DOTS_TO_WIN) {
                return 'H';
            }
            if (couter0 == DOTS_TO_WIN) {
                return 'C';
            }
        }
        return 0;
    } //end checkWinLines

    public static char checkWinDiagonals() {
        /**
         * counter for diagonals lines
         */

        int counterX_diag = 0;
        int counter0_diag = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    if (map[i][j] == DOT_X) {
                        counterX_diag++;
                    }
                    if (map[i][j] == DOT_O) {
                        counter0_diag++;
                    }
                }
            }
        }
        if (counterX_diag == DOTS_TO_WIN) {
            return 'H';
        }
        if (counter0_diag == DOTS_TO_WIN) {
            return 'C';
        }
        return 0;
    } //end checkWinDiagonals

        public static char checkWinOppositeDiagonals(){
        /**
        * counter for diagonals lines
        */

        int counterX_diag = 0;
        int counter0_diag = 0;

        /**
        * Checking Opposite diagonals lines
        */

        for (int i=0; i< map.length; i++){
            for (int j = 0,k = map[i].length-1; j < map[i].length; j++, k--) {
                if (i == k){
                    if (map[i][j] == DOT_X){
                        counterX_diag++;
                    }
                    if (map[i][j] == DOT_O){
                        counter0_diag++;
                    }
                }
            }
        }
        if (counterX_diag == DOTS_TO_WIN){
            return 'H';
        }
        if (counter0_diag == DOTS_TO_WIN){
            return 'C';
        }
        return 0;
    } // end checkWinOppositeDiagonals

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    } // end isMapFull

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    } // end aiTurn

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    } // end humanTurn

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    } // end isCellValid

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    } // end initMap

    public static void printMap() {

        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        } // печать шапки
        System.out.print("← x");
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " "); // печать координат слева
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("↑");
        System.out.println("y");
        System.out.println();
    } //end printMap
}