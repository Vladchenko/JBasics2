/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Влад
 */
public class Generics2 {

    private class Machine {

        @Override
        public String toString() {
            return ("I am a machine");
        }
    }

    private class Car extends Machine {

        @Override
        public String toString() {
            return ("I am a camera");
        }
    }
    List<Machine> oMachine = new ArrayList<Machine>();
    List<Car> oCar = new ArrayList<Car>();

    public Generics2() {
        oCar.add(new Car());
        oCar.add(new Car());
        oCar.add(new Car());
        oMachine.add(new Machine());
        oMachine.add(new Machine());
        oMachine.add(new Machine());
        showList(oCar);
        showList(oMachine);
        showList2(oCar);
        showList2(oMachine);
        showList3(oCar);
        showList3(oMachine);
        showList4(oCar);
        showList4(oMachine);
        showList5(fBoxArray);
        showList6(fBoxList);
    }

    // Prints all the elements of a list of any type.
    public void showList(List<?> lst) {
        System.out.println(lst);
    }

    // Prints all the elements of a list of any type.
    public void showList2(List<?> lst) {
        for (Object lst1 : lst) {
            System.out.println(lst1);
        }
        // Machine type is not allowed here
//        for (Machine lst1 : lst) { }
    }

    // Prints all the elements of a list of type Machine or its descendants.
    public void showList3(List<? extends Machine> lst) {
        System.out.println(lst);
    }

    // Prints all the elements of a list of type Machine or its descendants.
    public void showList4(List<? extends Machine> lst) {
        for (Machine lst1 : lst) {
            System.out.println(lst1);
        }
    }
//
//    
//    
    class Box<T> { }

//    T ее = new T();   // One cannot do that, because T is unknown.
    Box[] fBoxArray = new Box[5];
    List<String> fBoxList = new ArrayList<>();

    // Prints all the elements of an array of any type.
    public <T> void showList5(T[] x) {
        for (T x1 : x) {
            System.out.print(x1);
        }
        System.out.println("");
    }
    
    // Prints all the elements of a list of any type.
    public <T> void showList6(List<T> x) {
        for (T x1 : x) {
            System.out.print(x1);
        }
        System.out.println("");
    }
}
