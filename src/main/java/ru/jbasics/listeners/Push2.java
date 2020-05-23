/*
 * To change fr2 template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author Vlad
 */
public class Push2 {

    class PushButton implements Listener {

        @Override
        public void focusGained(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void focusLost(FocusEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyTyped(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    class PushFrame extends Push2 {
    }

    class PushTextArea extends Push2 {

    }

    PushButton b1 = new PushButton();
    PushButton b2 = new PushButton();
    PushFrame fr2 = new PushFrame();
    PushTextArea ta1 = new PushTextArea();

}
