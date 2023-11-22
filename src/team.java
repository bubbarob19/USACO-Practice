import utils.Kattio;

public class team {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt();
        int count = 0;
        for (int x = 0; x < n; x++) {
            int num = 0;
            for (int y = 0; y < 3; y++) {
                if (io.nextInt() == 1)
                    num++;
            }
            if (num >= 2)
                count++;
        }
        io.print(count);

        io.close();
    }
}
