import utils.Kattio;

import java.io.IOException;

public class lostcow {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("lostcow");

        int x = io.nextInt();
        int y = io.nextInt();

        int coord = x;
        int distTraveled = 0;
        int factor = 1;

        while(true) {
            int oldCoord = coord;
            coord = factor + x;
            distTraveled += Math.abs(coord - oldCoord);
            if (x < y && coord >= y) {
                distTraveled -= (coord - y);
                break;
            }
            if (x > y && coord <= y){
                distTraveled -= (y - coord);
                break;
            }

            factor *= -2;
        }

        io.println(distTraveled);

        io.close();
    }
}
