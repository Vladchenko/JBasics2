/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.util.*;

/**
 * @author Влад
 */
//private class Classes {   // Modifier "private" is not allowed here
//protected class Classes {   // Modifier "protected" is not allowed here
public class Classes {

    // http://interviewinit.com/2013/12/%D0%BA%D0%B0%D0%BA%D0%B8%D0%B5-%D1%82%D0%B8%D0%BF%D1%8B-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%BE%D0%B2-%D0%B1%D1%8B%D0%B2%D0%B0%D1%8E%D1%82-%D0%B2-java-%D0%B2%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%BD%D1%8B/

    private static int m = 0;
    private int width = 5;
    private int height = 5;
    private Classes2 class2 = new Classes2();

    /**
     * Static initializer. It is used only for a static fields initialization.
     * Allowed in any class. It is called in a first place and only once, when
     * class have been downloaded.
     */
    static {

        System.out.println("Static initializer is invoked");
        System.out.println(m);
        m = 1;
        System.out.println(Classes.m);

        /**
         * Following row says "non-static variable cannot be referenced from a
         * static context"
         */
//        width = 6;
        /**
         * Following field is seen only in this scope (within static
         * initializer). Notice that it is not marked as static, but is so, due
         * to be present in static initializer.
         */
        int n = 0;

    }

    /**
     * Instance initializer, also called "double brace initialization". Allowed
     * to be present in any class. It is invoked when object instance is being 
     * created. After that a constructor is invoked. Beware, this idiom has some 
     * unexpected side-effects, e.g. this syntax actually creates an anonymous 
     * inner class.
     */ {
        // http://www.programcreek.com/2011/10/java-class-instance-initializers/
        System.out.println("Instance initializer is invoked");
        m = 5;
        width = 6;
        this.height = 3;
        System.out.println(this.height);    //3
        System.out.println(this);  // ru.jbasics.Classes@XXXXXXXX, i.e. Hashcode
    }

    public Classes() {

        System.out.println("Constructor is invoked");

        /**
         * Since m is static it is referred to be used with a class reference.
         * Object also could be used, but putting a class instead, is
         * symantically correct.
         */
//        System.out.println(Classes.m);
        addressAssignCheck();
//        objectInfo(new Object());
//        objectInfo( (new Reflections()).dynamicObjectCreation() );
//        dotClass();
    }

    /**
     * Only an inner class can be static. An "outer" one cannot be so. An
     * ordinary inner class has a reference to an outer class. Static class does
     * not have one.
     * To make an instance of an inner static class, one do not need to
     * instantiate an outer class. Static inner class cannot refer to a not
     * static methods or fields located in an outer class.
     * Every inner class can independently inherit some class, even if an outer
     * class inherits some class. It is some sort of a multiple inheritance
     * realization.
     * <p>
     * Inner clases are called "nested" classes and divided into 2 groups:
     * - Static nested class (aka nested class) (*) ;
     * - Non static nested class (aka inner class): (*)
     * - Local classes (*)
     * - Anonymous class (*)
     * (*) - by oracle's definition.
     * Get more info from:
     * (https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html)
     */
    public static class NestedClass {

        int i;

        NestedClass() {
            System.out.println("static Class1 has been created");
        }

        static void method1() {
            System.out.println("Class1 method1 has been run.");
        }

        void method2() {
            System.out.println("Class1 method2 has been run.");
        }
    }

    ;

    public class LocalClass {

        int i;

        LocalClass() {
            System.out.println("Class2 has been created");
        }

        /**
         * An instance of an inner class is implicitly associated with an
         * instance of its outer class, it cannot define any static methods
         * itself. Since a static nested class cannot refer directly to instance
         * variables or methods defined in its enclosing class, it can use them
         * only through an object reference, it's safe to declare static methods
         * in a static nested class.
         */
//        static void method1() {
//        System.out.println("LocalClass method1 has been run.");
//        }

        void method2() {
            System.out.println("Class2 method2 has been run.");
        }

        void method3() {
            // Getting an access to a field residing in an outer class.
            int i = Classes.this.width;
            System.out.println(i);
        }

        private void method1() {
            System.out.println("method1");
        }
    }

    ;

    class Parent {

        int x;

        void method() {
            System.out.println("Parent.method");
        }
    }

    class Child extends Parent {

        int y;

        void method2() {
            System.out.println("Parent.method");
        }
    }

    class Child2 extends Parent {

        int z;
    }

    public void parentChildren() {
        /*
         * As soon as "p" has an interface of "Parent", it won't see the fields
         * of an instantiated class "Child", so p.y cannot be accessed, but it
         * is present in p.
         */
        Parent p = new Child();
        // Thus, next statement won't do.
//        System.out.println(p.y);
        /*
         * Apart from p keeping an interface of Parent, it keeps an instance of 
         * class Child, therefore explicit casting will provide an access to a 
         * "hidden" field.
         */
        System.out.println(((Child) p).y);
        /*
         * Following declaration puts a formerly instantiated "Child" into "c",
         * because "p" holds object "Child", though hides the realization of it.
         */
        Child c = (Child) p;

        // As seen here, "с" now has a field "y"
        System.out.println(c.y);

        Parent p2 = new Child2();
        /*
         * Following declaration is valid during compile time, but fires an
         * exception during runtime. Valid, because "Child" is a descendant of
         * Parent, but gets an error, because actual instance is "Child2" but
         * not "Child".
         */
        Child c2 = (Child) p2;

        // To check if a transition (casting) is possible, use "instanceof"
        if (p instanceof Child) {
            Child c3 = (Child) p;
        }

        Parent p3 = new Child();
//        Child c = p3;   // ошибка! сужение!
        Child c4 = (Child) p3;   // Explicit casting required.
        Parent p4 = (Parent) new Child();

    }

