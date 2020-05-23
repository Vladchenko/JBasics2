/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.java.util;

import java.util.*;

/**
 *
 * @author Vlad
 */
public class Maps {

    private String value;
    private Integer key = 21;
    
    // Possible declarations
    private HashMap<Integer, String> map1 = new HashMap<Integer, String>();
    private HashMap<Integer, String> map1_1 = new HashMap<>();
    private Map<Integer, String> map1_2 = new HashMap<Integer, String>();
    private Map<Integer, String> map1_3 = new HashMap<>();
    private Map map1_4 = new HashMap<>();
    private Map map1_5 = new HashMap();
    private Map map1_6 = new HashMap(map1);
    
    private Map lhmap1 = new LinkedHashMap();
    private Map treeMap1 = new TreeMap();
    private Map sortedMap1 = new SortedMap() {
        @Override
        public Comparator comparator() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public SortedMap subMap(Object fromKey, Object toKey) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public SortedMap headMap(Object toKey) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public SortedMap tailMap(Object fromKey) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object firstKey() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object lastKey() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Set keySet() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Collection values() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Set entrySet() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int size() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean isEmpty() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean containsKey(Object key) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean containsValue(Object value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object get(Object key) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object put(Object key, Object value) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object remove(Object key) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void putAll(Map m) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
    private Map idhmap1 = new IdentityHashMap() {};
    
    Iterator<Integer> keySetIterator;
    private boolean isEmpty = map1.isEmpty();

    public Maps() {

//        showBasicOperations();
        comparison();

    }

    // Populating a map
    public Map populateMaps(Map mp) {
        mp.put(21, "Twenty One");
        mp.put(41, "Forty One");
        mp.put(31, "Thirty One");
        mp.put(11, "Eleven");
        mp.put(51, "Fifty One");
        mp.put(41, "Ninety One");
        return mp;
    }

    // Printing a map
    public void printMap(Map mp) {
        System.out.println("-- Printing a map:");
        // Getting an iterator of a map for further traversing through map
        keySetIterator = mp.keySet().iterator();
        // Traversing through map
        while (keySetIterator.hasNext()) {
            Integer key = keySetIterator.next();
            System.out.println("  key: " + key
                    + " value: " + mp.get(key));
        }
    }
    
    public void showBasicOperations() {

        map1_5 = populateMaps(map1_5);

        //* Following row will throw compiler error because 21.0 is not integer
//        map.put(21.0, "Twenty One");

        // Getting a value from a map using a key
        value = map1.get(key);
        
        // Next statement doesn't work
//        value = map1_5.get(key);

        // Printing some map element
        System.out.println("Key: " + key + " value: " + value + "\n");
        
        System.out.println("\nIs HashMap is empty: " + map1_5.isEmpty());

        System.out.println("\nDoes HashMap contain 21 as key: "
                + map1_5.containsKey(21));
        System.out.println("Does HashMap contain 21 as value: "
                + map1_5.containsValue(21));
        System.out.println("Does HashMap contain Twenty One as value: "
                + map1_5.containsValue("Twenty One"));

        // Printing a map
        printMap(map1_5);
        
        // Removing some element from a map
        Object value = map1_5.remove(key);
        System.out.println("\nFollowing value is removed from Map: " + value);
        printMap(map1_5);

        System.out.println("\nSize of Map: " + map1_5.size());
        map1_5.clear(); //clears hashmap , removes all element
        System.out.println("Size of Map: " + map1_5.size());

    }
    
    public void comparison() {
        lhmap1 = populateMaps(lhmap1);
        map1_5 = populateMaps(map1_5);
        treeMap1 = populateMaps(treeMap1);
        idhmap1 = populateMaps(idhmap1);
        printMap(map1_5);
        printMap(lhmap1);
        printMap(treeMap1);
        printMap(idhmap1);
    }
}
