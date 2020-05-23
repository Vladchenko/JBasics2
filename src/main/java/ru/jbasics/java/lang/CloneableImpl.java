/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.java.lang;

/**
 * Article is present in a following link -
 * http://echuprina.blogspot.ru/2012/02/cloneable.html It is worthwhile to be
 * read.
 */
class User implements Cloneable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}

public class CloneableImpl {

    public void run() {

        User user = new User();

        user.setName("Иванов");
        user.setAge(25);

        System.out.println("Данные до клонирования: "
                + user.getName() + " - " + user.getAge() + "лет");

        User clone;
        try {
            clone = user.clone();
            clone.setName("Петров");
            clone.setAge(30);
            System.out.println("Клон после изменения данные: "
                    + clone.getName() + " - " + clone.getAge() + "лет");

        } catch (CloneNotSupportedException e) {
            System.out.println("Объект не может быть клонированным.");
        }

        System.out.println("Оригинал, после манипуляций с клоном: "
                + user.getName() + " - " + user.getAge() + "лет");
    }

}
