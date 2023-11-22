import utils.Kattio;

import java.util.*;

public class stuck_in_a_rut {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        ArrayList<Pair<Integer, Integer>> ordered = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> eCows = new ArrayList<>();
        ArrayList<Pair<Integer, Integer>> nCows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = io.next().charAt(0);
            Pair<Integer, Integer> pair = new Pair<>(io.nextInt(), io.nextInt());
            if (c == 'E')
                eCows.add(pair);
            else
                nCows.add(pair);
            ordered.add(pair);
        }

        ArrayList<Collision> collisions = new ArrayList<>();
        for (Pair<Integer, Integer> eCow : eCows) {
            for (Pair<Integer, Integer> nCow : nCows) {
                if (willCollide(eCow, nCow)) {
                    collisions.add(new Collision(eCow, nCow));
                }
            }
        }
        Collections.sort(collisions);

        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>(); // store distances traveled;
        for (int i = 0; i < collisions.size(); i++) {
            Collision collision = collisions.get(i);

            if ((map.containsKey(collision.eCow) && map.get(collision.eCow) + collision.eCow.x < collision.nCow.x) ||
                    (map.containsKey(collision.nCow) && map.get(collision.nCow) + collision.nCow.y < collision.eCow.y)) {
                continue;
            }

            if (collision.eCowStopsFirst) {
                map.put(collision.eCow, collision.collideTime);
            } else {
                map.put(collision.nCow, collision.collideTime);
            }
        }

        for (Pair<Integer, Integer> cow : ordered) {
            io.println(map.containsKey(cow) ? map.get(cow) : "Infinity");
        }

        io.close();
    }

    public static boolean willCollide(Pair<Integer, Integer> eCow, Pair<Integer, Integer> nCow) {
        return (eCow.x < nCow.x && nCow.y < eCow.y) && (nCow.x - eCow.x != eCow.y - nCow.y);
    }

    static class Collision implements Comparable<Collision> {
        public Pair<Integer, Integer> eCow;
        public Pair<Integer, Integer> nCow;
        public int collideTime;
        public boolean eCowStopsFirst;

        public Collision(Pair<Integer, Integer> eCow, Pair<Integer, Integer> nCow) {
            this.eCow = eCow;
            this.nCow = nCow;
            collideTime = Math.max(eCow.y - nCow.y, nCow.x - eCow.x);
            if (collideTime == nCow.x - eCow.x)
                eCowStopsFirst = true;
        }

        @Override
        public int compareTo(Collision c) {
            return collideTime - c.collideTime;
        }
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
            stuck_in_a_rut.Pair<?, ?> pair = (stuck_in_a_rut.Pair<?, ?>) o;
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
