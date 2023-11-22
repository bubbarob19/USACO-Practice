import utils.Kattio;

import java.io.IOException;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("gymnastics");

        int k = io.nextInt();
        int n = io.nextInt();
        int[][] results = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                results[i][j] = io.nextInt() - 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            permuteloop:
            for (int j = i + 1; j < n; j++) {
                int consistentWinner = -1;
                for (int[] result : results) {
                    for (int l : result) {
                        if (l == i || l == j) {
                            if (consistentWinner != -1 && consistentWinner != l)
                                continue permuteloop;
                            else {
                                consistentWinner = l;
                                break;
                            }
                        }
                    }
                }
                count++;
            }
        }
        io.println(count);

        io.close();
    }
}
