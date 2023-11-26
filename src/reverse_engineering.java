import utils.Kattio;

public class reverse_engineering {
    public static void main(String[] args) {
        Kattio io = new Kattio();

        int T = io.nextInt();
        t:
        while (T-- != 0) {
            int n = io.nextInt();
            int m = io.nextInt();
            int[][] b = new int[m][n];
            int[] answers = new int[m];
            for (int i = 0; i < m; i++) {
                char[] arr = io.next().toCharArray();
                for (int j = 0; j < n; j++) {
                    b[i][j] = arr[j] == '1' ? 1 : 0;
                }
                answers[i] = io.nextInt();
            }

            if (n == 1) {
                int num = b[0][0];
                int sol = answers[0];
                for (int i = 0; i < m; i++) {
                    if ((b[i][0] == num && sol != answers[i]) || (b[i][0] != num && sol == answers[i])) {
                        io.println("LIE");
                        continue t;
                    }
                }
                io.println("OK");
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int a = 0; a < 2; a++) {
                        for (int be = 0; be < 2; be++) {
                            for (int c = 0; c < 2; c++) {
                                for (int d = 0; d < 2; d++) {
                                    e:
                                    for (int e = 0; e < 2; e++) {
                                        for (int k = 0; k < m; k++) {
                                            if (runProgram(b[k][i], b[k][j], a, be, c, d, e) != answers[k]) {
                                                continue e;
                                            }
                                        }
                                        io.println("OK");
                                        continue t;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            io.println("LIE");
        }

        io.close();
    }

    public static int runProgram(int val1, int val2, int eq1, int eq2, int r1, int r2, int r3) {
        if (val1 == eq1) return r1;
        else if (val2 == eq2) return r2;
        else return r3;
    }
}
