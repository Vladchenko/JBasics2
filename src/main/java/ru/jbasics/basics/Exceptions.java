/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

/**
 * Exceptions demonstration.
 *
 * @author Влад
 */
public class Exceptions {

    public Exceptions() {
//        demo();
//        demo2();
//        demo3(null);
        demo4();
    }

    private void demo() {
        try {
            int[] numbers = {10, 100, 1000, 10000, 100000};
            int number = numbers[5];
            System.out.println(number);
        }
        // No code allowed here between try and catch
//        System.out.println("0");
        catch (IndexOutOfBoundsException ioobException) {
            System.out.println("1");
//            ioobException.printStackTrace();
        }
        // This catch won't work, 'cause a previous one worked
        catch (Exception exception) {
            System.out.println("2");
//            exception.printStackTrace();
        }
        System.out.println("3");
    }

    //https://habrahabr.ru/company/golovachcourses/blog/223821/#2

    /**
     * Выбор catch осуществляется в runtime (а не в compile-time), значит учитывается не тип ССЫЛКИ (Throwable),
     * а тип ССЫЛАЕМОГО (Exception)
     */

    private void demo2() {
        // One may catch any object of a Throwable type and its descendants.
        try {
            System.out.println("Exceptions.demo() method");
        } catch (Throwable t) {
            System.out.println("Catch clause");
        }
        try {
            throw new Error();
        } catch (Throwable t) {
            System.out.println("Error is caught");
        }
        throw null; // Throws null pointer exceptions.
    }

    private void demo3(NullPointerException e) {
        try {
            throw e;
        } catch (NullPointerException npe) {
            demo3(npe);
        }
    }

    private void demo4() {

        /**
         * >> RUNTIME ERROR: Exception in thread "main" java.lang.Error
         * >> sout
         *
         * or
         *
         * >> sout
         * >> RUNTIME ERROR: Exception in thread "main" java.lang.Error
         *
         * That's because System.out is a buffered stream and System.err
         * is not.
         * Check https://habrahabr.ru/company/golovachcourses/blog/223821/#2
         */

        System.out.println("sout");
        throw new Error();
    }

    private void demo5() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.print(" 2");
            if (true) {
                throw new Error();
            } // и бросили новый Error
            // хотя есть cath по Error "ниже", но мы в него не попадаем
        } catch (Error e) {
            System.err.print(" 3");
        }
        System.err.println(" 4");

        // Prints 0 2
    }

    private void demo6() {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {
                    throw new Error();
                } // и бросили новый Error
                System.err.print(" 2.3");
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");
        }
        System.err.println(" 4");

        // Prints 0 2.1 2.2 2.4 2.5 4
    }

    private void demo7() {
//        try {
//        } catch (Exception e) {
//            // Compile error - java.lang.RuntimeException
//            // has aleady been caught.
//        } catch (RuntimeException e) {
//        }
        // This one will do.
        try {
        } catch (Error e) {
        } catch (RuntimeException e) {
        }
    }

    private void demo8() {
        // Finally works anyway.
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }

    private void demo9() {

        // Finally works anyway.
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }

    private void demo10() {
        // JVM exits, so finally won't work.
        try {
            System.exit(42);
            // Same as - Runtime.getRuntime().exit(42);
            // Runtime.getRuntime().halt(42);
        } finally {
            System.err.println("finally");
        }
    }

    // Not done, stopped at
    // "Однако finally-секция может «перебить» throw/return
    // при помощи другого throw/return"

}