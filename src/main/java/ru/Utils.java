/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Влад
 */

public class Utils {

    // Printing an array of any object type.
    public static <T> void printArr(T[] arr) {
        for (T b : arr) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }

    // Printing an array of longs in a row
    public static void printArr(int[] arr) {
        for (int b : arr) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }

    // Printing an array of longs in a row
    public static void printArr(long[] arr) {
        for (long b : arr) {
            System.out.print(b + " ");
        }
        System.out.println("");
    }

    public static <T extends Iterable<E>, E> void printList(T list) {
        for (E lst:list) {
            System.out.print(lst + " ");
        }
    }

    // Integer list to array 
    public static int[] toArray(List<Integer> ints) {
        int[] intsArr = new int[ints.size()];
        for (int i = 0; i < intsArr.length; i++) {
            intsArr[i] = ints.get(i);
        }
        return intsArr;
    }

    // Reading integer from keyboard (Scanner is picked with no any reason).
    public static int readInteger() {
        int number = 0;
        System.out.print("Input integer : ");
        Scanner scanner = new Scanner(System.in);
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.print("Wrong integer, input again. ");
            readInteger();
        }
        return number;
    }

    // Reading string from keyboard.
    public static String readLine() {
        String str = null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = bufferedReader.readLine();
        } catch (IOException ex) {
            readLine();
        }
        return str;
    }

    // Shortcut for System.out.print(s);
    public static void print(String s) {
        System.out.print(s);
    }

    // Shortcut for System.out.println(s);
    public static void println(String s) {
        System.out.println(s);
    }

    // Populating array for ints.
    public static int[] populateArray(int number, int randomNumber) {
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = (int) (Math.random() * randomNumber);

        }
        return arr;
    }

    // Populting array for all the numeric types.
    // Not sure how to do that yet.
    public static <T extends Number> T[] populateArray_(int number, int random) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
//            list.add((Math.random() * random));
        }
        return (T[])list.toArray();
    }
    
    // Populating a 2d array.
    public static int[][] populateArray(int width, int height, int randomNumber) {
        int arrInts[][] = new int[height][width];
        for (int i = 0; i < arrInts.length; i++) {
            arrInts[i] = new int[width];
            for (int j = 0; j < arrInts[i].length; j++) {
                arrInts[i][j] = (int)(Math.random() * randomNumber);
            }
        }
        return arrInts;
    }
    
    // Printing a 2d array.
    public static void printArray(int[][] arrInts) {
        for (int i = 0; i < arrInts.length; i++) {
            for (int j = 0; j < arrInts[i].length; j++) {
                System.out.print(arrInts[i][j]);
            }
            System.out.println();
        }
    }
}
