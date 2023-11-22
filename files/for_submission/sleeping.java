import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


import java.util.ArrayList;
import java.util.Arrays;

public class sleeping {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int t = io.nextInt();
        t:
        for (int tc = 0; tc < t; tc++) {
            int n = io.nextInt();
            ArrayList<Integer> times = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int time = io.nextInt();
                if (time == 0) {
                    count++;
                } else {
                    times.add(time);
                }
            }
            if (times.size() == 0) {
                io.println(0);
                continue;
            }
            boolean finished = false;
            i:
            for (int i = 0; i < times.size(); i++) {
                int toGetTo = 0;
                int minusCount = 0;
                for (int j = i; j >= 0; j--) {
                    toGetTo += times.get(j);
                }
                int foundAlong = 0;
                for (int j = i + 1; j < times.size(); j++) {
                    foundAlong += times.get(j);
                    if (foundAlong == toGetTo) {
                        foundAlong = 0;
                        minusCount++;
                    }
                    if (foundAlong > toGetTo)
                        continue i;
                }
                if (foundAlong != 0)
                    continue;
                finished = true;
                io.println(count + times.size() - 1 - minusCount);
                break i;
            }
            if (!finished) {
                io.println(times.size() - 1);
            }
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
