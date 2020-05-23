/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

/**
 *
 * @author Влад
 *
 * To be done
 */
public class Merge extends AbstractSort implements Sort {

    @Override
    public void performSort(SortsHandler data) {
        int j = 0;
        for (int i = 0; i < getArrayInitial().length; i++) {
            for (j = 0; j < getArrayInitial().length - 1; j++) {
                if (getArrayInitial()[j] > getArrayInitial()[j + 1]) {
                    data.swap(this, j, j + 1);
                }
            }
        }

    }

}
