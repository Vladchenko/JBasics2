/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.languagespecific;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author v.yanchenko
 */
public class ImplementComparable {
    
    int iPlanets = 10;
    List<Planet> planets = new ArrayList<Planet>();
    
    public ImplementComparable() {
        populatePlanets(planets);
        processPlanets();
    }
    
    public void populatePlanets(List<Planet> planets) {
        for (int i = 0; i < iPlanets; i++) {
            planets.add(new Planet());
        }
    }
    
    public void printPlanets() {
        for (Planet planet : planets) {
            System.out.print(planet.size + " ");
        }
    }
    
    public void processPlanets() {
        System.out.print("Unsorted: ");
        printPlanets();
        Collections.sort(planets);
        System.out.println("");
        System.out.print("Sorted: ");
        printPlanets();
    }
}

class Planet implements Comparable {
    
    int size;
    
    public Planet() {
        this.size = (int)(Math.random() * 1000);
    }

    @Override
    public int compareTo(Object o) {
        
        Planet planet = (Planet)o;
        if (this.size == planet.size) {
            return 0;
        }
        if (this.size > planet.size) {
            return 1;
        } else {
            return -1;
        }
        
    }
}
