package com.km.hol;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private static int DELAY = 3000;
    private static int DISPLAY = 2000;
    private UI ui;
    private Label m;
    private Label h;
    private Button b;
    private Dictionary dictionary;

    Runner(UI ui, Label m, Label h, Button b) {
        this.ui = ui;
        this.m = m;
        this.h = h;
        this.b = b;
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
                final String mw = s[0];
                final String hw = s[1];
                ui.access(() -> {
                    m.setCaption(mw);
                    h.setCaption("");
                });
                Thread.sleep(DELAY);
                ui.access(() -> {
                    h.setCaption(hw);
                });
                Thread.sleep(DISPLAY);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String[] getWords(Word word) {
        String from, to;
        String s[];
        if (b.getCaption().equals(Lang.NL.name())) {
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
