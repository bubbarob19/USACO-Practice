import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.Arrays;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lifeguards");

        int n = io.nextInt();
        int[] startingTimes = new int[n];
        int[] endingTimes = new int[n];
        for (int i = 0; i < n; i++) {
            startingTimes[i] = io.nextInt();
            endingTimes[i] = io.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int[] timeCovered = new int[1001];
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                for (int k = startingTimes[j]; k < endingTimes[j]; k++) {
                    timeCovered[k] = 1;
                }
            }
            Arrays.sort(timeCovered);
            int k;
            for (k = 1000; k >= 0; k--) {
                if (timeCovered[k] == 0)
                    break;
            }
            max = Math.max(max, 1000 - k);
        }
        io.print(max);

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
