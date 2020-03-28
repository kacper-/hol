package com.km.hol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ImportUtil {
    private static final String SOURCE = "source.txt";
    private static final String TAG_START = "\">";
    private static final String TAG_STOP = "</a>";
    private static final String CLASS_START = "package com.km.hol;\n" +
            "\n" +
            "import java.util.ArrayList;\n" +
            "import java.util.List;\n" +
            "\n" +
            "public class Dictionary {\n" +
            "    private List<Word> words = new ArrayList<>();\n" +
            "    \n" +
            "    Dictionary() {\n" +
            "        load();\n" +
            "    }\n" +
            "    \n" +
            "    private void load() {" +
            "        ";
    private static final String CLASS_STOP = "    }\n" +
            "}\n";
    private static final String LOAD_START = "words.add(new Word(\"";
    private static final String LOAD_STOP = "\",\"\"));";

    public static void main(String[] args) {
        parseFile();
    }

    private static void parseFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(getStream()))) {
            String line;
            System.out.println(CLASS_START);
            while ((line = reader.readLine()) != null) {
                for (String w : extractWords(line)) {
                    System.out.println(w);
                }
            }
            System.out.println(CLASS_STOP);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static List<String> extractWords(String line) {
        int posFrom, posTo;
        int start = 0;
        List<String> list = new ArrayList<>();
        while ((posFrom = line.indexOf(TAG_START, start)) > 0) {
            posTo = line.indexOf(TAG_STOP, start);
            list.add(LOAD_START + line.substring(posFrom + TAG_START.length(), posTo) + LOAD_STOP);
            start = posTo + 1;
        }
        return list;
    }

    private static InputStream getStream() {
        return Main.class.getClassLoader().getResourceAsStream(SOURCE);
    }
}
