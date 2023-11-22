import utils.Kattio;

import java.util.ArrayList;

public class daisychains {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] petals = new int[n];
        for (int i = 0; i < n; i++) {
            petals[i] = io.nextInt();
        }

        int pics = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                ArrayList<Integer> flowers = new ArrayList<>();
                int total = 0;
                for (int k = i; k <= j; k++) {
                    flowers.add(petals[k]);
                    total += petals[k];
                }
                if (total % (j + 1 - i) == 0 && flowers.contains(total / (j + 1 - i)))
                    pics++;
            }
        }
        io.println(pics);

        io.close();
    }
}
