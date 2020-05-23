package ru.jbasics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyPanel extends JPanel {

    public static int x1;
    public static int x2;
    public static int y1;
    public static int y2;

    public MyPanel() {
        setLayout(null);
    }

    public static void setCoord(int c1, int c2, int c3, int c4) {
        x1 = c1;
        x2 = c2;
        y1 = c3;
        y2 = c4;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(x1, x2, y1, y2);
    }
}

public class Paint extends JFrame {

    private MyPanel panel = new MyPanel();
    private JButton button = new JButton("Paint");

    public Paint() {
        JFrame mf = new JFrame("Paint Test");
        mf.setLayout(new BorderLayout());
        mf.setSize(500, 500);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBorder(BorderFactory.createLineBorder(Color.RED));
        panel.setBackground(Color.WHITE);
        mf.add(panel, BorderLayout.CENTER);
        mf.add(button, BorderLayout.SOUTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MyPanel.setCoord(5, 5, 400, 400);
                panel.repaint();
            }
        });
        mf.setVisible(true);
    }
}
