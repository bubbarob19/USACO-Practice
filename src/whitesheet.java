import utils.Kattio;

import java.util.ArrayList;

public class whitesheet {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        ArrayList<Integer> xCoords = new ArrayList<>();
        ArrayList<Integer> yCoords = new ArrayList<>();

        int x1 = io.nextInt();
        int y1 = io.nextInt();
        int x2 = io.nextInt();
        int y2 = io.nextInt();
        xCoords.add(x1);
        xCoords.add(x2);
        yCoords.add(y1);
        yCoords.add(y2);
        Rectangle big = new Rectangle(x1, y1, x2, y2);

        x1 = io.nextInt();
        y1 = io.nextInt();
        x2 = io.nextInt();
        y2 = io.nextInt();
        xCoords.add(x1);
        xCoords.add(x2);
        yCoords.add(y1);
        yCoords.add(y2);
        Rectangle s1 = new Rectangle(x1, y1, x2, y2);

        x1 = io.nextInt();
        y1 = io.nextInt();
        x2 = io.nextInt();
        y2 = io.nextInt();
        xCoords.add(x1);
        xCoords.add(x2);
        yCoords.add(y1);
        yCoords.add(y2);
        Rectangle s2 = new Rectangle(x1, y1, x2, y2);

        for (int x : xCoords) {
            for (int y : yCoords) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        double xCoord = x + (i * .5);
                        double yCoord = y + (j * .5);
                        if (big.contains(xCoord, yCoord) && !s1.contains(xCoord, yCoord)
                        && !s2.contains(xCoord, yCoord)) {
                            io.println("YES");
                            io.close();
                            return;
                        }
                    }
                }
            }
        }

        io.println("NO");
        io.close();
    }

    static class Rectangle {
        int x1;
        int x2;
        int y1;
        int y2;
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
        public boolean contains(double x, double y) {
            return (x <= x2 && x >= x1 && y <= y2 && y >= y1);
        }
    }
}