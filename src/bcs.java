import utils.Kattio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class bcs {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("bcs");

        int n = io.nextInt();
        int k = io.nextInt();
        boolean[][] original = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] arr = io.next().toCharArray();
            for (int j = 0; j < n; j++) {
                original[i][j] = arr[j] == '#';
            }
        }

        boolean[][][] pieces = new boolean[k][n][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                char[] arr = io.next().toCharArray();
                for (int l = 0; l < n; l++) {
                    pieces[i][j][l] = arr[l] == '#';
                }
            }
        }

        ArrayList<boolean[][]>[] piecePermutations = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            piecePermutations[i] = generatePermutations(pieces[i]);
        }

        // Find answer
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                for (boolean[][] permute1 : piecePermutations[i]) {
                    for (boolean[][] permute2 : piecePermutations[j]) {
                        if (doesPermuteWork(permute1, permute2, original)) {
                            io.println((i + 1) + " " + (j + 1));
                            io.close();
                            return;
                        }
                    }
                }
            }
        }

        io.close();
    }

    private static boolean doesPermuteWork(boolean[][] permute1, boolean[][] permute2, boolean[][] original) {
//        System.out.println("NEW PERMUTE");
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(permute1[i][j] ? "#" : ".");
//            }
//            System.out.println();
//        }
//        System.out.println();
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(permute2[i][j]  ? "#" : ".");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[0].length; j++) {
                boolean b1 = permute1[i][j];
                boolean b2 = permute2[i][j];
                boolean t = false;
                if (b1 && b2)
                    return false;
                if (b1 || b2)
                    t = true;
                if (original[i][j] != t)
                    return false;
            }
        }
        return true;
    }

    public static ArrayList<boolean[][]> generatePermutations(boolean[][] pieces) {
        ArrayList<boolean[][]> upDownList = new ArrayList<>();
        upDownList.add(pieces);

        // DOWN
        int amt = 1;
        boolean[][] translation = translate(Dir.DOWN, pieces, amt);
        while (translation != null) {
            upDownList.add(translation);
            amt++;
            translation = translate(Dir.DOWN, pieces, amt);
        }

        // UP
        amt = 1;
        while ((translation = translate(Dir.UP, pieces, amt)) != null) {
            upDownList.add(translation);
            amt++;
        }

        ArrayList<boolean[][]> allPermutations = new ArrayList<>();
        allPermutations.addAll(upDownList);

        for (int i = 0; i < upDownList.size(); i++) {
            // LEFT
            boolean[][] toPermute = upDownList.get(i);
            amt = 1;
            while ((translation = translate(Dir.LEFT, toPermute, amt)) != null) {
                allPermutations.add(translation);
                amt++;
            }
            // RIGHT
            amt = 1;
            while ((translation = translate(Dir.RIGHT, toPermute, amt)) != null) {
                allPermutations.add(translation);
                amt++;
            }
        }

        return allPermutations;
    }

    // returns null if cant be translated
    public static boolean[][] translate(Dir dir, boolean[][] arr, int amount) {
        boolean[][] translation = new boolean[arr.length][arr[0].length];

        if (dir == Dir.UP) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!arr[i][j])
                        continue;
                    if (i - amount < 0)
                        return null;
                    translation[i - amount][j] = true;
                }
            }
        } else if (dir == Dir.DOWN) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!arr[i][j])
                        continue;
                    if (i + amount >= arr.length) {
                        return null;
                    }
                    translation[i + amount][j] = true;
                }
            }
        } else if (dir == Dir.LEFT) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!arr[i][j])
                        continue;
                    if (j - amount < 0)
                        return null;
                    translation[i][j - amount] = true;
                }
            }
        } else if (dir == Dir.RIGHT) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (!arr[i][j])
                        continue;
                    if (j + amount >= arr[0].length)
                        return null;
                    translation[i][j + amount] = true;
                }
            }
        }

        return translation;
    }

    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}


