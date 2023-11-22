import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.HashMap;

public class blocks {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("blocks");

        int n = io.nextInt();
        String[] words1 = new String[n];
        String[] words2 = new String[n];
        for (int i = 0; i < n; i++) {
            words1[i] = io.next();
            words2[i] = io.next();
        }
        int[] blocksNeeded = new int[26];
        for (int i = 0; i < n; i++) {
            int[] foundFirstWord = new int[26];
            int[] foundSecondWord = new int[26];
            for (char c : words1[i].toCharArray()) {
                foundFirstWord[c - 97]++;
            }
            for (char c : words2[i].toCharArray()) {
                foundSecondWord[c - 97]++;
            }
            for (int j = 0; j < 26; j++) {
                int max = Math.max(foundSecondWord[j], foundFirstWord[j]);
                if (max != 0) {
                    blocksNeeded[j] += max;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            io.println(blocksNeeded[i]);
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
