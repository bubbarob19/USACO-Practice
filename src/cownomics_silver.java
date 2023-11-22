import utils.Kattio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class cownomics_silver {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cownomics");

        int n = io.nextInt();
        int m = io.nextInt();
        ArrayList<char[]> spottedList = new ArrayList<>();
        ArrayList<char[]> plainList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            spottedList.add(io.next().toCharArray());
        }
        for (int i = 0; i < n; i++) {
            plainList.add(io.next().toCharArray());
        }

        int count = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = i + 1; j < m - 1; j++) {
                k:
                for (int k = j + 1; k < m; k++) {
                    HashSet<String> spottedGenomes = new HashSet<>();
                    for (int l = 0; l < n; l++) {
                        char[] cArr = spottedList.get(l);
                        char[] sorted = new char[]{cArr[i], cArr[j], cArr[k]};
//                        Arrays.sort(sorted);
                        spottedGenomes.add(String.copyValueOf(sorted));
                    }
                    for (int l = 0; l < n; l++) {
                        char[] cArr = plainList.get(l);
                        char[] sorted = new char[]{cArr[i], cArr[j], cArr[k]};
//                        Arrays.sort(sorted);
                        if (spottedGenomes.contains(String.copyValueOf(sorted)))
                            continue k;
                    }
                    count++;
                }
            }
        }
        io.println(count);

        io.close();
    }
}
