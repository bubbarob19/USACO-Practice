import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class billboard2 {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("billboard");

        Rectangle lawnbb = new Rectangle(io.nextInt(),io.nextInt(),io.nextInt(),io.nextInt());
        Rectangle feedbb = new Rectangle(io.nextInt(),io.nextInt(),io.nextInt(),io.nextInt());

        if (feedbb.y1 <= lawnbb.y1 && feedbb.y2 >= lawnbb.y2 && feedbb.x1 <= lawnbb.x1 && feedbb.x2 >= lawnbb.x2) {
            io.print(0);
        }
        else if (feedbb.x2 < lawnbb.x1 || lawnbb.x2 < feedbb.x1 || feedbb.y2 < lawnbb.y1 || lawnbb.y2 < feedbb.y1)
            io.print(lawnbb.getArea());
        // covers top to bottom
        else if (feedbb.y1 <= lawnbb.y1 && feedbb.y2 >= lawnbb.y2) {
            // on left side
            if (feedbb.x2 < lawnbb.x2) {
                io.print((lawnbb.y2 - lawnbb.y1) * (lawnbb.x2 - feedbb.x2));
            }
            // on right side
            else if (lawnbb.x1 < feedbb.x1){
                io.print((lawnbb.y2 - lawnbb.y1) * (feedbb.x2 - lawnbb.x1));
            }
            else {
                io.print(lawnbb.getArea());
            }
        }
        // covers left to right
        else if (feedbb.x1 <= lawnbb.x1 && feedbb.x2 >= lawnbb.x2) {
            // top
            if (feedbb.y2 > lawnbb.y2) {
                io.print((lawnbb.x2 - lawnbb.x1) * (feedbb.y1 - lawnbb.y1));
            }
            // bottom
            else if (lawnbb.y1 > feedbb.y1) {
                io.print((lawnbb.x2 - lawnbb.x1) * (lawnbb.y2 - feedbb.y1));
            }
            else {
                io.print(lawnbb.getArea());
            }
        }
        else {
            io.print(lawnbb.getArea());
        }

        io.close();
    }

    static class Rectangle {
        public int x1;
        public int y1;
        public int x2;
        public int y2;

        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public int getArea() {
            return Math.abs(x1 - x2) * Math.abs(y1 - y2);
        }
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
