/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs.classpertask;

/**
 *
 * @author Влад
 */
public class LuckyTickets {
    
    int luckyTicketsNumber = 0;
    int meetingTicketsNumber = 0;
    int palindromicTicketsNumber = 0;
    String number = "";
    
    public LuckyTickets() {
        computeTickets();
        printTickets();
    }
    
    private void computeTickets() {
        for (int i = 0; i < 999_999; i++) {
            number = Integer.toString(i);
            if (i < 10) {
                number = "00000" + number;
            } else
            if (i < 100) {
                number = "0000" + number;
            } else
            if (i < 1000) {
                number = "000" + number;
            } else 
            if (i < 10000) {
                number = "00" + number;
            } else 
            if (i < 100000) {
                number = "0" + number;
            }
            if (number.charAt(0) + number.charAt(1) + number.charAt(2)
                    == number.charAt(3) + number.charAt(4) + number.charAt(5)) {
                luckyTicketsNumber++;
            }
            if (number.charAt(0) + number.charAt(1) + number.charAt(2) + 1
                    == number.charAt(3) + number.charAt(4) + number.charAt(5)
                    || number.charAt(0) + number.charAt(1) + number.charAt(2)
                    == number.charAt(3) + number.charAt(4) + number.charAt(5) + 1) {
                meetingTicketsNumber++;
            }
            if (number.charAt(0) == number.charAt(5) 
                    && number.charAt(1) == number.charAt(4)
                    && number.charAt(2) == number.charAt(3)) {
                palindromicTicketsNumber++;
            }
        }
    }
    
    private void printTickets() {
        System.out.println("Number of lucky tickets is: " + luckyTicketsNumber);
        System.out.println("Number of meeting tickets is: " + meetingTicketsNumber);
        System.out.println("Number of palindromic tickets is: " + palindromicTicketsNumber);
    }
}
