import utils.Kattio;

import java.io.IOException;

public class traffic {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("traffic");

        int n = io.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(io.next(), io.nextInt(), io.nextInt());
        }

        int least;
        int greatest;

        // range pre
        least = Integer.MIN_VALUE;
        greatest = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (!segments[i].type.equals("none") && least == Integer.MIN_VALUE && greatest == Integer.MAX_VALUE)
                continue;
            if (segments[i].type.equals("none")) {
                least = Math.max(least, segments[i].min);
                greatest = Math.min(greatest, segments[i].max);
            }
            else if (segments[i].type.equals("on")) {
                least -= segments[i].max;
                greatest -= segments[i].min;
            } else {
                least += segments[i].min;
                greatest += segments[i].max;
            }
        }
        if (least < 0) least = 0;
        if (greatest < 0) greatest = 0;
        io.println(least + " " + greatest);


        // range post
        least = Integer.MIN_VALUE;
        greatest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!segments[i].type.equals("none") && least == Integer.MIN_VALUE && greatest == Integer.MAX_VALUE)
                continue;
            if (segments[i].type.equals("none")) {
                least = Math.max(least, segments[i].min);
                greatest = Math.min(greatest, segments[i].max);
            }
            else if (segments[i].type.equals("on")) {
                least += segments[i].min;
                greatest += segments[i].max;
            } else {
                least -= segments[i].max;
                greatest -= segments[i].min;
            }
        }
        if (least < 0) least = 0;
        if (greatest < 0) greatest = 0;
        io.println(least + " " + greatest);

        io.close();
    }

    static class Segment {
        public Segment(String type, int min, int max) {
            this.type = type;
            this.min = min;
            this.max = max;
        }

        String type;
        int min;
        int max;
    }
}
