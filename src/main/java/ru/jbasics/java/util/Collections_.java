package ru.jbasics.java.util;

import ru.Utils;

import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Demonstration of Collections (lists, arrays, sets).
 * This class doesn't look neat and not all the operations are present.
 * Maybe in some future it will become thorough.
 *
 * @author Vladislav Yanchenko
 */
public class Collections_ {

    // java.util.Map is present in a different class named Maps.java
    private position pos;
    private int width = 5;
    private int height = 5;
    private int length = 10;
    private int arrayLength = 5;
    private String[] strs;

    enum position {
        START, MIDDLE, END
    }

    public Collections_() {
//        staticArrayOperating();
//        printSet(set3);
//        dynamicArrayListOperating();
//        dynamicArrayListOperating();
//        populateSet(set);
//        printSet(set);
//        removeFromSet(set);
//        printSet(set);
//
//        System.out.println("ArrayList");
//        
//        showTimings(lst1);
//        System.out.println();
//        
//        System.out.println("LinkedList");
//        showTimings(lst2);
//        populateList(lst1);
//        traverseList(lst1);
    }

    //<editor-fold defaultstate="collapsed" desc="Static size arrays">
    public void staticArrayOperating() {

        /*
         * Following row makes a five-element array referring to an arrays of ten
         * objects of type "char". This statement does NOT allocate memory for any
         * "char" objects. Accessing an undefined array element causes a runtime
         * exception called ArrayIndexOutOfBoundsException. Accessing a defined
         * array element that has not yet been assigned to an object results in a
         * runtime NullPointerException.
         */
        char[][] chars2dArray = new char[10][5];

//        int ints1[][] = new int[][];   // Array dimensions missing !
//        int ints2[][] = new int[][10];    // Array incorrect dimension !
        // Following declarations are allowed
        char chars2dArray2[][] = new char[10][];
        char[] chars2dArray3[] = new char[10][5];
        char[][] chars2dArray4 = new char[10][5];

        chars2dArray4[1] = new char[]{'1', '5', '9', '3'};
        System.out.println("chars4[0] = " + chars2dArray4[0]);
        System.out.println("chars4[1] = " + chars2dArray4[1]);
        System.out.println("chars4[0][0] = " + chars2dArray4[0][0]);
        System.out.println("chars4[1][0] = " + chars2dArray4[1][0]);

        // Aggregate initialization
        Object[] objectsArray = {
                new Point(120, 160),
                new String("123"),
                new Character('1')
        };
        // Following declaration is not allowed
//        String s[3];
        String[] stringsArray = new String[2];
        String[] stringsArray_[];
        String[][] stringsArray2 = new String[5][];
        // Following declaration fires "Array dimension missing"
//        String[] s = new String[];
        String[] stringsArray3 = new String[]{"q", "w", "e"}; // static initialization
        String[] stringsArray4 = {"q", "w", "e"}; // static initialization
        String string1 = "123";
        String string2 = "456";
        String[] stringsArray5 = new String[]{string1, string2};
        System.out.println(stringsArray5[0]);
        int[] arr = {3, 6, 3, 1, 9};    // static initialization
        arr = new int[]{1, 2};           // Different way of initialization
        int jj[] = {};   // equivalent to - new int[0]

        int[] intArray = new int[arrayLength];
        int[] intArray2 = {1, 2, 3, 4, 5};
        Integer[] intArray3 = new Integer[arrayLength];
        int[] intArray4 = new int[arrayLength];
        int[][] intArray5 = new int[arrayLength][arrayLength];

        /**
         * Array's index is only of an int type. Types like byte, short, char
         * can also be used, but will be upcasted to an int implicitly.
         */
        int temp = 0;
        byte i1 = 0;
        temp = intArray[i1];
        short i2 = 0;
        temp = intArray[i2];
        char i3 = 0;
        temp = intArray[i3];
        long i4 = 0;
        /**
         * Long cannot be cast to int implicitly, thus compiler triggers
         * "possibly lossy conversion from long to int" error and doesn't
         * compile.
         */
//        temp = intArray[i4];
        Object objectsArray2[] = new Object[3];
        Object[][] objectsArray3 = new Object[3][];
        objectsArray3[0] = new Integer[]{1, 2, 4};
        objectsArray3[1] = new String[]{"a", "b"};
        objectsArray3[2] = new Float[]{1.0f, 2.0f};
        /**
         * Next row triggers a runtime exception. An array index is negative,
         * some how compiler cannot check this in advance.
         */
        objectsArray2[-1] = new Object();
        objectsArray2[0] = new Object();
        objectsArray2[1] = null;
        // Array of "Object" can refer to itself, unlike of any other type.
        objectsArray2[2] = objectsArray2;

        Object objectsArray4[] = {1, null, new Object(), new Character('1'), "fwr"};
        // Initializing an earlier created array with some default values
        objectsArray4 = new Object[]{new String("!"), 5};

        // Initializing an earlier created array with some default values
        intArray = new int[]{4, 9, 34, 8, 0};

        // Following row provides a hashcode
        System.out.println("Hashcode for an Array4 is: " + intArray5);

        // One may use byte or short or char or int as an index type.
        // But not long.
        for (byte i = 0; i < 10; i++) {
        }

        System.out.println("Array1,Array2 values: ");
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 1000);
            intArray3[i] = new Integer(6);
            System.out.print(intArray[i] + "," + intArray3[i] + "  ");
        }
        System.out.println();
        System.out.println();

        //* Extra way of traversing an elements of array */
        System.out.println("Array1 values: ");
        for (int i : intArray) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println();

        //* Copying contents of an array to another array */
        System.out.println("Array3 length = " + intArray4.length);
        System.out.println("Array1(2,3) -> Array3: ");
        intArray4 = Arrays.copyOfRange(intArray, 2, 4);
        for (int i = 0; i < intArray4.length; i++) {
            System.out.print(intArray4[i] + " ");
        }
        System.out.println("Array3 length = " + intArray4.length);
        System.out.println();
        System.out.println();

        //* Assigning a values to 2d array and printing them */
        System.out.println("2d Array: ");
        for (int i = 0; i < intArray5.length; i++) {
            for (int j = 0; j < intArray5[i].length; j++) {
                intArray5[i][j] = (int) (Math.random() * 1000);
                System.out.print(intArray5[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // This is the way a  2d array-class(object) is instantiated
        Coordinates[][] objectArray;
        objectArray = new Coordinates[width][];
        for (int i = 0; i < objectArray.length; i++) {
            objectArray[i] = new Coordinates[height];
            for (int j = 0; j < objectArray[i].length; j++) {
                objectArray[i][j] = new Coordinates();
            }

        }

        // Assigning a values to 2d array-class and printing them
        System.out.println("2d array-class(object)");
        for (int i = 0; i < objectArray.length; i++) {
            for (int j = 0; j < objectArray[i].length; j++) {
                objectArray[i][j].x = (int) (Math.random() * 1000);
                objectArray[i][j].y = (int) (Math.random() * 1000);
                System.out.print("x=" + objectArray[i][j].x + " " + "y=" + objectArray[i][j].y + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void testArrayTraverse() {    // 872  //Why not 723 ?
        int arr[] = {5, 8, 7, 2, 3};
        for (int i = 1; i < arr.length - 1; ++i) {
            System.out.println(arr[i]);
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Dynamic size arrays, i.e. lists">
    private List<Integer> lst2 = new LinkedList<Integer>(); // One can omit type here
    // Parametrized list, with no type defined in right part.
    private List<String> lst2_2 = new ArrayList<>();
    // Immutable (cannot be modified) empty list
    private List<Double> lst3 = Collections.emptyList();
    // Collection is a predecessor of a List, so this is allowed
    private Collection<Float> lst5 = new Vector<>();
    // Statically populated list. Cannot be expandable.
    private List<Character> lst4 = Arrays.asList('1', '2', '3');
    // Statically populated list. Can be expanded !
    private List<Character> lst4_2 = new ArrayList<>(Arrays.asList('1', '2', '3'));

    // Another way of statically populated list
    private List<String> lst6 = new ArrayList<>() {
        {
            add("one");
            add("two");
            add("three");
        }
    };

    private List<Coordinates> lst8 = new ArrayList<>();
    private List<Coordinates> lst9 = new LinkedList<>();

    private class Coordinates {
        private int x;
        private int y;
    }

    public void dynamicArrayListOperating() {

        // Putting to "i" a value that is to be a size of a "lst1"
        int i = (int) (Math.random() * 5) + 5;
        // Populating a "lst1"
        while (i > 0) {
            lst8.add(new Coordinates());
            i--;
        }
        i = 0;
        // Printing a "lst1"
        while (i < lst8.size()) {
            System.out.println(lst8.get(i));
            i++;
        }
        System.out.println();
        // Adding more elements to "lst1"
        i = (int) (Math.random() * 3) + 1;
        while (i > 0) {
            lst8.add(new Coordinates());
            i--;
        }

        // Extra way of passing through an ArrayList
        System.out.println("Traversing through an ArrayList using Iterator");
        for (Iterator<Coordinates> it = lst8.iterator(); it.hasNext(); ) {
            Coordinates class1 = it.next();
            System.out.println(class1);
        }
        System.out.println();

        // Extra way of passing through an ArrayList
        System.out.println("Traversing through an ArrayList using ListIterator");
        for (ListIterator<Coordinates> it = lst8.listIterator(); it.hasNext(); ) {
            Coordinates class1 = it.next();
            System.out.println(class1);
        }
        System.out.println();

        // Extra way of passing through an ArrayList
        System.out.println("Traversing through an ArrayList using "
                + "Collections.Coordinates class1 : lst1");
        for (Coordinates class1 : lst8) {
            System.out.println(class1);
        }
        System.out.println();

        // Removing a several items from an ArrayList
        i = (int) (Math.random() * 4) + 1;
        while (i > 0) {
            lst8.remove(1);
            i--;
        }
        /**
         * As of removing an elements from ArrayList. There are 2 methods for
         * removal - clear() and removeAll(Collection c). clear() removes all
         * the elements, its cost is O(n), removeAll removes the elements
         * present in Collection c, its cost is O(n^2). Eventually when removing
         * all the elements it is better to use clear() method.
         */
        // Printing a values of "lst1" to console
        for (int j = 0; j < lst8.size(); j++) {
            Coordinates class1 = lst8.get(j);
            System.out.println(class1);
        }

        // Throws java.lang.UnsupportedOperationException, since the lst4 is not expandable.
//        populateList(lst4);
        // Same error.
//        lst4.remove(1);
        // This works fine, because no change of a size of an array in this list.
        lst4.set(1, '8');
//        populateList(lst4_2);
    }

    private void populateListWithZeros(List<Integer> lst) {
        for (int i = 0; i < length; i++) {
            lst.add(0);
        }
    }

    private void removeList(List<Integer> lst, position pos) {
        if (pos == position.START) {
            for (int i = 0; i < length; i++) {
                lst.remove(0);
            }
        }
        if (pos == position.MIDDLE) {
            for (int i = 0; i < length; i++) {
                lst.remove(lst.size() / 2);
            }
        }
        if (pos == position.END) {
            for (int i = 0; i < length; i++) {
                lst.remove(lst.size() - 1);
            }
        }
    }

    private void showTimings(List<Integer> lst) {

        System.out.println("Adding data:");
        long start = System.currentTimeMillis();
        populateListWithZeros(lst);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        System.out.println("Removing data at 1st index:");
        start = System.currentTimeMillis();
        removeList(lst, position.START);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        populateListWithZeros(lst);
        System.out.println("Removing data at MIDDLE index:");
        start = System.currentTimeMillis();
        removeList(lst, position.MIDDLE);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

        populateListWithZeros(lst);
        System.out.println("Removing data at LAST index:");
        start = System.currentTimeMillis();
        removeList(lst, position.END);
        end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");

    }

    private void traverseThroughListDemo(List<Integer> lst) {
        // Only in Java 8
//        lst.stream().forEach(str -> System.out.println(str));
//        
//        lst.stream()
//         .filter(country -> country.contains("n"))
//         .forEach(str -> System.out.println(str));
//        
//        lst.stream()
//         .filter(country -> country.contains("n"))
//         .forEach(System.out::println);

        for (int i = 0; i < lst.size(); i++) {
            System.out.println("# " + i + " : " + lst.get(i));
        }

        for (Integer lstItem : lst) {
            System.out.print(lstItem + " ");
        }

        for (Iterator<Integer> it = lst.iterator(); it.hasNext(); ) {
            Integer object = it.next();
            System.out.print(object + " ");
        }

        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext()) {
            int number = itr.next();
            System.out.print(number + " ");
        }

        ListIterator<Integer> listItr = lst.listIterator();
        while (listItr.hasNext()) {
            int number = listItr.next();
            System.out.print(number + " ");
        }
    }

    private void operateList() {
        // Making a list from an array
        List<? extends String> lst1 = Arrays.asList(strs);
        List<? extends String> lst2 = Arrays.asList("one", "two", "three");
        List<? extends String> lst3 = Arrays.asList(new String[]{"one", "two", "three"});
        // For further making an ArrayList from List, do
        ArrayList alst1 = new ArrayList<>(lst2);
        /**
         * Arrays.asList() can not be used as regular List for further adding or
         * removing elements. It's kind of fixed length Lists which doesn't
         * support addition and removal of elements. Nevertheless its clean
         * solution for creating and initializing List in Java in one line,
         * quite useful for testing purpose.
         */
    }

    private void addToListAtRuntime(List<java.io.Serializable> lst) {
        lst.add(10);
        lst.add(new Character('2'));
        for (java.io.Serializable oLst : lst) {
            System.out.println(oLst);
        }
    }

    public void listDemo1() {
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        map1.put("Number1", new Integer(100));
        map1.put("Number2", new Integer(200));
        map1.put("Number3", new Integer(300));
        // One can put Map interface in a diamond operator.
        List<Map> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);
        HashMap resultMap = (HashMap) list.get(0);
        // Prints 200.
        System.out.println("Number: " + resultMap.get("Number2"));
    }

    // Converting array to list, using int type values only.
    public List<Integer> arrayToList(int[] ints) {

        // This way won't work. Check the link below this row.
//        return Arrays.asList(ints);

        // By the way, there is not way of making this method using only generics -
        // https://stackoverflow.com/questions/36598928/java-generics-in-arraylist-toarray/36599031

        // http://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            intList.add(ints[i]);
        }
        return intList;
    }

    // Converting any type of list to this type of array.
    // This one throws ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
    // One may try implement it using reflection, see ru.jbasics.java.lang.Reflections.toArray(...)
    // But reflection is not a good approach in this case.
    public static <T> T[] toArray(List<T> list) {
        T[] array = (T[]) new Object[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private void integerArrayToIntegerList() {
        Integer[] integerArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> integerList = new ArrayList<>();
        // http://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java
        // This way won't work
//        integerList = Arrays.asList(integerArray);
        // Use listToArray(List<T> lst) instead, let's try in a next row
        integerArray = listToArray(integerList);
    }

    private void arrayToListDemo() {
//         Array to list conversion
        Utils.printList(
                arrayToList(new Integer[]{3, 5, 8, 3})
        );
//         Array to list conversion
        Utils.printArr(
                listToArray(
                        new ArrayList<Boolean>(
                                Arrays.asList(
                                        new Boolean("true"),
                                        new Boolean("false"),
                                        new Boolean("true"))
                        )
                )
        );
//         Array to list conversion
        Utils.printArr(
                listToArray(
                        new ArrayList<Boolean>() {{
                            new Boolean("true");
                            new Boolean("false");
                            new Boolean("true");
                        }}
                )
        );
    }

    // Converting array to list using generics.
    // Method is able to process any type.
    public <T> List<T> arrayToList(T[] objects) {

        // This way won't work. Check the link below this row.
//        return Arrays.asList(objects);
        // http://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java

        // This is the only way.
        List<T> intList = new ArrayList<T>();
        for (int i = 0; i < objects.length; i++) {
            intList.add(objects[i]);
        }
        return intList;
    }

    // Converting array to list
    public <T> T[] listToArray(List<T> lst) {
        return (T[]) lst.toArray();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Sets">
    /*
     * Java Set example
     * http://examples.javacodegeeks.com/core-java/util/set/java-set-example/
     *
     */
    // Set that can hold any kind of objects, i.e. instances of Object
    Set set = new HashSet();
    // Set that can hold Integer objects
    Set<Integer> set2 = new HashSet<>();

    // Populating a set using an object initializer.
    Set<Character> set3 = new HashSet() {
        // Object initializer
        {
            add('1');
            add('X');
            add('!');
        }
    };

    void populateSet(Set set) {

        set.add("1");
        set.add(new Object());
        set.add(2);
        set.add('3');

        // Traversing through, extra way
//            for (String s : setThree) {
//                System.out.println(s);
//            }
        // Traversing through, extra way
        // In Java 8.0
//            set.forEach(System.out::println);
        // Traversing through, extra way
        // In Java 8.0
//        set.stream().forEach((elem) -> {
//      System.out.println(elem);
//});
//        System.out.println("populateSet() method out.");
    }

    void printSet(Set<? extends Object> set) {

        /**
         * Since Set interface or HashSet class doesn't provide a get() method
         * to retrieve elements, the only way to take out elements from a Set is
         * to iterate over it by using Iterator, or loop over Set using advanced
         * for loop of Java 5.
         *
         */
        System.out.println("Set elements are:");
        // Traversing through the set
        if (set.isEmpty()) {
            System.out.println("Set is empty");
        }
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("Element: class-" 
//                    + iterator.getClass() 
//                    + " value-" 
//                    + iterator.next());
//        }
        for (Object st : set) {
            System.out.print(st + ", ");
        }
        // iterating over HashSet using forEach() method in Java 8 
//        set.forEach(System.out::println);
        System.out.println("");

    }

    void removeFromSet(Set<? extends Object> set) {

        System.out.println("removeFromSet method");
        /**
         * Removal using "iterator" method doesn't make any changes to set.
         */
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            // At next row, there is a problem
//            set.remove(iterator.hasNext());
//            break;
//        }
        /**
         * Following code is well used, has to have a "break" statement after
         * removal. It removes a first element from a set.
         */
        for (Object setItem : set) {
            set.remove(setItem);
            break;
        }

    }

    public void setToList() {
        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        // Преобразование.
        List<String> list = new ArrayList<>(set);
    }

    public void listToSet() {
        List<Integer> listInts = new ArrayList<>();
        listInts.add(1);
        listInts.add(2);
        listInts.add(2);
        Set<Integer> set = new HashSet<>(listInts);
    }
    //</editor-fold>
}
