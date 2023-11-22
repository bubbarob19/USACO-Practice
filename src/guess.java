import utils.Kattio;

import java.io.IOException;
import java.util.*;

public class guess {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("guess");

        int n = io.nextInt();
        String[] animals = new String[n];
        ArrayList<ArrayList<String>> animalTraits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            animals[i] = io.next();
            int t = io.nextInt();
            ArrayList<String> traits = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                String trait = io.next();
                traits.add(trait);
            }
            animalTraits.add(traits);
        }
        int max = 0;
        for (int i = 0; i < animalTraits.size() - 1; i++) {
            for (int j = i + 1; j < animalTraits.size(); j++) {
                int yeses = 1;
                ArrayList<String> a1 = animalTraits.get(i);
                ArrayList<String> a2 = animalTraits.get(j);
                for (String s : a1) {
                    if (a2.contains(s))
                        yeses++;
                }
                max = Math.max(yeses, max);
            }
        }
        io.println(max);

        io.close();
    }
}
