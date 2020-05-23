/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

/**
 * @author v.yanchenko
 */
public class Labels {

    // Will this method compile and run or give an errors somewhere ?
    // Answer: Compiles with no errors.
    public static void doIt(String String) { //1
        int i = 10;
        i:
        for (int k = 0; k < 10; k++) {      //2
            System.out.println(String + i); //3
            if (k * k > 10) {
                continue i;                 //4 
            }
        }
    }

    // Method is not checked for consistency. Made up for a demo.
    public static void checkLabels() {
        label1:
        for (int i = 0; i < 10; i++) {
            label2:
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (k == 1) {
                        break label1;
                    }
                    if (j == 3) {
                        break label1;
                    }
                }
            }

        }
    }

}
