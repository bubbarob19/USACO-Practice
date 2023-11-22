import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



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
