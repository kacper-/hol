package com.km.hol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {
    private static final int SIZE = 3;
    private JLabel mLabel = new JLabel();
    private JLabel hLabel = new JLabel();
    JButton button;
    private Lang lang;

    public Frame() {
        super("Holenderski");
        Font f = mLabel.getFont();
        Font bigger = new Font(f.getName(), f.getStyle(), f.getSize() * SIZE);
        mLabel.setFont(bigger);
        hLabel.setFont(bigger);
        lang = Lang.NL;
    }

    void createComponents() {
        getContentPane().add(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        button = new JButton(lang.name());
        button.addActionListener(this::buttonAction);
        mainPanel.add(button);
        mainPanel.add(mLabel);
        mainPanel.add(hLabel);
        return mainPanel;
    }

    private void buttonAction(ActionEvent actionEvent) {
        if (lang == Lang.NL)
            lang = Lang.PL;
        else
            lang = Lang.NL;
        button.setText(lang.name());
    }

    void show(String m, String h) {
        mLabel.setText(m);
        hLabel.setText(h);
    }

    public Lang getLang() {
        return lang;
    }

}
