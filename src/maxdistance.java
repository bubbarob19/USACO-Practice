import utils.Kattio;

public class maxdistance {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = io.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = io.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]), max);
            }
        }
        io.print(max);

        io.close();
    }
}
