import utils.Kattio;

import java.io.IOException;
import java.util.Arrays;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lifeguards");

        int n = io.nextInt();
        int[] startingTimes = new int[n];
        int[] endingTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startingTimes[i] = io.nextInt();
            endingTimes[i] = io.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] timeCovered = new int[1001];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                for (int k = startingTimes[j]; k < endingTimes[j]; k++) {
                    timeCovered[k] = 1;
                }
            }
            Arrays.sort(timeCovered);
            int k;
            for (k = 1000; k >= 0; k--) {
                if (timeCovered[k] == 0)
                    break;
            }
            max = Math.max(max, 1000 - k);
        }
        io.print(max);

        io.close();
    }
}
