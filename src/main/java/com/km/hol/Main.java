package com.km.hol;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final int W = 600;
    private static final int H = 200;

    public static void main(String[] args) {
        final Frame frame = new Frame();
        SwingUtilities.invokeLater(() -> {
            frame.createComponents();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(frame.getExtendedState());
            frame.setVisible(true);
            frame.setSize(new Dimension(W, H));
            frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - W) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - H) / 2);
        });
        //new Thread(new Runner(frame)).start();
    }
}
