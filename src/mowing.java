import utils.Kattio;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class mowing {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mowing");

        int n = io.nextInt();
        Pair<Integer, Integer> coords = new Pair<>(0, 0);
        int max = Integer.MAX_VALUE;
        boolean ranInto = false;
        int time = 0;
        HashMap<Pair<Integer, Integer>, Integer> times = new HashMap<>();
        times.put(coords, 0);
        for (int i = 0; i < n; i++) {
            char c = io.next().charAt(0);
            int amount = io.nextInt();
            for (int j = 0; j < amount; j++) {
                time++;
                if (c == 'N')
                    coords = new Pair<>(coords.x, coords.y + 1);
                else if (c == 'S')
                    coords = new Pair<>(coords.x, coords.y - 1);
                else if (c == 'E')
                    coords = new Pair<>(coords.x + 1, coords.y);
                else
                    coords = new Pair<>(coords.x - 1, coords.y);
                if (times.containsKey(coords)) {
                    ranInto = true;
                    max = Math.min(max, time - times.get(coords));
                }
                times.put(coords, time);
            }
        }
        if (ranInto)
            io.println(max);
        else
            io.println("-1");

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
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
