import utils.Kattio;

import java.io.IOException;

public class promote {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("promote");

        int oldTotal = 0;
        int newTotal = 0;
        int[] oldAmounts = new int[4];
        int[] newAmounts = new int[4];

        int BtoS = 0;
        int StoG = 0;
        int GtoP = 0;

        for (int i = 0; i < 4; i++) {
            oldAmounts[i] = io.nextInt();
            oldTotal += oldAmounts[i];
            newAmounts[i] = io.nextInt();
            newTotal += newAmounts[i];
        }

        oldAmounts[0] += newTotal - oldTotal;

        for (int i = 0; i < 3; i++) {
            int difference = oldAmounts[i] - newAmounts[i];
            if (difference == 0)
                continue;

            oldAmounts[i] -= difference;
            oldAmounts[i + 1] += difference;
            if (i == 0)
                BtoS += difference;
            else if (i == 1)
                StoG += difference;
            else if (i == 2)
                GtoP += difference;
        }

        io.println(BtoS);
        io.println(StoG);
        io.println(GtoP);

        io.close();
    }
}
