import utils.Kattio;

import java.io.IOException;
import java.util.Arrays;

public class diamond {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("diamond");

        int n = io.nextInt();
        int k = io.nextInt();
        int[] diamonds = new int[n];
        for (int i = 0; i < n; i++) {
            diamonds[i] = io.nextInt();
        }
        Arrays.sort(diamonds);
        int max = 0;
        for (int i = 0; i < diamonds.length - 1; i++) {
            int count = 1;
            for (int j = i + 1; j < diamonds.length; j++) {
                if (diamonds[j] - diamonds[i] <= k)
                    count++;
                else
                    break;
            }
            max = Math.max(count, max);
        }

        io.println(max);

        io.close();
    }
}
