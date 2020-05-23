/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

/**
 *
 * @author v.yanchenko
 */
public class NoMainMethod {

    static {
        System.out.println("This program runs w/o main method");
        // Next row is optional. Absence of it does not invoke any error.
        System.exit(0);
    }
}
