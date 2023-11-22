import utils.Kattio;

import java.io.IOException;

public class shuffle {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("shuffle");

        int n = io.nextInt();
        int[] shuffle = new int[n];
        for (int i = 0; i < n; i++) {
            shuffle[i] = io.nextInt() - 1;
        }
        int[] ogOrder = new int[n];
        for (int i = 0; i < n; i++) {
            ogOrder[i] = io.nextInt();
        }

        // simulate 3 backwards shuffles
        for (int i = 0; i < 3; i++) {
            int[] newArr = new int[n];
            for (int j = 0; j < n; j++) {
                newArr[j] = ogOrder[shuffle[j]];
            }
            ogOrder = newArr;
        }

        for (int i : ogOrder) {
            io.println(i);
        }

        io.close();
    }
}
