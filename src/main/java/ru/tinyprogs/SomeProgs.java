/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.yanchenko
 */
public class SomeProgs {

    // http://www.cyberforum.ru/java-j2se/thread550416.html
// Regarded strings
    String[] strings = null;

    public String[] inputWordsFromKeyboard(String[] strings) {

        /* 
         * Method demands a user to input a number that stands for a quantity of 
         * a strings and input them afterwards.
         */
        int stringsQuantity = 0;
//        int longestString = 0;
//        int longestStringIndex = 0;
//        int shortestString = Integer.MAX_VALUE;
//        int shortestStringIndex = 0;

        // Defining a keyboard interaction
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter a quantity of strings to be inputed: ");

        try {
            // Getting a number of a strings to be entered
            stringsQuantity = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Something is wrong with an input");
            Logger.getLogger(SomeProgs.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }

        // Instantiating a strings field
        strings = new String[stringsQuantity];

        System.out.println("Enter a strings: ");

        // Inputting a strings from keyboard
        for (int i = 0; i < stringsQuantity; i++) {
            try {
                strings[i] = bufferedReader.readLine();
            } catch (IOException ex) {
                System.out.println("Something is wrong with an input");
                Logger.getLogger(SomeProgs.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }

        return strings;

    }

    public void printStrings(String[] strings) {

        // Method prints all the strings
        if (strings == null) {
            System.out.println("There are no any strings present");
            return;
        }
        System.out.println("   Strings are:");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(i + " - " + strings[i]);
        }

    }

    public void printShortestAndLongestWords(String[] strings) {

        /* 
         * Method looks for a longest and shortest strings and prints 
         * them along with their lengths.
         */
        int stringsQuantity = 0;
        int longestString = 0;
        int longestStringIndex = 0;
        int shortestString = Integer.MAX_VALUE;
        int shortestStringIndex = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                // Looking for a longest lines
                if (strings[i].length() > longestString) {
                    longestString = strings[i].length();
                    longestStringIndex = i;
                }
                // Looking for a shortest lines
                if (strings[i].length() < shortestString) {
                    shortestString = strings[i].length();
                    shortestStringIndex = i;
                }
            }
        }

        System.out.println("Shortest string is #" + (shortestStringIndex + 1)
                + ":  " + strings[shortestStringIndex]);
        System.out.println("Longest string is #" + (longestStringIndex + 1)
                + ":  " + strings[longestStringIndex]);
    }

    public void sortStringsBySizes() {

        /* 
         * Strings have to be sorted regarding their sizes.
         */
        int stringsQuantity = 0;
        int longestString = 0;
        int longestStringIndex = 0;
        int shortestString = Integer.MAX_VALUE;
        int shortestStringIndex = 0;

        for (int i = 0; i < stringsQuantity; i++) {
            if (strings[i] != null) {
                // Looking for a longest lines
                if (strings[i].length() > longestString) {
                    longestString = strings[i].length();
                    longestStringIndex = i;
                }
                // Looking for a shortest lines
                if (strings[i].length() < shortestString) {
                    shortestString = strings[i].length();
                    shortestStringIndex = i;
                }
            }
        }

        String strTemp = new String();
        for (int i = 0; i < stringsQuantity; i++) {
            for (int j = 0; j < stringsQuantity; j++) {
                if (i != j) {
                    if (strings[i].length() < strings[j].length()) {
                        strTemp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = strTemp;
                    }
                }
            }
        }

        // Printing a strings to a console
        for (int i = 0; i < stringsQuantity; i++) {
            System.out.println(strings[i]);
        }

    }

