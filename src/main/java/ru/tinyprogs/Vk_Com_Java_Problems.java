/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.tinyprogs;

//import com.singularsys.jep.EvaluationException;
//import com.singularsys.jep.Jep;

import ru.Utils;

import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author v.yanchenko
 */
public class Vk_Com_Java_Problems {

    // tasks for beginners
    // http://vk.com/java_problems
    // NOT DONE YET.
    // https://vk.com/java_problems?w=wall-60560229_602
    // https://vk.com/java_problems?w=wall-60560229_1094
    public Vk_Com_Java_Problems() {

//        Scanner scr = new Scanner(System.in);
//        System.out.print("Input a line to process: ");
//        strInitial = scr.nextLine();
//        System.out.println(task1("12345678"));
//        System.out.println(task1Mod2("11111_22222"));
//        task1Mod2();
//        System.out.println(task2(0.000000100000));
//        task3(
//                "10:23:13", "01:36:42", "08:06:16",
//                "01:38:13", "20:23:53", "05:30:40",
//                "10:23:28", "01:23:13", "13:00:27",
//                "20:10:43", "07:53:48", "08:40:05"
//        );
//        task3Mod1("10:23:13", "01:36:42", "08:06:16",
//                "01:38:13", "20:23:53", "05:30:40",
//                "10:23:28", "01:23:13", "13:00:27",
//                "20:10:43", "07:53:48", "08:40:05");
//        task4Mod1(6, new Integer[]{22, 4, 21, 35, 12, 56, 17, 71, 30, 15, 14, 10, 42, 55, 22, 34, 9});
//        task4Mod2(6, new int[]{22, 4, 21, 35, 12, 56, 17, 71, 30, 15, 14, 10, 42, 55, 22, 34, 9});
//        System.out.println(task5("Jaaaaava foooor beeeeginerss"));
//        System.out.println(task6());
//        System.out.println(task11(
//                "I am the master of my fate", "I am the of my"));
//        System.out.println(isBase2Number(2));
//        System.out.println(isBase2Number(20));
//        System.out.println(isBase2Number(256));
//        isPerfectNumber(50, 10000);
//        String[] strs = new String[]{
//            "Hello, is it me ", "you are looking for",
//            "Clue number one was", "the knock to my door",
//            "Clue number two was", "was the look that you wore",
//        }; 
//        
//        for (String str : removeWord(strs, " number")) {
//            System.out.print(str + "; ");
//        }
//        new SolveExpression().solveExpression();
//        int[] arr = fragmentNumber(115200);
//        for (int i : arr) {
//            System.out.print(i + ", ");
//        }
//        new replaceBadWords("Дурак ли дурак, если этот ,, упыРь,,, что. наз,,вал ,его чМо и оБМудок. уПырь");
//        new replaceBadWords("Дуракли,этот,,упыРь,,,что.наз,,вал,егочМоиоБМудок.");
//        makePyramid(9, 11, "left");
//        Utils.printArr(numberToDigitsArray(123));
//        computeRecharge(115);

        try {
            new BeginnersTasks2().multiplyAandAEndingWith5();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Дан текст. Удалите из него содержимое, заключенное в круглые скобки.
     * В случае если скобки расставлены неверно, удаление не происходит.
     *
     * @return String processed string.
     */
    public String removeTextWithinBrackets(String row) {
        String result = row;
        boolean start = false;
        int begin = -1;
        int end = -1;
        int bracket = 0;
        for (int i = 0; i < row.length(); i++) {
            switch (row.charAt(i)) {
                case '(' : {
                    bracket++;
                    if (!start) {
                        begin = i;
                        start = true;
                    }
                    break;
                }
                case ')' : {
                    bracket--;
                    end = i;
                    break;
                }
            }
            if (bracket < 0) {
                break;
            }
        }
        if (bracket == 0
                && begin != -1
                && end != -1) {
            result = row.substring(0, begin);
            result += row.substring(end + 1, row.length());
        }
        return result;
    }

    public String task1(String strInitial) {
        /**
         * Дана строка символов. Сожмите ее следующим образом - вместо
         * повторяющихся символов впишите сам символ и круглые скобки, внутри
         * которых будет кол-во повторов данного символа.
         */
        String strResult = "";
//        String strInitial;
//                = "_wwwwwerrtyyyuuui____ooooii1234444_";
//        Scanner scr = new Scanner(System.in);
//        System.out.print("Input a line to process: ");
//        strInitial = scr.nextLine();
        int repeat = 1;
        for (int i = 0; i < strInitial.length() - 1; i++) {
            if (strInitial.charAt(i) == strInitial.charAt(i + 1)) {
                repeat++;
                // When a last chars are repeatative.
                if (i == strInitial.length() - 2
                        && repeat > 1) {
                    strResult += strInitial.charAt(i) + "(" + repeat + ")";
                    repeat = 1;
                }
            } else {
                if (repeat > 1) {
                    strResult += strInitial.charAt(i) + "(" + repeat + ")";
                    repeat = 1;
                    continue;
                }
                strResult += strInitial.charAt(i);
            }
        }
        // When a last char is not = to a previous one.
        if (strInitial.charAt(strInitial.length() - 2)
                != strInitial.charAt(strInitial.length() - 1)) {
            strResult += strInitial.charAt(strInitial.length() - 1);
        }
//        System.out.println("Processed row is: " + strResult);
        return strResult;
    }

    public String task1Mod1(String strInitial) {
        /**
         * Дана строка символов. Сожмите ее следующим образом - вместо
         * повторяющихся символов впишите сам символ и круглые скобки, внутри
         * которых будет кол-во повторов данного символа.
         */
        String strResult = "";
        int posEnd = -1,
                posEndFixed = -1,
                posBegin = -1;
        int repeat = 1;
        boolean noRepeats = true;
        for (int i = 0; i < strInitial.length() - 1; i++) {
            if (strInitial.charAt(i) != strInitial.charAt(i + 1)) {
                if (i == 0) {
                    strResult += strInitial.charAt(i);
                }
                if (repeat > 1) {
                    strResult += strInitial.charAt(i) + "(" + repeat + ")";
                    repeat = 1;
                    posEndFixed = i + 1;
                }
                if (posBegin == -1) {
                    posBegin = i;
                }
                posEnd = i;
                if (noRepeats
                        && i == strInitial.length() - 2) {
                    strResult = strInitial;
                }
            } else {
                repeat++;
                noRepeats = false;
                if (posBegin != -1) {
                    strResult += strInitial.substring(posBegin + 1, posEnd + 1);
                    posEndFixed = posEnd + 1;
                    posBegin = -1;
                    posEnd = -1;
                }
            }
        }

        if (strResult.equals(strInitial)) {
            return strResult;
        }

        if (repeat == strInitial.length()) {
//            System.out.println("1");
            strResult += strInitial.charAt(0) + "(" + repeat + ")";
            return strResult;
        }

        if (repeat > 1) {
//            System.out.println("2");
            strResult += strInitial.charAt(posEndFixed) + "(" + repeat + ")";
            return strResult;
        }
        if (posBegin != -1
                && posEnd != -1) {
//            System.out.println("3");
            strResult += strInitial.substring(posBegin + 1, posEnd + 2);
            return strResult;
        }

        return strResult;
    }

    public String task1Mod2(String strInitial) {
        /**
         * Дана строка символов. Сожмите ее следующим образом - вместо
         * повторяющихся символов впишите сам символ и круглые скобки, внутри
         * которых будет кол-во повторов данного символа.
         */
        String strResult = "";
        int posEnd = -1,
                posEndFixed = -1,
                add = 0,
                posBegin = -1;
        int repeat = 1;
//        boolean noRepeats = true;
        for (int i = 0; i < strInitial.length() - 1; i++) {
            if (strInitial.charAt(i) == strInitial.charAt(i + 1)) {
                repeat++;
                if (posBegin != -1) {
                    strResult += strInitial.substring(posBegin, posEnd + 1);
                    posBegin = -1;
                }
            } else {
                if (repeat != 1) {
                    strResult += strInitial.charAt(i) + "(" + repeat + ")";
                    repeat = 1;
                    posEndFixed = i + 1;
                    add = 1;
                }
                if (posBegin == -1) {
                    posBegin = i + add;
                }
                posEnd = i;
            }
        }

        if (posBegin != -1
                && posEnd != -1) {
            strResult += strInitial.substring(posBegin, posEnd + 2);
            return strResult;
        }

        if (repeat > 1) {
            if (strResult.isEmpty()) {
//                System.out.println("1");
                strResult += strInitial.charAt(0) + "(" + repeat + ")";
                return strResult;
            } else {
//                System.out.println("2");
                if (posEndFixed != -1) {
                    strResult += strInitial.charAt(posEndFixed + 1) + "(" + repeat + ")";
                } else {
                    strResult += strInitial.charAt(posEnd + 1) + "(" + repeat + ")";
                }
                return strResult;
            }
        } else {
            if (strResult.isEmpty()) {
//                System.out.println("3");
                strResult = strInitial;
                return strResult;
            }
        }

//        return strResult;
        // Addition of a first char;
//        if (strInitial.charAt(1)
//                != strInitial.charAt(1)) {
//            strResult = strInitial.charAt(0) + strResult;
//        }
//        System.out.println("Processed row is: " + strResult);
        return strResult;
    }

    public String task2(Double numberDouble) {
        /**
         * На вход программы поступает число типа double. Если оно имеет дробную
         * часть, вывести само число, но без незначащих нулей в конце. Если же
         * дробная часть равна нулю, то вывести только целую часть.
         */
        /**
         * Как быть с экспонентой ? Отображать как Е или точкой цифрами ?
         *
         * //Option1, use decimalFormat. DecimalFormat df = new
         * DecimalFormat("#"); df.setMaximumFractionDigits(8);
         * System.out.println(df.format(myvalue));
         *
         * //Option 2, use printf. System.out.printf("%.9f", myvalue);
         * System.out.println();
         *
         * //Option 3, convert toBigDecimal and ask for toPlainString().
         * System.out.println(new BigDecimal(myvalue).toPlainString());
         * System.out.println();
         *
         * //Option 4, String.format System.out.println(String.format("%.12f",
         * myvalue));
         */

        String processedNumber = "";
        int lastZero = -1;
        String number;

//        DecimalFormat df = new DecimalFormat("#"); 
//        df.setMaximumFractionDigits(16);
//        number = df.format(numberDouble);
        number = numberDouble.toString();

        lastZero = number.lastIndexOf('0');
        if (lastZero == -1
                || number.indexOf('.') == -1
                || number.indexOf('.') > lastZero) {
            return number;
        } else {
            for (int i = number.length() - 1; i > 0; i--) {
//                || lastZero == number.length() - 1
                if (number.charAt(i) != '0') {
                    if (number.charAt(i) == '.') {
                        return number.substring(0, i);
                    } else {
                        return number.substring(0, i + 1);
                    }
                }
            }
        }

        return processedNumber;
    }

    // Only for unique values
    public SortedMap task3(String... arrStrings) {

        /**
         * Сортировка времени. #java Дано определенное количество различных
         * состояний цифровых часов в формате чч::мм::cc Необходимо вывести их
         * на экран таким образом, чтобы каждое новое состояние было больше
         * (позже), чем предыдущее.
         *
         * Тест Входные данные Кол-во интервалов: 4 1) 10 : 20 : 30 2) 7 : 30 :
         * 00 3) 23 : 59 : 59 4) 13 : 30 : 30
         *
         * Выходные данные 7 : 30 : 00 10 : 20 : 30 13 : 30 : 30 23 : 59 : 59
         */
        SortedMap sm = new TreeMap<String, String>();
        Date dt = new Date();

        for (String arrString : arrStrings) {
            DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
            try {
                dt = (Date) formatter.parse(arrString);
                sm.put(dt.getTime(), arrString);
            } catch (ParseException ex) {
                System.out.println("Wrong time !");
                Logger.getLogger(Vk_Com_Java_Problems.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

//        for (Object entrySet : sm.entrySet()) {
//            System.out.println(entrySet);
//        }
        return sm;
    }

    // Real algorithm, no hitches
    public String[] task3Mod1(String... arrStrings) {

        // Is it really so simple ?
        List<String> strs = new ArrayList<>(Arrays.asList(arrStrings));
        String[] arrStrs = new String[arrStrings.length];

        Collections.sort(strs);

        int i = 0;
        for (String str : strs) {
            arrStrs[i] = str;
            i++;
        }

//        for (String str : strs) {
//            System.out.println(str);
//        }
        // ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//        return (String[]) strs.toArray();
        return arrStrs;
    }

    // Only for unique values
    public String task4(int number, int[] arrInts) {
        /**
         * Поиск последовательности с наибольшей суммой. Дан массив и длина
         * последовательности. Найти последовательность данной длины такую, что
         * сумма её элементов максимальна. Элементы в полученной
         * последовательности берутся из массива необязательно в строгом порядке
         * один за другим
         */
        SortedMap sm = new TreeMap<Integer, Integer>();

        for (int i = 0; i < arrInts.length - 1; i++) {
            if (i < number) {
                sm.put(arrInts[i], i);
            } else if ((Integer) sm.firstKey() <= arrInts[i]) {
                sm.put(arrInts[i], i);
            }
            if (sm.size() > number) {
                sm.remove(sm.firstKey());
            }
        }

        for (Object entrySet : sm.entrySet()) {
            System.out.print(entrySet + ", ");
        }

        return new String();
    }

    // With a preliminary sort
    public Integer[] task4Mod1(int number, Integer[] arrInts) {

        Integer[] arrIntsMax = new Integer[number];

        arrIntsMax = Arrays.copyOf(arrInts, number);

        Comparator<Integer> cmp = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if ((Integer) o1 < (Integer) o2) {
                    return 1;
                }
                if ((Integer) o1 > (Integer) o2) {
                    return -1;
                }
                return 0;
            }

        };

        Arrays.sort(arrIntsMax, cmp);

//        for (int i = 0, j = 0, temp; i < arrInts.length; i++) {
//            System.out.print(arrInts[i] + ", ");
//        }
//        System.out.println("");
//        for (int i = 0, j = 0, temp; i < arrIntsMax.length; i++) {
//            System.out.print(arrIntsMax[i] + ", ");
//        }
//        System.out.println("");
        for (int i = number, j = 0, temp; i < arrInts.length; i++) {
//            System.out.print(arrInts[i] + ", ");
            while (arrIntsMax[j] >= arrInts[i]
                    && j < arrIntsMax.length - 1) {
                j++;
            }
            if (j > arrIntsMax.length - 1) {
                continue;
            }
            for (int k = arrIntsMax.length - 1; k > j; k--) {
//                temp = arrIntsMax[k];
//                arrIntsMax[k] = arrInts[i];
                arrIntsMax[k] = arrIntsMax[k - 1];
            }
            if (arrIntsMax[j] < arrInts[i]) {
                arrIntsMax[j] = arrInts[i];
            }
            j = 0;
        }
//        for (int i = 0, j = 0, temp; i < arrIntsMax.length; i++) {
//            System.out.print(arrIntsMax[i] + ", ");
//        }
        return arrIntsMax;
    }

    // Real algorithm, no hitches
    public int[] task4Mod2(int number, int[] arrInts) {

        /**
         * When a final array is presumed to be bigger than an initial one, just
         * return an initial array.
         */
        if (number >= arrInts.length) {
            return arrInts;
        }

        int[] intsMax = new int[number];

//        for (int i = 0, j = 0, temp; i < arrInts.length; i++) {
//            System.out.print(arrInts[i] + ", ");
//        }
        System.out.println("");

        for (int i = 0, j = 0; i < arrInts.length; i++) {
            while (arrInts[i]
                    < intsMax[j]
                    && j < intsMax.length - 1) {
                j++;
            }
            if (j >= intsMax.length) {
                continue;
            }
            // Shift all the intsMax elements to the left
            for (int k = intsMax.length - 1; k > j; k--) {
                intsMax[k] = intsMax[k - 1];
            }
            if (intsMax[j] < arrInts[i]) {
                intsMax[j] = arrInts[i];
            }
            j = 0;
        }

//        for (int i = 0; i < intsMax.length; i++) {
//            System.out.print(intsMax[i] + ", ");
//        }
        return intsMax;
    }

    public String task5(String str) {

        /**
         * Упаковка текста. #java Имеется текст. Необходимо сжать его по
         * следующему принципу. Получить код каждого символа текста согласно
         * Ascii-таблице (http://www.industrialnets.ru/files/misc/ascii.pdf)
         * Перевести код каждого символа в 16-ричную систему счисления и
         * записать преобразованный текст по специальной схеме.
         *
         * ------------------------------------------
         *
         * Например, строка символов 1 2 3 4 5 имеет следующую запись, согласно
         * таблице Ascii: 49 50 51 52 53 В 16-ричной системе счисления это будет
         * выглядеть так: 31 32 33 34 35
         *
         * -------------------------------------------------
         *
         * После того, как вся строка состоит из 16-ричных кодов пришло время
         * рассказать про специальную схему.
         *
         * Вместо всех повторяющихся символов записать число повторов (в 10-чной
         * системе счисления), а затем сам повторяющийся символ.
         *
         * Вместо не повторяющихся символов поставить указание, что идет серия
         * не повторяющихся символов - "00" Затем кол-во не повторяющихся
         * символов (в 10-чной системе счисления), а затем сами не повторяющиеся
         * символы.
         *
         * Итоговый результат будет иметь вид: 00 05 31 32 33 34 35
         *
         * На первом месте - указание, что идет серия не повторяющихся символов.
         * На втором - кол-во этих символов. Далее сами символы.
         *
         */
        StringBuilder sbResult = new StringBuilder();
        int shift = 0;
        boolean over = false;

        System.out.println(str);

        for (int i = 0, j = 0; i < str.length(); i++) {
            while (str.length() > (i + j + 1)
                    && str.charAt(i + j) == str.charAt(i + j + 1)) {
                j++;
            }
            if (j > 0) {
                sbResult.append(String.format("%02X ", j + 1));
                sbResult.append(Integer.toHexString(str.charAt(i + j))).append(" ");
                i += j;
                j = 0;
                continue;
            }
            while (str.length() > (i + j + 1)
                    && str.charAt(i + j) != str.charAt(i + j + 1)) {
                j++;
            }
            if (j > 0) {
                if (str.length() <= (i + j + 1)) {
                    shift = 1;
                } else {
                    shift = 0;
                }
                sbResult.append(String.format("%02X ", 0));
                sbResult.append(String.format("%02X ", j));
                for (int k = 0; k < j + shift; k++) {
                    sbResult.append(Integer.toHexString(str.charAt(i + k))).append(" ");
                    if (i + k == str.length() - 1) {
                        over = true;
                    }
                }
                i += j - 1;
                j = 0;
                continue;
            }
            if (!over
                    && i == str.length() - 1) {
                sbResult.append(String.format("%02X ", 0));
                sbResult.append(String.format("%02X ", j));
                sbResult.append(Integer.toHexString(str.charAt(i))).append(" ");
            }
        }

        return sbResult.toString();
    }

    public String[] task6() {
        /**
         * Выдача наличных банкоматом
         *
         * Эта программа будем симулировать работу банкомата. Пользователь хочет
         * снять какую-то сумму денег и вводит ее с клавиатуры. Банкомату
         * известно: 1. Купюры какого номинала есть в нем. 2. Сколько имеется
         * купюр каждого номинала.
         *
         * Необходимо вывести на экран все возможные комбинации выдачи
         * запрошенной суммы. Комбинации, имеющие одинаковые купюры, стоящие на
         * разных местах, не выводить (то есть вывести только одну из них).
         *
         * Формат входных данных: Пользователь хочет получить: <сумма>
         * Имеются следующие купюры ( <номинал купюры> - <кол-во>)
         *
         * Формат выходных данных: Первая комбинация ........ Последняя
         * комбинация.
         *
         * Тест 1. Сумма для получения: 1000 Купюры: 500 - 4 1000 - 2 5000 - 1
         *
         * Результат: 500 500 1000
         *
         * Тест 2. Сумма для получения: 2450 Купюры: 50 - 2 100 - 4 500 - 4 1000
         * - 2 5000 - 1
         *
         * Результат: 500 500 500 500 100 100 100 100 50 500 500 1000 100 100
         * 100 100 50 1000 1000 100 100 100 100 50
         *
         * Тест 2. Сумма для получения: 2450 Купюры: 100 - 4 500 - 4 1000 - 2
         * 5000 - 1
         *
         * Результат: Идите-ка в другой банкомат.
         */

        int note50s = 50;
        int note100s = 50;
        int note500s = 3;
        int note1000s = 2;
        int note5000s = 10;
        int amount = 0;
        int note = 5000;
        int tempAmount = 0;
        int currNotesQuantity = 0;
        int[] notesNominal = new int[]{5000, 1000, 500, 100, 50};
        int[] notesQuantityDefault = new int[]{10, 20, 30, 50, 50};
        int[] notesQuantity = Arrays.copyOf(notesQuantityDefault, notesQuantityDefault.length);
        String notes = "";
        List<String> notesStrs = new ArrayList<String>();
        String[] arrStrs;
        boolean addDraw = true;

        System.out.println("--- ATM ---");
        System.out.print("Notes number: ");
        for (int i = 0; i < notesQuantity.length; i++) {
            System.out.print(notesNominal[i] + "=" + notesQuantity[i] + ", ");
        }

        System.out.print("\nInput an amount to withdraw : ");
        Scanner scr = new Scanner(System.in);

        try {
            amount = Integer.parseInt(scr.nextLine());
            tempAmount = amount;
        } catch (NumberFormatException nfe) {
            System.out.println("Wrong amount !");
            System.exit(1);
        }

        if (amount % 50 > 0) {
            System.out.println("ATM cannot withdraw such an amount !");
            System.exit(0);
        }

        for (int j = 0; j < notesNominal.length; j++) {
            addDraw = true;
            for (int i = j; i < notesNominal.length; i++) {
                currNotesQuantity = tempAmount / notesNominal[i];
                while (currNotesQuantity > 0
                        && notesQuantity[i] > 0) {
                    notes += Integer.toString(notesNominal[i]) + " ";
                    notesQuantity[i]--;
                    currNotesQuantity--;
                    tempAmount -= notesNominal[i];
                    if (notesQuantity[i] == 0) {
                        break;
                    }
                }
                if (currNotesQuantity > 0
                        && tempAmount > 0) {
                    addDraw = false;
                }
            }
            if (addDraw) {
                if (notesStrs.size() == 0) {
                    notesStrs.add(notes);
                }
                if (notesStrs.size() > 0
                        && !notesStrs.get(notesStrs.size() - 1).equals(notes)) {
                    notesStrs.add(notes);
                }
            }
            notesQuantity = Arrays.copyOf(notesQuantityDefault, notesQuantityDefault.length);
            notes = "";
            tempAmount = amount;
        }

        arrStrs = new String[notesStrs.size()];
        for (int i = 0; i < notesStrs.size(); i++) {
            arrStrs[i] = notesStrs.get(i);
        }

        return arrStrs;
    }

    public int[] task7(double x1, double y1, double x2, double y2) {

        /**
         * Кол-во точек с целыми координатами. #java Имеются две пары координат
         * (x1,y1,x2,y2), задающие отрезок на плоскости. Требуется найти кол-во
         * точек на этом отрезке, у которых целые координаты.
         *
         * Входные данные Две пары координат
         *
         * Выходные данные Число точек на отрезке с целыми координатами.
         */
        double xDistance = x1 - x2;
        double yDistance = y1 - y2;
        double ratio = (double) xDistance / yDistance;
        double yCurrent = 0;
        boolean noPairs = true;
        List<Integer> coordinates = new ArrayList<>();

        for (int i = (int) Math.ceil(x1), ind = 1; i <= x2; i++) {
            yCurrent = (double) i / ratio;
//            System.out.println("Dot #" + ind++ + ": x=" + i + ", " 
//                    + "y=" + yCurrent);
            if (Math.round(yCurrent) == yCurrent) {
                System.out.println("Dot #" + ind++ + ": x=" + i + ", "
                        + "y=" + (int) yCurrent);
                noPairs = false;
                coordinates.add(i);
                coordinates.add((int) yCurrent);
            }
        }

        if (noPairs) {
            System.out.println("There are no pairs present.");
        }

        int[] arrInts = new int[coordinates.size()];
        int i = 0;
        // Turning a list to an array. Seems there is no other, more simple way...
        for (Iterator<Integer> iterator = coordinates.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            arrInts[i] = next;
            i++;
        }

        return arrInts;

    }

    public void task8(int minN, int[] arrInts) {
        /**
         * N-ый найменьший элемент. Выведите на экран N-ый найменьший элемент
         * массива или "нет решений", если такового нет.
         */
        int minPos = 0;
        int[] arrIntsTemp;
        arrIntsTemp = Arrays.copyOf(arrInts, arrInts.length);
        Arrays.sort(arrIntsTemp);
        System.out.print("Minimum #" + minN + ", value=" + arrIntsTemp[minN - 1]);
    }

    public String task9(String number) {

        /**
         * Определение системы счисления. #java #pascal На вход поступает число,
         * записанное в неизвестное системе счисления. Необходимо определить
         * минимально допустимый показатель системы счисления данного числа.
         * Если он больше 36-ти, вывести, что система неизвестна.
         */
        boolean notation2 = false;
        boolean notation10 = false;
        boolean notation8 = false;
        boolean notation16 = false;
        boolean notationCh = false;
        String result = "";
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) >= 'A'
                    && number.charAt(i) <= 'Z'
                    || (number.charAt(i) >= 'a'
                    && number.charAt(i) <= 'z')) {
                notationCh = true;
            } else if (number.charAt(i) < '2'
                    && number.charAt(i) >= '0') {
                notation2 = true;
            } else if (number.charAt(i) >= '1'
                    && number.charAt(i) <= '9') {
                notation10 = true;
            } else if (number.charAt(i) >= 'A'
                    && number.charAt(i) <= 'F'
                    || number.charAt(i) >= 'a'
                    && number.charAt(i) <= 'f') {
                notation16 = true;
            } else {
                return "Unknown notation";
            }
        }
        if (notationCh) {
            return "Alphabet";
        }
        if (notation16) {
            return "HEX";
        }
        if (notation10) {
            return "DEC";
        }
        if (notation2) {
            return "BIN";
        }
        return new String();
    }

