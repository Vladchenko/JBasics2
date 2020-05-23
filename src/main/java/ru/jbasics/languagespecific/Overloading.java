/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

/**
 *
 * @author v.yanchenko
 */
public class Overloading {

    public Overloading() {

        /**
         * Error - no suitable method found As soon as default type for a number
         * in java is int, the interface of this method is (int, int). Thus, it
         * doesn't fit to any method given lower.
         */
//        f1(1, 1);
        // Explicit casting does good
        f1((byte) 1, (byte) 1);

        Object o = (String) null;
//        String s = o;     //  Error - incompatible types
        String s2 = (String) o;
        
//        f2(1, 1);
        f3(10, 20.0);
        
//        method(null);
    }

    public void f1(byte b, char c) {
        System.out.println("1");
    }

    public void f1(byte b, byte c) {
        System.out.println("2");
    }

    public void f1(char b, char c) {
        System.out.println("3");
    }

    public void f1(char b, byte c) {
        System.out.println("4");
    }
    
    public void f2(Integer i1, Integer i2) {
        System.out.println("1");
    }

    public void f2(Integer i1, int i2) {
        System.out.println("2");
    }

    public void f2(int b, Integer c) {
        System.out.println("3");
    }

    public void f2(long b, long c) {
        System.out.println("4");
    }
    
    public void f3(double a, float b) {
        System.out.println("Double Float");
    }
    
    public void f3(double a, double b) {
        System.out.println("Double Double");
    }

    public void method(Object o) {
        System.out.println("Object");
    }

    public void method(java.io.FileNotFoundException f) {
        System.out.println("FileNotFoundException");
    }

    public void method(java.io.IOException i) {
        System.out.println("IOException");
    }    
}
