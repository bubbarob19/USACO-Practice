import utils.Kattio;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

public class circlecross {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("circlecross");

        char[] crosses = io.next().toCharArray();
        boolean[] charsAnalysed = new boolean[26];
        HashSet<Pair<Integer, Integer>> pairs = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            char c = crosses[i];
            if (charsAnalysed[c - 65])
                continue;

            int j = i + 1;
            int[] charsFound = new int[26];
            while (true) {
                char c2 = crosses[j];
                if (c2 == c)
                    break;
                charsFound[c2 - 65]++;
                j++;
                if (j == 52)
                    j = 0;
            }

            charsAnalysed[c - 65] = true;
            for (int k = 0; k < 26; k++) {
                if (charsFound[k] != 1)
                    continue;
                // c is bigger character
                if (k < c - 65)
                    pairs.add(new Pair<>(k, c - 65));
                else
                    pairs.add(new Pair<>(c - 65, k));
            }
        }
        io.println(pairs.size());

        io.close();
    }

    static class Pair<T, U> {
        public T x;
        public U y;

        public Pair(T x, U y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            circlecross.Pair<?, ?> pair = (circlecross.Pair<?, ?>) o;
            return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