    public String task10() {
        /**
         * Возраст человека. #java В программу человек вводит свою дату рождения
         * в формате ГГ ММ ДД ЧЧ ММ А также текущую дату. Желает человек увидеть
         * свой текущий возраст. В этом же формате. Крайне желательно учитывать
         * високосные годы.
         */

        String birthDay = "";
        Date birthDate = null;
        Date today = new Date();
        DateFormat format = new SimpleDateFormat("yy MM dd HH mm", Locale.ENGLISH);
        int yearsLived = 0;

        Scanner scr = new Scanner(System.in);
        System.out.print("Input birth date, YY MM DD HH MM: ");
//        83 01 29 20 50
        birthDay = scr.nextLine();
//        birthDay = "83 01 29 20 50";
        try {
            birthDate = format.parse(birthDay);
        } catch (ParseException ex) {
            Logger.getLogger(Vk_Com_Java_Problems.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Wrong date !");
            System.exit(-1);
        }
        yearsLived = (int) ((today.getTime() - birthDate.getTime())
                / (1000 * 60 * 60 * 24 * 365.25));
        return "Your age is: " + Integer.toString(yearsLived);
    }

    public String task11(String str1, String str2) {
        /**
         * Возможность составления слова. #java Даны две строки. Проверьте,
         * можно ли из слов, входящих в str1, составить str2, если при этом
         * слова 1) можно переставлять, 2) каждое слово можно использовать более
         * одного раза, 3) некоторые слова str1 можно не использовать.
         * Разделителями слов могут быть следующие символы: ! '' (двойные
         * кавычки) ; : ? - . , [пробел], остальные символы считаются частью
         * слов.
         *
         * Тест 1. Строка1 ="Программирование - это ни разу не легко" Строка2 =
         * "Программирование - это легко" Ответ: можно.
         *
         * Тест 2. Строка1 = "А люди уже ушли - остались лишь мы" Строка2 ="Люди
         * нынче пошли странные" Ответ: нельзя (слова нынче нет в строка1)
         *
         * Тест 3. Строка1 = "Абракадабра" Строка2 ="" Ответ: можно (пустая
         * строка - есть подмножество любой строки)
         */

//        String phrase = "the!music?made   it   hard      to        concentrate\"2";
        String delims = "[ !;:?.,\"]+";    // "[ ]+" - just the space
        String[] tokens1 = str1.split(delims);
        String[] tokens2 = str2.split(delims);

        boolean present;
        int matches = 0;
        for (int i = 0; i < tokens1.length; i++) {
            present = false;
            for (int j = 0; j < tokens2.length; j++) {
                // Checks if a token from a str1 is present in an str2
                if (tokens1[i].equals(tokens2[j])) {
                    matches++;
                    System.out.println(tokens1[i] + tokens2[j]);
                }
            }
        }

        if (matches == tokens2.length) {
            return "можно";
        } else {
            return "нельзя";
        }

    }

    public String isBase2Number(int number) {
        /**
         * Определить, является ли число, введеное пользователем, бинарным
         * (степенью двойки, иными словами).
         */
        String str = Integer.toBinaryString(number);
        if (str.indexOf('1') == str.lastIndexOf('1')) {
            return "it is";
        }
        return "it is not";
    }

    public int[] isPerfectNumber(int a, int b) {
        /**
         * https://ru.wikipedia.org/wiki/%D0%A1%D0%BE%D0%B2%D0%B5%D1%80%D1%88%D0%B5%D0%BD%D0%BD%D0%BE%D0%B5_%D1%87%D0%B8%D1%81%D0%BB%D0%BE
         *
         * Совершенное число. #java Понятие совершенного числа. Совершенное
         * число - число, которое есть сумма все делителей данного числа, кроме
         * самого числа (например, 6 = 1 + 2 + 3). Пользователь вводит начало
         * диапазона A и его конец Б, а увидеть он желает все совершенные числа,
         * принадлежащие диапазону. Пользователь средней сообразительности,
         * поэтому если в данном диапазоне совершенных чисел нет, об этом не
         * помешает сообщить.
         */

        List<Integer> lstNumbers = new ArrayList<Integer>();
        int[] arrNumbers;

        int sum = 0;
        boolean presentPerfect = false;
        for (int number = a; number < b; number++) {
            for (int j = number - 1; j > 0; j--) {
                if ((double) number / j == number / j) {
                    sum += j;
                }
            }
            if (sum == number) {
                presentPerfect = true;
                lstNumbers.add(number);
            }
            sum = 0;
        }

        arrNumbers = new int[lstNumbers.size()];
        for (int i = 0; i < lstNumbers.size(); i++) {
            arrNumbers[i] = lstNumbers.get(i);
        }

        return arrNumbers;
    }

    public String[] removeWord(String[] strs, String word) {
        /**
         * Удаление слова. #java Дан массив строк. Удалите из текста все
         * вхождения заданного слова. И выведите обновленный текст. Пустые
         * строки не выводите. Если в результате удаления весь текст состоит из
         * пустых строк - вывести, что выводить нечего.
         */

        String str;
        String[] strsResult;
        List<String> strList = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            str = strs[i].replace(word, "");
            if (!str.isEmpty()) {
                strList.add(str);
            }
        }

        strsResult = new String[strList.size()];
        int i = 0;
        for (String strElement : strList) {
            strsResult[i] = strElement;
            System.out.println(strsResult[i] + " ");
            i++;
        }

        return strsResult;
    }

