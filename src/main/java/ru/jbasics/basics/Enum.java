/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

/**
 * Enum demonstration
 *
 * @author Влад
 */
public class Enum {

    /**
     * Class that keeps only consts. It can also have a methods. Instance of
     * enum is only one in application. Provides type safety.
     * <p>
     * https://www.youtube.com/watch?v=foEbROYL53E
     * https://www.youtube.com/watch?v=XQifp8B8xvI
     */
    // enum may have no semicolon at the end of its declaration.
    enum Days {
        Sum, Mon, Tue
    }

    enum Weeks {

        FRST(1), SCND(2), THRD(3), FRTH(4);
        private final int id;

        Weeks(int num) {
            this.id = num;
        }

        public Weeks findByKey(int i) {
            Weeks[] weeks = Weeks.values();
            for (Weeks week : weeks) {
                if (week.id == i) {
                    return week;
                }
            }
            return null;
        }
    }

    ;

    // enum doesn't allow numbers in it. Following row is not compilable.
//    enum Minutes {1, 2, 3, 4};    

    // Show all the values present in enum.
    public void showValues() {
//        System.out.println(Days.values());  // [Lru.jbasics.Enum$Days;@xxxxxxxx
        for (Days day : Days.values()) {
            System.out.print(day + " ");
        }
    }

    public void printCommonInfo() {
        System.out.println(Days.valueOf("Mon"));
        try {
            System.out.println(Days.valueOf("Wed"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    public Enum() {
    }

    // Enum may have an arguments in a constructor
    public Enum(int i) {
    }
}
