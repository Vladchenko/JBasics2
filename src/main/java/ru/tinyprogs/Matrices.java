/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs;

import java.util.*;

/**
 *
 * @author Software Developer
 */
public class Matrices {

    int matrixWidth = 10;
    int matrixHeight = 10;
    // Value to pick up a random number from, e.c. [0..randomValue]
    int randomValue = 10;
    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

    public Matrices() {
        Task31();
    }

    public void populateMatrixRandomly(ArrayList<ArrayList<Integer>> matrix) {
        for (int i = 0; i < matrixHeight; i++) {
            ArrayList<Integer> ints = new ArrayList<>();
            for (int j = 0; j < matrixWidth; j++) {
                ints.add((int) (Math.random() * randomValue - 5));
            }
            matrix.add(ints);
        }
    }

    public void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        Iterator it = matrix.iterator();
        while (it.hasNext()) {
            List<Integer> ints = (List<Integer>) it.next();
            Iterator it2 = ints.iterator();
            while (it2.hasNext()) {
                System.out.print(it2.next() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void swapElements(ArrayList<ArrayList<Integer>> matrix, int i, int j) {
        // Method gets the matrix, row and a column as its parameters
        // and swaps elements as [column] & [column + 1]
        int temp = matrix.get(i).get(j);
        matrix.get(i).set(j, matrix.get(i).get(j + 1));
        matrix.get(i).set(j + 1, temp);
    }

    // Inputting an integer from a keyboard
    public int inputInt() {
        int i = 0;
        try {
            System.out.println("Input an integer value from keyboard: ");
            i = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wrong value ! Input again ...");
            inputInt();
        }
        return i;
    }

    //<editor-fold defaultstate="collapsed" desc="Tasks">
    public void Task1() {

        /*
         * Populate 2d array in some way.
         * Swap element with a next one, in case it is greater
         */
        populateMatrixRandomly(matrix);
        System.out.println("Initial matrix:");
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size() - 1; j++) {
                if (matrix.get(i).get(j) > matrix.get(i).get(j + 1)) {
                    try {
                        swapElements(matrix, i, j);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("!");
                    }
                }
            }
        }

        System.out.println("Processed matrix:");
        printMatrix(matrix);

    }

    public void Task2() {

        /*
         * Populate 2d array in some way.
         * If elements are multiples of 10, print their indices.
         */
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("Numbers that end with \"0\":");

        for (int i = 0; i < matrix.size() - 1; i++) {
            System.out.print("Line " + (i + 1) + " - ");
            for (int j = 0; j < matrix.get(i).size() - 1; j++) {
                if (matrix.get(i).get(j) % 10 == 0) {
                    System.out.print("[" + j + "]");
                }
            }
            System.out.println();
        }

    }

    public void Task3() {

        /*
         * Populate 2d array in some way.
         * Print the indices of an elements that are even.
         */
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("Even neighbors: (indices begin with 1, not 0)");

        for (int i = 0; i < matrix.size() - 1; i++) {
            System.out.print("Line " + (i + 1) + " - ");
            for (int j = 0; j < matrix.get(i).size() - 1; j++) {
                if (matrix.get(i).get(j) % 2 == 0
                        && matrix.get(i).get(j + 1) % 2 == 0) {
                    System.out.print("[" + (j + 1) + "," + (j + 2) + "]");
                }
            }
            System.out.println();
        }

    }

    public void Task4() {

        /*
         * Populate 2d array in some way.
         * Print the indices of an elements that are greater than a
         * previous and next element.
         */
        System.out.println("Neighbors are less: (indices begin with 1, not 0)");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            System.out.print("Line #" + i + " - ");
            for (int j = 1; j < matrix.get(i).size() - 1; j++) {
                if (matrix.get(i).get(j) > matrix.get(i).get(j + 1)
                        && matrix.get(i).get(j) > matrix.get(i).get(j - 1)) {
                    System.out.print("[" + (j + 1) + "],");
                }
            }
            System.out.println("");
        }

    }

