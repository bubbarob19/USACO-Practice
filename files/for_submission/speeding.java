import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class speeding {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("speeding");

        int n = io.nextInt();
        int m = io.nextInt();
        int[] speedLimits = new int[100];
        int length = 0;
        int newLength = 0;
        for (int i = 0; i < n; i++) {
            newLength += io.nextInt();
            int limit = io.nextInt();
            for (int j = length; j < newLength; j++) {
                speedLimits[j] = limit;
            }
            length = newLength;
        }

        int[] bessieSpeed = new int[100];
        int bLength = 0;
        int bNewLength = 0;
        for (int i = 0; i < m; i++) {
            bNewLength += io.nextInt();
            int limit = io.nextInt();
            for (int j = bLength; j < bNewLength; j++) {
                bessieSpeed[j] = limit;
            }
            bLength = bNewLength;
        }

        int max = 0;
        for (int i = 0; i < 100; i++) {
            max = Math.max(max, bessieSpeed[i] - speedLimits[i]);
        }
        io.println(max);

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
