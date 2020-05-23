/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.util.Properties;

/**
 *
 * @author v.yanchenko
 */
public class Props {

    Properties props1 = new Properties();

    public void run() {
        props1.setProperty("Login", "user1");
        props1.setProperty("Pass", "12345");
        System.out.println(props1.getProperty("Login") + " " + props1.getProperty("Pass"));
    }

}
