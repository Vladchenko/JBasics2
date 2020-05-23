/*
 * This class holds the data to be sorted
 */
package ru.jbasics.sorts;

/**
 *
 * @author Влад
 */
public class SortsHandler {

    private int temp = 0;

    // Defines if a sort to be in ascending or a descending order.
    public enum sortKind {

        ascending, descending
    };
    public sortKind oSortKind = sortKind.ascending;

    // Defines a type of a sort to be.
    public enum PopulatedDataKind {

        random, ascending, descending
    };
    public PopulatedDataKind oPopulatedDataKind = PopulatedDataKind.random;

    public void SortsHandler() {
    }

    /**
     * Populating an array before performing a sort. There are 3 kinds of
     * population - random, ascending, descending.
     */
    public void populateData(AbstractSort srt) {

        for (int i = 0; i < srt.getArrayInitial().length; i++) {
            if (srt.oPopulatedDataKind.equals(
                    srt.oPopulatedDataKind.random)) {
                srt.getArrayInitial()[i] = (int) (Math.random()
                        * srt.getNumbersQuantity());
            }
            if (srt.oPopulatedDataKind.equals(PopulatedDataKind.ascending)) {
                srt.getArrayInitial()[i] = i;
            }
            if (srt.oPopulatedDataKind.equals(PopulatedDataKind.descending)) {
                srt.getArrayInitial()[i] = srt.getNumbersQuantity() - i;
            }
            srt.getArraySorted()[i] = srt.getArrayInitial()[i];
        }
    }

    // Printing contents of an array
    public void printArray(int[] arrayInts) {
        for (int i : arrayInts) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Replacing two cells of an array
    public void swap(AbstractSort srt, int value1, int value2) {
        temp = srt.getArraySorted()[value1];
        srt.getArraySorted()[value1] = srt.getArraySorted()[value2];
        srt.getArraySorted()[value2] = temp;
        srt.setReplacements(srt.getReplacements() + 1);
    }

    /**
     * Returns an array to its initial state (i.e. the one initialized before
     * performing a sort), puts iterations and replacements to 0 also.
     */
    void makeArrayDefault(AbstractSort srt) {
        System.arraycopy(srt.getArrayInitial(), 0, srt.getArraySorted(), 0,
                srt.getArrayInitial().length);
        srt.setIterations(0);
        srt.setReplacements(0);
    }

    // Prints all data about a sort
    public void showAllSortData(AbstractSort srt) {
        System.out.println(srt.getClass().getSimpleName() + " sort:");
        System.out.print("  Initial array: ");
        this.populateData(srt);
        printArray(srt.getArrayInitial());
        srt.performSort(this);
        System.out.print("  Sorted array: ");
        printArray(srt.getArraySorted());
        System.out.println("Iterations: " + srt.getIterations() + " out of "
                + (srt.getNumbersQuantity() * (srt.getNumbersQuantity() - 1))
                + " possible");
        System.out.println("Replacements: " + srt.getReplacements());
        makeArrayDefault(srt);
    }

    // Prints sort data, with no random numbers shown and slight format change
    public void showSortData(AbstractSort srt) {
        System.out.print(srt.getClass().getSimpleName() + " sort:  ");
        srt.performSort(this);
        printArray(srt.getArraySorted());
        System.out.print("   Iterations: " + srt.getIterations() + " out of "
                + (srt.getNumbersQuantity() * (srt.getNumbersQuantity() - 1)) + " possible.  ");
        System.out.println("Replacements: " + srt.getReplacements());
        makeArrayDefault(srt);
//        printArray(srt.getArrayInitial());
//        printArray(srt.getArraySorted());
    }
    
    //    //<editor-fold defaultstate="collapsed" desc="Getters & Setters">
//    public int[] getArrayInitial() {
//        return arrayInitial;
//    }
//
//    public void setArrayInitial(int[] arrayInitial) {
//        this.arrayInitial = arrayInitial;
//    }
//
//    public int[] getArraySorted() {
//        return arraySorted;
//    }
//
//    public void setArraySorted(int[] arraySorted) {
//        this.arraySorted = arraySorted;
//    }
//
//    public void setoSortKind(sortKind oSortKind) {
//        this.oSortKind = oSortKind;
//    }
//
//    /**
//     * @return the numbersData
//     */
//    public int getNumbersData() {
//        return numbersQuantity;
//    }
//
//    /**
//     * @param numbersData the numbersData to set
//     */
//    public void setNumbersData(int numbersData) {
//        this.numbersQuantity = numbersData;
//    }
//
//    /**
//     * @return the iterations
//     */
//    public int getIterations() {
//        return iterations;
//    }
//
//    /**
//     * @param iterations the iterations to set
//     */
//    public void setIterations(int iterations) {
//        this.iterations = iterations;
//    }
//
//    /**
//     * @return the replacements
//     */
//    public int getReplacements() {
//        return replacements;
//    }
//
//    /**
//     * @param replacements the replacements to set
//     */
//    public void setReplacements(int replacements) {
//        this.replacements = replacements;
//    }
//    //</editor-fold>
}
