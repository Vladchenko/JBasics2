/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Demonstration of operating of a different loops.
 *
 * @author v.yanchenko
 */
public class Loops {

    int i = 0;
    int[] integerArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    List<Integer> integerList = new ArrayList<>();

    public void run() {

        // Following for statement is valid to compile and run
//        for (; true;) {
//            System.out.println();
//        }
        // i < intsArray.length - 2 will traverse up to element "7".
        for (i = 0; i < integerArray.length - 2; i++) {
            System.out.print(integerArray[i] + " ");
        }
        System.out.println();
        i = 0;

        for (int i2 : integerArray) {
            System.out.print(i2 + " ");
        }
        System.out.println();

        // As of iterating through an object type variables, it is required for 
        // such object to implement Iterable interface.
        // http://javarevisited.blogspot.ru/2016/02/how-does-enhanced-for-loop-works-in-java.html

        List<String> listOfCities = new ArrayList<>(
                Arrays.asList(new String[]{"USD", "GBP", "INR"}));
        for (String city : listOfCities) {
            System.out.println(city);
        }
        System.out.println();

        System.out.println("IntStream.range");
        IntStream.range(1, listOfCities.size()).forEach(i -> System.out.println(listOfCities.get(i-1)));

        System.out.println("listOfCities.forEach(item -> System.out.println(item));");
        listOfCities.forEach(item -> System.out.println(item));

        System.out.println("listOfCities.forEach(System.out::println);");
        listOfCities.forEach(System.out::println);

        while (i < integerArray.length) {
            System.out.print(i + " ");
            i++;
        }
        System.out.println();
        i = 0;

        do {
            System.out.print(integerArray[i]);
            i++;
        } while (i < integerList.size());
        System.out.println();

        System.out.println("Iterator: " + integerList.size());
        Iterator<Integer> itLst = integerList.iterator();
        while (itLst.hasNext()) {
            System.out.print(itLst.next() + " ");
        }

        // Prints Hello Hello Goodbye. Each from a next line.
        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Hello");
                continue outer;
            }
            System.out.println("outer");
        }
        System.out.println("Good-Bye");

    }

    private void demo() {
        // Strangely why this method has no compilation error.
        while (true);   // Infinite loop
    }
}
