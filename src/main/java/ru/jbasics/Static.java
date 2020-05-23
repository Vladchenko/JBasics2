package ru.jbasics;

/**
 * https://www.youtube.com/watch?v=cwQ0da3COaE    time frame [1:20 ... 5:30].
 * @author v.yanchenko
 */
public class Static {

    static int totalCount;
    /*
     * Provided that b is static, using a class name, "b" could be
     * referred to even without its preliminary declaration. But anyway,
     * it is going to be 0, such as "a" in a next row.
     */
    static int a = Static.b;
    static int b = 5;
    static int b2 = a;
    int a2 = Static.b;

    static {
        System.out.println(a);  // 0
        a = 5;
//        b3 = 7;   // cannot be used until its declaration
    }
    // Non static a2 cannot be put to static b3, because a2 do not exist yet, 
    // in this assignment.
//    static int b3 = a2;

    // a3 cannot be used without its classname.
//    static int b4 = a3;
    // a3 can be referred to before its declaration, when a classname is used.
    static int b4 = Static.a3;  //    b4 = 0;
    static int a3 = 3;          //    a3 = 3;

    public Static() {

        Static h = null;
        /**
         * Field "totalCount" is accessable even having an "h" object not
         * instatiated.
         */
        /**
         * One could refer to static fields and methods using both - classname
         * and instance name as well. It is strongly advised to use a classname,
         * when referring to a static fields or methods.
         */
        h.totalCount += 10;         // No error, totalCount = 10;
        Static.totalCount += 10;    // totalCount = 20;

//        h.getTotalCount();
//        Static.getTotalCount();
        /**
         * One cannot instantiate a Math object, because it's constructor is
         * declared private.
         */

//        Object obj = new Math();
        // It is allowed to use it only by referring to its classname.
//        double i = Math.sin(90);
    }

    public static int getTotalCount() {
        return totalCount;
    }

    class Static1 {
        // Check the error that following line spawns
        // inner class cannot have a static methods
//        static void method1() { }
    }

    class Static2 extends Static {
//        public static int getTotalCount() {
//            return 0;
//        }
    }

    public void checkStaticAB() {
        // A.f is invoked twice in this case. Check the code lower.
        A.f();
    }

    public void checkD() {
        D.method();
        D d = new D();
//        d. // No static methods.
    }
}

class A {

    final static Object b = new B();
    final static int S1 = 1;
    final static Integer S2 = 2;

    static void f() {
        System.out.println(S1);
        System.out.println(S2);
    }
}

// For A class
class B{

    static {
        A.f();
    }
}



class C {
    public static int с = 0;
    public static void method() {
        System.out.println("class C");
    }
}

class D extends C {

//    http://stackoverflow.com/questions/2223386/why-doesnt-java-allow-overriding-of-static-methods

//    Override is not allowed here, since static methods cannot be overloaded
//    @Override
    public static void method() {
        // Calling super.method() is also not allowed.
//        super.method();
        System.out.println("class D");
    }

}
