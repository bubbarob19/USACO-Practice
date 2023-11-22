import utils.Kattio;

import java.io.IOException;
import java.util.Arrays;

public class blist {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("blist");

        int n = io.nextInt();
        int[] bucketsUsed = new int[1001];
        for (int i = 0; i < n; i++) {
            int s = io.nextInt();
            int t = io.nextInt();
            int b = io.nextInt();
            for (int j = s; j < t + 1; j++) {
                bucketsUsed[j] += b;
            }
        }
        Arrays.sort(bucketsUsed);
        io.println(bucketsUsed[1000]);

        io.close();
    }
}
