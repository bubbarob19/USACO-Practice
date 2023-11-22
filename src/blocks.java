import utils.Kattio;

import java.io.IOException;
import java.util.HashMap;

public class blocks {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("blocks");

        int n = io.nextInt();
        String[] words1 = new String[n];
        String[] words2 = new String[n];
        for (int i = 0; i < n; i++) {
            words1[i] = io.next();
            words2[i] = io.next();
        }
        int[] blocksNeeded = new int[26];
        for (int i = 0; i < n; i++) {
            int[] foundFirstWord = new int[26];
            int[] foundSecondWord = new int[26];
            for (char c : words1[i].toCharArray()) {
                foundFirstWord[c - 97]++;
            }
            for (char c : words2[i].toCharArray()) {
                foundSecondWord[c - 97]++;
            }
            for (int j = 0; j < 26; j++) {
                int max = Math.max(foundSecondWord[j], foundFirstWord[j]);
                if (max != 0) {
                    blocksNeeded[j] += max;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            io.println(blocksNeeded[i]);
        }

        io.close();
    }
}
