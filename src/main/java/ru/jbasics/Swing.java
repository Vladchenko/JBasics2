/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author v.yanchenko
 */
public class Swing {

    JButton button1 = new JButton();
    JFrame frame1 = new JFrame();

    // Similar to a Point class, provides an x,y position
    Dimension dmn1 = new Dimension();
    Dimension dmn2 = Toolkit.getDefaultToolkit().getScreenSize();

    private class Frame extends JFrame {
    };

    private class Button extends JButton {
    };

    public void initJButton(JButton bt) {
//        bt.setText(str1);
        bt.setBounds(10, 10, 50, 50);
        bt.setVisible(true);
    }

    public void initJFrame(JFrame fr) {
        fr.setVisible(false);
        //fr.setContentPane(paintComponent(Grafics g) );
        //fr.setContentPane(new DrawPane());
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(400, 400);
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);
        fr.setVisible(true);
    }

    public void buttonAndFrame() {

        Frame frame1 = new Frame();
        Button button1 = new Button();
        this.initJButton(button1);
        this.initJFrame(frame1);
        frame1.add(button1);
        frame1.setVisible(true);

    }

    public Swing() {
//        initJButton(button1);
//        initJFrame(frame1);
//        buttonAndFrame();
    }
}
