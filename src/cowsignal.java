import utils.Kattio;

import java.io.IOException;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("cowsignal");

        int rows = io.nextInt();
        int cols = io.nextInt();
        int amplifyBy = io.nextInt();
        char[][] original = new char[rows][cols];
        char[][] amped = new char[rows * amplifyBy][cols * amplifyBy];
        for (int i = 0; i < rows; i++) {
            char[] chars = io.next().toCharArray();
            for (int j = 0; j < cols; j++) {
                original[i][j] = chars[j];
            }
        }

        for (int i = 0; i < rows * amplifyBy; i += amplifyBy) {
            for (int j = 0; j < cols * amplifyBy; j += amplifyBy) {
                char val = original[i / amplifyBy][j / amplifyBy];

                for (int k = 0; k < amplifyBy; k++) {
                    for (int l = 0; l < amplifyBy; l++) {
                        amped[i + k][j + l] = val;
                    }
                }
            }
        }

        for (int i = 0; i < amped.length; i++) {
            for (int j = 0; j < amped[0].length; j++) {
                io.print(amped[i][j]);
            }
            io.println();
        }

        io.close();
    }
}