    // NOT DONE YET
    public int computeDistanceBtwnDotAndLnSegment() {
        /**
         * Расстояние от точки до отрезка. #java Ввиду того, что задачу про
         * расстояние от треугольника до окружности никто решать не стал (как,
         * впрочем, и все остальные задачи группы) предлагаю облегченную версию.
         * Даны координаты точки M, Координаты начала отрезка (точка А) и конца
         * отрезка (точка В). Найти кратчайшее расстояние от точки до отрезка
         * (не стоит путать с прямой).
         */
        return 1;
    }

    public int[] fragmentNumber(long number) {

        double divResult = 0;
        List<Integer> lstNumbers = new ArrayList<>();
        int[] arrNumbers;

        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            divResult = (double) number / i;

            if (divResult == Math.round(divResult)) {
                lstNumbers.add(i);
                number = (long) divResult;
                i--;
            }
            if (divResult == 1) {
                break;
            }
        }

        arrNumbers = new int[lstNumbers.size()];
        for (int i = 0; i < lstNumbers.size(); i++) {
            arrNumbers[i] = lstNumbers.get(i);
        }
        return arrNumbers;

    }

    /**
     * Рисование пирамиды в матрице. #javaProblems Напишите программу, которая
     * будет рисовать максимально возможную пирамиду из единичек в данном
     * двумерном массиве mass NxM, заполненном нулями. Расположение основания
     * пирамиды и размеры матрицы задаются пользователем: 1 - слева 2 - справа 3
     * - сверху 4 - снизу.
     */
    public void makePyramid(int width, int height, String side) {

        // Populating a 2d array with zeros.
        int arrInts[][] = Utils.populateArray(width, height, 0);
        int span = 0;
        int position = height;

        side = side.toLowerCase();
        if (side != "left"
                && side != "right"
                && side != "up"
                && side != "down") {
            side = "down";
        }

        switch (side.toLowerCase()) {
            case "left": {
                for (int i = 0; i < width; i++) {
                    for (int j = span / 2; j < height - span / 2; j++) {
                        arrInts[j][i] = 1;
                    }
                    span += 2;
                }
                break;
            }
            case "right": {
                for (int i = width - 1; i > 0; i--) {
                    for (int j = span / 2; j < height - span / 2; j++) {
                        arrInts[j][i] = 1;
                    }
                    span += 2;
                }
                break;
            }
            case "down": {
                for (int j = 0; j < height && span < width; j++) {
                    for (int i = span / 2; i < width - span / 2; i++) {
                        arrInts[height - j - 1][i] = 1;
                    }
                    span += 2;
                }
                break;
            }
            case "up": {
                for (int j = height - 1; j > -1 && span < width; j--) {
                    for (int i = span / 2; i < width - span / 2; i++) {
                        arrInts[height - j - 1][i] = 1;
                    }
                    span += 2;
                }
                break;
            }
        }

        Utils.printArray(arrInts);
    }

    // Turning number to an array of digits of int type.
    public int[] numberToDigitsArray(int number) {

        String string = Integer.toString(number);
        int[] ints = new int[string.length()];
        int i = 0;
        for (char ch : string.toCharArray()) {
            ints[i] = Character.getNumericValue(ch);
            i++;
        }
        return ints;
    }

    // https://vk.com/java_problems?w=wall-60560229_1080
    public int computeRecharge(int amount) {
        // Recharge - пополнение баланса.
        /**
         * Банковский перевод #Java #Pascal #php #JavaScript
         Банк берет комиссию за перевод по принципу - с каждой сотни рублей изымается комиссия - 7 рублей. За неполную
         сотню также изымается 7 рублей. К примеру, за перевод одного рубля придется выложить 1 + 7 = 8 рублей.
         За перевод 101 рубля придется выложить уже 100 + 7 + 1 + 7 = 115 рублей

         Пользователь вводит сумму, которую хочет перевести, а программа должна определить:
         1. Максимально возможную сумму перевода (с учетом, что комиссия за перевод будет браться из переводимой суммы).
         2. Комиссию за данный перевод.

         1. Узнать сколько там сотен.
         2.

         */
        int chargePerHundred = 7;
        int charged;
        int fullCharges; // How many 100 + chargePerHundred.
        System.out.println("User tries to deposit: " + amount);
        if (amount < chargePerHundred + 1) {
            System.out.println("Amount cannot be deposited.");
            return 0;
        } else {
            fullCharges = (int) amount / (100 + chargePerHundred);
            // How much charged for full charges;
            charged = fullCharges * chargePerHundred;
            System.out.println("There are " + fullCharges + " of "
                    + (100 + chargePerHundred) + " = "
                    + (100 + chargePerHundred) * fullCharges);
            amount -= fullCharges * (100 + chargePerHundred);
            System.out.println("Leftover is: " + amount);
            if (amount <= chargePerHundred) {
                System.out.println("Leftover of " + amount + " is returned to payer.");
                System.out.println("Amount deposited: " + (fullCharges * 100));
                System.out.println("Amount charged: " + charged);
                return fullCharges * 100;
            } else {
                amount -= chargePerHundred;
                charged += chargePerHundred;
            }
            System.out.println("Amount charged: " + charged);
            System.out.println("Amount deposited: " + (fullCharges * 100 + amount));
            return fullCharges * 100 + amount;
        }

    }
}

