/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

import java.io.UnsupportedEncodingException;

/**
 * Java types conversion demonstration.
 *
 * @author Влад
 */
public class TypesConversion {

    /**
     * Правила преобразований при операциях конверсии типов:
     *      - если один из операндов операции относится к типу double, то и второй операнд
     * преобразуется к типу double.
     *      - если предыдущее условие не соблюдено, а один из операндов операции относится к типу
     * float, то и второй операнд преобразуется к типу float.
     *      - если предыдущие условия не соблюдены, а один из операндов операции относится к типу
     * long, то и второй операнд преобразуется к типу long.
     *      - иначе все операнды операции преобразуются к типу int.
     */
    public TypesConversion() {

        short s = 2;
        char c = '2';
        int i = 2;
        long l = 2;
        float f = 2;
        double d = 2;
        byte b = 20;

        byte b2 = (byte) -b;   // Unary minus makes a byte var to be int.
        byte b2_2 = (byte) +b;   // Unary plus does the same.

        byte x = -128;
        System.out.println(-x); // 128, because -x is int
        System.out.println(((Object) (-x)).getClass()); // class java.lang.Integer

        byte y = 127;
        System.out.println(++y);    // -128. Byte range is [-128...127].
        y = 127;
        System.out.println(((Object) (++y)).getClass());    // class java.lang.Byte

        byte z = (x > y) ? x : y; // Legitimate comparison, since x,y have the same type.
        System.out.println(z);  // -128. Comparison is done in int and in int -128 is bigger than 127 in binary view.
//        byte abs = (x > 0) ? x : -x; // Wrong. -x is of an int type.
        int abs2 = (x > 0) ? x : -x; // But this one is fine.

        long xL = 100;
        long yL = 200;
        long someL = (xL > yL) ? -xL : -yL;     // -200;

        /*
         * b*2 is of an "int" type and it cannot be implicitly cast to byte, 
         * thus we get a compilation error.
         */
//        b = b * 2;
        // This row also gives such error, 'cause *2 eventually gives int type
//        b = (byte) b * 2;
        /*
         * For "b * 2" expression to be casted to "byte", one has to explicitly 
         * put a type cast - (byte) for whole "b * 2" expression. Following row shows this.
         */
        b = (byte) (b * 2);
        //* As seen next, b * 2 is of an "int" type:
        System.out.println(((Object) (b * 2)).getClass()); // class java.lang.Integer
        /*
         * Programmer has to be aware that "b * 2" might overflow and the
         * resulting value won't fit into byte.
         * (Programmer has to check the result value, it may exceed byte range)
         */
        /*
         * "s * 2" is of an int type and int cannot be implicitly cast to short,
         * thus we get a compilation error.
         */
//        s = s * 2;
        // As seen next, "s * 2" is of an "int" type:
//        System.out.println(((Object)(s*2)).getClass());
        // This row works fine, but check the short range.
//        s = (short) (s * 2);
        System.out.println(((Object) (s * 2_000_000)).getClass()); // Still int
        // Although "s * 2_000_000_000" should be long, it is still int.
        System.out.println(s * 2_000_000_000);    // -294'967'296
        /*
         * Why doesn't it complain saying "Integer value too large" ?
         * Seems multiplication of any var with type less or equal to int and any
         * integral value leads to int.
         */
        // One has to add an L sign to an integral value.
        System.out.println(s * 2_000_000_000L);    // 4'000'000'000

        int x2 = 629339;
        int y2 = 4096;
        long res = x2 * y2;  // Same problem. * still makes integer value, no
        // matter if it is too large for it.
        System.out.println(res);
        res = (long) (x2 * y2);  // Still problem remains.
        System.out.println(res);
        res = ((long) x2) * y2;  // This is the way out.
        /*
         * Although the result of s*200L fits into int type, the result is
         * of a type long, because one of a multiplier is of a type long.
         */
        System.out.println(((Object) (s * 200L)).getClass());   // long type
        System.out.println(((Object) (s * 20000000000000L)).getClass()); // long type
        // "Integer number too large"
//        System.out.println(((Object) (s * 2000000000000000000000L)).getClass());
        // For big numbers, use BigDecimal

        // Default type for number that is integral(целое) is integer. It is seen below.
        System.out.println(((Object) 5).getClass());    // class java.lang.Integer
        System.out.println(((Object) 5F).getClass());   // class java.lang.Float
        System.out.println(((Object) 5D).getClass());   // class java.lang.Double
        System.out.println(((Object) 5L).getClass());   // class java.lang.Long
        System.out.println();

        System.out.println("--- char ---");
        char c2 = 'A';
        System.out.println(c2);                 // A
        System.out.println(c2 + 1);             // 66
        System.out.println('c' + '=' + c2);     // 225
        System.out.println("" + 'c' + '=' + c2);// c=A

        System.out.println(1 + 2 + "text");     // "3text"
        System.out.println("text" + 1 + 2);     // "text12"
        System.out.println();

        System.out.println("--- String ---");
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "a" + "bc";
        System.out.println(s1 == s2);           // true
        System.out.println(s1 == s3);           // true

        String s1_ = "abc";
        String s2_ = "ab";
        System.out.println(s1_ == (s2_ + "c"));   // false. Why ?
        System.out.println();

        System.out.println("--- rest ---");
        long a = 1234567890987654321L;
        System.out.println(a);
        float f2 = a;   // Strange that such an implicit casting is allowed.
        System.out.printf("%10.0f\n", f2);  // 1234567939550609410
        a = (long) f2;  // Here we see that we lost the initial long value.
        System.out.println(a) ;  // 1234567939550609408

        float f3_ = 2e9f;   // It is 2.0E9
        System.out.println((int) (char) f3_);   //37888
        System.out.println((char) (int) f3_);   // 鐀 - Unicode symbol ?
        System.out.println((int) (char) -f3_);  //27648

        long l2 = 1000000000000000000L;
        System.out.print(l2 / 2.0 + " ");   // 5.0E17
        System.out.println(((Object) (l2 / 2.0)).getClass());   // class java.lang.Double
        System.out.print(l2 / 2f + " ");    // 4.99999992E17
        System.out.println(((Object) (l2 / 2f)).getClass());    // class java.lang.Float
        System.out.printf("%.0f", l2 / 2f); // 499999992153374720
        System.out.println();

        System.out.println("--- double and float ---");
        String value = "29.1";
        /*
         * Somehow following statement, gives "false", though logically it
         * should provide "true", because both the sides of a comparison
         * logically compute "30.1"
         */
        System.out.println((Float.valueOf(value) + 1.0) == 30.1);   // false

        /*
         * Let's check what's happening there.
         * Following row displays class "java.lang.Float", that is intuitively correct
         */
        System.out.println((Float.valueOf(value)).getClass()); // java.lang.Float

        /*
         * While adding a "1.0" value, which is of a "Double" class, to a
         * previous expression, which is in turn, of a "Float" class, we finally get a
         * "Double" class.
         */
        System.out.println(((Object) (Float.valueOf(value) + 1.0)).getClass()); // java.lang.Double

        // Next row, also displays "Double" and that is obvious.
        System.out.println(((Object) (30.1)).getClass());

        /**
         * So we have made sure that the types are equal. Let's take a look to
         * the values. We will see that the following two rows give slightly
         * different values. The reason of this - when making an upcasting from
         * float to double, this operation somehow brings a glitch to the
         * upcasted value. Thus, we get false in the comparison.
         */
        System.out.println(
                (Float.valueOf(value) + 1.0));  // 30.100000381469727
        System.out.println((Object) (30.1));    // 30.1

        // Eventually
        System.out.println((Float.valueOf(value) + 1.0) == 30.1);   // false
        System.out.println((Double.valueOf(value) + 1.0) == 30.1);  // true

//        System.out.println(30.1f);
//        System.out.println(30.1);   // One might add "d" letter after 1, to make it look double,
//        // but without it, it is still double.

        System.out.println(30.1f + 1.0f);   // 31.1
        System.out.println(30.1 + 1.0);    // 31.1

        // When are these expressions false ? -
        //  1) x2*30/30 == x2
        //  2) x2/30*30 == x2;
        //      for 1) - Value greater than Integer.MAX_VALUE / 30
        //      for 2) - Любое целое число не делящееся нацело на 30;
        x2 = 1;
        System.out.println("x*30/30 == x, when x=" + x2 + " is " + (x2 * 30 / 30 == x2));
        x2 = 1;
        System.out.println("x/30*30 == x, when x=" + x2 + " is " + (x2 / 30 * 30 == x2));

        //<editor-fold defaultstate="collapsed" desc="String to primitives">
        // String to byte
        try {
            Byte b1 = new Byte("10");
            System.out.println(b1);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to byte using valueOf
        String str1 = "111";
        try {
            Byte b2_ = Byte.valueOf(str1);
            System.out.println(b2_);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to byte using parseByte
        byte b_ = 0;
        String str2 = "100";
        try {
            b_ = Byte.parseByte(str2);
            System.out.println(b_);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to byte array
        String str3 = "20150";
        byte[] b3 = str3.getBytes();
        System.out.println(b3);

        // byte array to String
        try {
            String s_ = new String(b3, "cp1251");
            System.out.println(s_);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // String to short using constructor
        try {
            Short s11 = new Short("68");
            System.out.println(s11);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to short using valueOf
        String str1_ = "59";
        try {
            Short s21 = Short.valueOf(str1_);
            System.out.println(s21);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to short using parseShort
        short s31 = 0;
        String str2_ = "100";
        try {
            s31 = Short.parseShort(str2_);
            System.out.println(s31);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        /*
         * If you want to have full control over parsing integers, check out
         * NumberFormat with various locales.
         */
        //
        // String to int using constructor
        try {
            Integer i1 = new Integer("20349");
            System.out.println(i1);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to int using valueOf.  Returns instance of Integer instance.
        String str4 = "1451";
        try {
            Integer i2 = Integer.valueOf(str4);
            System.out.println(i2);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to int using parseInt.  Returns primitive int.
        int i3 = 0;
        String str5 = "102944";
        try {
            i3 = Integer.parseInt(str5);
            System.out.println(i3);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to long using constructor
        try {
            Long l1 = new Long("11111111");
            System.out.println(l1);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to long using valueOf
        String str6 = "222222222";
        try {
            Long l2_ = Long.valueOf(str6);
            System.out.println(l2_);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to long using valueOf
        long l3 = 0;
        String str7 = "333333333";
        try {
            l3 = Long.parseLong(str7);
            System.out.println(l3);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to long using constructor
        try {
            Float f1 = new Float("123.5");
            System.out.println(f1);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to long using valueOf
        String str8 = "3.1415";
        try {
            Float f3 = Float.valueOf(str8);
            System.out.println(f3);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to long using parseFloat
        float f3 = 0;
        String str9 = "36.6";
        try {
            f3 = Float.parseFloat(str9);
            System.out.println(f3);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to double using constructor
        try {
            Double d1 = new Double("4.4e10");
            System.out.println(d1);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to double using valueOf
        try {
            Double d2 = Double.valueOf(str1);
            System.out.println(d2);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }

        // String to double using parseDouble
        double d3 = 0;
        String str10 = "13.7e10";
        try {
            d3 = Double.parseDouble(str10);
            System.out.println(d3);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
//</editor-fold>

        // String to boolean
        String s12 = "True";
        String s22 = "yes";
        boolean bool1, bool2, boolean1, boolean2;
        System.out.println("Boolean...");

        // Using parseBoolean
        bool1 = Boolean.parseBoolean(s12);
        bool2 = Boolean.parseBoolean(s22);
        System.out.println(bool1);  // true
        System.out.println(bool2);  // false

        // Using valueOf
        boolean1 = Boolean.valueOf(s12);
        boolean2 = Boolean.valueOf(s22);
        System.out.println(boolean1);  // true
        System.out.println(boolean2);  // false

        // int to String
        int i_ = 35;
        String str = Integer.toString(i_);
        System.out.println(str);    // 35

        // String to int
        str = "40";
        i_ = Integer.parseInt(str);
        System.out.println(i_);     // 40

        // String to int
        str = "45";
        i_ = Integer.valueOf(str);
        System.out.println(i_);     // 45

        // ! valueOf returns a new or cached instance of java.lang.Integer
        // ! parseInt returns primitive int.

        // double to String
        double i2 = 32.4e10;
        String str_ = Double.toString(i2);
        System.out.println(str);

        // long to String
        long i5 = 3422222L;
        String str11 = Long.toString(i5);
        System.out.println(str11);

        // float to String
        float i4 = 3.46f;
        String str12 = Float.toString(i4);
        System.out.println(str12);

        // char to String
        char ch = 'S';

        // c использованием класса Character
        String charToString = Character.toString(ch);
        System.out.println(charToString);

        // с использованием операции добавления класса String
        String str13 = "" + ch;
        System.out.println(str13);

        //с использованием массива
        String fromChar = new String(new char[]{ch});
        System.out.println(fromChar);

        // с использованием метода valueOf класса String 
        String valueOfchar = String.valueOf(ch);
        System.out.println(valueOfchar);

        // char to int
        char ch2 = '9';

        // c использованием метода getNumericValue
        // класса Character
        int i1 = Character.getNumericValue(ch2);
        System.out.println(i1);

        // c использованием метода digit класса Character
        int i7 = Character.digit(ch, 10);
        System.out.println(i7);

        // Преобразования чисел
        // int to long
        int i6 = 2015;
        long l2_ = (long) (i6);
        System.out.println(l2_);

        // int to float
        int i11 = 2015;
        float f4 = (float) (i11);
        System.out.println(f4);

        // long to int
        long l4 = 214748364;
        int i12 = (int) l4;
        System.out.println(i12);

        // double to int
        double d2 = 3.14;   // Fraction part is discarded.
        int i13 = (int) d2;
        System.out.println(i13);    // 3
    }
}
