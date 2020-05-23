/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.applet.Applet;
import java.awt.Graphics;

/**
 *
 * @author Vlad
 */
public class Applet_ extends Applet {

    /**
     * Initialization method that will be called after the applet is loaded into
     * the browser.
     * @param graph
     */
    public void init(Graphics graph) {
        // TODO start asynchronous download of heavy resources
        graph.drawString("Hello, World!", 20, 30);
        //context.showStatus("Displaying image");
        graph.drawString("www.javalicense.com", 35, 100);
    }
    // TODO overwrite start(), stop() and destroy() methods

    /**
     * Invoked, when an applet window has to be invoked. Shows contens of a
     * window (applet).
     *
     * @param g - graphical contest of an applet.
     */
    @Override
    public void paint(Graphics g) {
        g.drawString("Hello, world!", 70, 50);
        System.out.println("Method paint()");
    }
    
}