/**
 * Ход конем. У вас есть шахматная доска N*N клеток. На доске находится конь. И
 * клетки с дырками, куда ходить конь не может. Определите, можно ли дойти от
 * точки А до точки Б. Если можно, то покажите путь на самом поле. Входные
 * данные. Размер поля. Координаты точки А и Б. Координаты клеток, по которым
 * конь ходить не может.
 * <p>
 * Выходные данные Отрисованное поле с обозначением пути от А до Б. Или слово
 * НЕВОЗМОЖНО. Если конем нельзя добраться из А в Б
 * <p>
 * TO BE DONE.
 *
 * @author Влад
 */
class HorseTurn {

    String[][] field;

    HorseTurn(int x, int y) {
        field = new String[x][y];
    }
}

/**
 * Имеется арифметическое выражение сколь угодно большой длины. Пример:
 * 4+6/2-5*41 Задача - свернуть выражение в одно число, то есть проделать все
 * действия в соответствии приоритетами операций.
 * <p>
 * Модификация легкого уровня: В выражении можно использовать дробные числа.
 * Модификация среднего уровня: В выражении можно использовать числа сколь
 * угодно большие или маленькие. Модификация высокого уровня: В выражении можно
 * использовать скобки для явной расстановки приоритетов, а также указывать
 * степень числа в формате число^степень или число^(число<операция>число).
 * Модификация высшего уровня: В выражении можно использовать числа, записанные
 * в экспоненциальной форме.
 *
 * @author Влад
 */