    public void addressAssignCheck() {

        class Data {

            public int data = 0;

            public Data(int d) {
                data = d;
            }
        }
        Data a = new Data(1); // a.data is 1
        Data b = new Data(2); // b.data is 2

        System.out.print("a.toString() = " + a.toString());
        System.out.println("   a.data = " + a.data);    // 1
        System.out.print("b.toString() = " + b.toString());
        System.out.println("   b.data = " + b.data);    // 2
        System.out.println("");

        b = a; // b.data and a.data are 1
        System.out.println("b = a");
        System.out.print("a.toString() = " + a.toString());
        System.out.println("   a.data = " + a.data);    // 1
        System.out.print("b.toString() = " + b.toString());
        System.out.println("   b.data = " + b.data);    // 1
        System.out.println("");

        a.data = 3; // b.data and a.data are 3
        System.out.println("a.data = 3");
        System.out.print("a.toString() = " + a.toString());
        System.out.println("  a.data = " + a.data);    // 3
        System.out.print("b.toString() = " + b.toString());
        System.out.println("  b.data = " + b.data);    // 3
        System.out.println("");

        a = new Data(4);
        System.out.println("a = new Data(4)");
        System.out.print("a.toString() = " + a.toString());
        System.out.println("   a.data = " + a.data);    // 4
        System.out.print("b.toString() = " + b.toString());
        System.out.println("   b.data = " + b.data);    // 3
        System.out.println("");

        b = new Data(5);
        System.out.println("b = new Data(5)");
        System.out.print("a.toString() = " + a.toString());
        System.out.println("   a.data = " + a.data);    // 4
        System.out.print("b.toString() = " + b.toString());
        System.out.println("   b.data = " + b.data);    // 5
        System.out.println("");
    }

    private void instantiatingInnerClasses() {

        // Creating of a static "NestedClass" subclass of a "Classes" class
        NestedClass oClass1 = new NestedClass();
        NestedClass oClass1_2 = new Classes.NestedClass();
        Classes.NestedClass oClass1_3 = new NestedClass();
        Classes.NestedClass oClass1_4 = new Classes.NestedClass();
        // Cannot be done, because NestedClass is not static.
//        Classes.NestedClass oClass1_4 = (new Classes()).new NestedClass();

        // Creating of a "LocalClass" subclass of a "Classes" class
        // As one sees, it is required to create a "Classes" instance in advance
        Classes.LocalClass oClass2 = (new Classes()).new LocalClass();
        // (new Classes()) instantiates an outer class
        // .new LocalClass() instantiates an inner class

        // Doing the same, but splitting declaration and implementation
        Classes oClass = new Classes();
        Classes.LocalClass oClass3 = oClass.new LocalClass();

        // Making the same, but not assigning the instance to any field
        (new Classes()).new LocalClass();

        // Making the same, and invoking a method1() at the same time
        (new Classes()).new LocalClass().method1();

    }

    private void anonymousClass() {

        /**
         * Instead of "new Class2()", one could use interface or abstract class
         * instead.
         */
        LocalClass cls2 = new LocalClass() {
            int i = 0;

            // It's like overriding a method

            public void method() {
                System.out.println("anonymous class");
            }
        };

        // Implementing a List interface with an anonymous class.
        List cls3 = new List() {
            int i = 0;

            @Override
            public int size() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isEmpty() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean contains(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Iterator iterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object[] toArray() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object[] toArray(Object[] a) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean add(Object e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean remove(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean containsAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean addAll(int index, Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean removeAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean retainAll(Collection c) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void clear() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object get(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object set(int index, Object element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void add(int index, Object element) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public Object remove(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int indexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public int lastIndexOf(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator listIterator() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public ListIterator listIterator(int index) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public List subList(int fromIndex, int toIndex) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        // Implementing an abstract class with an anonymous class.
        Number nmbr = new Number() {
            @Override
            public int intValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public long longValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public float floatValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public double doubleValue() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

    }

    public void objectInfo(Object obj) {

        /* 
         * Java has a common object in its classes hierarchy called Object.
         * Let's check out some methods about it.
         */
        System.out.println("This shows some info about an Object passed into this method:");
        System.out.println("Object.equals(Object) = " + obj.equals(obj));
        System.out.println("Object.getClass()   = " + obj.getClass());
        System.out.println("Object.getClass().toString() = " + obj.getClass().toString());
        System.out.println("Object.hashCode()   = " + obj.hashCode());
        System.out.println("Object   = " + obj);
        System.out.println("Object.toString()   = " + obj.toString());
        System.out.println("");

    }

    public void dotClass() {

        /**
         * Methods that belong to class are invoked using ".class" lexem. This
         * approach is called a "Reflection" and regarded in a Reflection class
         * located in some other package.
         */

        Object[] arrObjects = HashMap.class.getClasses();
        for (int i = 0; i < arrObjects.length; i++) {
            System.out.println(arrObjects[i]);
        }

        // Extra way of instantiation of some class.
        try {
            System.out.println(Integer.class.getClass().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}

/**
 * Class can reside outside of a basic(public) class. It cannot be private,
 * protected or static, but can be final or abstract. As of modifier public,
 * there could be one such class in a file and it should be named by the name of
 * that class.
 *
 * @author v.yanchenko
 */
class Classes2 {
}
