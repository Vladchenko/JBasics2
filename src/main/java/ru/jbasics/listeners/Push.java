/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.listeners;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * This source provides
 *
 * @author Vlad
 */
public class Push extends JFrame implements KeyListener {

    Button b1 = new Button();
    Button b2 = new Button();
    JTextArea l1 = new JTextArea();

    public Push() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(360, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);

        b1.addKeyListener(b1);
        b1.setName("Button1");
        b2.addKeyListener(b1);
        b1.addMouseListener(b1);
        b1.addFocusListener(b1);
        b1.addMouseWheelListener(b1);
        b1.setText(b1.getName());
        b1.setBounds(20, 20, 100, 30);

        b2.setName("Button2");
        b2.addKeyListener(b2);
        b2.addMouseListener(b2);
        b2.addFocusListener(b2);
        b2.addMouseWheelListener(b2);
        b2.setText(b2.getName());
        b2.setBounds(140, 20, 100, 30);

        JScrollPane scroll = new JScrollPane(l1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scroll.setViewportView(l1);        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scroll.setVisible(true);

        l1.setBounds(20, 80, this.getWidth() - 55, this.getHeight() - 140);
        l1.setBorder(BorderFactory.createLineBorder(Color.black));
        l1.setName("l1");
        l1.setRows(10);
        l1.setColumns(30);
//        l1.setLineWrap(true);
        l1.setTabSize(10);
//        l1.setWrapStyleWord(true);

        this.setName("fr1");
        this.setLayout(null);
        this.add(b1);
        this.add(b2);
        this.add(l1);
        this.add(scroll, BorderLayout.CENTER);
        this.requestFocus();

    }

    //<editor-fold defaultstate="collapsed" desc="Public class' implementing methods">
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KeyTyped: \t\"" + e.getKeyChar() + "\" on " + this.getName());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KeyPressed: \t\"" + e.getKeyChar() + "\" on " + this.getName());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KeyReleased: \t\"" + e.getKeyChar() + "\" on " + this.getName());
        //throw new UnsupportedOperationException("Not supported yet.");
    }
    //</editor-fold>

    private class Button extends JButton implements MouseWheelListener, FocusListener, KeyListener,
            MouseListener {

        @Override
        public void keyTyped(KeyEvent e) {
            l1.append("keyTyped for a " + this.getClass() + "\n");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            l1.append("keyPressed for a " + this.getName() + "\n");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            l1.append("keyReleased for a " + this.getName() + "\n");
        }

        @Override
        public void focusGained(FocusEvent e) {
            l1.append("Focus has been gained by " + this.getName() + "\n");
        }

        @Override
        public void focusLost(FocusEvent e) {
            l1.append("Focus has been lost by " + this.getName() + "\n");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (e.getButton()) {
                case 1:
                    l1.append("Left mouse button has been clicked on a " + this.getName() + "\n");
                    break;
                case 2:
                    l1.append("Middle mouse button has been clicked on a " + this.getName() + "\n");
                    break;
                case 3:
                    l1.append("Right mouse button has been clicked on a " + this.getName() + "\n");
                    break;
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            switch (e.getButton()) {
                case 1:
                    l1.append("Left mouse button has been pressed on a " + this.getName() + "\n");
                    break;
                case 2:
                    l1.append("Middle mouse button has been pressed on a " + this.getName() + "\n");
                    break;
                case 3:
                    l1.append("Right mouse button has been pressed on a " + this.getName() + "\n");
                    break;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            l1.append("Mouse cursor has entered " + ((JButton) e.getSource()).getName() + "\n");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            l1.append("Mouse cursor has exited " + ((JButton) e.getSource()).getName() + "\n");
        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            l1.append("Mouse wheel has been moved on " + ((JButton) e.getSource()).getName() + "\n");
        }
    }

}
