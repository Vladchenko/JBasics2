/*
 * To change data template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

/**
 *
 * @author Влад
 */
public class Cocktail extends AbstractSort implements Sort {

    public Cocktail() {
        
    }
    
    public Cocktail(int[] array) {
        System.arraycopy(array, 0, this.getArrayInitial(), 0, array.length);
        System.arraycopy(array, 0, this.getArraySorted(), 0, array.length);
    }    
    
    @Override
    public void performSort(SortsHandler sh1) {

        int j = 0;
        int step1 = 0;
        int step2 = 1;
        for (int i = 0; i < getArraySorted().length; i++) {
            if (j > 0 && getReplacementsInOnePass() == 0) {
                return;
            }
            setReplacementsInOnePass(0);
            if (i % 2 == 0) {
                for (j = step1; j < getArraySorted().length - step1 - 1; j++) {
                    setIterations(getIterations() + 1);
                    if (oSortKind.equals(sortKind.ascending)) {
                        if (getArraySorted()[j] > getArraySorted()[j + 1]) {
                            sh1.swap(this, j, j + 1);
                            setReplacementsInOnePass(
                                    getReplacementsInOnePass() + 1);
                        }
                    }
                    if (oSortKind.equals(sortKind.descending)) {
                        if (getArraySorted()[j] < getArraySorted()[j + 1]) {
                            sh1.swap(this, j, j + 1);
                            setReplacementsInOnePass(
                                    getReplacementsInOnePass() + 1);
                        }
                    }
                }
                step1++;
            } else { // else for i % 2 == 0 
                for (j = getArraySorted().length - step2; j > step2 - 1; j--) {
                    setIterations(getIterations() + 1);
                    if (oSortKind.equals(sortKind.ascending)) {
                        if (getArraySorted()[j] < getArraySorted()[j - 1]) {
                            sh1.swap(this, j, j - 1);
                            setReplacementsInOnePass(
                                    getReplacementsInOnePass() + 1);
                        }
                    }
                    if (oSortKind.equals(sortKind.descending)) {
                        if (getArraySorted()[j] > getArraySorted()[j - 1]) {
                            sh1.swap(this, j, j - 1);
                            setReplacementsInOnePass(
                                    getReplacementsInOnePass() + 1);
                        }
                    }
                }
                step2++;
            }
        }

    }
}
