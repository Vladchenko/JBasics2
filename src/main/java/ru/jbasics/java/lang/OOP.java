/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.java.lang;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author v.yanchenko
 */
// Take a look to ru.java.basics.Inheritance class also.
public class OOP {

    public OOP() {
//        System.out.println("OOP constructor");
//        ClassB B = new ClassB(0);
//        B.method1();
        new PrivateOverride();
    }
    //<editor-fold defaultstate="collapsed" desc="Inheritance">
    // Following code is compilable, because JButton has a predecessor that is Object
    Object obj = new JButton("Start");
    // Following code is compilable, because Applet has a Panel as a predecessor
    Panel pnl = new Applet();

    private class ClassA {

        public int value1;

        ClassA(int i) {
            value1 = i;
//            System.out.println("ClassA constructor");
        }

        public void showValue1() {
            System.out.println("this is classA, value=" + this.value1);
        }

        private void method1() {
            System.out.println("method1 ClassA");
        }
    }

    /**
     * Defining and implementing a class that extends other class. This is the
     * way how inheritance is performed.
     */
    private class ClassB extends ClassA {

        public int value1;

        ClassB(int i) {

            /**
             * Having no default constructor for a class "ClassA" makes an
             * inherited class obliged to invoke a specific constructor as shown
             * next
             */
            super(i);
            value1 = i;
//            System.out.println("ClassB constructor");
        }

        @Override
        public void showValue1() {
            System.out.println("this is classB, value=" + this.value1);
        }

        /* As far as I see, the super.method1() just becomes hidden, but not 
        overridden*/
//        @Override     // Overriding a private method is not allowed
        public void method1() {
//            super.method1();
            System.out.println("method1 ClassB");
        }

        void setSuperV(int v) {
            super.value1 = v;
        }
    }

    public void performInheritance() {

        /**
         * How come this is possible, that an OOP instance exists without
         * invoking "new" on OOP class. Seems that "new
         * OOP().performInheritance();" lexem in "JavaBasics.java" creates this
         * instance. This has to be checked somehow.
         *
         * When one uncomments following row, OOP instance is created again and
         * that is wasting of time and memory.
         */
//        OOP oop1 = new OOP();
//        ClassA ob1 = this.new ClassA(1);
//        ClassB ob3 = this.new ClassB(1);
//
//        ob1.showValue1();
//        ob3.showValue1();
//        System.out.println("");
//
//        ob3.setSuperV(1);
//        ob3.value1 = 4;
//
//        ob1.showValue1();
//        ob3.showValue1();
//        ClassA ob2 = ob3;
//        ob1.value1 = 2;
//
//        ob1.showValue1();
//        ob2.showValue1();
//        ob3.showValue1();
//        System.out.println(ob3.value1);
        ClassA oCB1 = new ClassA(1);
        oCB1.method1();
        ClassB oCB2 = new ClassB(1);
        oCB2.method1();
        ClassA oCB3 = new ClassB(1);
        oCB3.method1();
        ((ClassB) oCB3).method1();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Abstraction">
    private abstract class ClassC {

        abstract void method1();
    }

    private class ClassD extends ClassC {

        @Override
        void method1() {
            System.out.println("Overriden method");
        }
    }
    
    // Implementing an abstract class with an anonynous class
    private ClassC cls = new ClassC() {

        @Override
        void method1() {
            
        }
    };
    
    public void performAbstraction() {
        ClassC obj1 = new ClassD();
//    ClassC obj2 = new ClassC();   // Given row is unable to be compiled
        ClassD obj3 = new ClassD();
//    ClassD obj4 = new ClassC();   // Given row is unable to be compiled
    }
    //</editor-fold>

    public void run() {
        
//        performInheritance();
//        performAbstraction();
        
        new Class2();   // Method 1 and method2 of a Class2 are invoked.
        
        Class1 cls = new Class2();
//        cls.  // Doesn't have a method1 or method2 in an interface 
//        (they cannot be invoked).
        
        Class2 cls2 = new Class2();
//        cls2. // Has only method2 in its interface. Where is static ?
    }
}

 //<editor-fold defaultstate="collapsed" desc="Static & private method overriding check">
class Class1 {

    public static int method1() {
        System.out.println("Class1:method1");
        return 0;
    }

    private String method2() {
        System.out.println("Class1:method2");
        return "";
    }
}

class Class2 extends Class1 {

    /**
     * This method doesn't inherit a superclass's version. Instead it hides its
     * realization.
     */
//    @Override
    public static int method1() {
        System.out.println("Class2:method1");
        return 0;
    }
//    @Override   // Compilation error - Method does not override or implement 
    // a method from a supertype.
    public String method2() {
        System.out.println("Class2:method2");
        return "";
    }

    Class2() {
        method1();  // Class2's method is invoked, not Class1's.
        method2();  // Class2's method is invoked, not Class1's.
    }
}
//</editor-fold>

// One can extend not abstract class with an abstract one !
abstract class OOP2 extends OOP {
    // And one may reimplement any method that is not final or static or private.

    @Override
    public void run() {
    }
    /* 
     * As of method run(); it may not be implemented again, 'cause its 
     * implementation is already done in an OOP class.
     * Or one caould make run(); abstract, then its descendants have to 
     * implement it for sure !
     */
    
    
}


class PrivateOverride {
    class Parent {
        private void method() {
            System.out.println("Parent method");
        }
    }
    class Child extends Parent {
        /**
         * Java does not, in fact, override a private method, because
         * it violates an incapsulation.
         */
        private void method() {
//            super.method();
            System.out.println("Child method");
        }
    }
    PrivateOverride() {
        new Child().method();
    }
}