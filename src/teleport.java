import utils.Kattio;

import java.io.IOException;

public class teleport {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("teleport");

        int start = io.nextInt();
        int end = io.nextInt();

        int tLoc1 = io.nextInt();
        int tLoc2 = io.nextInt();


        int a = Math.min(Math.min(Math.abs(start - tLoc1), Math.abs(start - tLoc2))
                + Math.min(Math.abs(end - tLoc1), Math.abs(end - tLoc2)), Math.abs(start - end));

        io.print(a);

        io.close();
    }
}
