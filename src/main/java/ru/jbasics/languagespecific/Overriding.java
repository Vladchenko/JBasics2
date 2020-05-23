/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

/**
 *
 * @author v.yanchenko
 */
public class Overriding {
    
    private void method1() {
        System.out.println("PrivateOverride method1");
    }
    
    public static void method2() {
        System.out.println("PrivateOverride method1");
    }
    
    public static void main(String[] args) {
        Overriding po = new PrivateOverrideSub();
        po.method1();
    }
    
}

class PrivateOverrideSub extends Overriding {
    
    void method1() {
        System.out.println("PrivateOverrideSub method1");
    }
    
    // Attempting to assign weaker access privilege - is not allowed !
//    private static void method2() {
//        System.out.println("Overriding method1");
//    }
}
