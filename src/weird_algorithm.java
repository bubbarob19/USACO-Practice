import utils.Kattio;

public class weird_algorithm {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        long n = io.nextLong();
        while (n != 1) {
            io.print(n + " ");
            if (n % 2 == 0)
                n /= 2;
            else
                n = n * 3 + 1;
        }
        io.print(n);

        io.close();
    }
}