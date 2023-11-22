import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;



import java.util.ArrayList;
import java.util.Collections;

public class know_your_abcs {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        ArrayList<Integer> input = new ArrayList<>();
        for (int x = 0; x < 7; x++) {
            input.add(io.nextInt());
        }
        Collections.sort(input);
        input.remove(6);

        for (int x = 5; x >= 0; x--) {
            if (isASumOfTwoNumbers(x, input))
                input.remove(x);
            if (input.size() == 3)
                break;
        }

        io.print(input.get(0) + " " + input.get(1) + " " + input.get(2));

        io.close();
    }

    private static boolean isASumOfTwoNumbers(int x, ArrayList<Integer> input) {
        for (int i = 0; i < x - 1; i++) {
            int firstNum = input.get(i);
            for (int j = i + 1; j < x; j++) {
                if (firstNum + input.get(j) == input.get(x))
                    return true;
            }
        }
        return false;
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
