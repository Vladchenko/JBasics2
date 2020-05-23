package ru.tinyprogs;

import ru.Utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v.yanchenko on 14.10.2016.
 */
public class Strings {

//    http://pas1.ru/taskstring
//    Not all the tasks are done, cause many of them are simple

    public Strings() {
//        System.out.println(removeSpacesBetweenQuestions("sdf ?fg r6t  rfgh 678 ?grtg ytui? 87 ?34 hht6"));
//        System.out.println(decimalToNotation(10000,4));
//        wordsInBackwardOrder(" q er t2  768  98     6hb54df 88!f%^&   ");
//        demoSortStringsBy1stChar();
//        replaceSpacesWithAsterisk("sdf fg r6t  rfgh 678 grtg ytui 87 34 hht6");
//        System.out.println(firstLetterOfSomeWord("ert 54we 65gdhgd g hgj56 34 86",3));
//        System.out.println(replaceAWithBInLongestWord("df 9hgt sad5 fahafaw kurlik"));
//        System.out.println(defineShortestWord("erret gf k ert 4f 678 t"));
//        System.out.println(replaceLast3CharsWith$OfWordsWithSomeLength("sdfg g fhv jhjl rt fvgdf f grty uikj zx", 1));
//        UpperToLowerCasesPercentageRatio("F;d5 7&GhnH *Nso :. /Kgp j6^f#g ASDF 567h");
//        defineMinMaxLengthWord("fghfg апр redf dfg   rtrth gh fghtyhnghn в rtghfghfgh");
//        findMostRepeatedWord("1 2 34 rt 3 2 45 rt 2 34");
//        splitStringIntoIntsDoublesWords("1 12.1 234e 45656");
        System.out.println(removeDuplicateChars("45gh4v5hg"));
    }

// NOT DONE
//    http://pas1.ru/matrix-word
//    http://pas1.ru/taskstring/unknown-substring

    public String removeSpacesBetweenQuestions(String string) {
        if (string.equals("")
                || string.equals(null)) {
            return "";
        }
        int position1 = string.indexOf('?');
        int position2 = string.indexOf('?', position1 + 1);
        String stringCut = string.substring(position1, position2 + 1);
        stringCut = stringCut.replaceAll("\\s", "");
        return string.substring(0, position1) + stringCut + string.substring(position2 + 1);
    }

    public String decimalToNotation(int number, int notation) {
        return Integer.toString(number, notation).toUpperCase();
    }

    public String wordsInBackwardOrder(String string) {
        // In case of willing to keep an inner spaces,
        // remove + sign from an argument of a split method.
        String[] strings = string.split("[\\s]+");
        for (int i = strings.length - 1; i > 0; i--) {
            System.out.print(strings[i] + " ");
        }
        System.out.print(strings[0]);
        return string;
    }

    public String[] sortStringsBy1stChar(String[] strings) {
//        Arrays.sort(strings); // Sorts by all the chars
        String replacer = "";
        int swaps = 0;
        for (int j = 0; j < strings.length - 1; j++) {
            swaps = 0;
            for (int i = 0; i < strings.length - 1; i++) {
                if (strings[i].charAt(0) > strings[i + 1].charAt(0)) {
                    replacer = strings[i];
                    strings[i] = strings[i + 1];
                    strings[i + 1] = replacer;
                    swaps++;
                }
            }
            if (swaps == 0) {
                break;
            }
        }
        return strings;
    }

    public void demoSortStringsBy1stChar() {
        String[] stringArr = {"3", "2", "1", "4"};
        sortStringsBy1stChar(stringArr);
        Utils.printArr(stringArr);
    }

    public String replaceSpacesWithAsterisk(String string) {
        // Remove + sign if you need to mark with * every space
        String[] strings = string.split("[\\s]+");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + "*");
        }
        System.out.print(strings[0]);
        return string;
    }

    public char firstLetterOfSomeWord(String string, int index) {
        // index - number of a string to get a char from.
        // Remove + sign if you need to mark with * every space
        String[] strings = string.split("[\\s]+");
        return strings[index - 1].charAt(0);
    }

    public String replaceAWithBInLongestWord(String string) {
        // Remove + sign if you need to mark with * every space
        String[] strings = string.split("[\\s]+");
        int max = 0, maxIndex = 0;
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            if (max < strings[i].length()) {
                max = strings[i].length();
                maxIndex = i;
            }
        }
        strings[maxIndex] = strings[maxIndex].replaceAll("a", "b");
        for (int i = 0; i < strings.length; i++) {
            result += strings[i] + " ";
        }
        return result;
    }

    public String defineShortestWord(String string) {
        String[] strings = string.split("[\\s]+");
        int min = Integer.MAX_VALUE,
                minIndex = 0;
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            if (min > strings[i].length()) {
                min = strings[i].length();
                minIndex = i;
            }
        }
        return strings[minIndex];
    }

    public String replaceLast3CharsWith$OfWordsWithSomeLength(String string, int length) {
        String[] strings = string.split("[\\s]+");
        String result = "";
        int shift = 3;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == length) {
                if (length < 3) {
                    shift = length;
                }
                strings[i] = strings[i].substring(0, strings[i].length() - shift) + "$$$";
            }
        }
        for (int i = 0; i < strings.length; i++) {
            result += strings[i] + " ";
        }
        return result;
    }

    public void UpperToLowerCasesPercentageRatio(String string) {
        int lowerCase = 0,
                upperCase = 0,
                charsNumber = 0;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))) {
                lowerCase++;
            }
            if (Character.isUpperCase(string.charAt(i))) {
                upperCase++;
            }
            charsNumber++;
        }
        System.out.println("Lower / upperCase ration is: " + (double) lowerCase / charsNumber * 100 + "% / "
                + (double) upperCase / charsNumber * 100 + "%");
    }

    public void defineMinMaxLengthWord(String string) {
        String[] strings = string.split("[\\s]+");
        int min = Integer.MAX_VALUE,
                minIndex = 0,
                max = Integer.MIN_VALUE,
                maxIndex = 0;
        for (int i = 0; i < strings.length; i++) {
            if (min > strings[i].length()) {
                min = strings[i].length();
                minIndex = i;
            }
            if (max < strings[i].length()) {
                max = strings[i].length();
                maxIndex = i;
            }
        }
        System.out.println("Minimum length word: " + strings[minIndex]
                + ", maximum length word: " + strings[maxIndex]);
    }

    // NOT DONE
    public String findMostRepeatedWord(String string) {
        String patternString = "(.+)(?=.*\\1)";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(string);
//        System.out.println(matcher.group(0));
        return "";
    }

    public String[] splitStringIntoIntsDoublesWords(String string) {
        //    http://pas1.ru/string-sorting
        String[] stringsResult = new String[]{"", "", ""};
        String[] strings;
        strings = string.split("[\\s]");
        for (String string_ : strings) {
            try {
                stringsResult[0] += Integer.toString(Integer.parseInt(string_)) + " ";
            } catch (Exception ex) {
                try {
                    stringsResult[1] += Double.toString(Double.parseDouble(string_)) + " ";
                } catch (Exception ex2) {
                    stringsResult[2] += string_ + " ";
                }
            }
        }
        for (String string_ : stringsResult) {
            System.out.println(string_);
        }
        return stringsResult;
    }

    public String removeDuplicateChars(String string) {
//        http://pas1.ru/deldupl
        String string_ = "";
        Set<Character> chars = new HashSet<>();
        for (Character ch : string.toCharArray()) {
            if (chars.add(ch)) {
                string_ += ch;
            }
        }
        return string_;
    }

    // Stopped @ http://pas1.ru/arraystring

}