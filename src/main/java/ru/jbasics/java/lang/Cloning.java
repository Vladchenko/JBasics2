package ru.jbasics.java.lang;

import java.awt.*;

/**
 * Created by Влад on 03.11.2016.
 */
public class Cloning {

    private Person original = new Person();
    private Person clone;

    Person cloning(Person foo) {
        Person newFoo = null;
        newFoo = (Person) foo.clone();
        return newFoo;
    }

    public Cloning() {
        clone = cloning(original);
        // Here we change a Point class to later check if it changed or not.
        clone.point = new Point(20, 20);
        // Here we see that the old value remained the same 10.
        System.out.println(original.point.x);
    }
}

class Person implements Cloneable {

    private String name = "Влад";
    private String lastName = "Янченко";
    private int age = 33;
    Point point = new Point(10, 10);

    @Override
    protected Object clone() {

        Person person = null;

        // Default return string is like this:
        //      return super.clone();
        // But seems it is much better to use casting of the type like this
        // http://ru.stackoverflow.com/questions/449746/%D0%9A%D0%B0%D0%BA-%D0%BF%D1%80%D0%B8%D0%BC%D0%B5%D0%BD%D0%B8%D1%82%D1%8C-%D0%BC%D0%B5%D1%82%D0%BE%D0%B4-clone-%D0%BA%D0%BB%D0%B0%D1%81%D1%81%D0%B0-object

        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return person;
    }
}
