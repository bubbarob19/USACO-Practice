import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class word {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("word");

        int n = io.nextInt();
        int limit = io.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = io.next();
        }

        int currentCount = 0;
        String currentLineContent = "";
        for (String word : words) {
            int len = word.length();
            if (len + currentCount > limit) {
                io.println(currentLineContent);
                currentLineContent = word;
                currentCount = len;
                continue;
            }
            if (currentCount != 0)
                currentLineContent += " ";
            currentLineContent += word;
            currentCount += len;
        }
        if (currentCount != 0) {
            io.print(currentLineContent);
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
