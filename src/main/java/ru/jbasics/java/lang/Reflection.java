/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.java.lang;

import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author v.yanchenko
 */
public class Reflection {

    int someValue = 100;
    private int someValue2 = 200;
    public int someValue3 = 300;
    int i = 0;

    class TestClass {

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int valueIn) {
            this.value = valueIn;
        }
    }

    class Parent {

        public int x;
        int x2;
    }

    class Child extends Parent {

        public int y;

        /**
         * Getting a number of fields present in class, using "Reflection".
         * .getClass().getFields() - counts only a public fields
         */
        public void runFieldAccibilityCheck() {
            Parent prnt = new Parent();
            Parent chld2 = new Child();
            Parent chld3 = new Child();
            Field[] flds = new Field[prnt.getClass().getFields().length];
            Field[] flds2 = new Field[chld2.getClass().getFields().length];
            Field[] flds3 = new Field[chld3.getClass().getFields().length];
            flds = prnt.getClass().getFields();
            flds2 = chld2.getClass().getFields();
            flds3 = chld3.getClass().getFields();
//        System.out.println(flds.length);
//        System.out.println(flds2.length);
            for (Field field : flds) {
                System.out.println(field);
            }
            System.out.println("");
            for (Field field : flds2) {
                System.out.println(field);
            }
            System.out.println("");
            for (Field field : flds3) {
                System.out.println(field);
            }
        }
    }

    public void printCommon() {
        TestClass testClass = new TestClass();

        for (Field field : testClass.getClass().getDeclaredFields()) {
            System.out.printf("name: %s, type: %s \n", field.getName(), field.getType().getCanonicalName());
        }

        for (Method method : testClass.getClass().getDeclaredMethods()) {
            System.out.printf("name: %s, return type: %s  \n", method.getName(), method.getReturnType().getCanonicalName());
        }

//            Class foo;
//            try {
//                foo = Class.forName("Foo");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//            try {
//                foo.getMethod("hello", null).invoke(foo.newInstance(), null);
//            } catch (NoSuchMethodException | SecurityException ex) {
//                Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
//            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
//        }

        Point p = null;
        try {
            // в следующей строке, используя лишь текстовое
            // имя класса Point, порождается объект без
            // применения ключевого слова new
            p = (Point) Class.forName("Point").newInstance();
        } catch (Exception e) { // обработка ошибок
            System.out.println(e);
        }

        (new Child()).runFieldAccibilityCheck();
    }

    public Reflection() {
    }

    public Reflection(String str) {
        System.out.println(str);
    }

    // Creating an instance of a class Reflection, using reflection.
    public void createInstance() {
        Class<?> clazz = null;
        clazz = Reflection.class;
        // or instead of this, you may also use this try block:
//        try {
//            clazz = Class.forName("ru.jbasics.java.lang.Reflection");
//        } catch (ClassNotFoundException ex) {
//            System.out.println("Class not found !");
//            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Constructor<?>[] ctor = null;
        try {
            ctor = clazz.getConstructors();
        } catch (SecurityException ex) {
            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Constructor constructor : ctor) {
            i++;
            System.out.println("Constructor #" + i + ": " + constructor);
        }
        Field[] fields = clazz.getDeclaredFields();
        i = 0;
        for (Field field : fields) {
            i++;
            System.out.println("Field #" + i + ": " + field);
        }
        Method[] methods = clazz.getDeclaredMethods();
        i = 0;
        for (Method method : methods) {
            i++;
            System.out.println("Method #" + i + ": " + method);
        }


//        Constructor<?> ctor2 = null;
//        try {
//            try {
//                ctor2 = clazz.getConstructor(Reflection.class);
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//        } catch (SecurityException ex) {
//            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            Object object = ctor2.newInstance(new Object[]{"Argument"});
//        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
//            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }
}