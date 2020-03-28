package com.km.hol;

import javax.swing.*;

public class Frame extends JFrame {
    private JLabel mLabel = new JLabel();
    private JLabel hLabel = new JLabel();

    public Frame() {
        super("Holenderski");
    }

    void createComponents() {
        getContentPane().add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.add(mLabel);
        mainPanel.add(hLabel);

        return mainPanel;
    }

    void show(String m, String h) {
        mLabel.setText(m);
        hLabel.setText(h);
    }
}
