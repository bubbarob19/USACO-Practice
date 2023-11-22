import utils.Kattio;

import java.io.IOException;

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
