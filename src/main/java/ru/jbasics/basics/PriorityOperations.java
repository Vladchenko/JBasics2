/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

/**
 * @author Влад
 */
public class PriorityOperations {

    public PriorityOperations() {
    }

    public void performPriority() {

        int a, b, c;

        a = 1;
        b = 1;
        c = ++a + ++b;
        System.out.println(c);  // 4

        a = 1;
        b = 1;
        c = a++ + ++b;
        System.out.println(c);  // 3

        a = 1;
        b = 1;
        c = a++ + b++;
        System.out.println(c);  // 2

        a = 1;
        b = 1;
        c = (a++) + (b++);
        System.out.println(c);  // 2

        a = 1;
        b = 1;
        c = ++a * ++b;
        System.out.println(c);  // 4

        a = 1;
        b = 1;
        c = a++ * ++b;
        System.out.println(c);  // 2

        a = 1;
        b = 1;
        c = a++ * b++;
        System.out.println(c);  // 1

    }

    public void Operations() {

        int a, b, c;

        a = 100;
        b = ~a;    // Побитовое дополнение (инвертировние битов)
        System.out.println("Inverted a is: " + b);

        // XOR
        a = 112;        //         00000000 00000000 00000000 01110000
        b = 94;         //         00000000 00000000 00000000 01011110
        c = a ^ b;      // c = 46: 00000000 00000000 00000000 00101110

        // Сдвиг вправо c учетом знака
        a = -17;        //         11111111 11111111 11111111 11101111
        b = a >> 2;     // b = -5: 11111111 11111111 11111111 11111011

        // Сдвиг вправо без учета знака
        a = -17;        //         11111111 11111111 11111111 11101111
        b = a >>> 2;    // b:      00111111 11111111 11111111 11111011
        // b =     1073741819
    }
}
