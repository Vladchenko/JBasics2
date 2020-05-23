package ru.jbasics.languagespecific.p2;

import ru.jbasics.languagespecific.p1.A;

/**
 * Created by Влад on 20.10.2016.
 */
public class B extends A {

    public B() {
        A a = new A();
//        a.disp();     // ! Instance and interface are NOT of a derived class.
        A ab = new B();
//        ab.disp();    // ! Interface is NOT of a derived class.
        B b = new B();
        b.disp();       // Instance and interface are of a derived class.
    }

}
