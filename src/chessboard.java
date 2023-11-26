import utils.Kattio;

import java.util.Arrays;

import static java.util.Collections.copy;

public class chessboard {
    public static boolean[][] board = new boolean[8][8];
    public static int solutions = 0;

    public static void main(String[] args) {
        Kattio io = new Kattio();

        for (int i = 0; i < 8; i++) {
            char[] arr = io.next().toCharArray();
            for (int j = 0; j < 8; j++) {
                board[i][j] = arr[j] == '*';
            }
        }
        generateSolution(board, 0);
        io.println(solutions);

        io.close();
    }

    public static void generateSolution(boolean[][] state, int queenCount) {
        if (queenCount == 8) {
            solutions++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (state[i][j])
                    continue;

                boolean[][] copy = copyAndCover(state, i, j);
                generateSolution(copy, queenCount + 1);
            }
        }
    }

    private static boolean[][] copyAndCover(boolean[][] state, int x, int y) {
        boolean[][] newArr = new boolean[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                newArr[i][j] = state[i][j] || (x == i) || (y == j) || (Math.abs(x - i) == Math.abs(y - j));
            }
        }
        return newArr;
    }

}
