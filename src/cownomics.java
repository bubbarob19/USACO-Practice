import utils.Kattio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class cownomics {
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
        outer:
        for (int i = 0; i < m; i++) {
            HashSet<Character> foundInSpotted = new HashSet<>();
            for (char[] chars : spottedList) {
                foundInSpotted.add(chars[i]);
            }
            for (char[] chars : plainList) {
                if (foundInSpotted.contains(chars[i]))
                    continue outer;
            }
            count++;
        }
        io.println(count);

        io.close();
    }
}
