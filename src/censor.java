import utils.Kattio;

import java.io.IOException;

public class censor {
    public static void main(String[] args) throws IOException {
        Kattio io = new Kattio("censor");

        String full = io.next();
        String remove = io.next();

        char[] chars = full.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
            if (builder.length() >= remove.length() &&
                    builder.substring(builder.length() - remove.length()).equals(remove))
                builder.replace(builder.length() - remove.length(), builder.length(), "");
        }

        io.println(builder);

        io.close();
    }
}
