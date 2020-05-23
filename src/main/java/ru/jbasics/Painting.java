package ru.jbasics;

import javax.swing.*;
import java.awt.*;

public class Painting {

    /**
     * For one could use graphics in java, one should use SWING's JFrame and
     * JPanel. JPanel should be added into a JFrame and has a paintComponent();
     * method invoked to provide drawing on a screen.
     */
    private class jPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            /**
             * Erasing a canvas. This line is optional, in fact there is nothing
             * to erase.
             */
            super.paintComponent(g);
            // Drawing a line
            g.drawLine(10, 10, 100, 100);
        }
    }

    private class jFrame extends JFrame {

        public jFrame() {
            JFrame mf = new JFrame("Paint Test");
            mf.setLayout(new BorderLayout());
            mf.setSize(500, 500);
            mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mf.add(panel, BorderLayout.CENTER);
            mf.setVisible(true);
            panel.repaint();
        }
    }

    private JPanel panel = new jPanel();
    private JFrame frame = new jFrame();

}
