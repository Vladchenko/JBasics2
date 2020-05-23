/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.designpatterns;

import java.awt.Point;

/**
 *
 * @author v.yanchenko
 */
public class Singleton {

    //  http://habrahabr.ru/post/129494/    рекомендуется к прочтению
    // Ленивые Singleton
    public static class Singleton1 {

        // Synchronized Accessor
        // + Ленивая инициализация
        // - Низкая производительность (критическая секция) в наиболее типичном доступе
        private static Singleton1 instance;

        public static synchronized Singleton1 getInstance() {
            if (instance == null) {
                instance = new Singleton1();
            }
            return instance;
        }
    }

    public static class Singleton2 {

        // Double Checked Locking & volatile
        // + Ленивая инициализация
        // + Высокая производительность 
        // - Поддерживается только с JDK 1.5 [5]
        private static volatile Singleton2 instance;

        public static Singleton2 getInstance() {
            Singleton2 localInstance = instance;
            if (localInstance == null) {
                synchronized (Singleton.class) {
                    localInstance = instance;
                    if (localInstance == null) {
                        instance = localInstance = new Singleton2();
                    }
                }
            }
            return localInstance;
        }
    }

    public static class Singleton3 {

        // On Demand Holder idiom
        // + Ленивая инициализация
        // + Высокая производительность
        // - Невозможно использовать для не статических полей класса
        public static class SingletonHolder {

            public static final Singleton3 HOLDER_INSTANCE = new Singleton3();
        }

        public static Singleton3 getInstance() {
            return SingletonHolder.HOLDER_INSTANCE;
        }
    }

    // Неленивые Singleton
    public static class Singleton4 {

        // Static field
        // + Простая и прозрачная реализация
        // + Потокобезопасность 
        // - Не ленивая инициализация
        public static final Singleton4 INSTANCE = new Singleton4();
    }

    public enum Singleton5 {

        // Enum Singleton
        // + Остроумно
        // + Сериализация из коробки
        // + Потокобезопасность из коробки
        // + Возможность использования EnumSet, EnumMap и т.д.
        // + Поддержка switch
        // - Не ленивая инициализация
        INSTANCE;
        static int i=10;
        
    }
    
    public void demoSingleton() {
        
        // Error - Enum type cannot be instantiated.
//        Singleton.Singleton5 sngltn5 = new Singleton.Singleton5();
        
        // This row doesn't affect the sngltn5
        Singleton5 sngltn5 = null;
        
        System.out.println(sngltn5.INSTANCE);
        System.out.println(sngltn5.i);
        sngltn5.i = sngltn5.i + 10;
        System.out.println(sngltn5.i);
    }
}
