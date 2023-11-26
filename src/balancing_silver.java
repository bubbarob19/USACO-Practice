import utils.Kattio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

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
        Collections.sort(xCoords);
        Collections.sort(yCoords);

        int max = Integer.MAX_VALUE;
        for (int i = xCoords.size() / 4; i < xCoords.size() * 3 / 4; i++) {
            int x = xCoords.get(i);
            for (int j = yCoords.size() / 4; j < yCoords.size() * 3 / 4; j++) {
                int y = yCoords.get(j);
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
