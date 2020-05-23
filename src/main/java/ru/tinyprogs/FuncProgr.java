package ru.tinyprogs;

/**
 * https://www.youtube.com/watch?v=J88M_hYINUw
 *
 * Created by v.yanchenko on 07.09.2016.
 */
public class FuncProgr {

    interface Function {
        void print();
    }

    Object o = new Object() {
        void print() {
            System.out.println("Hello");
        }
    };

    Function o2 = new Function() {
        public void print() {
            System.out.println("Hello2");
        }
    };

    public static void main(String[] args) {
        new Object() {
            void print() {
                System.out.println("Hello");
            }
        }.print();

//        o.print(); // print() is not accessible.
        new FuncProgr().o2.print();
    }
}
