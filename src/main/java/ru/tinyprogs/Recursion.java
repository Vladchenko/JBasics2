/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author v.yanchenko
 */
public class Recursion {

    // http://javarevisited.blogspot.com/2016/03/how-to-reverse-arraylist-in-java-using-recursion.html#ixzz43dAF5fTK
    public static List<String> reverseListRecursively(List<String> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<String> reversed = new ArrayList<>();
        reversed.add(list.get(list.size() - 1)); // last element
        reversed.addAll(reverseListRecursively(list.subList(0, list.size() - 1)));
        return reversed;
    }

    public static int numbers1To10(int i) {
        if (i < 11) {
            System.out.print(i + " ");
            numbers1To10(i + 1);
        }
        return i;
    }

    public static int numbers10To1(int i) {
//        if (i < 10) {
//            numbers10To1(i + 1);
//        }
//        System.out.print(i + " ");
//        return i;

        if (i == 11) {
            return 1;
        }
        System.out.print(i + " ");
        return numbers10To1(i + 1);
    }


//    https://habrahabr.ru/post/275813/

    public static int factorial(int n) {
        // условие выхода
        // Базовый случай
        // когда остановиться повторять рекурсию ?
        if (n == 1) {
            return 1;
        }
        // Шаг рекурсии / рекурсивное условие
        return factorial(n - 1) * n;
    }

    // Printing all the numbers from n to 1 in a row.
    public static int numbersNTo1(int n) {
        if (n == 0) {
            return 0;
        }
        System.out.print(n + " ");
        // Шаг рекурсии / рекурсивное условие
        return numbersNTo1(n - 1);
    }

    // Printing all the numbers from 1 to n in a row.
    public static String numbers1ToN(int n) {
        if (n == 0) {
            return "0";
        }
        System.out.print(n + " ");
        // Шаг рекурсии / рекурсивное условие
        return numbers1ToN(n - 1) + " " + n;
    }
}
