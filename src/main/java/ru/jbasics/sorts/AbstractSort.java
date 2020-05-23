/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

/**
 *
 * @author v.yanchenko
 */
public abstract class AbstractSort {

    private boolean populatedArray = false;
    private int iterations = 0;
    private int numbersQuantity = 50;
    private int replacements = 0;
    private int replacementsInOnePass = 0;
    private int[] arrayInitial = new int[numbersQuantity];
    private int[] arraySorted = new int[numbersQuantity];

    public enum sortKind {

        ascending, descending
    };
    public sortKind oSortKind = sortKind.ascending;

    public enum PopulatedDataKind {

        random, ascending, descending
    };
    public PopulatedDataKind oPopulatedDataKind = PopulatedDataKind.random;
    
    // To be overridden
    public abstract void performSort(SortsHandler sh);

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    public int getReplacements() {
        return replacements;
    }

    public void setReplacements(int replacements) {
        this.replacements = replacements;
    }

    public boolean isPopulatedArray() {
        return populatedArray;
    }

    public void setPopulatedArray(boolean populatedArray) {
        this.populatedArray = populatedArray;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }

    public int getNumbersQuantity() {
        return numbersQuantity;
    }

    public void setNumbersQuantity(int numbersQuantity) {
        this.numbersQuantity = numbersQuantity;
    }

    public int getReplacementsInOnePass() {
        return replacementsInOnePass;
    }

    public void setReplacementsInOnePass(int replacementsInOnePass) {
        this.replacementsInOnePass = replacementsInOnePass;
    }

    public int[] getArrayInitial() {
        return arrayInitial;
    }

    public void setArrayInitial(int[] arrayInitial) {
        this.arrayInitial = arrayInitial;
    }

    public int[] getArraySorted() {
        return arraySorted;
    }

    public void setArraySorted(int[] arraySorted) {
        this.arraySorted = arraySorted;
    }
    //</editor-fold>
}
