import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class cbarn {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cbarn");

        int n = io.nextInt();
        int[] cowsNeeded = new int[n];
        for (int i = 0; i < n; i++) {
            cowsNeeded[i] = io.nextInt();
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = 0;
            for (int j = 0; j < n - 1; j++) {
                // j = the starting door
                int index = (i - j - 1) % n;
                if (index < 0)
                    index += n;
                dist += cowsNeeded[index] * (n - j - 1);
            }
            minDistance = Math.min(minDistance, dist);
        }

        io.println(minDistance);

        io.close();
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
