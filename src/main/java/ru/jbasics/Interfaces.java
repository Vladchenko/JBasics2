/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

/**
 *
 * @author Влад
 */
public class Interfaces {

    // All the fields of interfaces are public static final
    static final int a = 0;
    final int B = 0;
    static int c = 0;

    /**
     * Interface methods are public, abstract and never final. Think of them as
     * prototypes only; no implementations are allowed
     */
    public interface Interface1 {

        public void method1();

        int method2();
    }

    public interface Interface2 {

        char method3();

        String method4();
    }

    /**
     * https://docs.oracle.com/javase/tutorial/java/IandI/interfaceDef.html
     *
     * The interface body can contain abstract methods, default methods, and
     * static methods. An abstract method within an interface is followed by a
     * semicolon, but no braces (an abstract method does not contain an
     * implementation). Default methods are defined with the default modifier,
     * and static methods with the static keyword. All abstract, default, and
     * static methods in an interface are implicitly public, so you can omit the
     * public modifier.
     *
     * In addition, an interface can contain constant declarations. All constant
     * values defined in an interface are implicitly public, static, and final.
     * Once again, you can omit these modifiers.
     */
    public interface Interface3 {

        // One can declare a class here, I wonder why.
        class A {

        }

        enum enumIdentifier {q,w,e,r};  // Enums are also allowed

        abstract void method1();

        static void method2() {
            System.out.println("This is static method.");
        }
    ;

    }
    
    /**
     * http://stackoverflow.com/questions/2400828/inner-class-within-interface
     * 
     * Yes it is possible to have static class definitions inside an interface, 
     * but maybe the most useful aspect of this feature is when using enum types
     * (which are special kind of static classes). For example you can have 
     * something like this:
     */
    public interface User {

        public enum Role {

            ADMIN("administrator"),
            EDITOR("editor"),
            VANILLA("regular user");

            private String description;

            private Role(String description) {
                this.description = description;
            }

            public String getDescription() {
                return description;
            }
        }

        public String getName();

        public void setName(String name);

        public Role getRole();

        public void setRole(Role role);
    }

    // Implementing an interface
    public class Interface1Impl implements Interface1 {

        @Override
        public void method1() {
            System.out.println("method1");
        }

        @Override
        public int method2() {
            System.out.println("method2");
            return 0;
        }
    }

    // Implementing an interfaces
    public class Interface2Impl implements Interface1, Interface2 {

        @Override
        public void method1() {
            System.out.println("method1");
        }

        @Override
        public int method2() {
            System.out.println("method2");
            return 0;
        }

        @Override
        public char method3() {
            System.out.println("method3");
            return 'c';
        }

        @Override
        public String method4() {
            System.out.println("method4");
            return "method4";
        }
    }

    // Instantiating a class that implements such an interface
    Interface1Impl oi1 = new Interface1Impl();
    /*
     * Making a scope wider, i.e. oi2 is able to hold any object that implements
     * an interface Inerface1.
     */
    Interface1 oi2 = new Interface1Impl();
    // Interface points to such a class. HOW COULD THIS BE POSSIBLE ?
    // AND WHAT IS THIS FOR ?
    Interface1 i1_ = oi1;
    // i1 has an "Interface1" type, though it points to "Interface2Impl" object
    // i1 won't see methods from "Interface2Impl" class
    Interface1 i1 = new Interface2Impl();
    Interface2 i2 = new Interface2Impl();

    Interfaces() {
        i1_.method1();
        i1.method2();
        i2.method3();
    }
}
