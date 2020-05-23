/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author Vlad
 *
 * This class creates two timers and runs them at the same time. Each of them
 * prints some strings to System.out
 *
 */
public class Timer_ {

    // Another way of creating a Timer_ ( java.util.Timer(); )
    TimerTask task1 = new TimerTask() {
        @Override
        public void run() {
            System.out.println("timer2 says: ");
            long ts = (new Date()).getTime();
            d.setTime(ts);
            System.out.println("   " + d);
            //System.out.println("Does");
        }
    };
    al al1 = new al();
    Timer timer1 = new Timer(400, al1);
    Date d = new Date();
    java.util.Timer timer2 = new java.util.Timer();

    public Timer_() {
        Timer_ tb = new Timer_();
        tb.timer1.start();
        tb.timer2.schedule(tb.task1, 1000);
        // TODO code application logic here
    }

    // One way of creating a Timer_ ( javax.swing.Timer; )
    private class al implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("timer1 says: ");
            long ts = (new Date()).getTime();
            d.setTime(ts);
            System.out.println("   " + d);
            //System.out.println("Does");
        }

    }

}
