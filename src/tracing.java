import utils.Kattio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class tracing {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("tracing");

        int N = io.nextInt();
        int T = io.nextInt();
        List<Boolean> states = io.next().chars().mapToObj(i -> i == 49).collect(Collectors.toList());
        ArrayList<Interaction> interList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            Interaction interaction = new Interaction(io.nextInt(), io.nextInt() - 1, io.nextInt() - 1);
            interList.add(interaction);
        }
        Collections.sort(interList);

        int minK = 300;
        int maxK = -1;
        boolean[] possibleCows = new boolean[N];
        for (int i = 0; i < N; i++) {
            k:
            for (int k = 0; k < 252; k++) {
                boolean[] newState = new boolean[N];
                int[] hoovesShaken = new int[N];
                newState[i] = true;
                for (Interaction inter : interList) {
                    if (newState[inter.x] && newState[inter.y]) {
                        hoovesShaken[inter.x]++;
                        hoovesShaken[inter.y]++;
                    }
                    else if (newState[inter.x] && hoovesShaken[inter.x] < k) {
                        newState[inter.y] = true;
                        hoovesShaken[inter.x]++;
                    }
                    else if (newState[inter.y] && hoovesShaken[inter.y] < k) {
                        newState[inter.x] = true;
                        hoovesShaken[inter.y]++;
                    }
                }
                for (int j = 0; j < N; j++) {
                    if (!states.get(j).equals(newState[j]))
                        continue k;
                }
                possibleCows[i] = true;
                maxK = Math.max(maxK, k);
                minK = Math.min(minK, k);
            }
        }
        int totalPossibleCows = 0;
        for (boolean cow : possibleCows) {
            if (cow)
                totalPossibleCows++;
        }
        io.println(totalPossibleCows + " " + minK + " " + (maxK != 251 ? maxK : "Infinity"));

        io.close();
    }

    static class Interaction implements Comparable<Interaction> {
        int x;
        int y;
        int t;
        public Interaction(int t, int x, int y) {
            this.t = t;
            this.x = Math.min(x, y);
            this.y = Math.max(x, y);
        }

        @Override
        public int compareTo(Interaction o) {
            return Integer.compare(t, o.t);
        }
    }
}
