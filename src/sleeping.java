import utils.Kattio;

import java.util.ArrayList;
import java.util.Arrays;

public class sleeping {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int t = io.nextInt();
        t:
        for (int tc = 0; tc < t; tc++) {
            int n = io.nextInt();
            ArrayList<Integer> times = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < n; i++) {
                int time = io.nextInt();
                if (time == 0) {
                    count++;
                } else {
                    times.add(time);
                }
            }
            if (times.size() == 0) {
                io.println(0);
                continue;
            }
            boolean finished = false;
            i:
            for (int i = 0; i < times.size(); i++) {
                int toGetTo = 0;
                int minusCount = 0;
                for (int j = i; j >= 0; j--) {
                    toGetTo += times.get(j);
                }
                int foundAlong = 0;
                for (int j = i + 1; j < times.size(); j++) {
                    foundAlong += times.get(j);
                    if (foundAlong == toGetTo) {
                        foundAlong = 0;
                        minusCount++;
                    }
                    if (foundAlong > toGetTo)
                        continue i;
                }
                if (foundAlong != 0)
                    continue;
                finished = true;
                io.println(count + times.size() - 1 - minusCount);
                break;
            }
            if (!finished) {
                io.println(times.size() - 1);
            }
        }

        io.close();
    }
}
