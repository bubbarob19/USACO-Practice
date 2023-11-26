import utils.Kattio;

public class twotables {
    public static Kattio io;

    public static void main(String[] args) {
        io = new Kattio();

        int t = io.nextInt();
        while (t-- != 0) {
            solve();
        }

        io.close();
    }

    public static void solve() {
        int w = io.nextInt();
        int h = io.nextInt();
        int x1 = io.nextInt();
        int y1 = io.nextInt();
        int x2 = io.nextInt();
        int y2 = io.nextInt();
        int t2w = io.nextInt();
        int t2h = io.nextInt();
        int rectW = x2 - x1;
        int rectH = y2 - y1;

        int minDist = Integer.MAX_VALUE;
        if (x1 >= t2w || (w - x2) >= t2w || y1 >= t2h || (h - y2) >= t2h)
            minDist = 0;
        if (w - rectW - t2w >= 0) {
            if (w - x2 > x1)
                minDist = Math.min(Math.max(0, t2w - (w - x2)), minDist);
            else
                minDist = Math.min(Math.max(0, t2w - x1), minDist);
        }
        if (h - rectH - t2h >= 0) {
            if (h - y2 > y1)
                minDist = Math.min(Math.max(0, t2h - (h - y2)), minDist);
            else
                minDist = Math.min(Math.max(0, t2h - y1), minDist);
        }
        if (minDist == Integer.MAX_VALUE) {
            io.println(-1);
            return;
        }

        io.println(minDist);
    }
}
