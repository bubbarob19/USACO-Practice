import utils.Kattio;

import java.io.IOException;
import java.util.Arrays;

public class measurement {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("measurement");

        int n = io.nextInt();

        // 0 = Bessie, 1 = Elsie, 2 = Mildred
        String topCows = "012";
        int[] milkLevels = new int[]{7, 7, 7};
        Pair<Integer, Integer>[] gallonOperations = new Pair[101];
        for (int i = 0; i < n; i++) {
            int day = io.nextInt();
            int cow = cowNumFromStr(io.next());
            String numStr = io.next();
            if (numStr.charAt(0) == '+')
                numStr = numStr.substring(1);
            int num = Integer.parseInt(numStr);
            Pair<Integer,Integer> pair = new Pair<>(cow, num);
            gallonOperations[day] = pair;
        }

        int total = 0;
        for (int i = 0; i < 101; i++) {
            if (gallonOperations[i] != null)
                milkLevels[gallonOperations[i].t] += gallonOperations[i].u;
            //System.out.println(milkLevels[0] + " " + milkLevels[1] + " " +milkLevels[2] + " " + topCows(milkLevels));
            String newTopCows = topCows(milkLevels);
            if (!newTopCows.equals(topCows))
                total++;
            topCows = newTopCows;
        }

        io.println(total);

        io.close();
    }

    private static int cowNumFromStr(String next) {
        if (next.equalsIgnoreCase("bessie"))
            return 0;
        if (next.equalsIgnoreCase("elsie"))
            return 1;
        return 2;
    }

    public static String topCows(int[] milkLevels) {
        if (milkLevels[0] > milkLevels[1] && milkLevels[0] > milkLevels[2])
            return "0";
        if (milkLevels[1] > milkLevels[0] && milkLevels[1] > milkLevels[2])
            return "1";
        if (milkLevels[2] > milkLevels[1] && milkLevels[2] > milkLevels[0])
            return "2";
        if (milkLevels[0] == milkLevels[1] && milkLevels[0] ==milkLevels[2])
            return "012";
        if (milkLevels[0] == milkLevels[1])
            return "01";
        if (milkLevels[0] == milkLevels[2])
            return "02";
        return "12";
    }

    static class Pair<T, U> {
        public T t;
        public U u;

        public Pair(T t, U u) {
            this.t = t;
            this.u = u;
        }
    }
}
