import utils.Kattio;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class balancing {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("balancing");

        int n = io.nextInt();
        int b = io.nextInt();
        Pair<Integer, Integer>[] pairs = new Pair[n];
        int[] xCoords = new int[n];
        int[] yCoords = new int[n];
        for (int i = 0; i < n; i++) {
            xCoords[i] = io.nextInt();
            yCoords[i] = io.nextInt();
            pairs[i] = new Pair<>(xCoords[i], yCoords[i]);
        }
        Arrays.sort(xCoords);
        Arrays.sort(yCoords);
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
            balancing.Pair<?, ?> pair = (balancing.Pair<?, ?>) o;
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
