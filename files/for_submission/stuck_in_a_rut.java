import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


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
                    //System.out.println(eCow + " " + nCow + " " + new Collision(eCow, nCow).collideTime + " " + new Collision(eCow, nCow).eCowStopsFirst);
                }
            }
        }
        Collections.sort(collisions);
        //collisions.stream().forEach(c -> System.out.println(c.nCow + " " + c.eCow + " " + c.collideTime));

        HashMap<Pair<Integer, Integer>, Integer> map = new HashMap<>(); // store distances traveled;
        for (int i = 0; i < collisions.size(); i++) {
            Collision collision = collisions.get(i);

            // cow has already stopped, no collision
            if ((map.containsKey(collision.eCow) && map.get(collision.eCow) + collision.eCow.x < collision.nCow.x) ||
                    (map.containsKey(collision.nCow) && map.get(collision.nCow) + collision.nCow.y < collision.eCow.y)) {
                continue;
            }

            // collision will happen at this point
            if (collision.eCowStopsFirst) {
                map.put(collision.eCow, collision.collideTime);
            } else {
                map.put(collision.nCow, collision.collideTime);
            }
        }

        for (Pair<Integer, Integer> cow : ordered) {
            int mapVal = map.getOrDefault(cow, -1);
            io.println(mapVal != -1 ? mapVal : "Infinity");
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



class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in, System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    // USACO-style file input
    public Kattio(String problemName) throws IOException {
        super(problemName + ".out");
        r = new BufferedReader(new FileReader(problemName + ".in"));
    }
    // returns null if no more input
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) {}
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}
