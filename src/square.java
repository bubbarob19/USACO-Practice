import utils.Kattio;

import java.io.IOException;

public class square {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("square");

        int x1 = io.nextInt();
        int y1 = io.nextInt();
        int x2 = io.nextInt();
        int y2 = io.nextInt();
        int x3 = io.nextInt();
        int y3 = io.nextInt();
        int x4 = io.nextInt();
        int y4 = io.nextInt();

        int side = Math.max(Math.max(x1, Math.max(x2, Math.max(x3, x4))) - Math.min(x1, Math.min(x2, Math.min(x3, x4))), Math.max(y1, Math.max(y2, Math.max(y3, y4))) - Math.min(y1, Math.min(y2, Math.min(y3, y4))));
        io.println(side * side);

        io.close();
    }
}
