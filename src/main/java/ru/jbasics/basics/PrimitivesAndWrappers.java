/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

import java.lang.reflect.Constructor;
import java.math.BigDecimal;

/**
 * Demonstration of a primitive values or their wrappers.
 * https://www.w3schools.com/java/java_wrapper_classes.asp
 *
 * @author Влад
 */
public class PrimitivesAndWrappers {

    // http://habrahabr.ru/post/261315/
    byte b = 0b1000111;     // Binary value (starts with "0b")
    byte b2 = 0b0100_0111;  // With a delimeter
//    byte b3 = 0b1000_0111;  // Value is bigger than byte, so it's an error
//    byte b2 = 100b;         // There is no such postfix like 'b' in java
    // Byte's values range is -128...127, so next row shows error, since
//    byte bb = 100 + 100;
    byte b4 = 065;      // OCTAL value 
    //    byte b5 = 0265;     // Value is bigger than byte, so it's error
    byte b6 = 0x14;     // HEX value 
//    byte b7 = 0x140;    // Value is bigger than byte, so it's error
    /**
     * Although, every numeric value is of an integer type, it is implicitly cast
     * to byte and to all other types as well.
     */
    byte f1 = ~1;   // ~ bitwise complement (побитовое дополнение, т.е. отрицание)

    //    int i0 = 4_000_000_000;   // Integer number too large
    int i = 0b0001_1001_1010;   // BINARY value with delimiters
    int i2 = 06435;             // OCTAL value
    int i3 = 7__234__999;       // DECIMAL value with __ delimiters
    int i4 = 0xb4___2f___6a;    // HEX value with ___ delimiters
    //    int i6 = 12f;       // Incompatible types - integer and float.
    float f4 = 12;      // But this one works fine, because int can be
    // implicitly (automatically) converted into float, it's called an implicit casting.
    /**
     * Following row throws an error - incompatible types. Because 35.0
     * is double value and it cannot be implicitly converted into float.
     */
//    float f2 = 35.0;  // double to float. Not allowed.
    /**
     * Here 35.0 has "f" sign that says it is of a float type.
     */
    float f3 = 35.0f;
    float f3_1 = (float) 35.0;   // Extra way of conversion.
    /**
     * "12" here has an "int" type and when assigning, it is implicitly
     * converted to "double".
     */
    double d1 = 12;
    double d2 = 12f;        // float is implicitly converted to double.
    double $ = 0XD_EP2F;    // 888

    // Check value of number in commonDemo() method.
    {
        number = 10;
    }
    private int number = 20;
    {
        number = 30;    // This one works out.
    }

    // One can put a primitive value into a wrapper class
    Long a = 5L,
            a2 = 5l;    // Do not use small l as a long identifier,
    // since it is a bad programming practice.
//    Integer i5 = 10f;   // Incompatible types - integer and float.
//    Float f2 = 10;      // Incompatible types - float and integer.
    Float f3_ = 12f;     // This one works fine.
    float f4_ = 12;     // This one works fine.
    final long Byte = 0;    // One can name a field as Byte. Byte is a wrapper class,
                            // but it doesn't bother you to name it this way.
                            // The main reason why you can, is that it is not a keyword in java.
    final long String = 0;  // The same goes for String and other wrappers.
//    final long Integer = 0; // Same here.

