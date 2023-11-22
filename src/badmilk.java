import utils.Kattio;

import java.io.IOException;
import java.util.HashMap;

public class badmilk {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("badmilk");

        int n = io.nextInt();
        int m = io.nextInt();
        int d = io.nextInt();
        int s = io.nextInt();

        HashMap<Integer, Integer>[] milkDrunk = new HashMap[n];
        int[] gotSick = new int[n];
        for (int i = 0; i < d; i++) {
            int person = io.nextInt() - 1;
            int milkType = io.nextInt();
            int time = io.nextInt();
            if (milkDrunk[person] == null) {
                milkDrunk[person] = new HashMap<>();
            }
            if (milkDrunk[person].containsKey(milkType)) {
                milkDrunk[person].put(milkType, Math.min(time, milkDrunk[person].get(milkType)));
            } else {
                milkDrunk[person].put(milkType, time);
            }
        }
        for (int i = 0; i < s; i++) {
            gotSick[io.nextInt() - 1] = io.nextInt();
        }

        int maxMedicine = 0;
        // loop milk types
        i:
        for (int i = 1; i < d + 1; i++) {
            // loop sicknesses,j == person
            for (int j = 0; j < n; j++) {
                if (gotSick[j] == 0)
                    continue;
                int timeGotSick = gotSick[j];
                if (milkDrunk[j].getOrDefault(i, 1000) >= timeGotSick)
                    continue i;
            }
            // past here, the sickness could be possible because of milk type i
            int sick = 0;
            for (int k = 0; k < n; k++) {
                if (milkDrunk[k] != null && milkDrunk[k].containsKey(i))
                    sick++;
            }
            maxMedicine = Math.max(maxMedicine, sick);
        }
        io.println(maxMedicine);

        io.close();
    }
}
