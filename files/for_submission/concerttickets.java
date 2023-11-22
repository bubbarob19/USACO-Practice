import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

public class concerttickets {
    public static void main(String[] args) throws Exception {
        FastIO io = new FastIO();

        int nTickets = io.nextInt();
        int nCustomers = io.nextInt();

        ArrayList<Integer> ticketPrices = new ArrayList<>();
        ArrayList<Integer> customers = new ArrayList<>();

        for (int i = 0; i < nTickets; i++) {
            ticketPrices.add(io.nextInt());
        }
        Collections.sort(ticketPrices);
        for (int i = 0; i < nCustomers; i++) {
            customers.add(io.nextInt());
        }

        for (int customer : customers) {
            int index = ticketPrices.isEmpty() ? -1 : findTicketIndex(customer, ticketPrices, 0, ticketPrices.size() - 1);
            int price = index != -1 ? ticketPrices.remove(index) : -1;
            io.println(price);
        }

        io.close();
    }

    public static int findTicketIndex(int customer, ArrayList<Integer> ticketPrices, int start, int end) {
        if (customer < ticketPrices.get(start))
            return -1;

        if (start == end)
            return start;
        if (start + 1 == end) {
            if (ticketPrices.get(start + 1) <= customer)
                return start + 1;
            if (ticketPrices.get(start) <= customer)
                return start;
            else
                return -1;
        }

        int middle = (end + start) / 2;
        if (ticketPrices.get(middle) > customer)
            return findTicketIndex(customer, ticketPrices, 0, middle);
        if (ticketPrices.get(middle) == customer)
            return middle;
        else {
            return findTicketIndex(customer, ticketPrices, middle, end);
        }
    }
}

class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1 << 16];
    private int curChar;
    private int numChars;

    // standard input
    public FastIO() { this(System.in, System.out); }

    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }

    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }

    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) { throw new InputMismatchException(); }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) { throw new InputMismatchException(); }
            if (numChars == -1) {
                return -1;  // end of file
            }
        }
        return buf[curChar++];
    }

    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c;
        do { c = nextByte(); } while (c <= ' ');

        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = nextByte();
        } while (c > ' ');
        return res.toString();
    }

    public int nextInt() {  // nextLong() would be implemented similarly
        int c;
        do { c = nextByte(); } while (c <= ' ');

        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = nextByte();
        }

        int res = 0;
        do {
            if (c < '0' || c > '9') { throw new InputMismatchException(); }
            res = 10 * res + c - '0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }

    public double nextDouble() { return Double.parseDouble(next()); }
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
