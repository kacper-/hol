package com.km.hol;

import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private static int DELAY = 3000;
    private static int DISPLAY = 2000;
    private Frame frame;
    private Dictionary dictionary;

    Runner(Frame frame) {
        this.frame = frame;
        dictionary = new Dictionary();
    }

    @Override
    public void run() {
        Word word;
        String s[];
        try {
            while (true) {
                word = getRandomWord();
                s = getWords(word);
                frame.show(s[0], "");
                Thread.sleep(DELAY);
                frame.show(s[0], s[1]);
                Thread.sleep(DISPLAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String[] getWords(Word word) {
        String from, to;
        String s[];
        if (frame.getLang() == Lang.NL) {
            s = word.getDutch().split(",");
            from = s[ThreadLocalRandom.current().nextInt(s.length)].trim();
            to = word.getPolish();
        } else {
            s = word.getPolish().split(",");
            from = s[ThreadLocalRandom.current().nextInt(s.length)].trim();
            to = word.getDutch();
        }
        return new String[]{from, to};
    }

    private Word getRandomWord() {
        return dictionary.getWords().get(ThreadLocalRandom.current().nextInt(dictionary.getWords().size()));
    }
}
