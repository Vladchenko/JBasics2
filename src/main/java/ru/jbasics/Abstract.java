package ru.jbasics;

/**
 *
 * Abstract class cannot be instantiated.
 * 
 * @author v.yanchenko
 */

// This class cannot be instantiated, but when you extend it, you can do that.
abstract class Abstract2 {}

// This class can instantiate.
class Abstract2Extended extends Abstract2 {
}

/**
 * This class cannot be instantiated, but when you extend it and implement all
 * the abstract methods, you can do that.
 */
abstract class Abstract3 {
    abstract void abstrMethod1();
}

class Abstract4 extends Abstract3 {
    void abstrMethod1() {
        System.out.println("abstrMethod1 is implemented.");
    }
}

public class Abstract {

    // Error - 'Abstract2' is abstract; cannot be instantiated
//    Abstract2 abstr2 = new Abstract2();

    // This one is instantiable.
    Abstract2Extended abstract2Extended = new Abstract2Extended();

    /**
     * Instantiating an abstract class with an anonymous class. In fact, it
     * is an anonymous class that we instantiate here, but not the
     * abstract one.
     */
    // http://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.9
    Abstract2 abstr21 = new Abstract2() {};

    /**
     * Instantiating an abstract class, with an anonymous class and overriding
     * a method.
     */
    Abstract3 abstr3 = new Abstract3() {
        @Override
        void abstrMethod1() {
            System.out.println("Abstract3.method1()");
        }
    };

    Abstract4 abstract4 = new Abstract4();

}

/**
 * Modifiers private or protected are not allowed here. The reason is - one 
 * cannot get an access to this class from outer classes, because scope 
 * specifier would say that it is not seen in other classes.
 */
//private abstract class Parent2 {
//        
//    }