//class SolveExpression {
//
//    Jep jep;
//
//    public SolveExpression() {
//        jep = new Jep();
//        System.out.println(solveExpression());
//    }
//
//    /**
//     * This class uses a separate library. Link is below. *
//     * http://www.singularsys.com/jep/download-trial.php
//     */
//    Object solveExpression() {
//        Object result;
//        try {
//            jep.parse("4+12/4-10.3");
//            try {
//                result = jep.evaluate();
//                return result;
//            } catch (EvaluationException ex) {
//                System.out.println("Evaluation failed.");
//            }
//        } catch (com.singularsys.jep.ParseException ex) {
//            System.out.println("Parsing failed.");
//        }
//        return null;
//    }
//}

class replaceBadWords {

    Set<String> setBadWords;
    String currentString;

    public replaceBadWords(String strInitial) {
        setBadWords = new HashSet<>();
        populateBadWords(setBadWords);
        System.out.println(strInitial);
        System.out.println(replaceBadWords2(strInitial, setBadWords));
    }

    void populateBadWords(Set setBadWords) {
        setBadWords.add("дурак");
        setBadWords.add("тварь");
        setBadWords.add("чмо");
        setBadWords.add("упырь");
        setBadWords.add("обмудок");
    }

    /**
     * Very simple solution - doesn't check if there are any surrounding
     * characters.
     *
     * @param row
     * @param badWords
     * @return
     */
    String replaceBadWords(String row, Set badWords) {
//        List<String> arrRows = new ArrayList<>();
        List<String> lstWords = Arrays.asList(row.split("[ ]"));
//        [ \\w\\s . ,]
        Iterator iterator = lstWords.iterator();
        String asterisk = "";
        String result = "";
        while (iterator.hasNext()) {
            currentString = (String) iterator.next();
//            System.out.println("|" + currentString + "|");
            if (badWords.contains(currentString.toLowerCase())) {
                for (int i = 0; i < currentString.length(); i++) {
                    asterisk += "*";
                }
                result += asterisk + " ";
                asterisk = "";
            } else {
                if (currentString.isEmpty()) {
//                    result = result.subSequence(0, result.length() - 1) + ", ";
                    result += currentString;
                } else {
                    result += currentString + " ";
                }
            }
        }
        return result;
    }

