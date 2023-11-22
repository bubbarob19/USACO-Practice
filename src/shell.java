import utils.Kattio;

import java.io.IOException;
import java.util.Arrays;

public class shell {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("shell");

        // [case type: shell starts at 0,1,or 2][shell lineup, 0,1,2][iteration of swap]
        int n = io.nextInt();
        int[][][] n1 = new int[3][3][n];
        n1[0][0][0] = 1;
        n1[1][1][0] = 1;
        n1[2][2][0] = 1;

        int[] guessCount = new int[3];
        for (int i = 0; i < n; i++) {
            int swap1 = io.nextInt() - 1;
            int swap2 = io.nextInt() - 1;
            int guess = io.nextInt() - 1;
            for (int j = 0; j < 3; j++) {
                //System.out.println(n1 + " " + swap1 + " " + swap2 + " " + i + " " + j);
                swap(n1, swap1, swap2, i, j);
                if (n1[j][guess][i] == 1)
                    guessCount[j]++;
            }
        }

        Arrays.sort(guessCount);
        io.println(guessCount[2]);

        io.close();
    }

    public static void swap(int[][][] arr, int shell1, int shell2, int iteration, int caseNum) {
        int temp = arr[caseNum][shell1][iteration];
        arr[caseNum][shell1][iteration] = arr[caseNum][shell2][iteration];
        arr[caseNum][shell2][iteration] = temp;

        if (iteration < arr[0][0].length - 1) {
            for (int i = 0; i < 3; i++) {
                arr[caseNum][i][iteration + 1] = arr[caseNum][i][iteration];
            }
        }
    }
}
