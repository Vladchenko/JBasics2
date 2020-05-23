package ru.jbasics;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Threads {

    int commonValue = 0;
    final Object lock1 = new Object();
    final Object lock2 = new Object();
    
    int setValue(int value) {
        while (true) {
            commonValue = 3;
            System.out.println(Thread.currentThread().getName() 
                        + ", value = " + commonValue);
        }
    }

    class Thread1 extends Thread {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName()
                        + ", value = " + commonValue);
                commonValue = 1;
                try {
                    Thread.sleep(800);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    class Thread2 implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName()
                        + ", value = " + commonValue);
                commonValue = 2;
                try {
                    Thread.sleep(900);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    class DeadlockThread1 extends Thread {

        @Override
        public void run() {
            synchronized(lock1) {
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " is holding a " + lock1.toString());
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " is waiting a " + lock2.toString());
                synchronized(lock2) {
                    System.out.println("Thread " + Thread.currentThread().getName()
                            + " is holding a " + lock1.toString()
                            + " and " + lock2.toString());
                }
            }
        }
    }

    class DeadlockThread2 extends Thread {

        @Override
        public void run() {
            synchronized(lock2) {
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " is holding a " + lock2.toString());
                System.out.println("Thread " + Thread.currentThread().getName()
                        + " is waiting a " + lock1.toString());
                synchronized(lock1) {
                    System.out.println("Thread " + Thread.currentThread().getName()
                            + " is holding a " + lock2.toString()
                            + " and " + lock1.toString());
                }
            }
        }
    }


    public Threads() throws InterruptedException {
    }

    public void demoThread1And2() {
        Thread th = new Thread(new Thread1());
        Thread th1 = new Thread1();
        Thread2 th2 = new Thread2();
        th.start();
        th1.start();
        th2.run();
        setValue(commonValue);
        /**
         * Prints as follows:
         *
         * main, value = 1
         * Thread-3, value = 2
         * Thread-4, value = 1
         *
         * (Where is Thread-2 ?)
         */
    }

    public void demoMyThread() throws InterruptedException {

        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        myThread1.join();
        myThread2.join();

        System.out.println(myThread1.getI());
    }

    public void commonDemo() {


        // This row throws IllegalMonitorStateException.
//        new Object().notify();

        // This row throws IllegalMonitorStateException.
//        new Object().notifyAll();

        // This row throws IllegalMonitorStateException.
//        new Object().wait();

        // These methods should be used in a synchronized block !
        // They are "native", JVM made them.
        // But synchronized can be used without them.

        // Illegal monitor state exception. Why ? Seems different objects.
//        synchronized (CommonInfo.class) {
//            new Object().wait();
//        }

        // IllegalMonitorStateException again. One has to synchronize over
        // a same object that one waits / notifies.
//        synchronized (new Object()) {
//            new Object().wait();
//        }

        // This part of code waits forever. That is correct.
//        Object obj = new Object();
//        synchronized (obj) {
//            obj.wait();
//        }

        // Synchronization is done by some really existing object,
        // so next part of code throws NullPointerException.
//        Object obj2 = null;
//        synchronized (obj2) {
//            obj2.wait();
//        }

        // This part of code is correct. This exсerpt shows that
        // synchronization is done not by the link, but by the
        // real object. It waits forever.
//        Object obj3 = new Object();
//        Object obj4 = obj3;
//        synchronized (obj4) {
//            obj4.wait();
//        }

        // This code will work.
        // 1) The order in which we capture the objects does not matter.
        // 2) Object can capture a lot of a locks !
//        Object obj5 = new Object();
//        Object obj6 = new Object();
//        synchronized (obj5) {
//            synchronized (obj6) {
//                // We could also put obj6 in a following row, it would work.
//                obj5.wait();
//            }
//        }

        // This code will also work.
//        Object obj7 = new Object();
//        synchronized (obj7) {
//            synchronized (obj7) {
//                obj7.wait();
//            }
//        }

//        synchronized void methodSome() { ... }
//            is the same as
//        synchronized (this) { ... }

        // This part of code is the same as method1().
        // It can be replaced with it.
        synchronized (Threads.class) {

        }
    }

    public void demoExecutor() {
        new Executor().execute();
    }

    public void simplestDeadlock() {

        try {
            // Simplest deadlock.
            // Calling this method on a main thread will cause a permanent waiting.
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void classicDeadlock() {
        Thread thread1 = new DeadlockThread1();
        Thread thread2 = new DeadlockThread2();
        thread1.start();
        thread2.start();
    }

}

/**
 * Simple threads demo. This class increases an int field "i" in 1_000_000 times.
 * The increment itself is in a synchronized block, which does not allow for a
 * several threads to enter this code simultaneously. This is done to evade a race
 * condition, when, for example, one thread reads an old data, while other one
 * updated to a new one.
 *
 * Created by Влад on 05.11.2016.
 */
class MyThread extends Thread {

    private static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1_000_000; j++) {
            /**
             * Removing a synchronized lexem, will break the logic.
             * The final i value will always be random.
             */
            synchronized (MyThread.class) {
                i++;
            }
        }
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class Executor {

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void execute() {
//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                Random random = new Random();
//                int duration = random.nextInt();
//                System.out.println("Started ...");
//                try {
//                    Thread.sleep(duration);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Finished.");
//            }
//        });
//        executorService.shutdown();

        executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Random random = new Random();
                int duration = random.nextInt();
                System.out.println("Started ...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished.");
                return duration;
            }
        });
        executorService.shutdown();

    }
}

