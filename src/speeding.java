import utils.Kattio;

import java.io.IOException;

public class speeding {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("speeding");

        int n = io.nextInt();
        int m = io.nextInt();
        int[] speedLimits = new int[100];
        int length = 0;
        int newLength = 0;
        for (int i = 0; i < n; i++) {
            newLength += io.nextInt();
            int limit = io.nextInt();
            for (int j = length; j < newLength; j++) {
                speedLimits[j] = limit;
            }
            length = newLength;
        }

        int[] bessieSpeed = new int[100];
        int bLength = 0;
        int bNewLength = 0;
        for (int i = 0; i < m; i++) {
            bNewLength += io.nextInt();
            int limit = io.nextInt();
            for (int j = bLength; j < bNewLength; j++) {
                bessieSpeed[j] = limit;
            }
            bLength = bNewLength;
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            max = Math.max(max, bessieSpeed[i] - speedLimits[i]);
        }
        io.println(max);

        io.close();
    }
}