    public Map<String, Integer> sortStringsByLength(
            Map<String, Integer> map, char directionSign) {
        List<Entry<String, Integer>> forSortBylength = new ArrayList<>(
                map.entrySet());
        switch (directionSign) {
            case '>':
                Collections.sort(forSortBylength,
                        new Comparator<Entry<String, Integer>>() {
                            public int compare(Entry<String, Integer> o1,
                                    Entry<String, Integer> o2) {
                                return ((Entry<String, Integer>) (o2)).getValue()
                                .compareTo(
                                        ((Entry<String, Integer>) (o1))
                                        .getValue());
                            }
                        });
                break;
            case '<':
                Collections.sort(forSortBylength,
                        new Comparator<Entry<String, Integer>>() {
                            public int compare(Entry<String, Integer> o1,
                                    Entry<String, Integer> o2) {
                                return ((Entry<String, Integer>) (o1)).getValue()
                                .compareTo(
                                        ((Entry<String, Integer>) (o2))
                                        .getValue());
                            }
                        });
                break;
            default:
                System.err.print("Wrong comparison sign !");
                break;
        }
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : forSortBylength) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public void printStringsSortedByLength(String[] strings) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : strings) {
            map.put(s, s.length());
        }
        System.out.println("Strings sorted by their length, ASC, string=length : "
                + sortStringsByLength(map, '<'));
        System.out.println("Strings sorted by their length, DSC, string=length : "
                + sortStringsByLength(map, '>'));
    }

    public void printStringsSmallerOrLargerThanAverage(String[] strings,
            char directionSign) {

        /* 
         * Methos prints a strings with a length that less or 
         * greater than an average length.
         */
        int stringsQuantity = 0;
        int longestString = 0;
        int longestStringIndex = 0;
        int shortestString = Integer.MAX_VALUE;
        int shortestStringIndex = 0;

        for (int i = 0; i < strings.length; i++) {
            if (strings[i] != null) {
                // Looking for a longest lines
                if (strings[i].length() > longestString) {
                    longestString = strings[i].length();
                    longestStringIndex = i;
                }
                // Looking for a shortest lines
                if (strings[i].length() < shortestString) {
                    shortestString = strings[i].length();
                    shortestStringIndex = i;
                }
            }
        }

        System.out.println("Shortest string is at #" + (shortestStringIndex + 1)
                + ":  " + strings[shortestStringIndex] + ", "
                + strings[shortestStringIndex].length() + " chars long");
        System.out.println("Longest string is at #" + (longestStringIndex + 1)
                + ":  " + strings[longestStringIndex] + ", "
                + strings[longestStringIndex].length() + " chars long");
        System.out.println("Average length is = " + (shortestString + longestString) / 2);

        /* 
         * Printing a strings to a console that have a length greater than an 
         * average one
         */
        switch (directionSign) {
            case '<':
                System.out.println("Strings that less than an average: ");
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].length() < ((shortestString + longestString) / 2)) {
                        System.out.println(strings[i]);
                    }
                }
                break;
            case '>':
                System.out.println("Strings that greater than an average: ");
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].length() > ((shortestString + longestString) / 2)) {
                        System.out.println(strings[i]);
                    }
                }
                break;
            default:
                System.err.print("Wrong comparison sign !");
                break;
        }

    }

    public boolean checkForUniqueChars(String str) {

        // Method checks if a string holds only a unique characters
        for (char ch : str.toCharArray()) {
            if (str.indexOf(ch) != str.lastIndexOf(ch)) {
                return false;
            }
        }
        return true;
    }

    public void print1stShortestStringWithUniqueChars(String[] strings) {
        int shortestStringIndex = Integer.MAX_VALUE;
        int shortestString = Integer.MAX_VALUE;
        for (int i = 0; i < strings.length; i++) {
            if (checkForUniqueChars(strings[i])) {
                if (strings[i].length() < shortestString) {
                    shortestStringIndex = i;
                    shortestString = strings[i].length();
                }
            }
        }
        if (shortestString != Integer.MAX_VALUE) {
            System.out.print("Index of a shortest, earliest strings with a unique "
                    + "characters is: " + (shortestStringIndex + 1) + "  ");
            System.out.println("It is - " + strings[shortestStringIndex]);
        } else {
            System.out.println("There are no strings with a unique "
                    + "characters ");
        }
    }

    public boolean findOnlyLatinChars(String str) {
        // Method checks if a given string contains only a latin characters
        return str.matches("\\w+");
    }

    public Set<String> retriveStringsWithLatinCharsOnly(String[] strings) {

        /*
         * Method returns a words only with a latin chars
         */
        Set<String> latinStrings = new HashSet<>();

        for (int i = 0; i < strings.length; i++) {
            if (findOnlyLatinChars(strings[i])) {
                latinStrings.add(strings[i]);
            }
        }

        return latinStrings;

    }

    public boolean checkIfVowelsEqualToConsonants(String str) {

        // Method checks if a number of vowels equal to consonants
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a'
                    || str.charAt(i) == 'e' || str.charAt(i) == 'E'
                    || str.charAt(i) == 'i' || str.charAt(i) == 'I'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'u' || str.charAt(i) == 'U'
                    || str.charAt(i) == 'y' || str.charAt(i) == 'Y') {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels == consonants;
    }

    public void printStringsWithVowelsEqualToConsonants(Set<String> strSet) {
        int vowels = 0;
        int consonants = 0;
        System.out.println("\nStrings that have an equal amount of consonants "
                + "and vowels");
        for (String s : strSet) {
            if (checkIfVowelsEqualToConsonants(s)) {
                System.out.println(s);
            }
        }
    }

    public void print1stStringWithAscendingCharCodes(String[] strings) {
        int position = -1;
        for (int i = 0; i < strings.length; i++) {
            position = i;
            for (int j = 0; j < strings[i].length() - 1; j++) {
                if (strings[i].charAt(j) - strings[i].charAt(j + 1) != -1) {
                    position = -1;
                    break;
                }
            }
            /* 
             * We need to find a first occurance of a required string,
             * so if there is one, we leave the for loop
             */
            if (position != -1) {
                break;
            }
        }
        if (position > -1) {
            System.out.println("String with an ascending code chars: " + strings[position]);
        } else {
            System.out.println("There are no strings with an ascending code chars");
        }
    }

    public void print1stStringWithUniqueChars(String[] strings) {
        for (String str : strings) {
            if (checkForUniqueChars(str)) {
                System.out.println("First string with only a unique chars is: " + str);
                // As sson as we need to find a first occurance, we need to
                // put a break here
                break;
            }
        }
    }

    public boolean checkIfStringIsPolyndrom(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public void print2ndPolindrom(String[] strings) {
        int j = 0;
        for (int i = 0; i < strings.length; i++) {
            if (checkIfStringIsPolyndrom(strings[i])) {
                j++;
                if (j == 2) {
                    System.out.println("2nd polyndrom is: " + strings[i]);
                }
            }
        }
        if (j != 2) {
            System.out.println("There is no 2nd polyndrom present !");
        }
    }

    public int inputIntFromKeyboard() {

        /* 
         * Method demands a user to input a number and returns it
         */
        int number = 0;

        // Defining a keyboard interaction
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.print("Enter an integer: ");

        try {
            // Getting a number of a strings to be entered
            number = Integer.parseInt(bufferedReader.readLine());
        } catch (NumberFormatException ex) {
            System.out.println("Not a number !");
            number = inputIntFromKeyboard();
        } catch (IOException ex) {
            System.out.println("Something is wrong with an input");
            Logger.getLogger(SomeProgs.class.getName()).log(Level.SEVERE, null, ex);
            number = inputIntFromKeyboard();
        }

        return number;

    }

    public void isBelongToRange(int k) {
        String[] ranges = {
            "(-10000, 0]",
            "(-10000, 5]",
            "(0, 5]",
            "[0, 10]",
            "(5, 10]",
            "[5, 15]",
            "[10, 10000]",
            "(10, 10000]"};
        String interval = null;
        for (int i = 0; i < ranges.length; i++) {
            switch (ranges[i]) {
                case "(-10000, 0]":
                    if (k > -10000 && k <= 0) {
                        interval = ranges[i];
                    }
                    break;
                case "(-10000, 5]":
                    if (k > -10000 && k <= 0) {
                        interval = ranges[i];
                    }
                    break;
                case "(0, 5]":
                    if (k > 0 && k <= 5) {
                        interval = ranges[i];
                    }
                    break;
                case "[0, 10]":
                    if (k >= 0 && k <= 10) {
                        interval = ranges[i];
                    }
                    break;
                case "(5, 10]":
                    if (k > 5 && k <= 10) {
                        interval = ranges[i];
                    }
                    break;
                case "[5, 15]":
                    if (k >= 5 && k <= 15) {
                        interval = ranges[i];
                    }
                    break;
                case "(10, 10000]":
                    if (k > 10 && k <= 10000) {
                        interval = ranges[i];
                    }
                    break;
                case "[10, 10000]":
                    if (k >= 10 && k <= 10000) {
                        interval = ranges[i];
                    }
                    break;
            }
        }
        if (interval != null) {
            System.out.println("Number belongs to " + interval + " interval.");
        } else {
            System.out.println("Number does not belong to any of the intervals provided.");
        }
    }

    public void printMatrix5x5() {
        int k = 1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (k < 10) {
                    System.out.print(k++ + "  ");
                } else {
                    System.out.print(k++ + " ");
                }
            }
            System.out.println();
        }
    }

    public void printMonthByNumber(int number) {
        switch (number) {
            case 1: {
                System.out.println("January");
                break;
            }
            case 2: {
                System.out.println("February");
                break;
            }
            case 3: {
                System.out.println("March");
                break;
            }
            case 4: {
                System.out.println("April");
                break;
            }
            case 5: {
                System.out.println("May");
                break;
            }
            case 6: {
                System.out.println("June");
                break;
            }
            case 7: {
                System.out.println("July");
                break;
            }
            case 8: {
                System.out.println("August");
                break;
            }
            case 9: {
                System.out.println("September");
                break;
            }
            case 10: {
                System.out.println("October");
                break;
            }
            case 11: {
                System.out.println("November");
                break;
            }
            case 12: {
                System.out.println("December");
                break;
            }
            default: {
                System.out.println("Wrong month number. Should be within [1..12] range.");
                break;
            }
        }
    }

    public SomeProgs(String[] args) {

        // This method is used when user inputs string from a keyboard
//        strings = inputWordsFromKeyboard(strings);
//        printStrings(strings);
//        printShortestAndLongestWords(strings); // 1.
//        printStringsSortedByLength(strings); // 2.
//        printStringsSmallerOrLargerThanAverage(strings, '<'); // 3.
//        print1stShortestStringWithUniqueChars(strings); // 4.
//        printStringsWithVowelsEqualToConsonants(
//            retriveStringsWithLatinCharsOnly(strings)); // 5.
//        print1stStringWithAscendingCharCodes(strings); // 6.
//        print1stStringWithUniqueChars(strings); // 7.
//        print2ndPolindrom(strings); // 8.
//        printStrings(args);
//        printShortestAndLongestWords(args);   // 9. 1.
//        printStringsSortedByLength(args); // 9. 2.
//        printStringsSmallerOrLargerThanAverage(args, '>'); // 9. 3.
//        print1stShortestStringWithUniqueChars(args); // 9. 4.
//        printStringsWithVowelsEqualToConsonants(
//            retriveStringsWithLatinCharsOnly(args)); // 9. 5.
//          print1stStringWithAscendingCharCodes(args); // 9. 6.
//        print1stStringWithUniqueChars(args); // 9. 7.
//        print2ndPolindrom(args); // 9. 8.
//        isBelongToRange(
//                inputIntFromKeyboard());  // 10. 11. sort of =)
//        printMatrix5x5(); // 12.
        printMonthByNumber(
                inputIntFromKeyboard()); // 14.

    }
}
