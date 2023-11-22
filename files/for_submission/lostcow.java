import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class lostcow {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lostcow");

        int x = io.nextInt();
        int y = io.nextInt();

        int coord = x;
        int distTraveled = 0;
        int factor = 1;

        while(true) {
            int oldCoord = coord;
            coord = factor + x;
            distTraveled += Math.abs(coord - oldCoord);
            if (x < y && coord >= y) {
                distTraveled -= (coord - y);
                break;
            }
            if (x > y && coord <= y){
                distTraveled -= (y - coord);
                break;
            }

            factor *= -2;
        }

        io.println(distTraveled);

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
