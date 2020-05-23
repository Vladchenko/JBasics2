/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.java.lang;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.jbasics.Classes;

/**
 *
 * @author Vlad
 */
public class Reflections {

    class A {
    }

    public class instance1 {

        public void render(String args[]) {
            try {
                Class cls = Class.forName("A");
                boolean b1 = cls.isInstance(new Integer(37));
                System.out.println(b1);
                boolean b2 = cls.isInstance(new A());
                System.out.println(b2);
            } catch (Throwable e) {
                System.err.println(e);
            }
        }
    }

    public void render(String args[]) {
        try {
            Class c = Class.forName(args[0]);
            Method m[] = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }

    public Object dynamicObjectCreation() {
        ArrayList myObject = null;
        try {
            try {
                myObject
                        = (ArrayList) Class.forName("java.util.ArrayList").newInstance();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InstantiationException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Classes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myObject;
    }

    // Making an array of any type from a list of this type.
    public static <T> T[] toArray(List<T> list) {
        T[] toR = (T[]) java.lang.reflect.Array.newInstance(list.get(0)
                .getClass(), list.size());
        for (int i = 0; i < list.size(); i++) {
            toR[i] = list.get(i);
        }
        return toR;
    }
}