    // Correct one.
    // Strings only used.
    String replaceBadWords2(String row, Set badWords) {

        int position = 0;
        int index = 0;
        String asterisk = "";
        String result = null;
        String strBadWord;

        for (Object badWord : badWords) {
            strBadWord = (String) badWord;
            position = 0;
            index = 0;
            while (position != -1) {
                position = row.toLowerCase().indexOf(strBadWord, index);
                index = position + 1;
                if (position == -1) {
                    break;
                } else {
                    for (int i = 0; i < strBadWord.length(); i++) {
                        asterisk += "*";
                    }
//                    asterisk += " ";
                    result = row.replace(strBadWord, asterisk);
                    asterisk = "";
                    row = result;
                }
            }
        }
        return result;
    }

    // Correct one.
    // StringBuilder is used.
    String replaceBadWords3(String row, Set badWords) {

        String word;
        int position = 0;
        int index = 0;
        String asterisk = "";
        StringBuilder stringBuilder = new StringBuilder(row.toLowerCase());

        for (Iterator iterator = badWords.iterator(); iterator.hasNext(); ) {
            word = (String) iterator.next();
            position = 0;
            while (position != -1) {
                position = stringBuilder.indexOf(word, index);
                index = position + 1;
                if (position != -1) {
                    for (int i = 0; i < word.length(); i++) {
                        asterisk += "*";
                    }
                    stringBuilder.delete(position, position + word.length());
                    stringBuilder.insert(position, asterisk, 0,
                            asterisk.length());
                    position = 0;
                    asterisk = "";
                }
            }
        }
        return stringBuilder.toString();
    }
}

