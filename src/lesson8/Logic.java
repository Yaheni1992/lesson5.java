package lesson8;


import java.util.Random;

public class Logic {

    static int SIZE = 3;
    static int WIN_TO_LINE = 3;

    static final char DOT_X = 'X';
    static final char DOT_0 = '0';
    static final char DOT_EMPTY = '•';

    static char[][] map;

    static boolean gameFinished;
    static Random rand = new Random();

    public static void go() {
        gameFinished = true;
            printMap();
            if (checkWin(DOT_X, WIN_TO_LINE)) {
                System.out.println("Победил человек");
                return;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                return;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_0, WIN_TO_LINE)) {
                System.out.println("Победил Искуственный Интеллект");
                return;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                return;
            }
        gameFinished = false;
    }

    public static boolean checkLines(int cy, int cx, int vy, int vx, char a, int victoryToLine) {
        if (cx + vx * (victoryToLine - 1) > SIZE - 1 || cy + vy * (victoryToLine - 1) > SIZE - 1 || cy + vy * (victoryToLine - 1) < 0)
        {
            return false;
        }
        for (int i = 0; i < victoryToLine; i++) {
            if (map[cy + i * vy][cx + i * vx] != a) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWin(char a, int victoryLine) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLines(i, j, 0, 1, a, victoryLine) ||
                        checkLines(i, j, 1, 0, a,victoryLine) ||
                        checkLines(i, j, 1, 1, a, victoryLine) ||
                        checkLines(i, j, -1, 1, a, victoryLine)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_0;
    }

    public static void humanTurn(int x, int y) {
        if(isCellValid(x, y)) {
            map[y][x] = DOT_X;
            go();
        }

    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}