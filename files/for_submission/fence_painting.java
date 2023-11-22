import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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



public class fence_painting {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("paint");

        int a = io.nextInt();
        int b = io.nextInt();
        int c = io.nextInt();
        int d = io.nextInt();

        int[] covered = new int[200];
        for (int x = a; x < b; x++)
            covered[x] = 1;
        for (int x = c; x < d; x++)
            covered[x] = 1;

        int coveredTotal = 0;
        for (int x = 0; x < 200; x++)
            if (covered[x] == 1)
                coveredTotal++;

        io.print(coveredTotal);

        io.close();
    }
}
