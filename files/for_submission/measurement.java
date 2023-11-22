import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.Arrays;

public class measurement {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("measurement");

        int n = io.nextInt();

        // 0 = Bessie, 1 = Elsie, 2 = Mildred
        String topCows = "012";
        int[] milkLevels = new int[]{7, 7, 7};
        Pair<Integer, Integer>[] gallonOperations = new Pair[101];
        for (int i = 0; i < n; i++) {
            int day = io.nextInt();
            int cow = cowNumFromStr(io.next());
            String numStr = io.next();
            if (numStr.charAt(0) == '+')
                numStr = numStr.substring(1);
            int num = Integer.parseInt(numStr);
            Pair<Integer,Integer> pair = new Pair<>(cow, num);
            gallonOperations[day] = pair;
        }

        int total = 0;
        for (int i = 0; i < 101; i++) {
            if (gallonOperations[i] != null)
                milkLevels[gallonOperations[i].t] += gallonOperations[i].u;
            //System.out.println(milkLevels[0] + " " + milkLevels[1] + " " +milkLevels[2] + " " + topCows(milkLevels));
            String newTopCows = topCows(milkLevels);
            if (!newTopCows.equals(topCows))
                total++;
            topCows = newTopCows;
        }

        io.println(total);

        io.close();
    }

    private static int cowNumFromStr(String next) {
        if (next.equalsIgnoreCase("bessie"))
            return 0;
        if (next.equalsIgnoreCase("elsie"))
            return 1;
        return 2;
    }

    public static String topCows(int[] milkLevels) {
        if (milkLevels[0] > milkLevels[1] && milkLevels[0] > milkLevels[2])
            return "0";
        if (milkLevels[1] > milkLevels[0] && milkLevels[1] > milkLevels[2])
            return "1";
        if (milkLevels[2] > milkLevels[1] && milkLevels[2] > milkLevels[0])
            return "2";
        if (milkLevels[0] == milkLevels[1] && milkLevels[0] ==milkLevels[2])
            return "012";
        if (milkLevels[0] == milkLevels[1])
            return "01";
        if (milkLevels[0] == milkLevels[2])
            return "02";
        return "12";
    }
}

class Pair<T, U> {
    public T t;
    public U u;

    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
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
