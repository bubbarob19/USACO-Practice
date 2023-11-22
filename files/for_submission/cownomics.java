import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.ArrayList;
import java.util.HashSet;

public class cownomics {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cownomics");

        int n = io.nextInt();
        int m = io.nextInt();
        ArrayList<char[]> spottedList = new ArrayList<>();
        ArrayList<char[]> plainList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            spottedList.add(io.next().toCharArray());
        }
        for (int i = 0; i < n; i++) {
            plainList.add(io.next().toCharArray());
        }

        int count = 0;
        outer:
        for (int i = 0; i < m; i++) {
            HashSet<Character> foundInSpotted = new HashSet<>();
            for (char[] chars : spottedList) {
                foundInSpotted.add(chars[i]);
            }
            for (char[] chars : plainList) {
                if (foundInSpotted.contains(chars[i]))
                    continue outer;
            }
            count++;
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
