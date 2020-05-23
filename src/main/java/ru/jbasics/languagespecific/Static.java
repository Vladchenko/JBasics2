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
class Static {

    static String name = "Himalaya";

    static Static getMountain() {
        System.out.println("Getting Name ");
        return null;
    }

    public static void main(String[] args) {
        // Here we get an access to a "name" field, because getMountain() 
        // stands for a class Static (seen by its return type). Therefore, 
        System.out.println(getMountain().name);
    }
}
