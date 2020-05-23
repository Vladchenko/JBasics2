package ru.jbasics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Влад on 01.11.2016.
 */
public class Polymorphism {

    class Shape {
        protected void draw() {
            System.out.println("Shape draw");
        }
    }

    class Rectangle extends Shape {
        @Override
        public void draw() {
            System.out.println("Rectangle draw");
        }
    }

    class Oval extends Shape {
        @Override
        public void draw() {
            System.out.println("Oval draw");
        }
    }

    class Circle extends Shape {
        @Override
        public void draw() {
            System.out.println("Circle draw");
        }
    }

    class Square extends Shape {
        @Override
        public void draw() {
            System.out.println("Square draw");
        }
    }

    private List<Shape> populateShapes() {
        // Strangely this one doesn't work
        List<Shape> shapes = new ArrayList<Shape>(){{
                add(new Square());
                add(new Rectangle());
                add(new Circle());
                add(new Oval());
        }};
        return shapes;
    }

    private void drawShapes(List<Shape> shapes) {
        for(Shape shapeCurrent:shapes) {
            shapeCurrent.draw();
        }
    }

    public Polymorphism() {
        drawShapes(populateShapes());
    }

}
