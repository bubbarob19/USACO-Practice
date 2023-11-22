import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class mixmilk {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mixmilk");

        int[] capacities = new int[3];
        int[] amountStored = new int[3];
        for (int i = 0; i < 3; i++) {
            capacities[i] = io.nextInt();
            amountStored[i] = io.nextInt();
        }

        for (int i = 0; i < 100; i++) {
            // mod 3 = 0 (1->2), 1 (2->3), 2 (3->1)
            int oldBucket = i % 3;
            int newBucket = (i + 1) % 3;
            int amountNeeded = capacities[newBucket] - amountStored[newBucket];
            if (amountNeeded >= amountStored[oldBucket]) {
                amountStored[newBucket] += amountStored[oldBucket];
                amountStored[oldBucket] = 0;
            }
            else {
                amountStored[newBucket] = capacities[newBucket];
                amountStored[oldBucket] -= amountNeeded;
            }
        }

        for (int i : amountStored)
            io.println(i);

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
