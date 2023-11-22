import utils.Kattio;

import java.io.IOException;
import java.util.Objects;

public class triangles {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("triangles");

        int n = io.nextInt();
        Pair<Integer, Integer>[] list = new Pair[n];
        for (int i = 0; i < n; i++) {
            list[i] = new Pair<>(io.nextInt(), io.nextInt());
        }

        int max = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int d1;
                    int d2;
                    if (list[i].x.equals(list[j].x) && !(!list[k].y.equals(list[i].y) && !list[k].y.equals(list[j].y))) {
                        d1 = Math.abs(list[i].y - list[j].y);
                        d2 = Math.abs(list[k].x - list[i].x);
                    }
                    else if (list[j].x.equals(list[k].x) && !(!list[i].y.equals(list[j].y) && !list[i].y.equals(list[k].y))) {
                        d1 = Math.abs(list[j].y - list[k].y);
                        d2 = Math.abs(list[i].x - list[j].x);
                    }
                    else if (list[k].x.equals(list[i].x) && !(!list[j].y.equals(list[k].y) && !list[j].y.equals(list[i].y))) {
                        d1 = Math.abs(list[k].y - list[i].y);
                        d2 = Math.abs(list[j].x - list[k].x);
                    }
                    else
                        continue;

                    max = Math.max(max, d1 * d2);
                }
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
            triangles.Pair<?, ?> pair = (triangles.Pair<?, ?>) o;
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
