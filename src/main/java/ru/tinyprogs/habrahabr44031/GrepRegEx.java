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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author v.yanchenko
 */
public class GrepRegEx {

    /**
     * Необходимо реализовать консольную программу, которая бы фильтровала поток
     * текстовой информации подаваемой на вход и на выходе показывала лишь те
     * строчки, которые содержат слово передаваемое программе на вход в качестве
     * аргумента.
     *
     * Варианты усложнения: - Программа не должна учитывать регистр - В
     * аргументах может быть передано не одно слово, а несколько - В качестве
     * аргумента может быть задано не конкретное слово, а регулярное выражение.
     *
     */
    /**
     * По моим предположениям, автор должен был обозначить, что "слово" должно
     * быть отделено пробеkами от соседних слов. (Влад)
     */
    private InputStream inputStream = System.in;
    private Reader inputStreamReader = new InputStreamReader(inputStream);
    private BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    List<String> lstStrings = new ArrayList<String>();
    List<String> lstStringsFiltered = new ArrayList<String>();

    public GrepRegEx(String word) {
        System.out.println("--- Input lines: ---");
        lstStrings = readLines();
        lstStringsFiltered = filterLines(lstStrings, word);
        printLines(lstStringsFiltered);
    }

    // Reading a lines from keyboard
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

    // Making a list of a lines that match the regex criterion.
    private List<String> filterLines(List<String> lstStrings, String word) {

        String str = " ";
        List<String> lstStringsLocal = new ArrayList<String>();

        Pattern r;
        Matcher m;

        // Create a Pattern object.
        r = Pattern.compile(word);

        for (int i = 0; i < lstStrings.size(); i++) {

            // Now create matcher object.
            m = r.matcher(lstStrings.get(i));

            while (m.find()) {
                lstStringsLocal.add(m.group());
            }
        }

        return lstStringsLocal;
    }

    private void printLines(List<String> lstStrings) {
        System.out.println("--- Strings are: ---");
        for (String lstString1 : lstStrings) {
            System.out.println(lstString1);
        }
    }
}
