import utils.Kattio;

import java.io.IOException;

public class word {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("word");

        int n = io.nextInt();
        int limit = io.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = io.next();
        }

        int currentCount = 0;
        String currentLineContent = "";
        for (String word : words) {
            int len = word.length();
            if (len + currentCount > limit) {
                io.println(currentLineContent);
                currentLineContent = word;
                currentCount = len;
                continue;
            }
            if (currentCount != 0)
                currentLineContent += " ";
            currentLineContent += word;
            currentCount += len;
        }
        if (currentCount != 0) {
            io.print(currentLineContent);
        }

        io.close();
    }
}
