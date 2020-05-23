/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

/**
 *
 * @author v.yanchenko
 */
public class TernaryOperator {

    public void ternaryOperator() {
        String result = (0 < 1)
                ? "0<1"     // This statement fires if the condition is true 
                : "0>1";    // This statement fires if the condition is false
        System.out.println(result);
    }
    
    public TernaryOperator() {
        ternaryOperator();
    }
    
}
