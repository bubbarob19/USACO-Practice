package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator {
    public static void main(String[] args) throws IOException {
        File readFile = new File("src/" + args[0] + ".java");
        File writeFile = new File("files/for_submission/" + args[0] + ".java");
        StringBuilder content = new StringBuilder();
        BufferedReader reader = null;
        FileWriter writer = null;

        reader = new BufferedReader(new FileReader(readFile));

        String line = reader.readLine();
        while (line != null) {
            content.append(line).append(System.lineSeparator());
            line = reader.readLine();
        }

        String built = content.toString();
        built = built.replace("import java.io.BufferedReader;", "");
        built = built.replace("import java.io.FileReader;", "");
        built = built.replace("import java.io.IOException;", "");
        built = built.replace("import java.io.InputStream;", "");
        built = built.replace("import java.io.InputStreamReader;", "");
        built = built.replace("import java.io.OutputStream;", "");
        built = built.replace("import java.io.PrintWriter;", "");
        built = built.replace("import java.util.StringTokenizer;", "");
        built = built.replace("import utils.Kattio;", "");

        built = getImportStatements() + built + getKattioClassString();

        writer = new FileWriter(writeFile, false);
        writer.write(built);

        reader.close();
        writer.close();
    }

    public static String getImportStatements() {
        return  "import java.io.BufferedReader;\n" +
                "import java.io.FileReader;\n" +
                "import java.io.IOException;\n" +
                "import java.io.InputStream;\n" +
                "import java.io.InputStreamReader;\n" +
                "import java.io.OutputStream;\n" +
                "import java.io.PrintWriter;\n" +
                "import java.util.StringTokenizer;\n";
    }

    public static String getKattioClassString() {
        return  "\n\n\nclass Kattio extends PrintWriter {\n" +
                "    private BufferedReader r;\n" +
                "    private StringTokenizer st;\n" +
                "    // standard input\n" +
                "    public Kattio() { this(System.in, System.out); }\n" +
                "    public Kattio(InputStream i, OutputStream o) {\n" +
                "        super(o);\n" +
                "        r = new BufferedReader(new InputStreamReader(i));\n" +
                "    }\n" +
                "    // USACO-style file input\n" +
                "    public Kattio(String problemName) throws IOException {\n" +
                "        super(problemName + \".out\");\n" +
                "        r = new BufferedReader(new FileReader(problemName + \".in\"));\n" +
                "    }\n" +
                "    // returns null if no more input\n" +
                "    public String next() {\n" +
                "        try {\n" +
                "            while (st == null || !st.hasMoreTokens())\n" +
                "                st = new StringTokenizer(r.readLine());\n" +
                "            return st.nextToken();\n" +
                "        } catch (Exception e) {}\n" +
                "        return null;\n" +
                "    }\n" +
                "    public int nextInt() { return Integer.parseInt(next()); }\n" +
                "    public double nextDouble() { return Double.parseDouble(next()); }\n" +
                "    public long nextLong() { return Long.parseLong(next()); }\n" +
                "}\n";
    }
}
