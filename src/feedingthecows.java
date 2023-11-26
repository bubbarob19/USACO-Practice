import utils.Kattio;

import java.util.Arrays;

public class feedingthecows {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int t = io.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int n = io.nextInt();
            int k = io.nextInt();

            if (k == 0) {
                io.println(n);
                io.println(io.next());
                continue;
            }

            char[] arr = io.next().toCharArray();
            int gNeeded = 0;
            int hNeeded = 0;
            int lastGIndex = -1;
            int lastHIndex = -1;
            char[] sol = new char[n];
            Arrays.fill(sol, '.');
            for (int i = 0; i < n; i++) {
                if (arr[i] == 'G') {
                    if (lastGIndex == -1 || Math.abs(i - lastGIndex) > k) {
                        lastGIndex = i + k < n ? i + k : (sol[n - 1] == '.' ? n - 1 : n - 2);
                        sol[lastGIndex] = 'G';
                        gNeeded++;
                    }
                } else {
                    if (lastHIndex == -1 || Math.abs(i - lastHIndex) > k) {
                        lastHIndex = i + k < n ? i + k : (sol[n - 1] == '.' ? n - 1 : n - 2);
                        sol[lastHIndex] = 'H';
                        hNeeded++;
                    }
                }
            }
            io.println((gNeeded + hNeeded));
            for (int i = 0; i < sol.length; i++) {
                io.print(sol[i]);
            }
            io.println();
        }

        io.close();
    }
}
