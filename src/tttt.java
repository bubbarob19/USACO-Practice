import utils.Kattio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class tttt {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("tttt");

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            char[] chars = io.next().toCharArray();
            for (int j = 0; j < 3; j++) {
                board[i][j] = chars[j];
            }
        }


        int s = 0;
        ArrayList<Character> sList = new ArrayList<>();
        int d = 0;
        ArrayList<char[]> dList = new ArrayList<>();

        if (singleVictory(board[0][0], board[0][1], board[0][2])) {
            if (!sList.contains(board[0][0])) {
                s++;
                sList.add(board[0][0]);
            }
        }
        if (multipleVictory(board[0][0], board[0][1], board[0][2])) {
            char[] team = getTeam(board[0][0], board[0][1], board[0][2]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[1][0], board[1][1], board[1][2])) {
            if (!sList.contains(board[1][0])) {
                s++;
                sList.add(board[1][0]);
            }
        }
        if (multipleVictory(board[1][0], board[1][1], board[1][2])) {
            char[] team = getTeam(board[1][0], board[1][1], board[1][2]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[2][0], board[2][1], board[2][2])) {
            if (!sList.contains(board[2][0])) {
                s++;
                sList.add(board[2][0]);
            }
        }
        if (multipleVictory(board[2][0], board[2][1], board[2][2])) {
            char[] team = getTeam(board[2][0], board[2][1], board[2][2]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[0][0], board[1][0], board[2][0])) {
            if (!sList.contains(board[0][0])) {
                s++;
                sList.add(board[0][0]);
            }
        }
        if (multipleVictory(board[0][0], board[1][0], board[2][0])) {
            char[] team = getTeam(board[0][0], board[1][0], board[2][0]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[0][1], board[1][1], board[2][1])) {
            if (!sList.contains(board[0][1])) {
                s++;
                sList.add(board[0][1]);
            }
        }
        if (multipleVictory(board[0][1], board[1][1], board[2][1])) {
            char[] team = getTeam(board[0][1], board[1][1], board[2][1]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[0][2], board[1][2], board[2][2])) {
            if (!sList.contains(board[0][2])) {
                s++;
                sList.add(board[0][2]);
            }
        }
        if (multipleVictory(board[0][2], board[1][2], board[2][2])) {
            char[] team = getTeam(board[0][2], board[1][2], board[2][2]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[0][0], board[1][1], board[2][2])) {
            if (!sList.contains(board[0][0])) {
                s++;
                sList.add(board[0][0]);
            }
        }
        if (multipleVictory(board[0][0], board[1][1], board[2][2])) {
            char[] team = getTeam(board[0][0], board[1][1], board[2][2]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }
        if (singleVictory(board[0][2], board[1][1], board[2][0])) {
            if (!sList.contains(board[0][2])) {
                s++;
                sList.add(board[0][2]);
            }
        }
        if (multipleVictory(board[0][2], board[1][1], board[2][0])) {
            char[] team = getTeam(board[0][2], board[1][1], board[2][0]);
            if (!containsTeam(team, dList)) {
                d++;
                dList.add(team);
            }
        }

        io.println(s);
        io.println(d);

        io.close();
    }

    private static char[] getTeam(char c, char c1, char c2) {
        char[] chars = new char[]{c, c1, c2};
        Arrays.sort(chars);
        return (new char[]{chars[0], chars[2]});
    }

    private static boolean containsTeam(char[] team, ArrayList<char[]> a) {
        for (char[] chars : a) {
            if (chars[0] == team[0] && chars[1] == team[1])
                return true;
        }
        return false;
    }

    public static boolean singleVictory(char c1, char c2, char c3) {
        return (c1 == c2 && c1 == c3);
    }
    public static boolean multipleVictory(char c1, char c2, char c3) {
        return (c1 == c2 && c1 != c3 || c1 == c3 && c1 != c2 || c3 == c2 && c1 != c3);
    }
}
