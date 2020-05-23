/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.listeners;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

/**
 *
 * @author Vlad
 */
public class Listener2 implements Listener {

    JTextArea ta1 = new JTextArea();

    public String getName() {
        return this.getClass().toString();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ta1.append("Some keyboard button typed for a " + this.getName() + "   ");
        //System.out.println("KeyTyped " + this.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        ta1.append("Some keyboard button pressed for a " + this.getName() + "   ");
        //System.out.println("KeyPressed " + this.toString());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //ta1.append("Some button pressed for a " + this.getLabel() + " ");
        //System.out.println("KeyReleased " + this.toString());
    }

    @Override
    public void focusGained(FocusEvent e) {
        ta1.append("Focus has gained a " + this.getName() + "   ");
    }

    @Override
    public void focusLost(FocusEvent e) {
        ta1.append("Focus has lost a " + this.getName() + "   ");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ta1.append("LMB has been clicked on a " + this.getName() + "   ");
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
