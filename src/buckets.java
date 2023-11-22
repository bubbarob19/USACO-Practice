import utils.Kattio;

import java.io.IOException;

public class buckets {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("buckets");

        // 0 = none, 1 = barn, 2 = lake, 3 = rock
        int bx = 0;
        int by = 0;
        int lx = 0;
        int ly = 0;
        int rx = 0;
        int ry = 0;

        for (int i = 0; i < 10; i++) {
            String next = io.next();
            for (int j = 0; j < 10; j++) {
                char c = next.charAt(j);
                if (c == 'L') {
                    lx = i;
                    ly = j;
                } else if (c == 'R') {
                    rx = i;
                    ry = j;
                } else if (c == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        if (rockNotInWay(bx, by, lx, ly, rx, ry))
            io.print(Math.abs(bx-lx) + Math.abs(by-ly) - 1);
        else {
            if (bx - lx == 0) {
                io.print(Math.abs(by-ly) + 1);
            } else {
                io.print(Math.abs(bx-lx) + 1);
            }
        }

        io.close();
    }

    private static boolean rockNotInWay(int bx, int by, int lx, int ly, int rx, int ry) {
        if (bx != lx && by != ly)
            return true;
        if (bx == lx && rx == bx && ((ry > by && ry < ly) || (ry < by && ry > ly)))
            return false;
        if (by == ly && ry == by && ((rx > bx && rx < lx) || (rx < bx && rx > lx)))
            return false;
        return true;
    }
}
