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

/**
 *
 * @author v.yanchenko
 */
public class Grep {

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

    private List<String> lstStrings;

    public Grep(String... word) {
        System.out.println("--- Input lines: ---");
        lstStrings = readLinesFiltered(word);
        printLines(lstStrings);
    }

    // Return a lines that incorporate a word in them.
    private List<String> readLinesFiltered(String... word) {
        int i = 0;
        int j = 0;
        String str = " ";
        List<String> lstStringsLocal = new ArrayList<String>();
        while (!str.isEmpty()) {
            try {
                str = bufferedReader.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Grep.class.getName()).log(Level.SEVERE, null, ex);
            }
            j = 0;
            while (j < word.length) {
            // Considering letters' case (small / big letters)
//          i = str.indexOf(word);
                // Not considering letters' case
                i = str.toLowerCase().indexOf(word[j].toLowerCase());
                if (i > -1) {
                    try {
                        if (str.charAt(i - 1) != ' ') {
                            j++;
                            continue;
                        }
                    } catch (Exception ex) {
                    }
                    try {
                        if (str.charAt(i + word[j].length()) != ' ') {
                            j++;
                            continue;
                        }
                    } catch (Exception ex) {
                    }
                    lstStringsLocal.add(str);
                    break;  // Goes to an outer loop.
                }
                j++;
            }
        }
        return lstStringsLocal;
    }

    private void printLines(List<String> lstString) {
        System.out.println("--- Strings are: ---");
        for (String lstString1 : lstString) {
            System.out.println(lstString1);
        }
    }
}
