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
        try {
            while (true) {
                word = getRandomWord();
                frame.show(word.getDutch(), "");
                Thread.sleep(DELAY);
                frame.show(word.getDutch(), word.getPolish());
                Thread.sleep(DISPLAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Word getRandomWord() {
        return dictionary.getWords().get(ThreadLocalRandom.current().nextInt(dictionary.getWords().size()));
    }
}
