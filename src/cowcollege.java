import utils.Kattio;

import java.util.*;

public class cowcollege {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int num = io.nextInt();
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        long totalCows = 0;
        long maxMoney = 0;
        long bestTuition = 0;
        while (true) {
            Map.Entry<Integer, Integer> e = map.pollLastEntry();
            if (e == null) {
                io.println(maxMoney + " " + bestTuition);
                break;
            }
            totalCows += e.getValue();
            if (maxMoney <= totalCows * e.getKey()) {
                maxMoney = totalCows * e.getKey();
                bestTuition = e.getKey();
            }
        }

        io.close();
    }
}
