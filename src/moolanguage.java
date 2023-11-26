import utils.Kattio;

import java.util.ArrayList;

public class moolanguage {
    public static Kattio io;

    public static void main(String[] args) {
        io = new Kattio();

        int t = io.nextInt();
        while (t-- != 0) {
            solve();
        }

        io.close();
    }

    public static void solve() {
        int n = io.nextInt();
        int c = io.nextInt();
        int p = io.nextInt();
        ArrayList<String> nouns = new ArrayList<>();
        ArrayList<String> transitive = new ArrayList<>();
        ArrayList<String> intransitive = new ArrayList<>();
        ArrayList<String> conjunction = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String word = io.next();
            String type = io.next();
            if (type.charAt(0) == 'n')
                nouns.add(word);
            else if (type.charAt(0) == 't')
                transitive.add(word);
            else if (type.charAt(0) == 'i')
                intransitive.add(word);
            else
                conjunction.add(word);
        }
    }
}
