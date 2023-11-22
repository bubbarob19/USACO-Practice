import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class shuffle {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("shuffle");

        int n = io.nextInt();
        int[] shuffle = new int[n];
        for (int i = 0; i < n; i++) {
            shuffle[i] = io.nextInt() - 1;
        }
        int[] ogOrder = new int[n];
        for (int i = 0; i < n; i++) {
            ogOrder[i] = io.nextInt();
        }

        // simulate 3 backwards shuffles
        for (int i = 0; i < 3; i++) {
            int[] newArr = new int[n];
            for (int j = 0; j < n; j++) {
                newArr[j] = ogOrder[shuffle[j]];
            }
            ogOrder = newArr;
        }

        for (int i : ogOrder) {
            io.println(i);
        }

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
