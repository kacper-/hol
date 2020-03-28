package com.km.hol;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        final Frame frame = new Frame();
        SwingUtilities.invokeLater(() -> {
            frame.createComponents();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(frame.getExtendedState());
            frame.setVisible(true);
            frame.setSize(new Dimension(800, 600));
            frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 800) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 600) / 2);
        });
    }
}
