/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

/**
 *
 * @author Влад
 */
public class Bubble extends AbstractSort implements Sort {

    public Bubble() {
        
    }
    
    public Bubble(int[] array) {
        System.arraycopy(array, 0, this.getArrayInitial(), 0, array.length);
        System.arraycopy(array, 0, this.getArraySorted(), 0, array.length);
    }
    
    @Override
    public void performSort(SortsHandler sh1) {
        
        int j = 0;
        for (int i = 0; i < getArraySorted().length; i++) {
            if (j > 0 && getReplacementsInOnePass() == 0) {
//                System.out.println("Sort has been performed earlier");
                return;
            }
            setReplacementsInOnePass(0);
            for (j = 0; j < getArraySorted().length - 1; j++) {
                setIterations(getIterations() + 1);
                if (oSortKind.equals(sortKind.ascending)) {
                    if (getArraySorted()[j] > getArraySorted()[j + 1]) {
                        sh1.swap(this, j, j + 1);
                        setReplacementsInOnePass(getReplacementsInOnePass() + 1);
                    }
                }
                if (oSortKind.equals(sortKind.descending)) {
                    if (getArraySorted()[j] < getArraySorted()[j + 1]) {
                        sh1.swap(this, j, j + 1);
                        setReplacementsInOnePass(getReplacementsInOnePass() + 1);
                    }
                }
            }
        }

    }

}
