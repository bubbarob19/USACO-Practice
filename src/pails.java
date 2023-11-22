import utils.Kattio;

import java.io.IOException;

public class pails {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("pails");

        int a = io.nextInt();
        int b = io.nextInt();
        int max = io.nextInt();

        int maxFound = 0;
        for (int i = 0; i <= max; i += a) {
            int total = i;
            while (total <= max - b) {
                total += b;
            }
            maxFound = Math.max(total, maxFound);
        }
        io.println(maxFound);

        io.close();
    }
}
