import utils.Kattio;

import java.io.IOException;

public class fence_painting {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("paint");

        int a = io.nextInt();
        int b = io.nextInt();
        int c = io.nextInt();
        int d = io.nextInt();

        int[] covered = new int[200];
        for (int x = a; x < b; x++)
            covered[x] = 1;
        for (int x = c; x < d; x++)
            covered[x] = 1;

        int coveredTotal = 0;
        for (int x = 0; x < 200; x++)
            if (covered[x] == 1)
                coveredTotal++;

        io.print(coveredTotal);

        io.close();
    }
}