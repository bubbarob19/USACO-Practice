import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



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
//        Collections.sort(xCoords);
        int max = Integer.MAX_VALUE;
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
