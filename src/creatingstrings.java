import utils.Kattio;

import java.util.ArrayList;
import java.util.Collections;

public class creatingstrings {
    static ArrayList<String> permutes = new ArrayList<>();
    static char[] charCount = new char[26];
    static int n;

    public static void main(String[] args) {
        Kattio io = new Kattio();

        String s = io.next();
        n = s.length();
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        generatePermutes("");

        int size = permutes.size();
        io.println(size);
        for (String st : permutes) {
            io.println(st);
        }

        io.close();
    }

    private static void generatePermutes(String s) {
        if (s.length() == n) {
            permutes.add(s);
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount[i] == 0)
                continue;
            charCount[i]--;
            char c = (char) ('a' + i);
            generatePermutes(s + c);
            charCount[i]++;
        }
    }
}
