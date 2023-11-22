import utils.Kattio;

import java.io.IOException;

public class mixmilk {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("mixmilk");

        int[] capacities = new int[3];
        int[] amountStored = new int[3];
        for (int i = 0; i < 3; i++) {
            capacities[i] = io.nextInt();
            amountStored[i] = io.nextInt();
        }

        for (int i = 0; i < 100; i++) {
            // mod 3 = 0 (1->2), 1 (2->3), 2 (3->1)
            int oldBucket = i % 3;
            int newBucket = (i + 1) % 3;
            int amountNeeded = capacities[newBucket] - amountStored[newBucket];
            if (amountNeeded >= amountStored[oldBucket]) {
                amountStored[newBucket] += amountStored[oldBucket];
                amountStored[oldBucket] = 0;
            }
            else {
                amountStored[newBucket] = capacities[newBucket];
                amountStored[oldBucket] -= amountNeeded;
            }
        }

        for (int i : amountStored)
            io.println(i);

        io.close();
    }
}
