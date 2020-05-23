package ru.tinyprogs.classpertask;

import java.math.BigInteger;

public class FibonacciNumber {

    public FibonacciNumber() {

        /*for (int n = 0; n < 100; n++) { 
         System.out.print(FibonacciNumber.getByRecurcive(n) + " "); 
         } 
         System.out.println(); 
  
         for (int n = 0; n < 10; n++) { 
         System.out.print(FibonacciNumber.getByLoop(n) + " "); 
         } 
         System.out.println();*/
        for (int n = 0; n < 125; n++) {
            System.out.print(FibonacciNumber.getByLoopWithBigInteger(n) + " ");
        }
        System.out.println();

    }

    static long getByRecurcive(int n) {
        if (n < 2) {
            return n;
        } else {
            return getByRecurcive(n - 1) + getByRecurcive(n - 2);
        }
    }

    static long getByLoop(int n) {
        long a = 0;
        long b = 1;
        for (int i = 0; i < n; i++) {
            long saveA = a;
            a = b;
            b = saveA + a;
        }
        return a;
    }

    static BigInteger getByLoopWithBigInteger(int n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");

        for (int i = 0; i < n; i++) {
            BigInteger saveA = a;
            a = b;
            b = saveA.add(a);
        }

        return a;
    }

}