    public void integerWrapperClass() {

        int ii = new Integer(5);    // This is ok

        String str1 = "10";
        String str2 = "10";

        System.out.println("--- INTEGER wrapper class ---\n");

        System.out.println(Integer.toBinaryString(i2));
        System.out.println(Integer.toOctalString(i2));
        System.out.println(Integer.toHexString(i2));

        // Returns a bits number in a variable
        System.out.println(Integer.bitCount(i3));
        System.out.println(Integer.compare(i2, i3));

        System.out.println(Integer.decode("#FF")); // hex to decimal
        System.out.println(Integer.decode("0377")); // oct to decimal

        // This string is to be considered as an octal value, 
        // not binary. Binary values are not processed here.
        System.out.println("\tInteger.decode(\"011100101\")\t=\t\t" + Integer.decode("011100101") + "\n");

        System.out.println("\tInteger.highestOneBit(i)\t=\t\t" + Integer.highestOneBit(i2));
        System.out.println("\tInteger.lowestOneBit(i)\t=\t\t" + Integer.lowestOneBit(i2) + "\n");

        System.out.println("\tInteger.numberOfLeadingZeros(i)\t=\t\t" + Integer.numberOfLeadingZeros(i2));
        System.out.println("\tInteger.numberOfTrailingZeros(i)\t=\t\t" + Integer.numberOfTrailingZeros(i2) + "\n");

        // Following function doesn't work
        System.out.println("\tInteger.getInteger(str1)\t=\t\t" + Integer.getInteger(str1));
        System.out.println("\tInteger.getInteger(System.getProperty(str1))\t=\t\t"
                + Integer.getInteger(System.getProperty(str1)));
        System.out.println("\tInteger.getInteger(str1)\t=\t\t" + Integer.getInteger(str1, 1) + "\n");

        System.out.println("\tInteger.parseInt(str1)\t=\t\t" + Integer.parseInt(str1));
        System.out.println("\tInteger.parseInt(\"11111111\", 2)\t=\t\t"
                + Integer.parseInt("11111111", 2));
        System.out.println("\tInteger.parseInt(\"05647\", 8)\t=\t\t" + Integer.parseInt("05647", 8));
        System.out.println("\tInteger.parseInt(\"FF\", 16)\t=\t\t" + Integer.parseInt("FF", 16) + "\n");

        System.out.println("   " + "\tInteger.reverse(i)\t=\t\t" + Integer.reverse(i2));
        System.out.println("\tInteger.reverseBytes(i)\t=\t\t" + Integer.reverseBytes(i2) + "\n");

        System.out.println("\tInteger.rotateLeft(i, 2)\t=\t\t" + Integer.rotateLeft(i2, 2));
        System.out.println("\tInteger.rotateRight(i, 2)\t=\t\t" + Integer.rotateRight(i2, 2) + "\n");

        System.out.println("\tInteger.toString(i)\t=\t\t" + Integer.toString(i2) + "\n");

        System.out.println("\tInteger.signum(i)\t=\t\t" + Integer.signum(i2) + "\n");

        System.out.println("\tInteger.valueOf(i)\t=\t\t" + Integer.valueOf(i2));

        System.out.println("\tInteger.valueOf(str1)\t=\t\t" + Integer.valueOf(str1) + "\n");

        System.out.println("\tInteger.class.getName()\t=\t\t" + Integer.class.getName() + "\n");

        System.out.print("\tInteger.class.cast(i)\t=\t\t");
        try {
            // This method casts an object to the class or 
            // interface represented by this Class object
            // What does "cast" mean
            System.out.println("   " + Integer.class.cast(i2));
        } catch (Exception e) {
            System.out.println("   Exception: " + e);
        }

        System.out.println("\tInteger.class.getConstructors()\t=\t\t");
        Constructor[] c1 = Integer.class.getConstructors();
        for (int i = 0; i < c1.length; i++) {
            System.out.println("\t\t\t\t\tConstructor #" + (i+1) + " = " + c1[i].getName());
    }

    }

