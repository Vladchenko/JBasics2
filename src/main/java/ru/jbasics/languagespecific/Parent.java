package ru.jbasics.languagespecific;

public class Parent {

    private static Parent c = new Parent();

    public Parent() {
        c.perform();
    }

    void perform() {
        System.out.println("perform");
    }

}
