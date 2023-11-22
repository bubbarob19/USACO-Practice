import utils.Kattio;

public class soldier_bananas {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int initCost = io.nextInt();
        int dollars = io.nextInt();
        int numBanana = io.nextInt();

        int total = initCost;
        for (int x = 0; x < numBanana - 1; x++) {
            total += initCost * (x + 2);
        }
        io.print(dollars < total ? total - dollars : 0);

        io.close();
    }
}
