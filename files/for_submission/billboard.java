import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;




public class billboard {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("billboard");

        boolean[][] area = new boolean[2001][2001];
        Rectangle rectangle = new Rectangle(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
        for (int i = rectangle.x1; i < rectangle.x2; i++) {
            for (int j = rectangle.y1; j < rectangle.y2; j++) {
                area[1000 + i][1000 + j] = true;
            }
        }
        rectangle = new Rectangle(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
        for (int i = rectangle.x1; i < rectangle.x2; i++) {
            for (int j = rectangle.y1; j < rectangle.y2; j++) {
                area[1000 + i][1000 + j] = true;
            }
        }
        rectangle = new Rectangle(io.nextInt(), io.nextInt(), io.nextInt(), io.nextInt());
        for (int i = rectangle.x1; i < rectangle.x2; i++) {
            for (int j = rectangle.y1; j < rectangle.y2; j++) {
                area[1000 + i][1000 + j] = false;
            }
        }
        int total = 0;
        for (boolean[] bArr : area) {
            for (boolean b : bArr) {
                if (b)
                    total++;
            }
        }
        io.println(total);

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
