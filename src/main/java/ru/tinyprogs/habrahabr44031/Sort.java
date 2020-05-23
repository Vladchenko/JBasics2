/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs.habrahabr44031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author v.yanchenko
 */
public class Sort {

    /**
     * Программа в качестве аргумента может получать порядковый номер слова в
     * строке, по которому надо сортировать строки.
     * 
     * Это как ?
     */
    
    private InputStream inputStream = System.in;
    private Reader inputStreamReader = new InputStreamReader(inputStream);
    private BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    private List<String> lstLines;
    private String[][] words;

    public Sort() {
        System.out.println("--- Input the lines: ---");
        lstLines = readLines();
        words = cutLines(lstLines);
//        sortWordsByAlpabetOrder(words);
        sortWordsByTheirLength(words);
        System.out.println("--- Lines cut into words and sorted: ---");
        printLines(words);
    }

    // Reading a lines from keyboard.
    private List<String> readLines() {

        String str = " ";
        List<String> lstStringsLocal = new ArrayList<String>();

        // Reading the lines from a keyboard
        while (!str.isEmpty()) {
            try {
                str = bufferedReader.readLine();
                lstStringsLocal.add(str);
            } catch (IOException ex) {
                Logger.getLogger(Grep.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstStringsLocal;
    }

    // Cutting a lines into words.
    private String[][] cutLines(List<String> lstStrings) {
        String[][] lstWords = new String[lstStrings.size()][];
        for (int i = 0; i < lstStrings.size(); i++) {
            lstWords[i] = lstStrings.get(i).split(" ");
        }
        return lstWords;
    }

    // Printing a lines to console
    private void printLines(String[][] cutLines) {
        for (int i = 0; i < cutLines.length; i++) {
            System.out.print("Line #" + i + ":  ");
            for (int j = 0; j < cutLines[i].length; j++) {
                System.out.print("word#" + (j + 1) + " = " + cutLines[i][j] + ", ");
            }
            System.out.println("");
        }
    }

    private void sortWordsByAlpabetOrder(String[][] cutLines) {
        for (int i = 0; i < cutLines.length; i++) {
            Arrays.sort(cutLines[i]);
        }
    }

    private void sortWordsByTheirLength(String[][] cutLines) {
        String str = new String();
        for (int i = 0; i < cutLines.length; i++) {
            for (int j = 0; j < cutLines[i].length; j++) {
                for (int k = 0; k < cutLines[i].length; k++) {
                    if (cutLines[i][j].length() > cutLines[i][k].length()) {
                        str = cutLines[i][j];
                        cutLines[i][j] = cutLines[i][k];
                        cutLines[i][k] = str;
                    }
                }
            }
        }
    }
}
