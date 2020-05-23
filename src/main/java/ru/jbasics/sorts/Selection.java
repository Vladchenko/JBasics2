/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

/**
 *
 * @author Влад
 */
public class Selection extends AbstractSort implements Sort {
    
    int min = Integer.MAX_VALUE;
    int minIndex;
    
    public Selection() {
        
    }
    
    public Selection(int[] array) {
        System.arraycopy(array, 0, this.getArrayInitial(), 0, array.length);
        System.arraycopy(array, 0, this.getArraySorted(), 0, array.length);
    }     

    @Override
    public void performSort(SortsHandler sh1) {


        minIndex = getArraySorted().length;
        int j;
        for (int i = 0; i < getArraySorted().length - 1; i++) {
            if (oSortKind.equals(sortKind.ascending)) {
                min = Integer.MAX_VALUE;
            }
            if (oSortKind.equals(sortKind.descending)) {
                min = Integer.MIN_VALUE;
            }
            for (j = i; j < getArraySorted().length; j++) {
                setIterations(getIterations() + 1);
                if (oSortKind.equals(sortKind.ascending)) {
                    if (min > getArraySorted()[j]) {
                        min = getArraySorted()[j];
                        minIndex = j;
                    }
                }
                if (oSortKind.equals(sortKind.descending)) {
                    if (min < getArraySorted()[j]) {
                        min = getArraySorted()[j];
                        minIndex = j;
                    }
                }
            }
            if (i != minIndex) {
                setReplacements(
                        getReplacements() + 1);
                sh1.swap(this, i, minIndex);
            }
        }
    }

}