    public void Task5() {

        /*
         * Populate 2d array in some way, for there could be positive
         * and negative values. Count the number of times the + is changed to -.
         */
        System.out.println("Number of times, +/- changing: (indices begin with 1, not 0)\n");

        int number = 0;

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 1; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) >= 0
                        && matrix.get(i).get(j - 1) < 0) {
                    number++;
                }
                if (matrix.get(i).get(j) < 0
                        && matrix.get(i).get(j - 1) >= 0) {
                    number++;
                }
            }

        }

        System.out.println("The number of times the sign is changed from "
                + "+ to -, or - to +   is = " + number);

    }

    public void Task6() {

        /*
         * Populate 2d array in some way. Compute an average value and find a
         * value that is closest to this average, but not the average.
         */
        int average = 0;
        int sum = 0;
        int elementsNumber = 0;
        int currentDelta = 0;
        int nearAverageI = 0;
        int nearAverageJ = 0;

        System.out.println("Find a number closest to average one, but the average.\n");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sum += matrix.get(i).get(j);
                elementsNumber++;
            }
        }

        average = sum / elementsNumber;
        System.out.println("The average number is : " + average);

        if (average >= 0) {
            currentDelta = Integer.MAX_VALUE;
        } else {
            currentDelta = Integer.MIN_VALUE;
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (currentDelta > matrix.get(i).get(j) - average
                        && matrix.get(i).get(j) - average > 0) {
                    currentDelta = matrix.get(i).get(j) - average;
                    nearAverageI = i;
                    nearAverageJ = j;
                }
            }
        }

        System.out.println("Number closest to average is: "
                + matrix.get(nearAverageI).get(nearAverageJ) + ", i=" + nearAverageI
                + ", j=" + nearAverageJ);
    }

    public void Task7() {

        /**
         * Populate a matrix in some way. Find a minimal element in it and
         * provide an indices for all the elements that equal to minimal.
         */
        int minimum = Integer.MAX_VALUE;

        System.out.println("Print the indices of an elements that equal to a minimum.\n");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (minimum > matrix.get(i).get(j)) {
                    minimum = matrix.get(i).get(j);
                }
            }
        }

        System.out.println("Minimum is : " + minimum + "\n");

        for (int i = 0; i < matrix.size(); i++) {
            System.out.print("Line #" + (i + 1) + " : ");
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (minimum == matrix.get(i).get(j)) {
                    System.out.print("[" + (j + 1) + "]");
                }
            }
            System.out.println("");
        }

    }

    public void Task8() {

        /**
         * Populate an array of 20 elements, split it into 2 10elm-s array.
         * First one gets even elements, second one - odd elements.
         */
        this.matrixWidth = 20;
        this.matrixHeight = 1;
        int evensInd = 0;
        int oddsInd = 0;
        int[] evens = new int[10],
                odds = new int[10];

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        // Populating elements in evens and odds.
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if ((j % 2) != 0) {
                    evens[evensInd] = matrix.get(i).get(j);
                    evensInd++;
                } else {
                    odds[oddsInd] = matrix.get(i).get(j);
                    oddsInd++;
                }
            }
        }

        // Printing evens and odds.
        System.out.print("Even elements: ");
        for (int i = 0; i < evens.length; i++) {
            System.out.print(evens[i] + " ");
        }
        System.out.println("");
        System.out.print("Odd elements: ");
        for (int i = 0; i < odds.length; i++) {
            System.out.print(odds[i] + " ");
        }

    }

    public void Task9() {

        /**
         * Populate a 2d array. Find and print a sum of an elements that less
         * than an evarage one.
         */
        int average = 0;
        int sum = 0;
        int elementsNumber = 0;

        System.out.println("Print a sum of an elements that less"
                + " than an evarage one.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sum += matrix.get(i).get(j);
                elementsNumber++;
            }
        }

        average = sum / elementsNumber;
        System.out.println("The average number is : " + average);
        System.out.println("Elements that less an average are : ");

        for (int i = 0; i < matrix.size(); i++) {
            System.out.print("Line #" + (i + 1) + " : ");
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) < average) {
                    System.out.print("[" + (j + 1) + "]");
                    sum += matrix.get(i).get(j);
                }
            }
            System.out.println("");
        }
        System.out.println("Sum is : " + sum);

    }

    public void Task10() {

        /**
         * Populate a 2d array. Find and print a sum of an elements that reside
         * in a primary and a secondary diagonal.
         */
        System.out.println("Print the sums of an elements of a primary diagonal and a secondary diagonal separately.");
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        int sumPrimary = 0;
        int sumSecondary = 0;
        int temp = 0;

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (i == j) {
                    sumPrimary += matrix.get(i).get(j);
                    //                    System.out.println(matrix.get(i).get(j));
                }
            }
            //            System.out.println(matrix.get(i).get(matrix.get(i).size() - i - 1));
            sumSecondary += matrix.get(i).get(
                    matrix.get(i).size() - i - 1);
        }

        System.out.println("Sum of a primary diagonal is : " + sumPrimary);
        System.out.println("Sum of a secondary diagonal is : " + sumSecondary);

    }

    public void Task11() {

        /**
         * Populate 2d array. Exchange some row of such matrix with a previously
         * entered number.
         */
        int number,
                row;

        System.out.println("Exchange some row of such matrix with a"
                + " previously entered number.");
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("Enter a number: ");
        number = new Scanner(System.in).nextInt();

        System.out.println("Enter a row: ");
        row = new Scanner(System.in).nextInt();

        System.out.println("\nRow #" + row + " is to be replaced with a number "
                + number + "\n");

        for (int i = 0; i < matrix.get(row - 1).size(); i++) {
            matrix.get(row - 1).set(i, number);
        }

        printMatrix(matrix);

    }

    public void Task12() {

        /**
         * Populate a matrix. Exchange some column of this matrix with some
         * number. Both of them should be entered from keyboard.
         */
        int number,
                column;

        System.out.println("Exchange some column of such matrix with a"
                + " previously entered number.");
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("Enter a number: ");
        number = new Scanner(System.in).nextInt();

        System.out.println("Enter a column: ");
        column = new Scanner(System.in).nextInt();

        System.out.println("\nColumn #" + column + " is to be replaced with a number "
                + number + "\n");

        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).set(column - 1, number);
        }

        printMatrix(matrix);

    }

    public void Task13() {

        /**
         * Populate a matrix. Find out if a multiplication of an elements of
         * some column spawns a 3 digit number. A number of column is to entered
         * from keyboard.
         */
        int multiplication = 1,
                column;

        System.out.println("Find out if a multiplication of an elements of "
                + " some column spawns a 3 digit number.");
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("Enter a column: ");
        column = new Scanner(System.in).nextInt();

        for (int i = 0; i < matrix.size(); i++) {
            multiplication *= matrix.get(i).get(column - 1);
        }

        System.out.print("\nMultiplication of an elements of column #"
                + column + " is: " + multiplication);

        if (Integer.toString(multiplication).length() == 3) {
            System.out.println(" and it is 3 digits long.");
        } else {
            System.out.println(" and it is NOT 3 digits long.");
        }

    }

    public void Task14() {

        /**
         * Populate matrix. Check if a number entered from keyboard is lower
         * than a sum of an elements of a specific row.
         */
        int number,
                row,
                sum = 0;

        System.out.println("Check if a sum of a row is greater than a specific number.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("\nInput a number to check a sum with :");
        number = new Scanner(System.in).nextInt();

        System.out.println("\nInput a row number :");
        row = new Scanner(System.in).nextInt();

        for (int j = 0; j < matrix.get(row).size(); j++) {
            System.out.print(matrix.get(row).get(j) + " ");
            sum += matrix.get(row).get(j);
        }

        System.out.print("\nSum of a row #" + row + " is " + sum);
        if (sum > number) {
            System.out.println(". It is greater than number " + number);
        } else {
            System.out.println(". It is lower than number " + number);

        }
    }

    public void Task15() {

        /**
         * Populate a matrix. Sum all the negative elements that reside within
         * some specific row. Row number is to be entered from keyboard.
         */
        int number,
                row,
                sum = 0;

        System.out.println("Sum all the negative elements in a specific row.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.print("\nInput a row number :");
        row = new Scanner(System.in).nextInt();

        for (int j = 0; j < matrix.get(row).size(); j++) {
            if (matrix.get(row).get(j) < 0) {
                System.out.print(matrix.get(row).get(j) + " ");
                sum += matrix.get(row).get(j);
            }
        }

        System.out.println("\nSum of a negative elements is " + sum);

    }

    public void Task16() {

        /**
         * Populate a matrix. Count a unmber of an even elements in each row.
         */
        int count = 0;

        System.out.println("Count a number of an even elements in each row.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            count = 0;
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) % 2 == 0) {
                    count++;
                }
            }
            System.out.println("Number of an even elements for row #" + i
                    + ", is : " + count);
        }

    }

    public void Task17() {

        /**
         * Populate a matrix. Count the number of elements that fall within a
         * range of [a,b]. a and b should be entered from a keyboard.
         */
        int a,
                b,
                count = 0;

        System.out.println("Show the elements that fall within a range of [a,b].");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.print("Input a :");
        a = new Scanner(System.in).nextInt();

        System.out.print("Input b :");
        b = new Scanner(System.in).nextInt();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) > a
                        && matrix.get(i).get(j) < b) {
                    count++;
                }
            }
        }

        int[][] matrix2 = null;

        for (int i[] : matrix2) {
            for (int j : i) {
            }
        }

        System.out.println("The number of an elements that fall withn a range "
                + "of [" + a + "," + b + "] is " + count);

    }

    public void Task18() {

        /**
         * Poupate a 2d array. Find a row with a maximum sum of its elements.
         */
        int sum = 0,
                max = Integer.MIN_VALUE,
                pos = -1;

        System.out.println("Find a row with a maximum sum of its elements. \n");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            sum = 0;
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sum += matrix.get(i).get(j);
            }
            if (max < sum) {
                max = sum;
                pos = i;
            }
        }

        System.out.println("Row #" + (pos + 1) + ", sum = " + max);
    }

    public void Task19() {

        /**
         * Poupate a 2d array. Find a row with a minimum sum of its elements.
         */
        int sum = 0,
                min = Integer.MAX_VALUE,
                pos = -1;

        System.out.println("Find a row with a minimum sum of its elements. \n");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            sum = 0;
            for (int j = 0; j < matrix.get(i).size(); j++) {
                sum += matrix.get(i).get(j);
            }
            if (min > sum) {
                min = sum;
                pos = i;
            }
        }

        System.out.println("Row #" + (pos + 1) + ", sum = " + min);
    }

    public void Task20() {

        /**
         * Populate 2 2d arrays of equal size. Make a 3rd array that hold an
         * elements that come as a sum of a 2 previous arrays.
         */
        System.out.println("Populate 2 2d arrays of equal size. Make a 3rd "
                + "array that hold an elements that come as a sum of a 2 "
                + "previous arrays.");

        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrix3 = new ArrayList<>();

        populateMatrixRandomly(matrix);
        populateMatrixRandomly(matrix2);
        printMatrix(matrix);
        System.out.println("");
        printMatrix(matrix2);

        System.out.println("3rd array is:");
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> ints = new ArrayList<>();
            for (int j = 0; j < matrix.size(); j++) {
                ints.add(matrix.get(i).get(j)
                        + matrix2.get(i).get(j));
            }
            matrix3.add(ints);
        }

        printMatrix(matrix3);

    }

    public void Task21() {

        /**
         * Populate 2 2d arrays. 3rd array's elements have to be populated in
         * the following way: if a signs of both initial arrays are the same,
         * then it is = to 100, else 0.
         */
        ArrayList<ArrayList<Integer>> matrix2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matrix3 = new ArrayList<>();

        populateMatrixRandomly(matrix);
        populateMatrixRandomly(matrix2);
        printMatrix(matrix);
        printMatrix(matrix2);

        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<Integer> ints = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) > -1
                        && matrix2.get(i).get(j) > -1
                        || matrix.get(i).get(j) < 0
                        && matrix2.get(i).get(j) < 0) {
                    ints.add(100);
                } else {
                    ints.add(0);
                }
            }
            matrix3.add(ints);
        }

        printMatrix(matrix3);
    }

    public void Task22() {

        /**
         * Populate 2d array. All the negative elements put to a separate 1d
         * array.
         */
        int i = 0,
                j = 0;
        ArrayList<Integer> lstIntArray = new ArrayList<>();

        System.out.println("All the negative elements put to a separate "
                + "1d array.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        while (i < matrix.size()) {
            j = 0;
            while (j < matrix.get(i).size()) {
                if (matrix.get(i).get(j) < 0) {
                    lstIntArray.add(matrix.get(i).get(j));
                }
                j++;
            }
            i++;
        }

        // Printing a list of a negative values
        for (int ints : lstIntArray) {
            System.out.print(ints + " ");
        }

    }

    public void Task23() {

        /**
         * Populate 2d array. All the even elements put to some 1d array and odd
         * elements to some other one.
         */
        int i = 0,
                j = 0;
        ArrayList<Integer> lstEvenIntArray = new ArrayList<>();
        ArrayList<Integer> lstOddIntArray = new ArrayList<>();

        System.out.println("All the even elements put to some 1d "
                + "array and odd elements to some other one.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        while (i < matrix.size()) {
            j = 0;
            while (j < matrix.get(i).size()) {
                if (j % 2 == 0) {
                    lstEvenIntArray.add(matrix.get(i).get(j));
                } else {
                    lstOddIntArray.add(matrix.get(i).get(j));
                }
                j++;
            }
            i++;
        }

        System.out.println("Array of an even elements: ");
        for (int ints : lstEvenIntArray) {
            System.out.print(ints + " ");
        }

        System.out.println("\nArray of an odd elements: ");
        for (int ints : lstOddIntArray) {
            System.out.print(ints + " ");
        }

    }

    public void Task24() {

        /**
         * Populate a 2d array. Exchange a 1st and a 3rd rows.
         */
        int[] intArr = new int[matrix.size()];
        int temp = 0,
                j = 0;

        System.out.println("Exchange a 1st and a 3rd rows\n");

        populateMatrixRandomly(matrix);
        System.out.println("Initial matrix");
        printMatrix(matrix);

        while (j < matrix.size()) {
            temp = matrix.get(0).get(j);
            matrix.get(0).set(j, matrix.get(2).get(j));
            matrix.get(2).set(j, temp);
            j++;
        }

        System.out.println("Resulting matrix");
        printMatrix(matrix);

    }

    public void Task25() {

        /**
         * Populate 2d array. Exchange an elements of a 2nd and a last column.
         */
        int temp = 0,
                i = 0;

        System.out.println("Exchange an elements of a 2nd and a last column.\n");
        System.out.println("Initial matrix");

        populateMatrixRandomly(matrix);
        System.out.println("Resulting matrix");
        printMatrix(matrix);

        for (int j = 0; j < matrix.size(); j++) {
            temp = matrix.get(j).get(0);
            matrix.get(j).set(0, matrix.get(j).get(matrix.get(j).size() - 1));
            matrix.get(j).set(matrix.get(j).size() - 1, temp);
        }

        printMatrix(matrix);
    }

    public void Task26() {

        /**
         * Populate 2d array. Array should have an even number of rows. Elements
         * of each even row has to be swapped with an elements of odd row.
         */
        int temp = 0;

        System.out.println("Exchange an even rows with a odd ones. Number of "
                + "rows should be even.\n");

        populateMatrixRandomly(matrix);
        if (matrix.size() % 2 != 0) {
            System.out.println("Number of rows should be even!");
            System.exit(0);
        }
        System.out.println("Initial matrix");
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i += 2) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i + 1).get(j));
                matrix.get(i + 1).set(j, temp);
            }
        }

        System.out.println("Resulting matrix");
        printMatrix(matrix);

    }

    public void Task27() {

        /**
         * Populate 2d array. Remove a row of some specific number.
         */
        System.out.println("Remove a row of some specific number.");

        System.out.println("Initial matrix");
        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        System.out.println("Enter a row number to be removed. First row goes "
                + "with 1, not 0");
        int rowNumber = new Scanner(System.in).nextInt() - 1;
        matrix.remove(rowNumber);

        System.out.println("Resulting matrix");
        printMatrix(matrix);
    }

    public void Task28() {

        /**
         * Populate 2d array. Remove a specific column in it.
         */
        int iColumn = 0;

        System.out.println("Remove some column in a matrix\n");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        iColumn = inputInt();

        System.out.println(iColumn);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (j == iColumn - 1) {
                    matrix.get(i).remove(j);
                }
            }
        }

        printMatrix(matrix);

    }

    public void Task29() {

        /**
         * Populate 2d array. Define a number that is going to be used as a
         * position for a row that should be added to matrix and filled with an
         * elements that have a value of "100".
         */
        int iRow = 0;

        System.out.println("Define a number that is going to be used as "
                + " a position for a row that should be added to matrix and filled with "
                + " an elements that have a value of \"100\".");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        iRow = inputInt();

        matrix.add(iRow, new ArrayList<Integer>());
        for (int i = 0; i < matrix.get(0).size(); i++) {
            matrix.get(iRow).add(100);
        }

        printMatrix(matrix);
    }

    public void Task30() {

        /**
         * Populate 2d array. Add a column at some position, with an elements =
         * to 0. Column number can be entered anyway.
         */
        System.out.println("Add a column at some position, with an elements "
                + "= to 0. Column number can be entered anyway.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        int iColumn = inputInt();

        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).add(iColumn - 1, 0);
        }

        printMatrix(matrix);

    }

    public void Task31() {

        /**
         * Populate 2d array. Add extra column with values of "10", after each
         * even column.
         */
        System.out.println("Add extra column with values of \"10\", after each"
                + " even column.");

        populateMatrixRandomly(matrix);
        printMatrix(matrix);

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 2; j < matrix.get(i).size(); j += 2) {
                matrix.get(i).add(j, 10);
                j++;
            }
        }

        printMatrix(matrix);

    }
    //</editor-fold>
}
