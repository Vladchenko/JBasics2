/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

/**
 *
 * @author v.yanchenko
 */
public class SomeClass {

    /**
     * Why is it that java invokes a "print" method from "SomeChild1", but not
     * from "SomeClass" ?
     */
    public SomeClass() {
        SomeClass c = new SomeChild1();
        c.print();
        ((SomeClass) c).print();
        ((SomeChild1) c).print();
        ((SomeChild2) c).print();
    }

    public void print() {
        System.out.println("SomeClass");
    }
}

class SomeChild1 extends SomeClass {

    @Override
    public void print() {
        System.out.println("SomeChild1");
    }
}

class SomeChild2 extends SomeClass {

    @Override
    public void print() {
        System.out.println("SomeChild2");
    }
}
