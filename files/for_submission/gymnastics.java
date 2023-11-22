import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class gymnastics {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("gymnastics");

        int k = io.nextInt();
        int n = io.nextInt();
        int[][] results = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                results[i][j] = io.nextInt() - 1;
            }
        }

        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            permuteloop:
            for (int j = i + 1; j < n; j++) {
                int consistentWinner = -1;
                for (int[] result : results) {
                    findnumberloop:
                    for (int l : result) {
                        if (l == i || l == j) {
                            if (consistentWinner != -1 && consistentWinner != l)
                                continue permuteloop;
                            else {
                                consistentWinner = l;
                                break findnumberloop;
                            }
                        }
                    }
                }
                count++;
            }
        }
        io.println(count);

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
