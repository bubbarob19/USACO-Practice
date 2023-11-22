import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.*;

public class guess {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("guess");

        int n = io.nextInt();
        String[] animals = new String[n];
        ArrayList<ArrayList<String>> animalTraits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            animals[i] = io.next();
            int t = io.nextInt();
            ArrayList<String> traits = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                String trait = io.next();
                traits.add(trait);
            }
            animalTraits.add(traits);
        }
        int max = 0;
        for (int i = 0; i < animalTraits.size() - 1; i++) {
            for (int j = i + 1; j < animalTraits.size(); j++) {
                int yeses = 1;
                ArrayList<String> a1 = animalTraits.get(i);
                ArrayList<String> a2 = animalTraits.get(j);
                for (String s : a1) {
                    if (a2.contains(s))
                        yeses++;
                }
                max = Math.max(yeses, max);
            }
        }
        io.println(max);

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
