/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

/**
 *
 * @author v.yanchenko
 */
// Take a look to ru.java.basics.lang.OOP class also.
public class Inheritance {

    public static void method() {
        System.out.println("Inheritance method");
    }

    private void method2() {

    }

    public void checkInstanceOf() {

        Inheritance oIS = new Inheritance();
        System.out.println(oIS instanceof Inheritance);  // true
        System.out.println(oIS instanceof InheritanceSub);  // true
        System.out.println(oIS instanceof InheritanceSub2);  // true
        System.out.println("");

        Inheritance oIS2 = new InheritanceSub();
        System.out.println(oIS2 instanceof Inheritance);  // true
        System.out.println(oIS2 instanceof InheritanceSub);  // true
        System.out.println(oIS2 instanceof InheritanceSub2);  // true

        InheritanceSub oIS2_ = new InheritanceSub();
        System.out.println(oIS2_ instanceof Inheritance);  // true
        System.out.println(oIS2_ instanceof InheritanceSub);  // true
        System.out.println(oIS2_ instanceof InheritanceSub2);  // true
        System.out.println("");

        Inheritance oIS3 = new InheritanceSub2();
        System.out.println(oIS3 instanceof Inheritance);  // true
        System.out.println(oIS3 instanceof InheritanceSub);  // true
        System.out.println(oIS3 instanceof InheritanceSub2);  // true

        InheritanceSub oIS3_ = new InheritanceSub2();
        System.out.println(oIS3_ instanceof Inheritance);  // true
        System.out.println(oIS3_ instanceof InheritanceSub);  // true
        System.out.println(oIS3_ instanceof InheritanceSub2);  // true

        InheritanceSub2 oIS3__ = new InheritanceSub2();
        System.out.println(oIS3__ instanceof Inheritance);  // true
        System.out.println(oIS3__ instanceof InheritanceSub);  // true
        System.out.println(oIS3__ instanceof InheritanceSub2);  // true

    }

    public void checkInvocation(Inheritance inh) {
        // This method is to be invoked in a subclass
        System.out.println(inh.getClass());
    }

    public Inheritance() {
        
        // Case 1
//        new Derived().getName();    // null

        // Case 2
//        Base2 bs2 = new Base2();
//        Derived2 dr2 = new Derived2();
//        /**
//         * Super class's method may accept a subclass's instance, although an 
//         * interface of a method points to a super class. This is an inheritance 
//         * feature and called "upcasting", i.e. восходящее преобразование типов.
//         */
//        bs2.getName(dr2);   // class ru.jbasics.Derived2
        
        // Case 3 - NO ANY SENSE HERE, MADE FOR FURTHER
        Instrument instr = new Instrument();
        instr.play(new Guitar());
        instr.play(new Piano());
        instr.play(new Violin());
    }
}

class InheritanceSub extends Inheritance {

    /*
     * Although, the method is static, it anyway extends to subclass and one 
     * cannot assign a weaker access privilege.
     */
//    private static void method() {
//        System.out.println("InheritanceSub method");
//    }
    public void method2() {
        // Method2 has a private access
//        super.method2();
    }

    public InheritanceSub() {
        // Method2 has a private access
//        super.method2();
    }
}

class InheritanceSub2 extends InheritanceSub {
    
}


// Case 1
class Base {

    public Base() {
        /*
         Here we get "null" instead of Derived.
         https://habrahabr.ru/company/rambler-co/blog/277273/
         https://docs.oracle.com/javase/specs/jls/se7/html/jls-12.html#jls-12.5
         If U R to put a "final" for a "name" in "Derived" class, then we get 
         "Derived" printed.
         */
        System.out.println(getName());
    }

    protected String getName() {
        return "Base";
    }
}

class Derived extends Base {

    private String name = "Derived";

    @Override
    protected String getName() {
        return this.name;
    }

}

// Case 2
class Base2 {

    protected void getName(Base2 bs) {
        System.out.println(bs.getClass().toString());
    }
}

class Derived2 extends Base2 {
}




// Case 3 - NO ANY SENSE HERE, MADE FOR FURTHER
class Instrument {
    void play(Instrument instr) {
        System.out.println("Playing instrument");
    }
}

class Guitar extends Instrument {
    void play(Instrument instr) {
        System.out.println("Guitar playing");
    }
}

class Piano extends Instrument {
    void play(Instrument instr) {
        System.out.println("Piano playing");
    }
}

class Violin extends Instrument {
    void play(Instrument instr) {
        System.out.println("Violin playing");
    }
}
