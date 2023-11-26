import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        int[] ogSet = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for (int mask = 0; mask < (1 << ogSet.length); mask++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for (int i = 0; i < ogSet.length; i++) {
                if ((mask & (1 << i)) > 0)
                    subset.add(ogSet[i]);
            }
            subsets.add(subset);
            System.out.print("[");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i != subset.size() - 1)
                    System.out.print(",");
            }
            System.out.println("]");
        }
    }
}
