/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.sorts;

/**
 *
 * @author v.yanchenko
 */
public class AllSorts {

    Bubble oBubble;
    Cocktail oCocktail;
    Gnome oGnome;
    Insertion oInsertion;
    Selection oSelection;
    SortsHandler oSortsHandler = new SortsHandler();

    // Bad method. Improve it.
    public AllSorts() {
        oBubble = new Bubble();
        oSortsHandler.populateData(oBubble);
        System.out.print("Initial data:  ");
        oSortsHandler.printArray(oBubble.getArrayInitial());
        System.out.println("");
        oSortsHandler.showSortData(oBubble);
        
        oCocktail = new Cocktail(oBubble.getArrayInitial());
        oSortsHandler.showSortData(oCocktail);
        
        oGnome = new Gnome(oBubble.getArrayInitial());
        oSortsHandler.showSortData(oGnome);
        
        oInsertion = new Insertion(oBubble.getArrayInitial());
        oSortsHandler.showSortData(oInsertion);
        
        oSelection = new Selection(oBubble.getArrayInitial());
        oSortsHandler.showSortData(oSelection);
    }
}
