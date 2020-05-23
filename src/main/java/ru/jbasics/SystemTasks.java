/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics;

import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Влад
 */
public class SystemTasks {

    public SystemTasks() {

        //<editor-fold defaultstate="collapsed" desc="Checking some RAM info">
        System.out.println("Maximum memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
        System.out.println("Cleaning a RAM");
        System.gc();    // Garbage collector invoking
        System.gc();
        System.out.println("Maximum memory: " + Runtime.getRuntime().maxMemory());
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory());
        System.out.println("Free memory: " + Runtime.getRuntime().freeMemory());
        //</editor-fold>

        // Invoking a garbage collector
        System.gc();
        // Invoking a garbage collector in a slightly different way
        Runtime.getRuntime().gc();

        // Finalizes all the objects pending finalization
        System.runFinalization();
        
        System.out.println("Bytes free = " + Runtime.getRuntime().freeMemory());
        System.out.println("Kilobytes free = " + Runtime.getRuntime().freeMemory() / 1024);
        System.out.println("Megabytes free = " + Runtime.getRuntime().freeMemory() / 1024 / 1024);
        
        System.out.println(ClassLoader.getSystemClassLoader().hashCode());
        System.out.println(Compiler.class.getCanonicalName());
        
        Properties properties = System.getProperties();
        System.out.println("\n\tSystem properties are:");
        for (Map.Entry<Object, Object> entrySet : properties.entrySet()) {
            Object key = entrySet.getKey();
            Object value = entrySet.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }
    }

}
