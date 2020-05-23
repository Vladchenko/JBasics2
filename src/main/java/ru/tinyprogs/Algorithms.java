/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs;

import ru.Utils;

import java.util.*;

/**
 * @author v.yanchenko
 */
public class Algorithms {

    public Algorithms() {

//        demoFibonacci();
        System.out.println(countWords("qwerty"));
    }

    // Counting a number of specific character present in a string.
    int countChars(char ch, String str1) {
        int number = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == ch) {
                number++;
            }
        }
        return number;
    }

    // Counting a number of words present in a string. Numbers do also count as words.
    int countWords(String str) {

        String[] strings;
        int wordsCount = 0;

        if (str.equals(null)) {
            return 0;
        }
        strings = str.split("[ ]");
        for (int i = 0; i < strings.length; i++) {
            if (!"".equals(strings[i])) {
                wordsCount++;
            }
        }
        return wordsCount;
    }

    // Counting a number of numbers present in a string.
    private int[] countNumbers(String row) {
        /*
         * \\D - разделителем является любой символ, кроме цифры.
         * Применять в том случае, когда надо учитывать случаи, как " 67gh6 ".
         * Это выражение распознается как 67 и 6.
         * \\s - разделителем является пробел.
         * Применять в том случае, когда надо не учитывать случаи, как " 67gh6 ".
         * Это выражение распознается как текст и не будет являться число.
         */
        String[] numbers = row.split("[\\s]");  // \\D
//        (?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!numbers[i].equals("")) {
                try {
                    ints.add(Integer.parseInt(numbers[i]));
                } catch (Exception ex) {
                }
            }
        }
        int[] intsArr = new int[ints.size()];
        for (int i = 0; i < ints.size(); i++) {
            intsArr[i] = ints.get(i);
        }
        return intsArr;
    }

    // Printing all the prime numbers up to a number read from keyboard.
    public void demoPrimeNumber() {
        int number = 0;
        number = Utils.readInteger();
        System.out.print("Prime numbers up to " + number + " are : ");
        int[] numbers = primeNumber(number);
        Utils.printArr(numbers);
    }

    // Getting all the prime numbers up to number.
    public int[] primeNumber(int number) {
        int[] ints;
        boolean enlist = false;
        List<Integer> listInts = new ArrayList<>();
        for (int i = 2; i < number; i++) {
            enlist = true;
            for (int j = i - 1; j > 1; j--) {
                if (i % j == 0) {
                    enlist = false;
                    break;
                }
            }
            if (enlist) {
                listInts.add(i);
            }
        }
        ints = new int[listInts.size()];
        ints = Utils.toArray(listInts);
        return ints;
    }

    // Computing factorial.
    public long factorial(int number) {
        long factorialValue = 1;
        for (int i = 1; i < number; i++) {
            factorialValue *= i;
        }
        return factorialValue;
    }

    // Printing factorial of a number read from keyboard.
    public void demoFactorial() {
        int number = 0;
        number = Utils.readInteger();
        System.out.print("Factorial for " + number + " is "
                + factorial(number) + ".");
        System.out.println("");
    }

    // Checking if a string is palindrome.
    public boolean isPalindrome(String str) {
        // One could use a StringBuilder/StringBuffer's reverse method
        // to check if an str is palindrome.
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // Gets all the palindromes, even the ones incorporated into the other ones.
    // CHALLENGE - remove the short palindromes.
    public Set getAllPalindromes(String row) {
        Set<String> palindromes = new TreeSet<>();
        int offset = 1;
        String currentRow = "";
        for (offset = 1; offset < row.length() - 2; offset++) {
            for (int i = 0; i < row.length() - 1 - offset; i++) {
                currentRow = row.substring(i, i + offset + 1);
//                System.out.println(currentRow);
                if (isPalindrome(currentRow)) {
//                    System.out.println(currentRow);
                    palindromes.add(currentRow);
                }
            }
        }
        return palindromes;
    }

    public void printSet(Set<String> set) {
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    // Showing palindrome.
    public void demoPalindrome() {
        String str;
        System.out.print("Enter a string: ");
        str = Utils.readLine();
        System.out.println("The word you entered is "
                + (String) ((isPalindrome(str)) ? "" : "not ") + "a palindrome.");
    }

    // Computing computeFibonacci sequence.
    public long[] computeFibonacci(int limit) {
        long[] numbers = new long[limit];
        long a = 0;
        numbers[0] = a;
        long b = 1;
        numbers[1] = b;
        int i = 2;
        while (i < limit) {
            a += b;
            numbers[i] = a;
            i++;
            if (i == limit) {
                break;
            }
            b += a;
            numbers[i] = b;
            i++;
        }
        return numbers;
    }

    // Showing computeFibonacci sequence.
    public void demoFibonacci() {
        long[] fibonacciArr = computeFibonacci(Utils.readInteger());
        System.out.print("Fibonacci sequence is : ");
        Utils.printArr(fibonacciArr);
    }

    // Reversing the list.
    public static List reverseList(List lst) {
        // Method has been checked for proper execution
        int j;
        for (int i = 0; i < lst.size() / 2; i++) {
            j = (int) lst.get(i);
            lst.set(i, lst.get(lst.size() - i - 1));
            lst.set(lst.size() - i - 1, j);
        }
        return lst;
    }

    public static void populateList(List<Integer> lst) {
        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }
    }

    public int multiplicativeInversion(int value, int module) {
        // Мультипликативной инверсией числа 11 по модулю 19 является
        // Как я понял, задание звучит так -
        // На что нужно умножить 11, что бы произведение 11 и этого числа
        // при делении на 19 дало в остатке 1.
        for (int i = 1; i < module; i++) {
            if (value * i % module == 1) {
                return i;
            }
        }
        return -1;
    }

    public void demoMultiplicativeInversion(int value, int module) {
        int i = multiplicativeInversion(value, module);
        System.out.print("Result is: " + i + "      ");
        System.out.println(value + " * " + i + " = " + value * i
                + " % " + module + " = " + value * i % module);
    }

}
