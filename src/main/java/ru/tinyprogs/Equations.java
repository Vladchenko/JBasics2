/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs;

import java.awt.*;

/**
 *
 * @author Влад
 */
public class Equations {

    public Equations() {
        task1();
    }


    public void task1() {
        /**
         * Найти общее решение для уравнения 3x+5y=10
         *
         * Выберите один ответ: a. X=-20+3k, Y=30-5k b. X=-30+3k, Y=20-5k c.
         * X=-20+5k, Y=30-3k d. X=-30+5k, Y=20-3k
         */
        int x,
                y;
        for (int k = 0; k < 1000; k++) {
            x = -20 + 3 * k;
            y = 30 - 5 * k;
            if (3 * x + 5 * y == 10) {
                System.out.println("a. X=-20+3k, Y=30-5k is correct for k = " + k);
            }
            x = -30 + 3 * k;
            y = 20 - 5 * k;
            if (3 * x + 5 * y == 10) {
                System.out.println("b. X=-30+3k, Y=20-5k is correct for k = " + k);
            }
            x = -20 + 5 * k;
            y = 30 - 3 * k;
            if (3 * x + 5 * y == 10) {
                System.out.println("c. X=-20+5k, Y=30-3k is correct for k = " + k);
            }
            x = -30 + 5 * k;
            y = 20 - 3 * k;
            if (3 * x + 5 * y == 10) {
                System.out.println("d. X=-30+5k, Y=20-3k is correct for k = " + k);
            }
        }
    }

    public void task2() {
        /**
         * Имеется система уравнений вида A1*x + B1*y + C = 0 A2*x + B2*y + C =
         * 0.
         * По имеющимся значениям A1,A2,B1,B2,C1,C2 найти неизвестные "х" и "y".
         * 
         * http://www.mathprofi.ru/kak_reshit_sistemu_uravnenii.html
         * 
         * NOT DONE YET.
         * 
         */
        
    }


    /**
     * Solves a quadratic equation, using a discriminant.
     * int a, int b, int c stand for ax^2 + bx + c = 0, respectively
     *
     * @return Point - roots of the equation - x1, x2.
     */
    public static Point solveQuadraticEquation(int a, int b, int c)
            throws ArithmeticException {
        int x1 = 0;
        int x2 = 0;
        int D = b * b - 4 * a * c;
        if (D < 0) {
            throw new ArithmeticException();
        }
        if (D >= 0) {
            x1 = (int) ((-b + Math.sqrt(D)) / (2 * a));
            x2 = (int) ((-b - Math.sqrt(D)) / (2 * a));
        }
        return new Point(x1, x2);
    }

    /**
     * Represents a solution of a quadratic equation.
     *
     * @param a
     * @param b
     * @param c - stand for ax^2 + bx + c = 0, respectfully.
     * @param root1
     * @param root2 - stand for roots - x1, x2.
     *
     * Sample look - x^2 + 5x - 3 = 0 -> x1 = 0, x2 = -3
     */
    public static void showQuadraticEquation(int a, int b, int c, int root1, int root2) {
        String result = "";
        result += (a < 0) ? "-" : "" + "x^" + Math.abs(a) + " ";
        result += (b < 0) ? "- " : "+ " + Math.abs(b) + "x ";
        result += ((c < 0) ? "- " : "+ ") + Math.abs(c) + " = 0";
        System.out.println(result + "  ->  x1 = " + root1 + ", x2 = " + root2);
    }

    /**
     * Functionality is analogous to showQuadraticEquation(int a, int b, int c,
     * int root1, int root2), except parameters int root1, int root2 are
     * replaced with Point pnt that hold root1 and root2 as Point.x, Point.y .
     */
    public static void showQuadraticEquation(int a, int b, int c, Point pnt) {
        showQuadraticEquation(a, b, c, pnt.x, pnt.y);
    }


}
