package com.km.hol;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private static final int SIZE = 3;
    private JLabel mLabel = new JLabel();
    private JLabel hLabel = new JLabel();

    public Frame() {
        super("Holenderski");
        Font f = mLabel.getFont();
        Font bigger = new Font(f.getName(), f.getStyle(), f.getSize() * SIZE);
        mLabel.setFont(bigger);
        hLabel.setFont(bigger);
    }

    void createComponents() {
        getContentPane().add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(mLabel);
        mainPanel.add(hLabel);
        return mainPanel;
    }

    void show(String m, String h) {
        mLabel.setText(m);
        hLabel.setText(h);
    }
}
