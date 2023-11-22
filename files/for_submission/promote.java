import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class promote {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("promote");

        int oldTotal = 0;
        int newTotal = 0;
        int[] oldAmounts = new int[4];
        int[] newAmounts = new int[4];

        int BtoS = 0;
        int StoG = 0;
        int GtoP = 0;

        for (int i = 0; i < 4; i++) {
            oldAmounts[i] = io.nextInt();
            oldTotal += oldAmounts[i];
            newAmounts[i] = io.nextInt();
            newTotal += newAmounts[i];
        }

        oldAmounts[0] += newTotal - oldTotal;

        for (int i = 0; i < 3; i++) {
            int difference = oldAmounts[i] - newAmounts[i];
            if (difference == 0)
                continue;

            oldAmounts[i] -= difference;
            oldAmounts[i + 1] += difference;
            if (i == 0)
                BtoS += difference;
            else if (i == 1)
                StoG += difference;
            else if (i == 2)
                GtoP += difference;
        }

        io.println(BtoS);
        io.println(StoG);
        io.println(GtoP);

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
