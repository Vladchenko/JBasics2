/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import ru.Utils;

/**
 *
 * @author v.yanchenko
 */
class Super {

    static String ID = "QBANK";
}

class Sub extends Super {

    static {
        System.out.print("In Sub");
    }
}

public class Invocation {

    public Invocation() {
        new InvocationPrimitives();
    }

    public void checkInvocation() {
        // Prints QBANK, but not "In Sub"
        System.out.println(Sub.ID);
    }
    
        // This method has to do with method call check
    public void externalClassMethodCallCheck() {
        /**
         * Following method can be called without putting a name of class in
         * front of it (i.e. Printing.print(); ), because this class inherits
         * jbasics.Printing (i.e. JavaBasics extends jbasics.Printing ).
         */
//        print(str1);
        /**
         * Next statement also works fine, provided that print method is a
         * static method. You may also remove "extends jbasics.Printing" - it is
         * not required here.
         */
        Utils.print("Print check");
    }
}

class InvocationPrimitives {

    public InvocationPrimitives() {
        method(5);
        method(5.0);
        method((short)5.0);
        method(5.0f);
        method(0b001101);
        method(0004106);
        method((byte)(-200));
        method((Integer)5);
    }

    private void method(byte b) {
        System.out.println("byte");
    }
    private void method(short s) {
        System.out.println("short");
    }
    private void method(int i) {
        System.out.println("int");
    }
    private void method(float f) {
        System.out.println("float");
    }
    private void method(double d) {
        System.out.println("double");
    }
}