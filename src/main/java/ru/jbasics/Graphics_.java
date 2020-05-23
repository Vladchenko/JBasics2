/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

/**
 *
 * @author Software Developer
 */
public class Graphics_ {

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

    public Graphics_() {
        showAllFonts();
    }

    public void showAllFonts() {
        Font[] fnts1 = ge.getAllFonts();
        for (Font font : fnts1) {
            System.out.println(font);
        }
    }

}
