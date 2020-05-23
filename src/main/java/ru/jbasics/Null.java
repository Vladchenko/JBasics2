/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

/**
 *
 * @author Влад
 */
public class Null {

    /*
     * Get more info on
     * http://javarevisited.blogspot.ru/2014/12/9-things-about-null-in-java.html
     */
    private static Object myObj;

    public static void run() {

        System.out.println("Value of myObjc is : " + myObj);    // null
        // NullPointerException
        try {
            System.out.println("Value of myObj.getClass() is : " + myObj.getClass());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        myObj = new Object();
        System.out.println("Value of myObj is : " + myObj);
        System.out.println("Value of myObj.getClass() is : " + myObj.getClass());

        String str = null; // null can be assigned to String 
        Integer itr = null; // you can assign null to Integer also 
        Double dbl = null; // null can also be assigned to Double 
        String myStr = (String) null; // null can be type casted to String 
        Integer myItr = (Integer) null; // it can also be type casted to Integer 
        Double myDbl = (Double) null; // yes it's possible, no error

        Integer itr2 = null; // this is ok 
//        int j = itr2; // this is also ok, but NullPointerException at runtime

        Integer iAmNull = null;
        /**
         * Following piece of code says that "iAmNull" is not of an "Integer"
         * type
         */
        if (iAmNull instanceof Integer) {
            System.out.println("iAmNull is instance of Integer");
        } else {
            System.out.println("iAmNull is NOT an instance of Integer");
        }

        String abc = null;
        String cde = null;
        if (abc == cde) {
            System.out.println("null == null is true in Java"); // this one works
        }
//        if (abc.equals(cde)) {    // NullPointerException
//            System.out.println("null == null is true in Java"); // this one works
//        }
        if (null != null) {
            System.out.println("null != null is false in Java");
        }

        // classical null check 
        if (abc == null) {
            // do something 
        }

        // not ok, compile time error. null cannot be compared
//        if(abc > null){ }
        Null myObject = null;
        /*
         * Instance that is null invokes static method. This method
         * is invoked from a class, not the instance.
         */
        myObject.iAmStaticMethod();
//        myObject.iAmNonStaticMethod();    // NullPointerException

    }

    private static void iAmStaticMethod() {
        System.out.println("I am static method, can be called by null reference");
    }

    private void iAmNonStaticMethod() {
        System.out.println("I am NON static method, don't date to call me by null");
    }

}
