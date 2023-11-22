import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.Arrays;

public class blist {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("blist");

        int n = io.nextInt();
        int[] bucketsUsed = new int[1001];
        for (int i = 0; i < n; i++) {
            int s = io.nextInt();
            int t = io.nextInt();
            int b = io.nextInt();
            for (int j = s; j < t + 1; j++) {
                bucketsUsed[j] += b;
            }
        }
        Arrays.sort(bucketsUsed);
        io.println(bucketsUsed[1000]);

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
