/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

/**
 *
 * @author Влад
 */
public class CuriousCode {

//    https://habrahabr.ru/post/111189/
    
    public CuriousCode(int[] outer, int[] inner) {
        System.out.println(linearIn(outer, inner));
//        new Main().$_$();
    }

    // Find a sequence
    public boolean linearIn(int[] outer, int[] inner) {
        int j = 0;
        int sum = 0;
        if (inner.length == 0) {
            return true;
        }
        for (int i = 0; i < outer.length; i++) {
            System.out.println("i=" + i + " j=" + j + " outer[i]=" + outer[i]
                    + " inner[j]=" + inner[j] + " sum=" + sum);
            if (outer[i] == inner[j]) {
                sum++;
                j++;
            } else {
                if (sum > 0) {
                    i--;
                }
                sum = 0;
                j = 0;
            }
            if (sum == inner.length) {
                return true;
            }
            System.out.println("i=" + i + " j=" + j + " outer[i]=" + outer[i]
                    + " inner[j]=" + inner[j] + " sum=" + sum);
            System.out.println("");
        }
        return false;
    }

}

// Such class works saying 0.
/*
 Первое, что бросается в глаза — это использование точек с запятой там, где их 
 можно не использовать. Например после объявления класса (как в С++). Или же 
 между членами класса. Зачем компилятор дал возможность ставить их там — я так 
 и не выяснил. Но это вполне допустимо.

 Имя метода — вполне допустимый идентификатор. А вот возвращаемый тип здесь 
 не short а массив из short. Компилятор разрешает 2 формы объявления массива 
 — квадратные скобки до идентификатора и после. Причём первый случай 
 предназначен как-раз для метода. А что если попробовать второй случай для 
 метода? Он тоже корректен, но выглядит ужасно, поэтому никогда не используйте 
 его в реальных проектах. Но такая возможность есть.
 */
class Main {;
    public static void main(String[] args) {
        System.out.println(new Main().$_$()[2]);
    }

    ;short $_$()[] {{{
        return new short[007];
    }}};
};