    public void characterWrapperClass() {
        /**
         * These methods could be used for checking if a password has some wrong
         * chars
         */
        System.out.println(Character.isLetter('t'));
        System.out.println(Character.isDigit('3'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isUpperCase('B'));
        System.out.println(Character.isLowerCase('b'));
        System.out.println(Character.getNumericValue('b'));
    }

    public void commonDemo() {

        int big = 1234567890;
        float approx = big;     // int can be put to float with no explicit casting.

        System.out.println(big);        // 1234567890
        System.out.println(approx);     // 1.23456794E9
        System.out.println((int) approx);// 1234567936
        System.out.println(big - (int) approx);  // -43
        // if "big" was say 1234, then such problem wouldn't occur.

        System.out.println("number = " + number);

        System.out.println(0.1d);       // 0.1
        System.out.println(0.1000000d);   // Prints 0.1, but not 0.1000000
        // Prints 0.1000000000000000055511151231257827021181583404541015625
        System.out.println(new BigDecimal(0.1));
        // Prints 0.200000000000000011102230246251565404236316680908203125
        System.out.println(new BigDecimal(0.2));
        // Prints 0.2300000000000000099920072216264088638126850128173828125
        System.out.println(new BigDecimal(0.23));

        System.out.println(1 + 2 + "3");    // Prints 33
        System.out.println("1" + 2 + 3);    // Prints 123
        System.out.println(Integer.toOctalString(i));   // DEC to OCT number = 632
        int x_ = 10;
        // Prints 120, first x=10, second x=12;
        System.out.println("x = 10; x = x++ + ++x, x = " + x_++ * ++x_);

//        long l = 2347435543; // An error - integer number too large
        long l = 2_347_435_543L; // Last char L removes previous error
        int i4_1 = (int) l;     // Casting to int
        System.out.println("Casting long to int:\n\t "
                + "(int) 2_347_435_543l = " + i4_1);
        int i5 = (int) 2.54F;    // Fractional part is discarded.
        System.out.println(i5); // 2

        int x = 0, a = 6, b = 7;
        x = a++ + b++;  // When sum is performed, a = 6, b = 7;
        // After - a = 7, b = 8;
        System.out.println(x);  // 13
        x = 0;
        a = 6;
        b = 7;
        x = ++a + b++;  // When sum is performed, a = 7, b = 7;
        // After - a = 7, b = 8;
        System.out.println(x);  // 14
        x = 0;
        a = 6;
        b = 7;
        x = ++a + ++b;  // When sum is performed, a = 7, b = 8;
        // After - a = 7, b = 8;
        System.out.println(x);  // 15

        int y = 0;
        x = 0;
        System.out.println((++x == 1) || (y++ == 1));   // true
        System.out.println(x + " " + y);    // 1 0  y=0, because
        // second part after || is never checked

        System.out.println(++i == i++);     // true
        System.out.println(i++ == i++);     // false

        int aa = 7;
        int bb = 4;
        System.out.println("-7 % 4 = " + (-aa % bb));   // -3
        System.out.println("7 % -4 = " + (aa % -bb));   // 3
        System.out.println("-7 % 4 == 7 % -4 - is " + ((-aa % bb) == (aa % -bb)));  // false

        i = -+(10 + 2 + i);   //No error
//        ++i--;                //Error

//        System.out.println(1 / 0);      // ArithmeticException: / by zero
        System.out.println(1. / 0);     // INFINITY
        System.out.println(1 / 0.);     // INFINITY
        System.out.println(-1. / 0);     // -INFINITY
        System.out.println(1 / -0.);     // -INFINITY
        System.out.println(1. / 0.);    // INFINITY
        System.out.println(0. / 0.);    // NAN
        System.out.println(0. / 0. + 10);    // NAN

        char ch = 66;
        System.out.println("char ch = 66, is " + ch);   // B
        ch = 'A';
        System.out.println((int) ch);   // 65
        // Значения типа char не "склеиваются", а складываются.
        System.out.println('1' + '\u0031' + 49);    // 147
        System.out.println('\n' + '\r');  // 23

        // http://stackoverflow.com/questions/3442090/java-what-is-this-ljava-lang-object
        System.out.println(new int[0][0][7]); // [[[I@xxxxx
        System.out.println(new String[4][2]); // [[Ljava.lang.String;@xxxxx
        System.out.println(new boolean[256]); // [Z@xxxxx

//        Double d1_ = 1; // Incompatible types - java.lang.Double and int.
        Double d1 = 1d;
        Double d2 = 1d;
        // Next is FALSE, because == compares memory addresses, but not a values.
        // False, because wrappers are objects and they always stored in a heap.
        System.out.println("d1 == d2 - " + (d1 == d2)); // false

        Float f1 = 1f;
        Float f2 = 1f;
        // Next is FALSE, because == compares memory addresses, but not a values
        // False, because wrappers are always stored in a heap, due to being objects.
        System.out.println("f1 == f2 - " + (f1 == f2)); // false

        Integer i1 = 100;
        Integer i2 = 100;
        // This is true. All the values from -128 to 127 are cached for all the integral number wrappers.
        System.out.println("i1 == i2 - " + (i1 == i2)); // true
        System.out.println("i1 == 100 - " + (i1 == 100)); // true
        // Because http://stackoverflow.com/questions/1700081/why-does-128-128-return-false-but-127-127-return-true-when-converting-to-integ
        Integer i3 = new Integer(100);
        System.out.println("i1 == i3 - " + (i1 == i3)); // false
        Integer i4 = new Integer(100);
        System.out.println("i3 == i4 - " + (i3 == i4)); // false
        System.out.println("i3 == 100 - " + (i3 == 100)); // true

        // Next is TRUE, because EQUALS compares values
        System.out.println("d1.equals(d2) - " + d1.equals(d2)); // true

        // Signed shift. Shifts a value, keeping the sign.
        System.out.println("128 >> 1" + Integer.toString(128 >> 1));    //164
        // Unsigned shift. Shifts a value, not keeping the sign.
        System.out.println("128 >>> 1" + Integer.toString(128 >>> 1));  //164
        // One cannot shift a byte/short but can shift int or long. Shifting,
        // say a byte will make it int first and then makes a shifting.

        /*
         * This is a mock value that pretends to be "true". In fact, everything that
         * is different to lexem "true" is regarded as "false".
         */
        Boolean b1 = new Boolean("/true");  // false;
        Boolean m = (i2 < i3);  // Assigning a value to m in a specific way;

        /*
         Итак, вот вам ещё один пример кода, который на первый взгляд вводит в 
         заблуждение. Для начала вас должно смутить казалось бы следующее два 
         раза друг за другом объявление массива из оболочек для байтов. Однако 
         если вы внимательно изучали язык, вы должны знать, что есть два способа 
         объявления массива — с квадратными скобками до имени и после. Более 
         того, никто не мешает нам использовать эти два способа одновременно 
         — перед вами просто двумерный массив.

         Далее вас должно смутить имя массива, которое полностью совпадает с 
         именем класса. Java позволяет называть локальные переменные классами 
         стандартной библиотеки, при этом они будут перекрывать классы. Однако 
         компилятор у Джавы умный. Очень умный. Он сообразит, что после оператора 
         new может следовать только класс, да и перед .class — тоже. И в том 
         контексте будет подразумеваться именно класс Byte, хотя имя экземпляра 
         должно его перекрывать.
         */
        Byte[] Byte[] = {{0}};
        System.out.println(Byte);
        System.out.println(Byte.class);
        System.out.println(Byte.length);
        System.out.println(new Byte("8"));

        // Prints "def one def three four def"
        for(int i = 0 ; i < 4 ; ) {
            switch(new Integer(i++)) {
                case 1:
                    System.out.print("one ");
                    break;
                case 3:
                    System.out.print("three ");
                case 4:
                    System.out.print("four ");
                default:
                    System.out.print("def ");
            }
        }

        System.out.println();
        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE); // true
        // When integer overflows, it gets to 0, i.e. - Integer.MIN_VALUE.

    }

    public void checkFloatNan() {

        Float f1_ = new Float(Float.NaN);
        Float f2 = new Float(Float.NaN);

        System.out.println("" + (f1_ == f2) + " " + f1_.equals(f2) + " "
                + (Float.NaN == Float.NaN));    // false true false
    }

}
