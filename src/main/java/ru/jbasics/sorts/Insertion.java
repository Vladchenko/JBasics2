/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

import java.util.Date;

/**
 *
 * @author Влад
 *
 * This class serves to be a template for a further sorts development
 */
public class Insertion extends AbstractSort implements Sort {

    /**
     * Having taken a quick look, it is clear that 2nd sort does less
     * operations, at least in 1 for each for loop, sometimes 2
     */
    private long beginTime = (new Date()).getTime();
    private long endTime = (new Date()).getTime();
    
    public Insertion() {
        
    }
    
    public Insertion(int[] array) {
        System.arraycopy(array, 0, this.getArrayInitial(), 0, array.length);
        System.arraycopy(array, 0, this.getArraySorted(), 0, array.length);
    }     

    @Override
    public void performSort(SortsHandler sh1) {
        
        int temp, pos = 0;
//        beginTime = (new Date()).getTime();

        /**
         * Following sort algorythm is taken from:
         * http://habrahabr.ru/post/181271/
         */
        for (int i = 1; i < getArraySorted().length; i++) {
            for (int j = i;
                    j > 0
                    && getArraySorted()[j - 1] > getArraySorted()[j];
                    j--) {
                sh1.swap(this, j - 1, j);
            }
        }

//        endTime = (new Date()).getTime();
//        System.out.println("Time elapsed " + (endTime - beginTime) + " ");
//        makeArrayDefault();
//        beginTime = (new Date()).getTime();
        // This one is done by me personally
//        for (int i = 1; i < getArraySorted().length; i++) {
//            pos = -1;
//            temp = getArraySorted()[i];
//            for (int j = i - 1; j >= 0; j--) {
//                if (getArraySorted()[j] > temp) {
//                    getArraySorted()[j + 1] = getArraySorted()[j];
//                    pos = j;
//                } else {
//                    break;
//                }
//            }
//            if (pos > -1) {
//                getArraySorted()[pos] = temp;
//            }
//        }
//        endTime = (new Date()).getTime();
//        System.out.println("Time elapsed " + (endTime - beginTime) + " ");
    }
}
