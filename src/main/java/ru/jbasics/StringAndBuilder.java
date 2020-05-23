/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

/**
 *
 * @author v.yanchenko
 */
public class StringAndBuilder {

    private String str1 = "10";
    private String str2 = "10";

    // Cannot be done
//    String s = true;

    // In java 8 only
    String message = String.join("-", "Java", "is", "best"); // "Java-is-best"
    String csv = String.join(",", new String[]{"a", "b"}); // a,b

    String[] supportedPhones = {"iPhone", "Samsung Galaxy", "iPad"};
    String models = String.join(",", supportedPhones);

    public StringAndBuilder() {
//        System.out.println(reverseString("1234"));
    }

    public void stringDemo() {

        System.out.println("1,234,567".replace(",", "'"));
        System.out.println(5);  // 5 is converted into String and then shown.

        // Here multiline comment is part of a string.
        String string = "text/*just text*/";

        str1.replace("1", "00000");
        str1.indexOf(str1);
        str1.compareTo(str1);
        str1.compareToIgnoreCase(str1);

        // It is advised not to use == comparison for Strings.
        System.out.println("str1 == str2 - " + (str1 == str2));
        System.out.println(
                "str1.equals(str2) - " + str1.equals(str2) + "\n");

        str1 = "10";
        str2 = "10";

        // It is advised not to use == comparison for Strings.
        System.out.println(
                "str1 == str2 - " + (str1 == str2));
        System.out.println(
                "str1.equals(str2) - " + str1.equals(str2) + "\n");

        str1 = new String("10");
        str2 = "10";

        // It is advised not to use == comparison for Strings.
        System.out.println(
                "str1 == str2 - " + (str1 == str2));
        System.out.println(
                "str1.equals(str2) - " + str1.equals(str2) + "\n");
        
        str1 = "10";
        str2 = new String("10");
        
        System.out.println(
                "str1 == str2 - " + (str1 == str2));
        System.out.println(
                "str1.equals(str2) - " + str1.equals(str2));
        // str2.intern() puts string to a string pool.
        System.out.print("str1 == str2.intern() - ");
        System.out.println((str1 == str2.intern()) + "\n");
        
        str1 = new String("10");
        str2 = new String("10");
        
        System.out.println(
                "str1 == str2 - " + (str1 == str2));
        System.out.println(
                "str1.equals(str2) - " + str1.equals(str2) + "\n");

        // Comparison of a strings that have a different case, but same chars.
        System.out.println("Str".equalsIgnoreCase("str"));

        char[] helloArray = {'h', 'e', 'l', 'l', 'o'};
        String helloString = new String(helloArray);
        System.out.println(helloString);

        String fs;
        fs = String.format("Format is %10.4f", 123.0);
        System.out.println(fs);
        fs = String.format("Format is %4d", 123);
        System.out.println(fs);

        int ascii[] = {65, 66, 67, 68};
        String s = new String(ascii, 1, 3);
        System.out.println(s);

        String str = "1234";
        // Good practice for checking if a string is null. 
        // Will not work in Java 5.0
        if (str != null && !str.isEmpty()) {
            System.out.println("String is not null and not empty");
        }

        // Will work in Java 5.0
        if (str != null && str.length() > 0) {
            System.out.println("String is not null and not empty");
        }

        // if str == " " then it's an empty string.
        if (str != null && str.trim().length() > 0) {
            System.out.println("String is not null and not empty");
        }

        Integer i = new Integer("10");
        // toString() makes a new String everytime it is invoked.
        if (i.toString() == i.toString()) {
            System.out.println("Равный");
        } else {
            System.out.println("Неравный");
        }

    }

    public void stringBuilderDemo() {
        // StringBuilder is not a thread-safe. Use StringBuffer instead.
        StringBuilder sb = new StringBuilder("123456");
        // Deletion of a char at some specifica position
        sb.deleteCharAt(4);
        System.out.println(sb.toString());
        // This action is faster ...
        sb.append(sb).append("s").append('_').append(999);
        // ... than adding strings like sb + "s" + "_" + "999";
        System.out.println(sb.toString());
        sb = new StringBuilder('1');    // Idea shows it with yellow !
        sb.append("23");
        System.out.println(sb); // 23, but not 123.
        // StringBuilder('1') is considered as StringBuilder(int) !
    }

    public void compareStrings() {
        String str = "123";
        String str2 = "124";
        System.out.println(str.compareTo(str2));
        str = "123";
        str2 = "1231";
        System.out.println(str.compareTo(str2));
    }

    public void cutString() {
        String textfile = "ReadMe.txt";
        // Getting a 1st part of a string
        System.out.println(textfile.split("\\.")[0]);
        // Getting a 2nd part of a string
        System.out.println(textfile.split("\\.")[1]);
        // The same as a first one
        System.out.println(textfile.split("[.]")[0]);
        // The same as a secind one
        System.out.println(textfile.split("[.]")[1]);
    }

    /*
     This method reverses the character sequence of the String in place. It also 
     handles the surrogate pairs correctly. If there are any surrogate pairs 
     included in the sequence, these are treated as single characters for the 
     reverse operation.

     Thus, the order of the high-low surrogates is never reversed. Note that the 
     reverse operation may result in producing surrogate pairs that were 
     unpaired low-surrogates and high-surrogates before the operation. For 
     example, reversing "\uDC00\uD800" produces "\uD800\uDC00" which is a valid 
     surrogate pair.

     http://javarevisited.blogspot.com/2016/03/how-to-reverse-string-in-place-in-java.html#ixzz43cja6iKk
     */
    public String reverseString(String str) {
        // StringBuilder is not threadsafe.
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    /* 
     "Imperative" implementation of a string reverse. Nota bene - no string used 
     for the replacing element. So this method is faster than a previous one.
     */
    public static String inPlaceReverse(final String input) {
        final StringBuilder builder = new StringBuilder(input);
        int length = builder.length();
        for (int i = 0; i < length / 2; i++) {
            final char current = builder.charAt(i);
            final int otherEnd = length - i - 1;
            builder.setCharAt(i, builder.charAt(otherEnd)); // swap 
            builder.setCharAt(otherEnd, current);
        }
        return builder.toString();
    }

    // http://javarevisited.blogspot.ru/2016/03/how-to-convert-array-to-comma-separated-string-in-java.html
    // String[] to comma separated strings
    public static String toCSV(String[] array) {
        String result = "";
        if (array.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (String s : array) {
                sb.append(s).append(",");
            }
            result = sb.deleteCharAt(sb.length() - 1).toString();
        }
        return result;
    }
}
