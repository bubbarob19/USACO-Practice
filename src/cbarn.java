import utils.Kattio;

import java.io.IOException;

public class cbarn {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cbarn");

        int n = io.nextInt();
        int[] cowsNeeded = new int[n];
        for (int i = 0; i < n; i++) {
            cowsNeeded[i] = io.nextInt();
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = 0;
            for (int j = 0; j < n - 1; j++) {
                // j = the starting door
                int index = (i - j - 1) % n;
                if (index < 0)
                    index += n;
                dist += cowsNeeded[index] * (n - j - 1);
            }
            minDistance = Math.min(minDistance, dist);
        }

        io.println(minDistance);

        io.close();
    }
}
