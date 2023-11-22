import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class cowsignal {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cowsignal");

        int rows = io.nextInt();
        int cols = io.nextInt();
        int amplifyBy = io.nextInt();
        char[][] original = new char[rows][cols];
        char[][] amped = new char[rows * amplifyBy][cols * amplifyBy];
        for (int i = 0; i < rows; i++) {
            char[] chars = io.next().toCharArray();
            for (int j = 0; j < cols; j++) {
                original[i][j] = chars[j];
            }
        }

        for (int i = 0; i < rows * amplifyBy; i += amplifyBy) {
            for (int j = 0; j < cols * amplifyBy; j += amplifyBy) {
                char val = original[i / amplifyBy][j / amplifyBy];

                for (int k = 0; k < amplifyBy; k++) {
                    for (int l = 0; l < amplifyBy; l++) {
                        amped[i + k][j + l] = val;
                    }
                }
            }
        }

        for (int i = 0; i < amped.length; i++) {
            for (int j = 0; j < amped[0].length; j++) {
                io.print(amped[i][j]);
            }
            io.println();
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
