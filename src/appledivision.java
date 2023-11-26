import utils.Kattio;

import java.util.Arrays;

public class appledivision {
    public static int n;
    public static int[] vals;

    public static void main(String[] args) {
        Kattio io = new Kattio();

        n = io.nextInt();
        vals = new int[n];
        for (int i = 0; i < n; i++) {
            vals[i] = io.nextInt();
        }

        io.println(trySum(0, 0, 0));

        io.close();
    }

    public static long trySum(int index, long s1, long s2) {
        if (index == n)
            return Math.abs(s1 - s2);

        return Math.min(
                trySum(index + 1, s1 + vals[index], s2),
                trySum(index + 1, s1, s2 + vals[index])
        );
    }

}