class BeginnersTasks2 {

    //    https://acmp.ru/?main=tasks
    String filesPath = "user/files/";

    // https://acmp.ru/?main=task&id_task=1
    void sumAandB() throws Exception {

        // Is catching an exception and rethrowing it again is ok ?

        long a = 0;
        long b = 0;
        String[] strings;

        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(filesPath + "/input.txt"));
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File " + filesPath + "/input.txt"
                    + " does not exist.");
        }

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(
                    new FileWriter(filesPath + "/output.txt"));
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File " + filesPath + "/output.txt"
                    + " does not exist.");
        }
        if (fileReader == null) {
            throw new IOException("File reader is null.");
        }
        if (bufferedWriter == null) {
            throw new IOException("File writer is null.");
        }

        try {
            // Splitting what's been read into words.
            strings = fileReader.readLine().split("[ ]");
        } catch (NullPointerException npe) {
            throw new NullPointerException("Nothing is present in a file.");
        }
//        Utils.printArr(strings);
        try {
            a = Integer.parseInt(strings[0]);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("First summand is not a number.");
        }
        if (a > 10e9) {
            throw new NumberFormatException("First summand is more than 10e9.");
        }
        if (b > 10e9) {
            throw new NumberFormatException("Second summand is more than 10e9.");
        }
        if (strings.length < 2) {
            throw new Exception("There is no second summand.");
        }
        try {
            b = Integer.parseInt(strings[1]);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("Second summand is not a number.");
        }
        if (strings.length > 2) {
            System.out.println("More than 2 summands present.");
        }

        BigDecimal bigDecimal = new BigDecimal(a + b);
        bufferedWriter.write(bigDecimal.toString());

        // Closing streams.
        if (fileReader != null) {
            try {
                fileReader.close();
            } catch (IOException ioe) {
                System.out.println("fileReader cannot be closed.");
            }
        }
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException ioe) {
                System.out.println("bufferedWriter cannot be closed.");
            }
        }

        System.out.println("Addition is performed successfully, check the output file.");

    }

    void multiplyAandAEndingWith5() throws Exception {

        String[] strings;

        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new FileReader(filesPath + "/input.txt"));
        BufferedWriter bufferedWriter = null;
        bufferedWriter = new BufferedWriter(new FileWriter(filesPath + "/output.txt"));

        strings = bufferedReader.readLine().split("[ ]");

        if (strings.length > 1) {
            System.out.println("There is more than one lexem.");
        }

        if (strings.length == 0) {
            throw new Exception("No any lexem present in a file.");
        }

        int i = Integer.parseInt(strings[0]);
        if (i > 4 * 10e5) {
            throw new NumberFormatException("Number is greater than 4 * 10e5");
        }

        // If a last letter is 5,
        if (strings[0].lastIndexOf("5") == strings[0].length() - 1) {
            // Putting all the digits, except the last one.
            i = Integer.parseInt(strings[0].substring(0, strings[0].length() - 1));
            i = i * ++i;
            strings[0] = Integer.toString(i) + "25";
            bufferedWriter.write(strings[0]);
        }

        // Closing streams.
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException ioe) {
                System.out.println("fileReader cannot be closed.");
            }
        }
        if (bufferedWriter != null) {
            try {
                bufferedWriter.close();
            } catch (IOException ioe) {
                System.out.println("bufferedWriter cannot be closed.");
            }
        }

    }

}
