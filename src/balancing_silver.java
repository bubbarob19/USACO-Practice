import utils.Kattio;

import java.io.IOException;
import java.util.*;

public class balancing_silver {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("balancing");

        int n = io.nextInt();
        Pair<Integer, Integer>[] pairs = new Pair[n];
        ArrayList<Integer> xCoords = new ArrayList<>();
        ArrayList<Integer> yCoords = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = io.nextInt();
            int y = io.nextInt();
            if (!xCoords.contains(x))
                xCoords.add(x);
            if (!yCoords.contains(y))
                yCoords.add(y);
            pairs[i] = new Pair<>(x, y);
        }

        int max = 100;
        for (int x : xCoords) {
            for (int y : yCoords) {
                int ne = 0;
                int nw = 0;
                int se = 0;
                int sw = 0;
                for (Pair<Integer, Integer> pair : pairs) {
                    if (pair.x > x && pair.y > y)
                        ne++;
                    else if (pair.x > x)
                        se++;
                    else if (pair.y > y)
                        nw++;
                    else
                        sw++;
                }
                max = Math.min(max, Math.max(ne, Math.max(nw, Math.max(sw, se))));
            }
        }
        io.println(max);

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
            balancing_silver.Pair<?, ?> pair = (balancing_silver.Pair<?, ?>) o;
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
